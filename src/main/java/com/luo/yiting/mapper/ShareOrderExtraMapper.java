package com.luo.yiting.mapper;

import com.luo.yiting.bean.ShareOrderExtra;
import com.luo.yiting.bean.ShareOrderExtraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareOrderExtraMapper {
    int countByExample(ShareOrderExtraExample example);

    int deleteByExample(ShareOrderExtraExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareOrderExtra record);

    int insertSelective(ShareOrderExtra record);

    List<ShareOrderExtra> selectByExample(ShareOrderExtraExample example);

    ShareOrderExtra selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareOrderExtra record, @Param("example") ShareOrderExtraExample example);

    int updateByExample(@Param("record") ShareOrderExtra record, @Param("example") ShareOrderExtraExample example);

    int updateByPrimaryKeySelective(ShareOrderExtra record);

    int updateByPrimaryKey(ShareOrderExtra record);
}