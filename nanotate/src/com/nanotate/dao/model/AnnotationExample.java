package com.nanotate.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AnnotationExample {

	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public AnnotationExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOriginal_textIsNull() {
			addCriterion("original_text is null");
			return (Criteria) this;
		}

		public Criteria andOriginal_textIsNotNull() {
			addCriterion("original_text is not null");
			return (Criteria) this;
		}

		public Criteria andOriginal_textEqualTo(String value) {
			addCriterion("original_text =", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textNotEqualTo(String value) {
			addCriterion("original_text <>", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textGreaterThan(String value) {
			addCriterion("original_text >", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textGreaterThanOrEqualTo(String value) {
			addCriterion("original_text >=", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textLessThan(String value) {
			addCriterion("original_text <", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textLessThanOrEqualTo(String value) {
			addCriterion("original_text <=", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textLike(String value) {
			addCriterion("original_text like", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textNotLike(String value) {
			addCriterion("original_text not like", value, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textIn(List<String> values) {
			addCriterion("original_text in", values, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textNotIn(List<String> values) {
			addCriterion("original_text not in", values, "original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textBetween(String value1, String value2) {
			addCriterion("original_text between", value1, value2,
					"original_text");
			return (Criteria) this;
		}

		public Criteria andOriginal_textNotBetween(String value1, String value2) {
			addCriterion("original_text not between", value1, value2,
					"original_text");
			return (Criteria) this;
		}

		public Criteria andTagsIsNull() {
			addCriterion("tags is null");
			return (Criteria) this;
		}

		public Criteria andTagsIsNotNull() {
			addCriterion("tags is not null");
			return (Criteria) this;
		}

		public Criteria andTagsEqualTo(String value) {
			addCriterion("tags =", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotEqualTo(String value) {
			addCriterion("tags <>", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsGreaterThan(String value) {
			addCriterion("tags >", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsGreaterThanOrEqualTo(String value) {
			addCriterion("tags >=", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLessThan(String value) {
			addCriterion("tags <", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLessThanOrEqualTo(String value) {
			addCriterion("tags <=", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsLike(String value) {
			addCriterion("tags like", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotLike(String value) {
			addCriterion("tags not like", value, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsIn(List<String> values) {
			addCriterion("tags in", values, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotIn(List<String> values) {
			addCriterion("tags not in", values, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsBetween(String value1, String value2) {
			addCriterion("tags between", value1, value2, "tags");
			return (Criteria) this;
		}

		public Criteria andTagsNotBetween(String value1, String value2) {
			addCriterion("tags not between", value1, value2, "tags");
			return (Criteria) this;
		}

		public Criteria andDocumentIsNull() {
			addCriterion("document is null");
			return (Criteria) this;
		}

		public Criteria andDocumentIsNotNull() {
			addCriterion("document is not null");
			return (Criteria) this;
		}

		public Criteria andDocumentEqualTo(String value) {
			addCriterion("document =", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentNotEqualTo(String value) {
			addCriterion("document <>", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentGreaterThan(String value) {
			addCriterion("document >", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentGreaterThanOrEqualTo(String value) {
			addCriterion("document >=", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentLessThan(String value) {
			addCriterion("document <", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentLessThanOrEqualTo(String value) {
			addCriterion("document <=", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentLike(String value) {
			addCriterion("document like", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentNotLike(String value) {
			addCriterion("document not like", value, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentIn(List<String> values) {
			addCriterion("document in", values, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentNotIn(List<String> values) {
			addCriterion("document not in", values, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentBetween(String value1, String value2) {
			addCriterion("document between", value1, value2, "document");
			return (Criteria) this;
		}

		public Criteria andDocumentNotBetween(String value1, String value2) {
			addCriterion("document not between", value1, value2, "document");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreationIsNull() {
			addCriterion("creation is null");
			return (Criteria) this;
		}

		public Criteria andCreationIsNotNull() {
			addCriterion("creation is not null");
			return (Criteria) this;
		}

		public Criteria andCreationEqualTo(Date value) {
			addCriterion("creation =", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationNotEqualTo(Date value) {
			addCriterion("creation <>", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationGreaterThan(Date value) {
			addCriterion("creation >", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationGreaterThanOrEqualTo(Date value) {
			addCriterion("creation >=", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationLessThan(Date value) {
			addCriterion("creation <", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationLessThanOrEqualTo(Date value) {
			addCriterion("creation <=", value, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationIn(List<Date> values) {
			addCriterion("creation in", values, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationNotIn(List<Date> values) {
			addCriterion("creation not in", values, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationBetween(Date value1, Date value2) {
			addCriterion("creation between", value1, value2, "creation");
			return (Criteria) this;
		}

		public Criteria andCreationNotBetween(Date value1, Date value2) {
			addCriterion("creation not between", value1, value2, "creation");
			return (Criteria) this;
		}

		public Criteria andCompletedIsNull() {
			addCriterion("completed is null");
			return (Criteria) this;
		}

		public Criteria andCompletedIsNotNull() {
			addCriterion("completed is not null");
			return (Criteria) this;
		}

		public Criteria andCompletedEqualTo(Date value) {
			addCriterion("completed =", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedNotEqualTo(Date value) {
			addCriterion("completed <>", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedGreaterThan(Date value) {
			addCriterion("completed >", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedGreaterThanOrEqualTo(Date value) {
			addCriterion("completed >=", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedLessThan(Date value) {
			addCriterion("completed <", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedLessThanOrEqualTo(Date value) {
			addCriterion("completed <=", value, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedIn(List<Date> values) {
			addCriterion("completed in", values, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedNotIn(List<Date> values) {
			addCriterion("completed not in", values, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedBetween(Date value1, Date value2) {
			addCriterion("completed between", value1, value2, "completed");
			return (Criteria) this;
		}

		public Criteria andCompletedNotBetween(Date value1, Date value2) {
			addCriterion("completed not between", value1, value2, "completed");
			return (Criteria) this;
		}

		public Criteria andJson_valueIsNull() {
			addCriterion("json_value is null");
			return (Criteria) this;
		}

		public Criteria andJson_valueIsNotNull() {
			addCriterion("json_value is not null");
			return (Criteria) this;
		}

		public Criteria andJson_valueEqualTo(String value) {
			addCriterion("json_value =", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueNotEqualTo(String value) {
			addCriterion("json_value <>", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueGreaterThan(String value) {
			addCriterion("json_value >", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueGreaterThanOrEqualTo(String value) {
			addCriterion("json_value >=", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueLessThan(String value) {
			addCriterion("json_value <", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueLessThanOrEqualTo(String value) {
			addCriterion("json_value <=", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueLike(String value) {
			addCriterion("json_value like", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueNotLike(String value) {
			addCriterion("json_value not like", value, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueIn(List<String> values) {
			addCriterion("json_value in", values, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueNotIn(List<String> values) {
			addCriterion("json_value not in", values, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueBetween(String value1, String value2) {
			addCriterion("json_value between", value1, value2, "json_value");
			return (Criteria) this;
		}

		public Criteria andJson_valueNotBetween(String value1, String value2) {
			addCriterion("json_value not between", value1, value2, "json_value");
			return (Criteria) this;
		}

		public Criteria andDoiIsNull() {
			addCriterion("doi is null");
			return (Criteria) this;
		}

		public Criteria andDoiIsNotNull() {
			addCriterion("doi is not null");
			return (Criteria) this;
		}

		public Criteria andDoiEqualTo(String value) {
			addCriterion("doi =", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiNotEqualTo(String value) {
			addCriterion("doi <>", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiGreaterThan(String value) {
			addCriterion("doi >", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiGreaterThanOrEqualTo(String value) {
			addCriterion("doi >=", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiLessThan(String value) {
			addCriterion("doi <", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiLessThanOrEqualTo(String value) {
			addCriterion("doi <=", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiLike(String value) {
			addCriterion("doi like", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiNotLike(String value) {
			addCriterion("doi not like", value, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiIn(List<String> values) {
			addCriterion("doi in", values, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiNotIn(List<String> values) {
			addCriterion("doi not in", values, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiBetween(String value1, String value2) {
			addCriterion("doi between", value1, value2, "doi");
			return (Criteria) this;
		}

		public Criteria andDoiNotBetween(String value1, String value2) {
			addCriterion("doi not between", value1, value2, "doi");
			return (Criteria) this;
		}

		public Criteria andUser_nameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUser_nameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUser_nameEqualTo(String value) {
			addCriterion("user_name =", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameGreaterThan(String value) {
			addCriterion("user_name >", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLessThan(String value) {
			addCriterion("user_name <", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLike(String value) {
			addCriterion("user_name like", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotLike(String value) {
			addCriterion("user_name not like", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameIn(List<String> values) {
			addCriterion("user_name in", values, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "user_name");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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