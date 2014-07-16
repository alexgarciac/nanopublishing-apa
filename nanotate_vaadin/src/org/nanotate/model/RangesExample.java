package org.nanotate.model;

import java.util.ArrayList;
import java.util.List;

public class RangesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RangesExample() {
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

        public Criteria andRange_idIsNull() {
            addCriterion("range_id is null");
            return (Criteria) this;
        }

        public Criteria andRange_idIsNotNull() {
            addCriterion("range_id is not null");
            return (Criteria) this;
        }

        public Criteria andRange_idEqualTo(Integer value) {
            addCriterion("range_id =", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idNotEqualTo(Integer value) {
            addCriterion("range_id <>", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idGreaterThan(Integer value) {
            addCriterion("range_id >", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("range_id >=", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idLessThan(Integer value) {
            addCriterion("range_id <", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idLessThanOrEqualTo(Integer value) {
            addCriterion("range_id <=", value, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idIn(List<Integer> values) {
            addCriterion("range_id in", values, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idNotIn(List<Integer> values) {
            addCriterion("range_id not in", values, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idBetween(Integer value1, Integer value2) {
            addCriterion("range_id between", value1, value2, "range_id");
            return (Criteria) this;
        }

        public Criteria andRange_idNotBetween(Integer value1, Integer value2) {
            addCriterion("range_id not between", value1, value2, "range_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idIsNull() {
            addCriterion("annotation_id is null");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idIsNotNull() {
            addCriterion("annotation_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idEqualTo(String value) {
            addCriterion("annotation_id =", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idNotEqualTo(String value) {
            addCriterion("annotation_id <>", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idGreaterThan(String value) {
            addCriterion("annotation_id >", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idGreaterThanOrEqualTo(String value) {
            addCriterion("annotation_id >=", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idLessThan(String value) {
            addCriterion("annotation_id <", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idLessThanOrEqualTo(String value) {
            addCriterion("annotation_id <=", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idLike(String value) {
            addCriterion("annotation_id like", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idNotLike(String value) {
            addCriterion("annotation_id not like", value, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idIn(List<String> values) {
            addCriterion("annotation_id in", values, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idNotIn(List<String> values) {
            addCriterion("annotation_id not in", values, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idBetween(String value1, String value2) {
            addCriterion("annotation_id between", value1, value2, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andAnnotation_idNotBetween(String value1, String value2) {
            addCriterion("annotation_id not between", value1, value2, "annotation_id");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(String value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(String value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(String value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(String value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(String value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(String value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLike(String value) {
            addCriterion("start like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotLike(String value) {
            addCriterion("start not like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<String> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<String> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(String value1, String value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(String value1, String value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(String value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(String value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(String value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(String value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(String value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(String value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLike(String value) {
            addCriterion("end like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotLike(String value) {
            addCriterion("end not like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<String> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<String> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(String value1, String value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(String value1, String value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andStartOffsetIsNull() {
            addCriterion("startOffset is null");
            return (Criteria) this;
        }

        public Criteria andStartOffsetIsNotNull() {
            addCriterion("startOffset is not null");
            return (Criteria) this;
        }

        public Criteria andStartOffsetEqualTo(Integer value) {
            addCriterion("startOffset =", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetNotEqualTo(Integer value) {
            addCriterion("startOffset <>", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetGreaterThan(Integer value) {
            addCriterion("startOffset >", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("startOffset >=", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetLessThan(Integer value) {
            addCriterion("startOffset <", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("startOffset <=", value, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetIn(List<Integer> values) {
            addCriterion("startOffset in", values, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetNotIn(List<Integer> values) {
            addCriterion("startOffset not in", values, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetBetween(Integer value1, Integer value2) {
            addCriterion("startOffset between", value1, value2, "startOffset");
            return (Criteria) this;
        }

        public Criteria andStartOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("startOffset not between", value1, value2, "startOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetIsNull() {
            addCriterion("endOffset is null");
            return (Criteria) this;
        }

        public Criteria andEndOffsetIsNotNull() {
            addCriterion("endOffset is not null");
            return (Criteria) this;
        }

        public Criteria andEndOffsetEqualTo(Integer value) {
            addCriterion("endOffset =", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetNotEqualTo(Integer value) {
            addCriterion("endOffset <>", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetGreaterThan(Integer value) {
            addCriterion("endOffset >", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("endOffset >=", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetLessThan(Integer value) {
            addCriterion("endOffset <", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("endOffset <=", value, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetIn(List<Integer> values) {
            addCriterion("endOffset in", values, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetNotIn(List<Integer> values) {
            addCriterion("endOffset not in", values, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetBetween(Integer value1, Integer value2) {
            addCriterion("endOffset between", value1, value2, "endOffset");
            return (Criteria) this;
        }

        public Criteria andEndOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("endOffset not between", value1, value2, "endOffset");
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