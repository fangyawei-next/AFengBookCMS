package com.book.mapper;

import com.book.pojo.BisDict;
import com.book.pojo.BisDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BisDictMapper {
    int countByExample(BisDictExample example);

    int deleteByExample(BisDictExample example);

    int deleteByPrimaryKey(Long bisId);

    int insert(BisDict record);

    int insertSelective(BisDict record);

    List<BisDict> selectByExample(BisDictExample example);

    BisDict selectByPrimaryKey(Long bisId);

    int updateByExampleSelective(@Param("record") BisDict record, @Param("example") BisDictExample example);

    int updateByExample(@Param("record") BisDict record, @Param("example") BisDictExample example);

    int updateByPrimaryKeySelective(BisDict record);

    int updateByPrimaryKey(BisDict record);
}