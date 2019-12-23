package com.book.pojo;

public class SysRight {
    private String rightCode;

    private String rightParentCode;

    private String rightType;

    private String rightText;

    private String rightUrl;

    private String rightTip;

    private String rightImg;

    private String rightIscurrent;

    private Integer rightIsflag;

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    public String getRightParentCode() {
        return rightParentCode;
    }

    public void setRightParentCode(String rightParentCode) {
        this.rightParentCode = rightParentCode == null ? null : rightParentCode.trim();
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText == null ? null : rightText.trim();
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl == null ? null : rightUrl.trim();
    }

    public String getRightTip() {
        return rightTip;
    }

    public void setRightTip(String rightTip) {
        this.rightTip = rightTip == null ? null : rightTip.trim();
    }

    public String getRightImg() {
        return rightImg;
    }

    public void setRightImg(String rightImg) {
        this.rightImg = rightImg == null ? null : rightImg.trim();
    }

    public String getRightIscurrent() {
        return rightIscurrent;
    }

    public void setRightIscurrent(String rightIscurrent) {
        this.rightIscurrent = rightIscurrent == null ? null : rightIscurrent.trim();
    }

    public Integer getRightIsflag() {
        return rightIsflag;
    }

    public void setRightIsflag(Integer rightIsflag) {
        this.rightIsflag = rightIsflag;
    }

	@Override
	public String toString() {
		return "SysRight [rightCode=" + rightCode + ", rightParentCode=" + rightParentCode + ", rightType=" + rightType
				+ ", rightText=" + rightText + ", rightUrl=" + rightUrl + ", rightTip=" + rightTip + ", rightImg="
				+ rightImg + ", rightIscurrent=" + rightIscurrent + ", rightIsflag=" + rightIsflag + "]";
	}
}