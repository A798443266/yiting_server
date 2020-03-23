package com.luo.yiting.mapper;

import com.luo.yiting.bean.ParkAdmin;
import com.luo.yiting.bean.ParkAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkAdminMapper {
    int countByExample(ParkAdminExample example);

    int deleteByExample(ParkAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkAdmin record);

    int insertSelective(ParkAdmin record);

    List<ParkAdmin> selectByExample(ParkAdminExample example);

    ParkAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkAdmin record, @Param("example") ParkAdminExample example);

    int updateByExample(@Param("record") ParkAdmin record, @Param("example") ParkAdminExample example);

    int updateByPrimaryKeySelective(ParkAdmin record);

    int updateByPrimaryKey(ParkAdmin record);
}