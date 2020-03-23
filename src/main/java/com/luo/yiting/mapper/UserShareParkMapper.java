package com.luo.yiting.mapper;

import com.luo.yiting.bean.UserSharePark;
import com.luo.yiting.bean.UserShareParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShareParkMapper {
    int countByExample(UserShareParkExample example);

    int deleteByExample(UserShareParkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSharePark record);

    int insertSelective(UserSharePark record);

    List<UserSharePark> selectByExample(UserShareParkExample example);

    UserSharePark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSharePark record, @Param("example") UserShareParkExample example);

    int updateByExample(@Param("record") UserSharePark record, @Param("example") UserShareParkExample example);

    int updateByPrimaryKeySelective(UserSharePark record);

    int updateByPrimaryKey(UserSharePark record);
}