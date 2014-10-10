package com.wugu.zhaopin.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZpDeliveryInfoCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public ZpDeliveryInfoCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	protected ZpDeliveryInfoCriteria(ZpDeliveryInfoCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table zp_delivery_info
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition,
				List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andDeliveryInfoIdIsNull() {
			addCriterion("delivery_info_id is null");
			return this;
		}

		public Criteria andDeliveryInfoIdIsNotNull() {
			addCriterion("delivery_info_id is not null");
			return this;
		}

		public Criteria andDeliveryInfoIdEqualTo(Long value) {
			addCriterion("delivery_info_id =", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdNotEqualTo(Long value) {
			addCriterion("delivery_info_id <>", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdGreaterThan(Long value) {
			addCriterion("delivery_info_id >", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("delivery_info_id >=", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdLessThan(Long value) {
			addCriterion("delivery_info_id <", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdLessThanOrEqualTo(Long value) {
			addCriterion("delivery_info_id <=", value, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdIn(List<Long> values) {
			addCriterion("delivery_info_id in", values, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdNotIn(List<Long> values) {
			addCriterion("delivery_info_id not in", values, "deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdBetween(Long value1, Long value2) {
			addCriterion("delivery_info_id between", value1, value2,
					"deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryInfoIdNotBetween(Long value1, Long value2) {
			addCriterion("delivery_info_id not between", value1, value2,
					"deliveryInfoId");
			return this;
		}

		public Criteria andDeliveryUidIsNull() {
			addCriterion("delivery_uid is null");
			return this;
		}

		public Criteria andDeliveryUidIsNotNull() {
			addCriterion("delivery_uid is not null");
			return this;
		}

		public Criteria andDeliveryUidEqualTo(Long value) {
			addCriterion("delivery_uid =", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidNotEqualTo(Long value) {
			addCriterion("delivery_uid <>", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidGreaterThan(Long value) {
			addCriterion("delivery_uid >", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidGreaterThanOrEqualTo(Long value) {
			addCriterion("delivery_uid >=", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidLessThan(Long value) {
			addCriterion("delivery_uid <", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidLessThanOrEqualTo(Long value) {
			addCriterion("delivery_uid <=", value, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidIn(List<Long> values) {
			addCriterion("delivery_uid in", values, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidNotIn(List<Long> values) {
			addCriterion("delivery_uid not in", values, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidBetween(Long value1, Long value2) {
			addCriterion("delivery_uid between", value1, value2, "deliveryUid");
			return this;
		}

		public Criteria andDeliveryUidNotBetween(Long value1, Long value2) {
			addCriterion("delivery_uid not between", value1, value2,
					"deliveryUid");
			return this;
		}

		public Criteria andResumeIdIsNull() {
			addCriterion("resume_id is null");
			return this;
		}

		public Criteria andResumeIdIsNotNull() {
			addCriterion("resume_id is not null");
			return this;
		}

		public Criteria andResumeIdEqualTo(Long value) {
			addCriterion("resume_id =", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdNotEqualTo(Long value) {
			addCriterion("resume_id <>", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdGreaterThan(Long value) {
			addCriterion("resume_id >", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("resume_id >=", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdLessThan(Long value) {
			addCriterion("resume_id <", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdLessThanOrEqualTo(Long value) {
			addCriterion("resume_id <=", value, "resumeId");
			return this;
		}

		public Criteria andResumeIdIn(List<Long> values) {
			addCriterion("resume_id in", values, "resumeId");
			return this;
		}

		public Criteria andResumeIdNotIn(List<Long> values) {
			addCriterion("resume_id not in", values, "resumeId");
			return this;
		}

		public Criteria andResumeIdBetween(Long value1, Long value2) {
			addCriterion("resume_id between", value1, value2, "resumeId");
			return this;
		}

		public Criteria andResumeIdNotBetween(Long value1, Long value2) {
			addCriterion("resume_id not between", value1, value2, "resumeId");
			return this;
		}

		public Criteria andCompanyIdIsNull() {
			addCriterion("company_id is null");
			return this;
		}

		public Criteria andCompanyIdIsNotNull() {
			addCriterion("company_id is not null");
			return this;
		}

		public Criteria andCompanyIdEqualTo(Integer value) {
			addCriterion("company_id =", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdNotEqualTo(Integer value) {
			addCriterion("company_id <>", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdGreaterThan(Integer value) {
			addCriterion("company_id >", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("company_id >=", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdLessThan(Integer value) {
			addCriterion("company_id <", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
			addCriterion("company_id <=", value, "companyId");
			return this;
		}

		public Criteria andCompanyIdIn(List<Integer> values) {
			addCriterion("company_id in", values, "companyId");
			return this;
		}

		public Criteria andCompanyIdNotIn(List<Integer> values) {
			addCriterion("company_id not in", values, "companyId");
			return this;
		}

		public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
			addCriterion("company_id between", value1, value2, "companyId");
			return this;
		}

		public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("company_id not between", value1, value2, "companyId");
			return this;
		}

		public Criteria andPostIdIsNull() {
			addCriterion("post_id is null");
			return this;
		}

		public Criteria andPostIdIsNotNull() {
			addCriterion("post_id is not null");
			return this;
		}

		public Criteria andPostIdEqualTo(Integer value) {
			addCriterion("post_id =", value, "postId");
			return this;
		}

		public Criteria andPostIdNotEqualTo(Integer value) {
			addCriterion("post_id <>", value, "postId");
			return this;
		}

		public Criteria andPostIdGreaterThan(Integer value) {
			addCriterion("post_id >", value, "postId");
			return this;
		}

		public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_id >=", value, "postId");
			return this;
		}

		public Criteria andPostIdLessThan(Integer value) {
			addCriterion("post_id <", value, "postId");
			return this;
		}

		public Criteria andPostIdLessThanOrEqualTo(Integer value) {
			addCriterion("post_id <=", value, "postId");
			return this;
		}

		public Criteria andPostIdIn(List<Integer> values) {
			addCriterion("post_id in", values, "postId");
			return this;
		}

		public Criteria andPostIdNotIn(List<Integer> values) {
			addCriterion("post_id not in", values, "postId");
			return this;
		}

		public Criteria andPostIdBetween(Integer value1, Integer value2) {
			addCriterion("post_id between", value1, value2, "postId");
			return this;
		}

		public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
			addCriterion("post_id not between", value1, value2, "postId");
			return this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return this;
		}

		public Criteria andCreateTimeEqualTo(Integer value) {
			addCriterion("create_time =", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotEqualTo(Integer value) {
			addCriterion("create_time <>", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeGreaterThan(Integer value) {
			addCriterion("create_time >", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("create_time >=", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeLessThan(Integer value) {
			addCriterion("create_time <", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
			addCriterion("create_time <=", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeIn(List<Integer> values) {
			addCriterion("create_time in", values, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotIn(List<Integer> values) {
			addCriterion("create_time not in", values, "createTime");
			return this;
		}

		public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("create_time not between", value1, value2,
					"createTime");
			return this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return this;
		}

		public Criteria andUpdateTimeEqualTo(Integer value) {
			addCriterion("update_time =", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotEqualTo(Integer value) {
			addCriterion("update_time <>", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeGreaterThan(Integer value) {
			addCriterion("update_time >", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("update_time >=", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeLessThan(Integer value) {
			addCriterion("update_time <", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
			addCriterion("update_time <=", value, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeIn(List<Integer> values) {
			addCriterion("update_time in", values, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotIn(List<Integer> values) {
			addCriterion("update_time not in", values, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return this;
		}

		public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("update_time not between", value1, value2,
					"updateTime");
			return this;
		}

		public Criteria andOpIdIsNull() {
			addCriterion("op_id is null");
			return this;
		}

		public Criteria andOpIdIsNotNull() {
			addCriterion("op_id is not null");
			return this;
		}

		public Criteria andOpIdEqualTo(Long value) {
			addCriterion("op_id =", value, "opId");
			return this;
		}

		public Criteria andOpIdNotEqualTo(Long value) {
			addCriterion("op_id <>", value, "opId");
			return this;
		}

		public Criteria andOpIdGreaterThan(Long value) {
			addCriterion("op_id >", value, "opId");
			return this;
		}

		public Criteria andOpIdGreaterThanOrEqualTo(Long value) {
			addCriterion("op_id >=", value, "opId");
			return this;
		}

		public Criteria andOpIdLessThan(Long value) {
			addCriterion("op_id <", value, "opId");
			return this;
		}

		public Criteria andOpIdLessThanOrEqualTo(Long value) {
			addCriterion("op_id <=", value, "opId");
			return this;
		}

		public Criteria andOpIdIn(List<Long> values) {
			addCriterion("op_id in", values, "opId");
			return this;
		}

		public Criteria andOpIdNotIn(List<Long> values) {
			addCriterion("op_id not in", values, "opId");
			return this;
		}

		public Criteria andOpIdBetween(Long value1, Long value2) {
			addCriterion("op_id between", value1, value2, "opId");
			return this;
		}

		public Criteria andOpIdNotBetween(Long value1, Long value2) {
			addCriterion("op_id not between", value1, value2, "opId");
			return this;
		}
	}
}