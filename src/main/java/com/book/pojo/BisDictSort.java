package com.book.pojo;

public class BisDictSort {
    private Long sortId;

    private String sortName;

    private String sortDetail;

    private String sortFlag;

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public String getSortDetail() {
        return sortDetail;
    }

    public void setSortDetail(String sortDetail) {
        this.sortDetail = sortDetail == null ? null : sortDetail.trim();
    }

    public String getSortFlag() {
        return sortFlag;
    }

    public void setSortFlag(String sortFlag) {
        this.sortFlag = sortFlag == null ? null : sortFlag.trim();
    }

	@Override
	public String toString() {
		return "BisDictSort [sortId=" + sortId + ", sortName=" + sortName + ", sortDetail=" + sortDetail + ", sortFlag="
				+ sortFlag + "]";
	}
}