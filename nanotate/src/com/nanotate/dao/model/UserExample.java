package com.nanotate.dao.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {

	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public UserExample() {
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameIsNull() {
			addCriterion("twitter_username is null");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameIsNotNull() {
			addCriterion("twitter_username is not null");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameEqualTo(String value) {
			addCriterion("twitter_username =", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameNotEqualTo(String value) {
			addCriterion("twitter_username <>", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameGreaterThan(String value) {
			addCriterion("twitter_username >", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameGreaterThanOrEqualTo(String value) {
			addCriterion("twitter_username >=", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameLessThan(String value) {
			addCriterion("twitter_username <", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameLessThanOrEqualTo(String value) {
			addCriterion("twitter_username <=", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameLike(String value) {
			addCriterion("twitter_username like", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameNotLike(String value) {
			addCriterion("twitter_username not like", value, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameIn(List<String> values) {
			addCriterion("twitter_username in", values, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameNotIn(List<String> values) {
			addCriterion("twitter_username not in", values, "twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameBetween(String value1, String value2) {
			addCriterion("twitter_username between", value1, value2,
					"twitter_username");
			return (Criteria) this;
		}

		public Criteria andTwitter_usernameNotBetween(String value1,
				String value2) {
			addCriterion("twitter_username not between", value1, value2,
					"twitter_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameIsNull() {
			addCriterion("facebook_username is null");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameIsNotNull() {
			addCriterion("facebook_username is not null");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameEqualTo(String value) {
			addCriterion("facebook_username =", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameNotEqualTo(String value) {
			addCriterion("facebook_username <>", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameGreaterThan(String value) {
			addCriterion("facebook_username >", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameGreaterThanOrEqualTo(String value) {
			addCriterion("facebook_username >=", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameLessThan(String value) {
			addCriterion("facebook_username <", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameLessThanOrEqualTo(String value) {
			addCriterion("facebook_username <=", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameLike(String value) {
			addCriterion("facebook_username like", value, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameNotLike(String value) {
			addCriterion("facebook_username not like", value,
					"facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameIn(List<String> values) {
			addCriterion("facebook_username in", values, "facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameNotIn(List<String> values) {
			addCriterion("facebook_username not in", values,
					"facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameBetween(String value1, String value2) {
			addCriterion("facebook_username between", value1, value2,
					"facebook_username");
			return (Criteria) this;
		}

		public Criteria andFacebook_usernameNotBetween(String value1,
				String value2) {
			addCriterion("facebook_username not between", value1, value2,
					"facebook_username");
			return (Criteria) this;
		}

		public Criteria andFirstnameIsNull() {
			addCriterion("firstname is null");
			return (Criteria) this;
		}

		public Criteria andFirstnameIsNotNull() {
			addCriterion("firstname is not null");
			return (Criteria) this;
		}

		public Criteria andFirstnameEqualTo(String value) {
			addCriterion("firstname =", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotEqualTo(String value) {
			addCriterion("firstname <>", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameGreaterThan(String value) {
			addCriterion("firstname >", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameGreaterThanOrEqualTo(String value) {
			addCriterion("firstname >=", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLessThan(String value) {
			addCriterion("firstname <", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLessThanOrEqualTo(String value) {
			addCriterion("firstname <=", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLike(String value) {
			addCriterion("firstname like", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotLike(String value) {
			addCriterion("firstname not like", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameIn(List<String> values) {
			addCriterion("firstname in", values, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotIn(List<String> values) {
			addCriterion("firstname not in", values, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameBetween(String value1, String value2) {
			addCriterion("firstname between", value1, value2, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotBetween(String value1, String value2) {
			addCriterion("firstname not between", value1, value2, "firstname");
			return (Criteria) this;
		}

		public Criteria andLastnameIsNull() {
			addCriterion("lastname is null");
			return (Criteria) this;
		}

		public Criteria andLastnameIsNotNull() {
			addCriterion("lastname is not null");
			return (Criteria) this;
		}

		public Criteria andLastnameEqualTo(String value) {
			addCriterion("lastname =", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotEqualTo(String value) {
			addCriterion("lastname <>", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameGreaterThan(String value) {
			addCriterion("lastname >", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameGreaterThanOrEqualTo(String value) {
			addCriterion("lastname >=", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLessThan(String value) {
			addCriterion("lastname <", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLessThanOrEqualTo(String value) {
			addCriterion("lastname <=", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLike(String value) {
			addCriterion("lastname like", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotLike(String value) {
			addCriterion("lastname not like", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameIn(List<String> values) {
			addCriterion("lastname in", values, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotIn(List<String> values) {
			addCriterion("lastname not in", values, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameBetween(String value1, String value2) {
			addCriterion("lastname between", value1, value2, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotBetween(String value1, String value2) {
			addCriterion("lastname not between", value1, value2, "lastname");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenIsNull() {
			addCriterion("facebook_token is null");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenIsNotNull() {
			addCriterion("facebook_token is not null");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenEqualTo(String value) {
			addCriterion("facebook_token =", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenNotEqualTo(String value) {
			addCriterion("facebook_token <>", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenGreaterThan(String value) {
			addCriterion("facebook_token >", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenGreaterThanOrEqualTo(String value) {
			addCriterion("facebook_token >=", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenLessThan(String value) {
			addCriterion("facebook_token <", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenLessThanOrEqualTo(String value) {
			addCriterion("facebook_token <=", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenLike(String value) {
			addCriterion("facebook_token like", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenNotLike(String value) {
			addCriterion("facebook_token not like", value, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenIn(List<String> values) {
			addCriterion("facebook_token in", values, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenNotIn(List<String> values) {
			addCriterion("facebook_token not in", values, "facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenBetween(String value1, String value2) {
			addCriterion("facebook_token between", value1, value2,
					"facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_tokenNotBetween(String value1, String value2) {
			addCriterion("facebook_token not between", value1, value2,
					"facebook_token");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresIsNull() {
			addCriterion("facebook_token_expires is null");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresIsNotNull() {
			addCriterion("facebook_token_expires is not null");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresEqualTo(Long value) {
			addCriterion("facebook_token_expires =", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresNotEqualTo(Long value) {
			addCriterion("facebook_token_expires <>", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresGreaterThan(Long value) {
			addCriterion("facebook_token_expires >", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresGreaterThanOrEqualTo(Long value) {
			addCriterion("facebook_token_expires >=", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresLessThan(Long value) {
			addCriterion("facebook_token_expires <", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresLessThanOrEqualTo(Long value) {
			addCriterion("facebook_token_expires <=", value,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresIn(List<Long> values) {
			addCriterion("facebook_token_expires in", values,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresNotIn(List<Long> values) {
			addCriterion("facebook_token_expires not in", values,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresBetween(Long value1,
				Long value2) {
			addCriterion("facebook_token_expires between", value1, value2,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andFacebook_token_expiresNotBetween(Long value1,
				Long value2) {
			addCriterion("facebook_token_expires not between", value1, value2,
					"facebook_token_expires");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenIsNull() {
			addCriterion("twitter_token is null");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenIsNotNull() {
			addCriterion("twitter_token is not null");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenEqualTo(String value) {
			addCriterion("twitter_token =", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenNotEqualTo(String value) {
			addCriterion("twitter_token <>", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenGreaterThan(String value) {
			addCriterion("twitter_token >", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenGreaterThanOrEqualTo(String value) {
			addCriterion("twitter_token >=", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenLessThan(String value) {
			addCriterion("twitter_token <", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenLessThanOrEqualTo(String value) {
			addCriterion("twitter_token <=", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenLike(String value) {
			addCriterion("twitter_token like", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenNotLike(String value) {
			addCriterion("twitter_token not like", value, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenIn(List<String> values) {
			addCriterion("twitter_token in", values, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenNotIn(List<String> values) {
			addCriterion("twitter_token not in", values, "twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenBetween(String value1, String value2) {
			addCriterion("twitter_token between", value1, value2,
					"twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_tokenNotBetween(String value1, String value2) {
			addCriterion("twitter_token not between", value1, value2,
					"twitter_token");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretIsNull() {
			addCriterion("twitter_token_secret is null");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretIsNotNull() {
			addCriterion("twitter_token_secret is not null");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretEqualTo(String value) {
			addCriterion("twitter_token_secret =", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretNotEqualTo(String value) {
			addCriterion("twitter_token_secret <>", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretGreaterThan(String value) {
			addCriterion("twitter_token_secret >", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretGreaterThanOrEqualTo(String value) {
			addCriterion("twitter_token_secret >=", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretLessThan(String value) {
			addCriterion("twitter_token_secret <", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretLessThanOrEqualTo(String value) {
			addCriterion("twitter_token_secret <=", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretLike(String value) {
			addCriterion("twitter_token_secret like", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretNotLike(String value) {
			addCriterion("twitter_token_secret not like", value,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretIn(List<String> values) {
			addCriterion("twitter_token_secret in", values,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretNotIn(List<String> values) {
			addCriterion("twitter_token_secret not in", values,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretBetween(String value1,
				String value2) {
			addCriterion("twitter_token_secret between", value1, value2,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andTwitter_token_secretNotBetween(String value1,
				String value2) {
			addCriterion("twitter_token_secret not between", value1, value2,
					"twitter_token_secret");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlIsNull() {
			addCriterion("profile_pic_url is null");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlIsNotNull() {
			addCriterion("profile_pic_url is not null");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlEqualTo(String value) {
			addCriterion("profile_pic_url =", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlNotEqualTo(String value) {
			addCriterion("profile_pic_url <>", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlGreaterThan(String value) {
			addCriterion("profile_pic_url >", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlGreaterThanOrEqualTo(String value) {
			addCriterion("profile_pic_url >=", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlLessThan(String value) {
			addCriterion("profile_pic_url <", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlLessThanOrEqualTo(String value) {
			addCriterion("profile_pic_url <=", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlLike(String value) {
			addCriterion("profile_pic_url like", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlNotLike(String value) {
			addCriterion("profile_pic_url not like", value, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlIn(List<String> values) {
			addCriterion("profile_pic_url in", values, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlNotIn(List<String> values) {
			addCriterion("profile_pic_url not in", values, "profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlBetween(String value1, String value2) {
			addCriterion("profile_pic_url between", value1, value2,
					"profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andProfile_pic_urlNotBetween(String value1,
				String value2) {
			addCriterion("profile_pic_url not between", value1, value2,
					"profile_pic_url");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
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
	}}