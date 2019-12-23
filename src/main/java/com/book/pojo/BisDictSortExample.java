package com.book.pojo;

import java.util.ArrayList;
import java.util.List;

public class BisDictSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BisDictSortExample() {
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

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Long value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Long value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Long value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Long value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Long value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Long> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Long> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Long value1, Long value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Long value1, Long value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNull() {
            addCriterion("sort_name is null");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNotNull() {
            addCriterion("sort_name is not null");
            return (Criteria) this;
        }

        public Criteria andSortNameEqualTo(String value) {
            addCriterion("sort_name =", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotEqualTo(String value) {
            addCriterion("sort_name <>", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThan(String value) {
            addCriterion("sort_name >", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThanOrEqualTo(String value) {
            addCriterion("sort_name >=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThan(String value) {
            addCriterion("sort_name <", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThanOrEqualTo(String value) {
            addCriterion("sort_name <=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLike(String value) {
            addCriterion("sort_name like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotLike(String value) {
            addCriterion("sort_name not like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameIn(List<String> values) {
            addCriterion("sort_name in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotIn(List<String> values) {
            addCriterion("sort_name not in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameBetween(String value1, String value2) {
            addCriterion("sort_name between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotBetween(String value1, String value2) {
            addCriterion("sort_name not between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortDetailIsNull() {
            addCriterion("sort_detail is null");
            return (Criteria) this;
        }

        public Criteria andSortDetailIsNotNull() {
            addCriterion("sort_detail is not null");
            return (Criteria) this;
        }

        public Criteria andSortDetailEqualTo(String value) {
            addCriterion("sort_detail =", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotEqualTo(String value) {
            addCriterion("sort_detail <>", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailGreaterThan(String value) {
            addCriterion("sort_detail >", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailGreaterThanOrEqualTo(String value) {
            addCriterion("sort_detail >=", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLessThan(String value) {
            addCriterion("sort_detail <", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLessThanOrEqualTo(String value) {
            addCriterion("sort_detail <=", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLike(String value) {
            addCriterion("sort_detail like", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotLike(String value) {
            addCriterion("sort_detail not like", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailIn(List<String> values) {
            addCriterion("sort_detail in", values, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotIn(List<String> values) {
            addCriterion("sort_detail not in", values, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailBetween(String value1, String value2) {
            addCriterion("sort_detail between", value1, value2, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotBetween(String value1, String value2) {
            addCriterion("sort_detail not between", value1, value2, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortFlagIsNull() {
            addCriterion("sort_flag is null");
            return (Criteria) this;
        }

        public Criteria andSortFlagIsNotNull() {
            addCriterion("sort_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSortFlagEqualTo(String value) {
            addCriterion("sort_flag =", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagNotEqualTo(String value) {
            addCriterion("sort_flag <>", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagGreaterThan(String value) {
            addCriterion("sort_flag >", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sort_flag >=", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagLessThan(String value) {
            addCriterion("sort_flag <", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagLessThanOrEqualTo(String value) {
            addCriterion("sort_flag <=", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagLike(String value) {
            addCriterion("sort_flag like", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagNotLike(String value) {
            addCriterion("sort_flag not like", value, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagIn(List<String> values) {
            addCriterion("sort_flag in", values, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagNotIn(List<String> values) {
            addCriterion("sort_flag not in", values, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagBetween(String value1, String value2) {
            addCriterion("sort_flag between", value1, value2, "sortFlag");
            return (Criteria) this;
        }

        public Criteria andSortFlagNotBetween(String value1, String value2) {
            addCriterion("sort_flag not between", value1, value2, "sortFlag");
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