package com.luo.yiting.mapper;

import com.luo.yiting.bean.ParkOrder;
import com.luo.yiting.bean.ParkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkOrderMapper {
    int countByExample(ParkOrderExample example);

    int deleteByExample(ParkOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkOrder record);

    int insertSelective(ParkOrder record);

    List<ParkOrder> selectByExample(ParkOrderExample example);

    ParkOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkOrder record, @Param("example") ParkOrderExample example);

    int updateByExample(@Param("record") ParkOrder record, @Param("example") ParkOrderExample example);

    int updateByPrimaryKeySelective(ParkOrder record);

    int updateByPrimaryKey(ParkOrder record);
}