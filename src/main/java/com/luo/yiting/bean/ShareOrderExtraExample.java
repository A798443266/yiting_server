package com.luo.yiting.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareOrderExtraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareOrderExtraExample() {
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

        public Criteria andBookerUpPicIsNull() {
            addCriterion("booker_up_pic is null");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicIsNotNull() {
            addCriterion("booker_up_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicEqualTo(String value) {
            addCriterion("booker_up_pic =", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicNotEqualTo(String value) {
            addCriterion("booker_up_pic <>", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicGreaterThan(String value) {
            addCriterion("booker_up_pic >", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicGreaterThanOrEqualTo(String value) {
            addCriterion("booker_up_pic >=", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicLessThan(String value) {
            addCriterion("booker_up_pic <", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicLessThanOrEqualTo(String value) {
            addCriterion("booker_up_pic <=", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicLike(String value) {
            addCriterion("booker_up_pic like", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicNotLike(String value) {
            addCriterion("booker_up_pic not like", value, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicIn(List<String> values) {
            addCriterion("booker_up_pic in", values, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicNotIn(List<String> values) {
            addCriterion("booker_up_pic not in", values, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicBetween(String value1, String value2) {
            addCriterion("booker_up_pic between", value1, value2, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andBookerUpPicNotBetween(String value1, String value2) {
            addCriterion("booker_up_pic not between", value1, value2, "bookerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicIsNull() {
            addCriterion("announcer_up_pic is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicIsNotNull() {
            addCriterion("announcer_up_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicEqualTo(String value) {
            addCriterion("announcer_up_pic =", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicNotEqualTo(String value) {
            addCriterion("announcer_up_pic <>", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicGreaterThan(String value) {
            addCriterion("announcer_up_pic >", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicGreaterThanOrEqualTo(String value) {
            addCriterion("announcer_up_pic >=", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicLessThan(String value) {
            addCriterion("announcer_up_pic <", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicLessThanOrEqualTo(String value) {
            addCriterion("announcer_up_pic <=", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicLike(String value) {
            addCriterion("announcer_up_pic like", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicNotLike(String value) {
            addCriterion("announcer_up_pic not like", value, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicIn(List<String> values) {
            addCriterion("announcer_up_pic in", values, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicNotIn(List<String> values) {
            addCriterion("announcer_up_pic not in", values, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicBetween(String value1, String value2) {
            addCriterion("announcer_up_pic between", value1, value2, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andAnnouncerUpPicNotBetween(String value1, String value2) {
            addCriterion("announcer_up_pic not between", value1, value2, "announcerUpPic");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBookerTimeIsNull() {
            addCriterion("booker_time is null");
            return (Criteria) this;
        }

        public Criteria andBookerTimeIsNotNull() {
            addCriterion("booker_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookerTimeEqualTo(Date value) {
            addCriterion("booker_time =", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeNotEqualTo(Date value) {
            addCriterion("booker_time <>", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeGreaterThan(Date value) {
            addCriterion("booker_time >", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("booker_time >=", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeLessThan(Date value) {
            addCriterion("booker_time <", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeLessThanOrEqualTo(Date value) {
            addCriterion("booker_time <=", value, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeIn(List<Date> values) {
            addCriterion("booker_time in", values, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeNotIn(List<Date> values) {
            addCriterion("booker_time not in", values, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeBetween(Date value1, Date value2) {
            addCriterion("booker_time between", value1, value2, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andBookerTimeNotBetween(Date value1, Date value2) {
            addCriterion("booker_time not between", value1, value2, "bookerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeIsNull() {
            addCriterion("announcer_time is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeIsNotNull() {
            addCriterion("announcer_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeEqualTo(Date value) {
            addCriterion("announcer_time =", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeNotEqualTo(Date value) {
            addCriterion("announcer_time <>", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeGreaterThan(Date value) {
            addCriterion("announcer_time >", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("announcer_time >=", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeLessThan(Date value) {
            addCriterion("announcer_time <", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeLessThanOrEqualTo(Date value) {
            addCriterion("announcer_time <=", value, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeIn(List<Date> values) {
            addCriterion("announcer_time in", values, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeNotIn(List<Date> values) {
            addCriterion("announcer_time not in", values, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeBetween(Date value1, Date value2) {
            addCriterion("announcer_time between", value1, value2, "announcerTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncerTimeNotBetween(Date value1, Date value2) {
            addCriterion("announcer_time not between", value1, value2, "announcerTime");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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