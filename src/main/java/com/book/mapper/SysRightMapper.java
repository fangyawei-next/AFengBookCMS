package com.book.mapper;

import com.book.common.TreeByUserId;
import com.book.pojo.SysRight;
import com.book.pojo.SysRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRightMapper extends BaseMapper<SysRight>{
    int countByExample(SysRightExample example);

    int deleteByExample(SysRightExample example);

    int deleteByPrimaryKey(String rightCode);

    int insert(SysRight record);

    int insertSelective(SysRight record);

    List<SysRight> selectByExample(SysRightExample example);

    SysRight selectByPrimaryKey(String rightCode);

    int updateByExampleSelective(@Param("record") SysRight record, @Param("example") SysRightExample example);

    int updateByExample(@Param("record") SysRight record, @Param("example") SysRightExample example);

    int updateByPrimaryKeySelective(SysRight record);

    int updateByPrimaryKey(SysRight record);
    
    //根据父类查找的id查询
    //SELECT * FROM sys_right WHERE right_parent_code IN (SELECT right_code FROM sys_right WHERE right_parent_code = 'ROOT_MENU')
    List<SysRight> selectByParentCode(String parentCode);
    
    //根据父类和id查询树状列表
	List<SysRight> selectByExampleUserId(TreeByUserId treeByUserId);
}