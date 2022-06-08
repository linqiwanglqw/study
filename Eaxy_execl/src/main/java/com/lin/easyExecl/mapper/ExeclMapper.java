package com.lin.easyExecl.mapper;

import com.lin.easyExecl.execlVO.execlData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExeclMapper extends Mapper {

    void save(List<execlData> list);

}
