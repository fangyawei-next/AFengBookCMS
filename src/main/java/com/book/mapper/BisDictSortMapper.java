package com.book.mapper;

import com.book.pojo.BisDictSort;
import com.book.pojo.BisDictSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BisDictSortMapper {
    int countByExample(BisDictSortExample example);

    int deleteByExample(BisDictSortExample example);

    int deleteByPrimaryKey(Long sortId);

    int insert(BisDictSort record);

    int insertSelective(BisDictSort record);

    List<BisDictSort> selectByExample(BisDictSortExample example);

    BisDictSort selectByPrimaryKey(Long sortId);

    int updateByExampleSelective(@Param("record") BisDictSort record, @Param("example") BisDictSortExample example);

    int updateByExample(@Param("record") BisDictSort record, @Param("example") BisDictSortExample example);

    int updateByPrimaryKeySelective(BisDictSort record);

    int updateByPrimaryKey(BisDictSort record);
}