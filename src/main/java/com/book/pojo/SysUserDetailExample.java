package com.book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysUserDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailNameIsNull() {
            addCriterion("detail_name is null");
            return (Criteria) this;
        }

        public Criteria andDetailNameIsNotNull() {
            addCriterion("detail_name is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNameEqualTo(String value) {
            addCriterion("detail_name =", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotEqualTo(String value) {
            addCriterion("detail_name <>", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameGreaterThan(String value) {
            addCriterion("detail_name >", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("detail_name >=", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLessThan(String value) {
            addCriterion("detail_name <", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLessThanOrEqualTo(String value) {
            addCriterion("detail_name <=", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLike(String value) {
            addCriterion("detail_name like", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotLike(String value) {
            addCriterion("detail_name not like", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameIn(List<String> values) {
            addCriterion("detail_name in", values, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotIn(List<String> values) {
            addCriterion("detail_name not in", values, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameBetween(String value1, String value2) {
            addCriterion("detail_name between", value1, value2, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotBetween(String value1, String value2) {
            addCriterion("detail_name not between", value1, value2, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailSexIsNull() {
            addCriterion("detail_sex is null");
            return (Criteria) this;
        }

        public Criteria andDetailSexIsNotNull() {
            addCriterion("detail_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSexEqualTo(String value) {
            addCriterion("detail_sex =", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexNotEqualTo(String value) {
            addCriterion("detail_sex <>", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexGreaterThan(String value) {
            addCriterion("detail_sex >", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexGreaterThanOrEqualTo(String value) {
            addCriterion("detail_sex >=", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexLessThan(String value) {
            addCriterion("detail_sex <", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexLessThanOrEqualTo(String value) {
            addCriterion("detail_sex <=", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexLike(String value) {
            addCriterion("detail_sex like", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexNotLike(String value) {
            addCriterion("detail_sex not like", value, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexIn(List<String> values) {
            addCriterion("detail_sex in", values, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexNotIn(List<String> values) {
            addCriterion("detail_sex not in", values, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexBetween(String value1, String value2) {
            addCriterion("detail_sex between", value1, value2, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailSexNotBetween(String value1, String value2) {
            addCriterion("detail_sex not between", value1, value2, "detailSex");
            return (Criteria) this;
        }

        public Criteria andDetailDateIsNull() {
            addCriterion("detail_date is null");
            return (Criteria) this;
        }

        public Criteria andDetailDateIsNotNull() {
            addCriterion("detail_date is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDateEqualTo(Date value) {
            addCriterionForJDBCDate("detail_date =", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("detail_date <>", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateGreaterThan(Date value) {
            addCriterionForJDBCDate("detail_date >", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("detail_date >=", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateLessThan(Date value) {
            addCriterionForJDBCDate("detail_date <", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("detail_date <=", value, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateIn(List<Date> values) {
            addCriterionForJDBCDate("detail_date in", values, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("detail_date not in", values, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("detail_date between", value1, value2, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("detail_date not between", value1, value2, "detailDate");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneIsNull() {
            addCriterion("detail_phone is null");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneIsNotNull() {
            addCriterion("detail_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneEqualTo(String value) {
            addCriterion("detail_phone =", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneNotEqualTo(String value) {
            addCriterion("detail_phone <>", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneGreaterThan(String value) {
            addCriterion("detail_phone >", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("detail_phone >=", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneLessThan(String value) {
            addCriterion("detail_phone <", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneLessThanOrEqualTo(String value) {
            addCriterion("detail_phone <=", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneLike(String value) {
            addCriterion("detail_phone like", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneNotLike(String value) {
            addCriterion("detail_phone not like", value, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneIn(List<String> values) {
            addCriterion("detail_phone in", values, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneNotIn(List<String> values) {
            addCriterion("detail_phone not in", values, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneBetween(String value1, String value2) {
            addCriterion("detail_phone between", value1, value2, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailPhoneNotBetween(String value1, String value2) {
            addCriterion("detail_phone not between", value1, value2, "detailPhone");
            return (Criteria) this;
        }

        public Criteria andDetailEmailIsNull() {
            addCriterion("detail_email is null");
            return (Criteria) this;
        }

        public Criteria andDetailEmailIsNotNull() {
            addCriterion("detail_email is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEmailEqualTo(String value) {
            addCriterion("detail_email =", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailNotEqualTo(String value) {
            addCriterion("detail_email <>", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailGreaterThan(String value) {
            addCriterion("detail_email >", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailGreaterThanOrEqualTo(String value) {
            addCriterion("detail_email >=", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailLessThan(String value) {
            addCriterion("detail_email <", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailLessThanOrEqualTo(String value) {
            addCriterion("detail_email <=", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailLike(String value) {
            addCriterion("detail_email like", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailNotLike(String value) {
            addCriterion("detail_email not like", value, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailIn(List<String> values) {
            addCriterion("detail_email in", values, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailNotIn(List<String> values) {
            addCriterion("detail_email not in", values, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailBetween(String value1, String value2) {
            addCriterion("detail_email between", value1, value2, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailEmailNotBetween(String value1, String value2) {
            addCriterion("detail_email not between", value1, value2, "detailEmail");
            return (Criteria) this;
        }

        public Criteria andDetailAutographIsNull() {
            addCriterion("detail_autograph is null");
            return (Criteria) this;
        }

        public Criteria andDetailAutographIsNotNull() {
            addCriterion("detail_autograph is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAutographEqualTo(String value) {
            addCriterion("detail_autograph =", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographNotEqualTo(String value) {
            addCriterion("detail_autograph <>", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographGreaterThan(String value) {
            addCriterion("detail_autograph >", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographGreaterThanOrEqualTo(String value) {
            addCriterion("detail_autograph >=", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographLessThan(String value) {
            addCriterion("detail_autograph <", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographLessThanOrEqualTo(String value) {
            addCriterion("detail_autograph <=", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographLike(String value) {
            addCriterion("detail_autograph like", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographNotLike(String value) {
            addCriterion("detail_autograph not like", value, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographIn(List<String> values) {
            addCriterion("detail_autograph in", values, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographNotIn(List<String> values) {
            addCriterion("detail_autograph not in", values, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographBetween(String value1, String value2) {
            addCriterion("detail_autograph between", value1, value2, "detailAutograph");
            return (Criteria) this;
        }

        public Criteria andDetailAutographNotBetween(String value1, String value2) {
            addCriterion("detail_autograph not between", value1, value2, "detailAutograph");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}