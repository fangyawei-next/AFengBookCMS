package com.book.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.base.service.impl.BaseServiceImpl;
import com.book.common.EasyUITreeNode;
import com.book.common.TreeByUserId;
import com.book.common.TreeChildren;
import com.book.mapper.SysRightMapper;
import com.book.pojo.SysRight;
import com.book.pojo.SysRightExample;
import com.book.user.service.SysRightService;

@Service
public class SysRightServiceImpl extends BaseServiceImpl<SysRight> implements SysRightService {
	
	private SysRightMapper sysRightMapper;
	@Resource
	public void setMapper(SysRightMapper mapper) {
		super.setBaseMapper(mapper);
		this.sysRightMapper = mapper;
	}

	@Override
	public List<EasyUITreeNode> selectTreeToAll() {
		// TODO Auto-generated method stub
		SysRightExample example = new SysRightExample();
		example.createCriteria().andRightParentCodeEqualTo("ROOT_MENU");
		List<SysRight> sysRightList = sysRightMapper.selectByExample(example);
		List<EasyUITreeNode> treeList = new ArrayList<EasyUITreeNode>();
		for (SysRight sysRight : sysRightList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setTitle(sysRight.getRightText());
			node.setIcon(sysRight.getRightImg());
			node.setHref(sysRight.getRightUrl());
			node.setIsCurrent("false".equals(sysRight.getRightIscurrent())?false:true);
			//node.setMenu(sysRightMapper.selectByParentCode(sysRight.getRightCode()));
			
			List<SysRight> sysRightListChildren = sysRightMapper.selectByParentCode(sysRight.getRightCode());
			List<TreeChildren> treeListChildren = new ArrayList<TreeChildren>();
			for (SysRight sysRightChildren : sysRightListChildren) {
				TreeChildren treeChildren = new TreeChildren();
				treeChildren.setTitle(sysRightChildren.getRightText());
				treeChildren.setHref(sysRightChildren.getRightUrl());
				treeChildren.setIsCurrent("false".equals(sysRightChildren.getRightIscurrent())?false:true);
				treeListChildren.add(treeChildren);
			}
			
			node.setChildren(treeListChildren);
			treeList.add(node);
		}
		return treeList;
	}

	@Override
	public List<EasyUITreeNode> selectTreeToAll(Object userId) {
		// TODO Auto-generated method stub
		TreeByUserId treeByUserId = new TreeByUserId();
		treeByUserId.setId(userId);
		treeByUserId.setParentCode("ROOT_MENU");
		List<SysRight> sysRightList = sysRightMapper.selectByExampleUserId(treeByUserId);
		List<EasyUITreeNode> treeList = new ArrayList<EasyUITreeNode>();
		for (SysRight sysRight : sysRightList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setTitle(sysRight.getRightText());
			node.setIcon(sysRight.getRightImg());
			node.setHref(sysRight.getRightUrl());
			node.setIsCurrent("false".equals(sysRight.getRightIscurrent())?false:true);
			//node.setMenu(sysRightMapper.selectByParentCode(sysRight.getRightCode()));
			
			List<SysRight> sysRightListChildren = sysRightMapper.selectByParentCode(sysRight.getRightCode());
			List<TreeChildren> treeListChildren = new ArrayList<TreeChildren>();
			for (SysRight sysRightChildren : sysRightListChildren) {
				TreeChildren treeChildren = new TreeChildren();
				treeChildren.setTitle(sysRightChildren.getRightText());
				treeChildren.setHref(sysRightChildren.getRightUrl());
				treeChildren.setIsCurrent("false".equals(sysRightChildren.getRightIscurrent())?false:true);
				treeListChildren.add(treeChildren);
			}
			
			node.setChildren(treeListChildren);
			treeList.add(node);
		}
		return treeList;
	}


}
