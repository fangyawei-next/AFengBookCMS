package com.book.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//解决: 是因为在实体类中 发现有字段为null，在转化成json的时候，fasterxml.jackson将对象转换为json报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Book {
    private Long id;

    private String name;

    private Double price;

    private String num;

    private String image;

    private String detail;

    private String author;

    private Long sort;

    private Long state;

    private Date startDate;

    private Date endDate;
    
    //联表查询一对一 关联字典表 类别、状态
    private BisDict sortBisDict;
    private BisDict stateBisDict;
    

	public BisDict getSortBisDict() {
		return sortBisDict;
	}

	public void setSortBisDict(BisDict sortBisDict) {
		this.sortBisDict = sortBisDict;
	}

	public BisDict getStateBisDict() {
		return stateBisDict;
	}

	public void setStateBisDict(BisDict stateBisDict) {
		this.stateBisDict = stateBisDict;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + ", image=" + image
				+ ", detail=" + detail + ", author=" + author + ", sort=" + sort + ", state=" + state + ", startDate="
				+ startDate + ", endDate=" + endDate + ", sortBisDict=" + sortBisDict + ", stateBisDict=" + stateBisDict
				+ ", getSortBisDict()=" + getSortBisDict() + ", getStateBisDict()=" + getStateBisDict() + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getNum()=" + getNum()
				+ ", getImage()=" + getImage() + ", getDetail()=" + getDetail() + ", getAuthor()=" + getAuthor()
				+ ", getSort()=" + getSort() + ", getState()=" + getState() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
