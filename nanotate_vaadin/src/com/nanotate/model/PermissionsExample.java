package com.nanotate.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionsExample() {
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

        public Criteria andPermission_idIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermission_idIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermission_idEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThan(Integer value) {
            addCriterion("permission_id <", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permission_id");
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

        public Criteria andRead_permissionIsNull() {
            addCriterion("read_permission is null");
            return (Criteria) this;
        }

        public Criteria andRead_permissionIsNotNull() {
            addCriterion("read_permission is not null");
            return (Criteria) this;
        }

        public Criteria andRead_permissionEqualTo(String value) {
            addCriterion("read_permission =", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionNotEqualTo(String value) {
            addCriterion("read_permission <>", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionGreaterThan(String value) {
            addCriterion("read_permission >", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionGreaterThanOrEqualTo(String value) {
            addCriterion("read_permission >=", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionLessThan(String value) {
            addCriterion("read_permission <", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionLessThanOrEqualTo(String value) {
            addCriterion("read_permission <=", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionLike(String value) {
            addCriterion("read_permission like", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionNotLike(String value) {
            addCriterion("read_permission not like", value, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionIn(List<String> values) {
            addCriterion("read_permission in", values, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionNotIn(List<String> values) {
            addCriterion("read_permission not in", values, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionBetween(String value1, String value2) {
            addCriterion("read_permission between", value1, value2, "read_permission");
            return (Criteria) this;
        }

        public Criteria andRead_permissionNotBetween(String value1, String value2) {
            addCriterion("read_permission not between", value1, value2, "read_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionIsNull() {
            addCriterion("admin_permission is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionIsNotNull() {
            addCriterion("admin_permission is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionEqualTo(String value) {
            addCriterion("admin_permission =", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionNotEqualTo(String value) {
            addCriterion("admin_permission <>", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionGreaterThan(String value) {
            addCriterion("admin_permission >", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionGreaterThanOrEqualTo(String value) {
            addCriterion("admin_permission >=", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionLessThan(String value) {
            addCriterion("admin_permission <", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionLessThanOrEqualTo(String value) {
            addCriterion("admin_permission <=", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionLike(String value) {
            addCriterion("admin_permission like", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionNotLike(String value) {
            addCriterion("admin_permission not like", value, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionIn(List<String> values) {
            addCriterion("admin_permission in", values, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionNotIn(List<String> values) {
            addCriterion("admin_permission not in", values, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionBetween(String value1, String value2) {
            addCriterion("admin_permission between", value1, value2, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andAdmin_permissionNotBetween(String value1, String value2) {
            addCriterion("admin_permission not between", value1, value2, "admin_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionIsNull() {
            addCriterion("update_permission is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionIsNotNull() {
            addCriterion("update_permission is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionEqualTo(String value) {
            addCriterion("update_permission =", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionNotEqualTo(String value) {
            addCriterion("update_permission <>", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionGreaterThan(String value) {
            addCriterion("update_permission >", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionGreaterThanOrEqualTo(String value) {
            addCriterion("update_permission >=", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionLessThan(String value) {
            addCriterion("update_permission <", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionLessThanOrEqualTo(String value) {
            addCriterion("update_permission <=", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionLike(String value) {
            addCriterion("update_permission like", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionNotLike(String value) {
            addCriterion("update_permission not like", value, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionIn(List<String> values) {
            addCriterion("update_permission in", values, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionNotIn(List<String> values) {
            addCriterion("update_permission not in", values, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionBetween(String value1, String value2) {
            addCriterion("update_permission between", value1, value2, "update_permission");
            return (Criteria) this;
        }

        public Criteria andUpdate_permissionNotBetween(String value1, String value2) {
            addCriterion("update_permission not between", value1, value2, "update_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionIsNull() {
            addCriterion("delete_permission is null");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionIsNotNull() {
            addCriterion("delete_permission is not null");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionEqualTo(String value) {
            addCriterion("delete_permission =", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionNotEqualTo(String value) {
            addCriterion("delete_permission <>", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionGreaterThan(String value) {
            addCriterion("delete_permission >", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionGreaterThanOrEqualTo(String value) {
            addCriterion("delete_permission >=", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionLessThan(String value) {
            addCriterion("delete_permission <", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionLessThanOrEqualTo(String value) {
            addCriterion("delete_permission <=", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionLike(String value) {
            addCriterion("delete_permission like", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionNotLike(String value) {
            addCriterion("delete_permission not like", value, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionIn(List<String> values) {
            addCriterion("delete_permission in", values, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionNotIn(List<String> values) {
            addCriterion("delete_permission not in", values, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionBetween(String value1, String value2) {
            addCriterion("delete_permission between", value1, value2, "delete_permission");
            return (Criteria) this;
        }

        public Criteria andDelete_permissionNotBetween(String value1, String value2) {
            addCriterion("delete_permission not between", value1, value2, "delete_permission");
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