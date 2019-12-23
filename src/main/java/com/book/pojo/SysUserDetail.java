package com.book.pojo;

import java.util.Date;

public class SysUserDetail {
    private Long detailId;

    private String detailName;

    private String detailSex;

    private Date detailDate;

    private String detailPhone;

    private String detailEmail;

    private String detailAutograph;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName == null ? null : detailName.trim();
    }

    public String getDetailSex() {
        return detailSex;
    }

    public void setDetailSex(String detailSex) {
        this.detailSex = detailSex == null ? null : detailSex.trim();
    }

    public Date getDetailDate() {
        return detailDate;
    }

    public void setDetailDate(Date detailDate) {
        this.detailDate = detailDate;
    }

    public String getDetailPhone() {
        return detailPhone;
    }

    public void setDetailPhone(String detailPhone) {
        this.detailPhone = detailPhone == null ? null : detailPhone.trim();
    }

    public String getDetailEmail() {
        return detailEmail;
    }

    public void setDetailEmail(String detailEmail) {
        this.detailEmail = detailEmail == null ? null : detailEmail.trim();
    }

    public String getDetailAutograph() {
        return detailAutograph;
    }

    public void setDetailAutograph(String detailAutograph) {
        this.detailAutograph = detailAutograph == null ? null : detailAutograph.trim();
    }

	@Override
	public String toString() {
		return "SysUserDetail [detailId=" + detailId + ", detailName=" + detailName + ", detailSex=" + detailSex
				+ ", detailDate=" + detailDate + ", detailPhone=" + detailPhone + ", detailEmail=" + detailEmail
				+ ", detailAutograph=" + detailAutograph + "]";
	}
}