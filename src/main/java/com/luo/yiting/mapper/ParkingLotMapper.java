package com.luo.yiting.mapper;

import com.luo.yiting.bean.ParkingLot;
import com.luo.yiting.bean.ParkingLotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotMapper {
    int countByExample(ParkingLotExample example);

    int deleteByExample(ParkingLotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkingLot record);

    int insertSelective(ParkingLot record);

    List<ParkingLot> selectByExample(ParkingLotExample example);

    ParkingLot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkingLot record, @Param("example") ParkingLotExample example);

    int updateByExample(@Param("record") ParkingLot record, @Param("example") ParkingLotExample example);

    int updateByPrimaryKeySelective(ParkingLot record);

    int updateByPrimaryKey(ParkingLot record);
}