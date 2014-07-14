package com.nanotate.model;

import java.util.ArrayList;
import java.util.List;

public class TagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TagExample() {
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

        public Criteria andTag_idIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTag_idIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTag_idEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idLessThan(Integer value) {
            addCriterion("tag_id <", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tag_id");
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

        public Criteria andTag_labelIsNull() {
            addCriterion("tag_label is null");
            return (Criteria) this;
        }

        public Criteria andTag_labelIsNotNull() {
            addCriterion("tag_label is not null");
            return (Criteria) this;
        }

        public Criteria andTag_labelEqualTo(String value) {
            addCriterion("tag_label =", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelNotEqualTo(String value) {
            addCriterion("tag_label <>", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelGreaterThan(String value) {
            addCriterion("tag_label >", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelGreaterThanOrEqualTo(String value) {
            addCriterion("tag_label >=", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelLessThan(String value) {
            addCriterion("tag_label <", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelLessThanOrEqualTo(String value) {
            addCriterion("tag_label <=", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelLike(String value) {
            addCriterion("tag_label like", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelNotLike(String value) {
            addCriterion("tag_label not like", value, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelIn(List<String> values) {
            addCriterion("tag_label in", values, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelNotIn(List<String> values) {
            addCriterion("tag_label not in", values, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelBetween(String value1, String value2) {
            addCriterion("tag_label between", value1, value2, "tag_label");
            return (Criteria) this;
        }

        public Criteria andTag_labelNotBetween(String value1, String value2) {
            addCriterion("tag_label not between", value1, value2, "tag_label");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagIsNull() {
            addCriterion("automatic_tag is null");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagIsNotNull() {
            addCriterion("automatic_tag is not null");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagEqualTo(Boolean value) {
            addCriterion("automatic_tag =", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagNotEqualTo(Boolean value) {
            addCriterion("automatic_tag <>", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagGreaterThan(Boolean value) {
            addCriterion("automatic_tag >", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("automatic_tag >=", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagLessThan(Boolean value) {
            addCriterion("automatic_tag <", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagLessThanOrEqualTo(Boolean value) {
            addCriterion("automatic_tag <=", value, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagIn(List<Boolean> values) {
            addCriterion("automatic_tag in", values, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagNotIn(List<Boolean> values) {
            addCriterion("automatic_tag not in", values, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagBetween(Boolean value1, Boolean value2) {
            addCriterion("automatic_tag between", value1, value2, "automatic_tag");
            return (Criteria) this;
        }

        public Criteria andAutomatic_tagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("automatic_tag not between", value1, value2, "automatic_tag");
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