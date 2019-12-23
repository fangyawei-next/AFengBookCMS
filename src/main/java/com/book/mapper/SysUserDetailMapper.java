package com.book.mapper;

import com.book.pojo.SysUserDetail;
import com.book.pojo.SysUserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserDetailMapper {
    int countByExample(SysUserDetailExample example);

    int deleteByExample(SysUserDetailExample example);

    int deleteByPrimaryKey(Long detailId);

    int insert(SysUserDetail record);

    int insertSelective(SysUserDetail record);

    List<SysUserDetail> selectByExample(SysUserDetailExample example);

    SysUserDetail selectByPrimaryKey(Long detailId);

    int updateByExampleSelective(@Param("record") SysUserDetail record, @Param("example") SysUserDetailExample example);

    int updateByExample(@Param("record") SysUserDetail record, @Param("example") SysUserDetailExample example);

    int updateByPrimaryKeySelective(SysUserDetail record);

    int updateByPrimaryKey(SysUserDetail record);
    
    //插入一条数据并返回id
    int insertReturnDetailId(SysUserDetail record);
}