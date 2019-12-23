package com.book.pojo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class SysUser {
    private Long userId;

    private String userName;

    private String userPassword;

    private Integer userFlag;

    private Long userRoleId;

    private Long userDetailId;
    
    //关联角色表
    private List<SysRole> sysRoleList;
    //关联详情表
	private SysUserDetail sysUserDetail = new SysUserDetail();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserDetailId() {
        return userDetailId;
    }
    public void setUserDetailId(Long userDetailId) {
        this.userDetailId = userDetailId;
    }

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

	public SysUserDetail getSysUserDetail() {
		return sysUserDetail;
	}
	public void setSysUserDetail(SysUserDetail sysUserDetail) {
		this.sysUserDetail = sysUserDetail;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userFlag="
				+ userFlag + ", userRoleId=" + userRoleId + ", userDetailId=" + userDetailId + ", sysRoleList="
				+ sysRoleList + ", sysUserDetail=" + sysUserDetail + "]";
	}
	
}