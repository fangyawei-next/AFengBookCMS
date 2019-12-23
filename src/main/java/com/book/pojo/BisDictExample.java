package com.book.pojo;

import java.util.ArrayList;
import java.util.List;

public class BisDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BisDictExample() {
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

        public Criteria andBisIdIsNull() {
            addCriterion("bis_id is null");
            return (Criteria) this;
        }

        public Criteria andBisIdIsNotNull() {
            addCriterion("bis_id is not null");
            return (Criteria) this;
        }

        public Criteria andBisIdEqualTo(Long value) {
            addCriterion("bis_id =", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdNotEqualTo(Long value) {
            addCriterion("bis_id <>", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdGreaterThan(Long value) {
            addCriterion("bis_id >", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bis_id >=", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdLessThan(Long value) {
            addCriterion("bis_id <", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdLessThanOrEqualTo(Long value) {
            addCriterion("bis_id <=", value, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdIn(List<Long> values) {
            addCriterion("bis_id in", values, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdNotIn(List<Long> values) {
            addCriterion("bis_id not in", values, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdBetween(Long value1, Long value2) {
            addCriterion("bis_id between", value1, value2, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisIdNotBetween(Long value1, Long value2) {
            addCriterion("bis_id not between", value1, value2, "bisId");
            return (Criteria) this;
        }

        public Criteria andBisNameIsNull() {
            addCriterion("bis_name is null");
            return (Criteria) this;
        }

        public Criteria andBisNameIsNotNull() {
            addCriterion("bis_name is not null");
            return (Criteria) this;
        }

        public Criteria andBisNameEqualTo(String value) {
            addCriterion("bis_name =", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameNotEqualTo(String value) {
            addCriterion("bis_name <>", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameGreaterThan(String value) {
            addCriterion("bis_name >", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameGreaterThanOrEqualTo(String value) {
            addCriterion("bis_name >=", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameLessThan(String value) {
            addCriterion("bis_name <", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameLessThanOrEqualTo(String value) {
            addCriterion("bis_name <=", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameLike(String value) {
            addCriterion("bis_name like", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameNotLike(String value) {
            addCriterion("bis_name not like", value, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameIn(List<String> values) {
            addCriterion("bis_name in", values, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameNotIn(List<String> values) {
            addCriterion("bis_name not in", values, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameBetween(String value1, String value2) {
            addCriterion("bis_name between", value1, value2, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisNameNotBetween(String value1, String value2) {
            addCriterion("bis_name not between", value1, value2, "bisName");
            return (Criteria) this;
        }

        public Criteria andBisDetailIsNull() {
            addCriterion("bis_detail is null");
            return (Criteria) this;
        }

        public Criteria andBisDetailIsNotNull() {
            addCriterion("bis_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBisDetailEqualTo(String value) {
            addCriterion("bis_detail =", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailNotEqualTo(String value) {
            addCriterion("bis_detail <>", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailGreaterThan(String value) {
            addCriterion("bis_detail >", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailGreaterThanOrEqualTo(String value) {
            addCriterion("bis_detail >=", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailLessThan(String value) {
            addCriterion("bis_detail <", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailLessThanOrEqualTo(String value) {
            addCriterion("bis_detail <=", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailLike(String value) {
            addCriterion("bis_detail like", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailNotLike(String value) {
            addCriterion("bis_detail not like", value, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailIn(List<String> values) {
            addCriterion("bis_detail in", values, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailNotIn(List<String> values) {
            addCriterion("bis_detail not in", values, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailBetween(String value1, String value2) {
            addCriterion("bis_detail between", value1, value2, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisDetailNotBetween(String value1, String value2) {
            addCriterion("bis_detail not between", value1, value2, "bisDetail");
            return (Criteria) this;
        }

        public Criteria andBisSortIsNull() {
            addCriterion("bis_sort is null");
            return (Criteria) this;
        }

        public Criteria andBisSortIsNotNull() {
            addCriterion("bis_sort is not null");
            return (Criteria) this;
        }

        public Criteria andBisSortEqualTo(Long value) {
            addCriterion("bis_sort =", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortNotEqualTo(Long value) {
            addCriterion("bis_sort <>", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortGreaterThan(Long value) {
            addCriterion("bis_sort >", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortGreaterThanOrEqualTo(Long value) {
            addCriterion("bis_sort >=", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortLessThan(Long value) {
            addCriterion("bis_sort <", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortLessThanOrEqualTo(Long value) {
            addCriterion("bis_sort <=", value, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortIn(List<Long> values) {
            addCriterion("bis_sort in", values, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortNotIn(List<Long> values) {
            addCriterion("bis_sort not in", values, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortBetween(Long value1, Long value2) {
            addCriterion("bis_sort between", value1, value2, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisSortNotBetween(Long value1, Long value2) {
            addCriterion("bis_sort not between", value1, value2, "bisSort");
            return (Criteria) this;
        }

        public Criteria andBisFlagIsNull() {
            addCriterion("bis_flag is null");
            return (Criteria) this;
        }

        public Criteria andBisFlagIsNotNull() {
            addCriterion("bis_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBisFlagEqualTo(Integer value) {
            addCriterion("bis_flag =", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagNotEqualTo(Integer value) {
            addCriterion("bis_flag <>", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagGreaterThan(Integer value) {
            addCriterion("bis_flag >", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("bis_flag >=", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagLessThan(Integer value) {
            addCriterion("bis_flag <", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagLessThanOrEqualTo(Integer value) {
            addCriterion("bis_flag <=", value, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagIn(List<Integer> values) {
            addCriterion("bis_flag in", values, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagNotIn(List<Integer> values) {
            addCriterion("bis_flag not in", values, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagBetween(Integer value1, Integer value2) {
            addCriterion("bis_flag between", value1, value2, "bisFlag");
            return (Criteria) this;
        }

        public Criteria andBisFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("bis_flag not between", value1, value2, "bisFlag");
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