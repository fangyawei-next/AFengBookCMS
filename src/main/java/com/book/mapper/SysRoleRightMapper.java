package com.book.mapper;

import com.book.pojo.SysRoleRightExample;
import com.book.pojo.SysRoleRightKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleRightMapper {
    int countByExample(SysRoleRightExample example);

    int deleteByExample(SysRoleRightExample example);

    int deleteByPrimaryKey(SysRoleRightKey key);

    int insert(SysRoleRightKey record);

    int insertSelective(SysRoleRightKey record);

    List<SysRoleRightKey> selectByExample(SysRoleRightExample example);

    int updateByExampleSelective(@Param("record") SysRoleRightKey record, @Param("example") SysRoleRightExample example);

    int updateByExample(@Param("record") SysRoleRightKey record, @Param("example") SysRoleRightExample example);
}