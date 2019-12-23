package com.book.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//解决: 是因为在实体类中 发现有字段为null，在转化成json的时候，fasterxml.jackson将对象转换为json报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BisDict {
    private Long bisId;

    private String bisName;

    private String bisDetail;

    private Long bisSort;

    private Integer bisFlag;
    
    //联表一对一
    private BisDictSort bisDictSort;
    
    public BisDictSort getBisDictSort() {
		return bisDictSort;
	}

	public void setBisDictSort(BisDictSort bisDictSort) {
		this.bisDictSort = bisDictSort;
	}

	public Long getBisId() {
        return bisId;
    }

    public void setBisId(Long bisId) {
        this.bisId = bisId;
    }

    public String getBisName() {
        return bisName;
    }

    public void setBisName(String bisName) {
        this.bisName = bisName == null ? null : bisName.trim();
    }

    public String getBisDetail() {
        return bisDetail;
    }

    public void setBisDetail(String bisDetail) {
        this.bisDetail = bisDetail == null ? null : bisDetail.trim();
    }

    public Long getBisSort() {
        return bisSort;
    }

    public void setBisSort(Long bisSort) {
        this.bisSort = bisSort;
    }

    public Integer getBisFlag() {
        return bisFlag;
    }

    public void setBisFlag(Integer bisFlag) {
        this.bisFlag = bisFlag;
    }

	@Override
	public String toString() {
		return "BisDict [bisId=" + bisId + ", bisName=" + bisName + ", bisDetail=" + bisDetail + ", bisSort=" + bisSort
				+ ", bisFlag=" + bisFlag + ", bisDictSort=" + bisDictSort + "]";
	}
    
}