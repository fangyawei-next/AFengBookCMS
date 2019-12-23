package com.book.user.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.base.service.impl.BaseServiceImpl;
import com.book.common.EasyUIDataGridResult;
import com.book.common.ResultUtil;
import com.book.mapper.SysRoleMapper;
import com.book.mapper.SysUserDetailMapper;
import com.book.mapper.SysUserMapper;
import com.book.pojo.SysUser;
import com.book.pojo.SysUserDetail;
import com.book.pojo.SysUserExample;
import com.book.pojo.SysUserExample.Criteria;
import com.book.user.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
	
	private SysUserMapper userMapper;
	@Resource
	public void setMapper(SysUserMapper mapper) {
		super.setBaseMapper(mapper);
		this.userMapper = mapper;
	}
	@Resource
	private SysUserDetailMapper sysUserDetailMapper;
	
	@Override
	public ResultUtil login(SysUser sysUser) {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(sysUser.getUserName());
		criteria.andUserPasswordEqualTo(sysUser.getUserPassword());
		criteria.andUserFlagEqualTo(1);
		//有值返回200，没值返回404
		try {
			sysUser = userMapper.selectByExample(example).get(0);
			return ResultUtil.ok(sysUser);
		}catch (IndexOutOfBoundsException e1) {
			// TODO Auto-generated catch block
			return ResultUtil.build(404, "你使用的用户或已停用,详情请联系官方");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultUtil.build(404, "登录失败");
		}
		
	}
	@Override
	public ResultUtil verifyUsername(String username) {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		List<SysUser> sysUserList = userMapper.selectByExample(example);
		if(sysUserList.size()>0) {
			return ResultUtil.build(404, "用户名重复,请改正");
		}else if(sysUserList==null) {
			return ResultUtil.build(404, "系统查询出错");
		}else {
			return ResultUtil.ok(null);
		}
	}
	@Override
	public ResultUtil enrol(SysUser sysUser) {
		// TODO Auto-generated method stub
		try {
			sysUser.setUserFlag(1);
			int num = userMapper.insert(sysUser);
			return ResultUtil.ok("添加成功了"+num+"条");
		} catch (Exception e) {
			return ResultUtil.build(404, "系统添加出错");
		}
	}
	//用户列表
//	@Override
//	public EasyUIDataGridResult userList(SysUser user) {
//		// TODO Auto-generated method stub
//		EasyUIDataGridResult result = new EasyUIDataGridResult();
//		List<SysUser> list = userMapper.selectByExampleByLike(user);
//		result.setRows(list);
//		result.setTotal(1000L);
//		return result;
//	}
	@Override
	public EasyUIDataGridResult userList(SysUser user, int page, int rows) {
		// TODO Auto-generated method stub
		//设置启始页数，每页显示的条数
		String orderBy ="user_id desc";//按照（数据库）排序字段 倒序 排序
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(page, rows);
		List<SysUser> list = userMapper.selectByExampleByLike(user);
		PageInfo pageInfo = new PageInfo(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		//System.out.println(pageInfo.getList());
		result.setRows(pageInfo.getList());
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	//删除用户
	@Override
	public ResultUtil delete(String userId) {
		//String id = 
//		try {
//			userMapper.deleteByPrimaryKey(Long.valueOf(userId));
//			return ResultUtil.build(200, "删除成功!");
//		} catch (Exception e) {
//			return ResultUtil.build(404, "删除失败!");
//		}
		try {
			if(userId!=null&&userId!="") {
				userMapper.deleteByUserIdToString(userId);
				return ResultUtil.build(200, "删除成功!");
			}else {
				return ResultUtil.build(404, "删除失败!");
			}
		} catch (Exception e) {
			return ResultUtil.build(404, "删除失败!");
		}
	}
	
	//添加用户及其详情
	@Override
	@Transactional
	public ResultUtil addAndDetail(SysUser sysUser) {
		// TODO Auto-generated method stub
		try {
			SysUserDetail sysUserDetail = sysUser.getSysUserDetail();
			//先添加详情
			//创建日期
			Date date = new Date();
			sysUserDetail.setDetailDate(date);
			//获取添加的id
			sysUserDetailMapper.insertReturnDetailId(sysUserDetail);
			Long num = sysUserDetail.getDetailId();
			//添加用户
			sysUser.setUserFlag(1);
			sysUser.setUserDetailId(num);
			userMapper.insert(sysUser);
			return ResultUtil.build(200, "添加成功!");
		} catch (Exception e) {
			return ResultUtil.build(404, "添加失败!");
		}
	}
	
	//根据id查询用户及其详情
	@Override
	public ResultUtil findUserById(Long userId) {
		// TODO Auto-generated method stub
		try {
			SysUser sysUser = userMapper.selectByPrimaryKey(userId);
			Long num = sysUser.getUserDetailId();
			if(num!=null||!"".equals(num)) {
				sysUser.setSysUserDetail(sysUserDetailMapper.selectByPrimaryKey(num));
			}else {
				System.out.println("此用户没有详情!");
			}
			return ResultUtil.ok(sysUser);
			//return ResultUtil.build(404, "查询Id为"+userId+"的用户失败!");
		} catch (Exception e) {
			return ResultUtil.build(404, "查询Id为"+userId+"的用户失败!");
		}
	}
	
	//更新用户
	@Override
	@Transactional
	public ResultUtil update(SysUser sysUser) {
		// TODO Auto-generated method stub
		//System.out.println(sysUser);
		try {
			Long detailId = sysUser.getUserDetailId();
			SysUserDetail sysUserDetail = sysUser.getSysUserDetail();
			Date date = new Date();
			//判断前台传递过来的详情表的id是否为空,如果为空则添加,不为空则更新
			if(detailId!=null) {
				//System.out.println(0);
				sysUserDetail.setDetailId(detailId);
				sysUserDetailMapper.updateByPrimaryKeySelective(sysUserDetail);
				//如果是游客编辑的话,编辑成功直接晋级成普通用户(4)
				if(sysUser.getUserRoleId()==5) {
					sysUser.setUserRoleId(4L);
				}
				userMapper.updateByPrimaryKeySelective(sysUser);
			}else {
				//如果传递过来的日期为空,则直接赋值new Date()
				if(sysUserDetail.getDetailDate()==null) {
					sysUserDetail.setDetailDate(date);
				}
				sysUserDetailMapper.insertReturnDetailId(sysUserDetail);
				Long num = sysUserDetail.getDetailId();
				sysUser.setUserDetailId(num);
				//如果是游客编辑的话,编辑成功直接晋级成普通用户(4)
				if(sysUser.getUserRoleId()==5) {
					sysUser.setUserRoleId(4L);
				}
				userMapper.updateByPrimaryKeySelective(sysUser);
			}
			return ResultUtil.build(200, "更新成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultUtil.build(404, "更新失败!");
		}
	}

}
