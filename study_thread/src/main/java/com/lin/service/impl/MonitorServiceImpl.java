package com.lin.service.impl;

import com.google.common.collect.Lists;
import com.lin.service.MonitorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MonitorServiceImpl implements MonitorService {

    private final Executor monitorThreadPoolExecutor;
    private static final Logger logger=LoggerFactory.getLogger(MonitorServiceImpl.class);

    @Autowired
    public MonitorServiceImpl(@Qualifier("monitorThreadPoolExecutor") Executor monitorThreadPoolExecutor){
        this.monitorThreadPoolExecutor=monitorThreadPoolExecutor;
    }

    @Override
    public void monitor() {
        //定义一个初始数据
        List<String> list=inintDataList();
        //数据分租
        List<List<String>> partition = Lists.partition(list, 1000);
        //partition.size()分组数量
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        AtomicInteger exceptionCount=new AtomicInteger();
        for (List<String> strings : partition) {
            monitorThreadPoolExecutor.execute(()->{
                try {
                    handle(exceptionCount,strings);
                }catch (Exception e){
                    logger.error("异常");
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异常数据数量"+exceptionCount.get());
    }

    private void handle(AtomicInteger exceptionCount, List<String> strings) {
        for (String string : strings) {
            //大于10000即为异常
            if(Integer.parseInt(string)>1000){
                exceptionCount.incrementAndGet();
            }
        }
    }

    private List<String> inintDataList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}
