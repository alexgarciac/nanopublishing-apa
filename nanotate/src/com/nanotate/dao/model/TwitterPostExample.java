package com.nanotate.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TwitterPostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TwitterPostExample() {
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

        public Criteria andIdtwitter_postIsNull() {
            addCriterion("idtwitter_post is null");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postIsNotNull() {
            addCriterion("idtwitter_post is not null");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postEqualTo(Integer value) {
            addCriterion("idtwitter_post =", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postNotEqualTo(Integer value) {
            addCriterion("idtwitter_post <>", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postGreaterThan(Integer value) {
            addCriterion("idtwitter_post >", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postGreaterThanOrEqualTo(Integer value) {
            addCriterion("idtwitter_post >=", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postLessThan(Integer value) {
            addCriterion("idtwitter_post <", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postLessThanOrEqualTo(Integer value) {
            addCriterion("idtwitter_post <=", value, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postIn(List<Integer> values) {
            addCriterion("idtwitter_post in", values, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postNotIn(List<Integer> values) {
            addCriterion("idtwitter_post not in", values, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postBetween(Integer value1, Integer value2) {
            addCriterion("idtwitter_post between", value1, value2, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdtwitter_postNotBetween(Integer value1, Integer value2) {
            addCriterion("idtwitter_post not between", value1, value2, "idtwitter_post");
            return (Criteria) this;
        }

        public Criteria andIdannotationIsNull() {
            addCriterion("idannotation is null");
            return (Criteria) this;
        }

        public Criteria andIdannotationIsNotNull() {
            addCriterion("idannotation is not null");
            return (Criteria) this;
        }

        public Criteria andIdannotationEqualTo(Integer value) {
            addCriterion("idannotation =", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationNotEqualTo(Integer value) {
            addCriterion("idannotation <>", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationGreaterThan(Integer value) {
            addCriterion("idannotation >", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationGreaterThanOrEqualTo(Integer value) {
            addCriterion("idannotation >=", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationLessThan(Integer value) {
            addCriterion("idannotation <", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationLessThanOrEqualTo(Integer value) {
            addCriterion("idannotation <=", value, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationIn(List<Integer> values) {
            addCriterion("idannotation in", values, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationNotIn(List<Integer> values) {
            addCriterion("idannotation not in", values, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationBetween(Integer value1, Integer value2) {
            addCriterion("idannotation between", value1, value2, "idannotation");
            return (Criteria) this;
        }

        public Criteria andIdannotationNotBetween(Integer value1, Integer value2) {
            addCriterion("idannotation not between", value1, value2, "idannotation");
            return (Criteria) this;
        }

        public Criteria andTweet_urlIsNull() {
            addCriterion("tweet_url is null");
            return (Criteria) this;
        }

        public Criteria andTweet_urlIsNotNull() {
            addCriterion("tweet_url is not null");
            return (Criteria) this;
        }

        public Criteria andTweet_urlEqualTo(String value) {
            addCriterion("tweet_url =", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlNotEqualTo(String value) {
            addCriterion("tweet_url <>", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlGreaterThan(String value) {
            addCriterion("tweet_url >", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlGreaterThanOrEqualTo(String value) {
            addCriterion("tweet_url >=", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlLessThan(String value) {
            addCriterion("tweet_url <", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlLessThanOrEqualTo(String value) {
            addCriterion("tweet_url <=", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlLike(String value) {
            addCriterion("tweet_url like", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlNotLike(String value) {
            addCriterion("tweet_url not like", value, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlIn(List<String> values) {
            addCriterion("tweet_url in", values, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlNotIn(List<String> values) {
            addCriterion("tweet_url not in", values, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlBetween(String value1, String value2) {
            addCriterion("tweet_url between", value1, value2, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andTweet_urlNotBetween(String value1, String value2) {
            addCriterion("tweet_url not between", value1, value2, "tweet_url");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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