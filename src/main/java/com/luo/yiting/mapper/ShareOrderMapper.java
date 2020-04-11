package com.luo.yiting.mapper;

import com.luo.yiting.bean.ShareOrder;
import com.luo.yiting.bean.ShareOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareOrderMapper {
    int countByExample(ShareOrderExample example);

    int deleteByExample(ShareOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareOrder record);

    int insertSelective(ShareOrder record);

    List<ShareOrder> selectByExample(ShareOrderExample example);

    ShareOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareOrder record, @Param("example") ShareOrderExample example);

    int updateByExample(@Param("record") ShareOrder record, @Param("example") ShareOrderExample example);

    int updateByPrimaryKeySelective(ShareOrder record);

    int updateByPrimaryKey(ShareOrder record);
}