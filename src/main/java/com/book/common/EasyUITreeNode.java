package com.book.common;

import java.io.Serializable;
import java.util.List;

/**
 * 异步树控件
 * @author Lenovo
 *
 */
public class EasyUITreeNode implements Serializable {
	
	private String title;
	private String icon;
	private String href;
	private boolean isCurrent;
	//子节点
	private List<TreeChildren> children;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean getIsCurrent() {
		return isCurrent;
	}
	public void setIsCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public List<TreeChildren> getChildren() {
		return children;
	}
	public void setChildren(List<TreeChildren> children) {
		this.children = children;
	}
}

