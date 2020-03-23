package com.luo.yiting.bean;

import java.util.ArrayList;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
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

        public Criteria andLicensePlateIsNull() {
            addCriterion("license_plate is null");
            return (Criteria) this;
        }

        public Criteria andLicensePlateIsNotNull() {
            addCriterion("license_plate is not null");
            return (Criteria) this;
        }

        public Criteria andLicensePlateEqualTo(String value) {
            addCriterion("license_plate =", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotEqualTo(String value) {
            addCriterion("license_plate <>", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateGreaterThan(String value) {
            addCriterion("license_plate >", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateGreaterThanOrEqualTo(String value) {
            addCriterion("license_plate >=", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLessThan(String value) {
            addCriterion("license_plate <", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLessThanOrEqualTo(String value) {
            addCriterion("license_plate <=", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateLike(String value) {
            addCriterion("license_plate like", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotLike(String value) {
            addCriterion("license_plate not like", value, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateIn(List<String> values) {
            addCriterion("license_plate in", values, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotIn(List<String> values) {
            addCriterion("license_plate not in", values, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateBetween(String value1, String value2) {
            addCriterion("license_plate between", value1, value2, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andLicensePlateNotBetween(String value1, String value2) {
            addCriterion("license_plate not between", value1, value2, "licensePlate");
            return (Criteria) this;
        }

        public Criteria andNewEnergyIsNull() {
            addCriterion("new_energy is null");
            return (Criteria) this;
        }

        public Criteria andNewEnergyIsNotNull() {
            addCriterion("new_energy is not null");
            return (Criteria) this;
        }

        public Criteria andNewEnergyEqualTo(Integer value) {
            addCriterion("new_energy =", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyNotEqualTo(Integer value) {
            addCriterion("new_energy <>", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyGreaterThan(Integer value) {
            addCriterion("new_energy >", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_energy >=", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyLessThan(Integer value) {
            addCriterion("new_energy <", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyLessThanOrEqualTo(Integer value) {
            addCriterion("new_energy <=", value, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyIn(List<Integer> values) {
            addCriterion("new_energy in", values, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyNotIn(List<Integer> values) {
            addCriterion("new_energy not in", values, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyBetween(Integer value1, Integer value2) {
            addCriterion("new_energy between", value1, value2, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andNewEnergyNotBetween(Integer value1, Integer value2) {
            addCriterion("new_energy not between", value1, value2, "newEnergy");
            return (Criteria) this;
        }

        public Criteria andFrameNumberIsNull() {
            addCriterion("frame_number is null");
            return (Criteria) this;
        }

        public Criteria andFrameNumberIsNotNull() {
            addCriterion("frame_number is not null");
            return (Criteria) this;
        }

        public Criteria andFrameNumberEqualTo(String value) {
            addCriterion("frame_number =", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberNotEqualTo(String value) {
            addCriterion("frame_number <>", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberGreaterThan(String value) {
            addCriterion("frame_number >", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberGreaterThanOrEqualTo(String value) {
            addCriterion("frame_number >=", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberLessThan(String value) {
            addCriterion("frame_number <", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberLessThanOrEqualTo(String value) {
            addCriterion("frame_number <=", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberLike(String value) {
            addCriterion("frame_number like", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberNotLike(String value) {
            addCriterion("frame_number not like", value, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberIn(List<String> values) {
            addCriterion("frame_number in", values, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberNotIn(List<String> values) {
            addCriterion("frame_number not in", values, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberBetween(String value1, String value2) {
            addCriterion("frame_number between", value1, value2, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andFrameNumberNotBetween(String value1, String value2) {
            addCriterion("frame_number not between", value1, value2, "frameNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIsNull() {
            addCriterion("engine_number is null");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIsNotNull() {
            addCriterion("engine_number is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNumberEqualTo(String value) {
            addCriterion("engine_number =", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotEqualTo(String value) {
            addCriterion("engine_number <>", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberGreaterThan(String value) {
            addCriterion("engine_number >", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberGreaterThanOrEqualTo(String value) {
            addCriterion("engine_number >=", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLessThan(String value) {
            addCriterion("engine_number <", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLessThanOrEqualTo(String value) {
            addCriterion("engine_number <=", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLike(String value) {
            addCriterion("engine_number like", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotLike(String value) {
            addCriterion("engine_number not like", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIn(List<String> values) {
            addCriterion("engine_number in", values, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotIn(List<String> values) {
            addCriterion("engine_number not in", values, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberBetween(String value1, String value2) {
            addCriterion("engine_number between", value1, value2, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotBetween(String value1, String value2) {
            addCriterion("engine_number not between", value1, value2, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
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