package com.demomodel.teaffic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvolvedTerrorPointsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvolvedTerrorPointsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNull() {
            addCriterion("id_num is null");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNotNull() {
            addCriterion("id_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumEqualTo(String value) {
            addCriterion("id_num =", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotEqualTo(String value) {
            addCriterion("id_num <>", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThan(String value) {
            addCriterion("id_num >", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_num >=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThan(String value) {
            addCriterion("id_num <", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThanOrEqualTo(String value) {
            addCriterion("id_num <=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLike(String value) {
            addCriterion("id_num like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotLike(String value) {
            addCriterion("id_num not like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumIn(List<String> values) {
            addCriterion("id_num in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotIn(List<String> values) {
            addCriterion("id_num not in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumBetween(String value1, String value2) {
            addCriterion("id_num between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotBetween(String value1, String value2) {
            addCriterion("id_num not between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNull() {
            addCriterion("birth_place is null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNotNull() {
            addCriterion("birth_place is not null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceEqualTo(String value) {
            addCriterion("birth_place =", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotEqualTo(String value) {
            addCriterion("birth_place <>", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThan(String value) {
            addCriterion("birth_place >", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("birth_place >=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThan(String value) {
            addCriterion("birth_place <", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("birth_place <=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLike(String value) {
            addCriterion("birth_place like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotLike(String value) {
            addCriterion("birth_place not like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIn(List<String> values) {
            addCriterion("birth_place in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotIn(List<String> values) {
            addCriterion("birth_place not in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceBetween(String value1, String value2) {
            addCriterion("birth_place between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("birth_place not between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsIsNull() {
            addCriterion("high_out_and_in_counts is null");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsIsNotNull() {
            addCriterion("high_out_and_in_counts is not null");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsEqualTo(Integer value) {
            addCriterion("high_out_and_in_counts =", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsNotEqualTo(Integer value) {
            addCriterion("high_out_and_in_counts <>", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsGreaterThan(Integer value) {
            addCriterion("high_out_and_in_counts >", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_out_and_in_counts >=", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsLessThan(Integer value) {
            addCriterion("high_out_and_in_counts <", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsLessThanOrEqualTo(Integer value) {
            addCriterion("high_out_and_in_counts <=", value, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsIn(List<Integer> values) {
            addCriterion("high_out_and_in_counts in", values, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsNotIn(List<Integer> values) {
            addCriterion("high_out_and_in_counts not in", values, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsBetween(Integer value1, Integer value2) {
            addCriterion("high_out_and_in_counts between", value1, value2, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighOutAndInCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("high_out_and_in_counts not between", value1, value2, "highOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsIsNull() {
            addCriterion("high_total_points is null");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsIsNotNull() {
            addCriterion("high_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsEqualTo(Integer value) {
            addCriterion("high_total_points =", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsNotEqualTo(Integer value) {
            addCriterion("high_total_points <>", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsGreaterThan(Integer value) {
            addCriterion("high_total_points >", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_total_points >=", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsLessThan(Integer value) {
            addCriterion("high_total_points <", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("high_total_points <=", value, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsIn(List<Integer> values) {
            addCriterion("high_total_points in", values, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsNotIn(List<Integer> values) {
            addCriterion("high_total_points not in", values, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("high_total_points between", value1, value2, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("high_total_points not between", value1, value2, "highTotalPoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceIsNull() {
            addCriterion("high_risk_place is null");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceIsNotNull() {
            addCriterion("high_risk_place is not null");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceEqualTo(Integer value) {
            addCriterion("high_risk_place =", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceNotEqualTo(Integer value) {
            addCriterion("high_risk_place <>", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceGreaterThan(Integer value) {
            addCriterion("high_risk_place >", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_risk_place >=", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceLessThan(Integer value) {
            addCriterion("high_risk_place <", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceLessThanOrEqualTo(Integer value) {
            addCriterion("high_risk_place <=", value, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceIn(List<Integer> values) {
            addCriterion("high_risk_place in", values, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceNotIn(List<Integer> values) {
            addCriterion("high_risk_place not in", values, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_place between", value1, value2, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlaceNotBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_place not between", value1, value2, "highRiskPlace");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsIsNull() {
            addCriterion("high_risk_place_points is null");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsIsNotNull() {
            addCriterion("high_risk_place_points is not null");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsEqualTo(Integer value) {
            addCriterion("high_risk_place_points =", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsNotEqualTo(Integer value) {
            addCriterion("high_risk_place_points <>", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsGreaterThan(Integer value) {
            addCriterion("high_risk_place_points >", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_risk_place_points >=", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsLessThan(Integer value) {
            addCriterion("high_risk_place_points <", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsLessThanOrEqualTo(Integer value) {
            addCriterion("high_risk_place_points <=", value, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsIn(List<Integer> values) {
            addCriterion("high_risk_place_points in", values, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsNotIn(List<Integer> values) {
            addCriterion("high_risk_place_points not in", values, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_place_points between", value1, value2, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andHighRiskPlacePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_place_points not between", value1, value2, "highRiskPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsIsNull() {
            addCriterion("temple_out_and_in_counts is null");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsIsNotNull() {
            addCriterion("temple_out_and_in_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsEqualTo(Integer value) {
            addCriterion("temple_out_and_in_counts =", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsNotEqualTo(Integer value) {
            addCriterion("temple_out_and_in_counts <>", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsGreaterThan(Integer value) {
            addCriterion("temple_out_and_in_counts >", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("temple_out_and_in_counts >=", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsLessThan(Integer value) {
            addCriterion("temple_out_and_in_counts <", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsLessThanOrEqualTo(Integer value) {
            addCriterion("temple_out_and_in_counts <=", value, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsIn(List<Integer> values) {
            addCriterion("temple_out_and_in_counts in", values, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsNotIn(List<Integer> values) {
            addCriterion("temple_out_and_in_counts not in", values, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsBetween(Integer value1, Integer value2) {
            addCriterion("temple_out_and_in_counts between", value1, value2, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleOutAndInCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("temple_out_and_in_counts not between", value1, value2, "templeOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsIsNull() {
            addCriterion("temple_total_points is null");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsIsNotNull() {
            addCriterion("temple_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsEqualTo(Integer value) {
            addCriterion("temple_total_points =", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsNotEqualTo(Integer value) {
            addCriterion("temple_total_points <>", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsGreaterThan(Integer value) {
            addCriterion("temple_total_points >", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("temple_total_points >=", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsLessThan(Integer value) {
            addCriterion("temple_total_points <", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("temple_total_points <=", value, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsIn(List<Integer> values) {
            addCriterion("temple_total_points in", values, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsNotIn(List<Integer> values) {
            addCriterion("temple_total_points not in", values, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("temple_total_points between", value1, value2, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("temple_total_points not between", value1, value2, "templeTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountIsNull() {
            addCriterion("temple_double_access_count is null");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountIsNotNull() {
            addCriterion("temple_double_access_count is not null");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountEqualTo(Integer value) {
            addCriterion("temple_double_access_count =", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountNotEqualTo(Integer value) {
            addCriterion("temple_double_access_count <>", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountGreaterThan(Integer value) {
            addCriterion("temple_double_access_count >", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("temple_double_access_count >=", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountLessThan(Integer value) {
            addCriterion("temple_double_access_count <", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("temple_double_access_count <=", value, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountIn(List<Integer> values) {
            addCriterion("temple_double_access_count in", values, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountNotIn(List<Integer> values) {
            addCriterion("temple_double_access_count not in", values, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountBetween(Integer value1, Integer value2) {
            addCriterion("temple_double_access_count between", value1, value2, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("temple_double_access_count not between", value1, value2, "templeDoubleAccessCount");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsIsNull() {
            addCriterion("temple__double_access_points is null");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsIsNotNull() {
            addCriterion("temple__double_access_points is not null");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsEqualTo(Integer value) {
            addCriterion("temple__double_access_points =", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsNotEqualTo(Integer value) {
            addCriterion("temple__double_access_points <>", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsGreaterThan(Integer value) {
            addCriterion("temple__double_access_points >", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("temple__double_access_points >=", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsLessThan(Integer value) {
            addCriterion("temple__double_access_points <", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsLessThanOrEqualTo(Integer value) {
            addCriterion("temple__double_access_points <=", value, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsIn(List<Integer> values) {
            addCriterion("temple__double_access_points in", values, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsNotIn(List<Integer> values) {
            addCriterion("temple__double_access_points not in", values, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsBetween(Integer value1, Integer value2) {
            addCriterion("temple__double_access_points between", value1, value2, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andTempleDoubleAccessPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("temple__double_access_points not between", value1, value2, "templeDoubleAccessPoints");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsIsNull() {
            addCriterion("peers_out_and_in_counts is null");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsIsNotNull() {
            addCriterion("peers_out_and_in_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsEqualTo(Integer value) {
            addCriterion("peers_out_and_in_counts =", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsNotEqualTo(Integer value) {
            addCriterion("peers_out_and_in_counts <>", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsGreaterThan(Integer value) {
            addCriterion("peers_out_and_in_counts >", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_out_and_in_counts >=", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsLessThan(Integer value) {
            addCriterion("peers_out_and_in_counts <", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_out_and_in_counts <=", value, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsIn(List<Integer> values) {
            addCriterion("peers_out_and_in_counts in", values, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsNotIn(List<Integer> values) {
            addCriterion("peers_out_and_in_counts not in", values, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsBetween(Integer value1, Integer value2) {
            addCriterion("peers_out_and_in_counts between", value1, value2, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersOutAndInCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_out_and_in_counts not between", value1, value2, "peersOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsIsNull() {
            addCriterion("peers_total_points is null");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsIsNotNull() {
            addCriterion("peers_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsEqualTo(Integer value) {
            addCriterion("peers_total_points =", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsNotEqualTo(Integer value) {
            addCriterion("peers_total_points <>", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsGreaterThan(Integer value) {
            addCriterion("peers_total_points >", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_total_points >=", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsLessThan(Integer value) {
            addCriterion("peers_total_points <", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_total_points <=", value, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsIn(List<Integer> values) {
            addCriterion("peers_total_points in", values, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsNotIn(List<Integer> values) {
            addCriterion("peers_total_points not in", values, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("peers_total_points between", value1, value2, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_total_points not between", value1, value2, "peersTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsIsNull() {
            addCriterion("peers_with_terror_counts is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsIsNotNull() {
            addCriterion("peers_with_terror_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsEqualTo(Integer value) {
            addCriterion("peers_with_terror_counts =", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsNotEqualTo(Integer value) {
            addCriterion("peers_with_terror_counts <>", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsGreaterThan(Integer value) {
            addCriterion("peers_with_terror_counts >", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_terror_counts >=", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsLessThan(Integer value) {
            addCriterion("peers_with_terror_counts <", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_terror_counts <=", value, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsIn(List<Integer> values) {
            addCriterion("peers_with_terror_counts in", values, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsNotIn(List<Integer> values) {
            addCriterion("peers_with_terror_counts not in", values, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_terror_counts between", value1, value2, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_terror_counts not between", value1, value2, "peersWithTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsIsNull() {
            addCriterion("peers_with_terror_points is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsIsNotNull() {
            addCriterion("peers_with_terror_points is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsEqualTo(Integer value) {
            addCriterion("peers_with_terror_points =", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsNotEqualTo(Integer value) {
            addCriterion("peers_with_terror_points <>", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsGreaterThan(Integer value) {
            addCriterion("peers_with_terror_points >", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_terror_points >=", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsLessThan(Integer value) {
            addCriterion("peers_with_terror_points <", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_terror_points <=", value, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsIn(List<Integer> values) {
            addCriterion("peers_with_terror_points in", values, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsNotIn(List<Integer> values) {
            addCriterion("peers_with_terror_points not in", values, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_terror_points between", value1, value2, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTerrorPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_terror_points not between", value1, value2, "peersWithTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsIsNull() {
            addCriterion("peers_with_train_terror_counts is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsIsNotNull() {
            addCriterion("peers_with_train_terror_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_counts =", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsNotEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_counts <>", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsGreaterThan(Integer value) {
            addCriterion("peers_with_train_terror_counts >", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_counts >=", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsLessThan(Integer value) {
            addCriterion("peers_with_train_terror_counts <", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_counts <=", value, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsIn(List<Integer> values) {
            addCriterion("peers_with_train_terror_counts in", values, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsNotIn(List<Integer> values) {
            addCriterion("peers_with_train_terror_counts not in", values, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_train_terror_counts between", value1, value2, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_train_terror_counts not between", value1, value2, "peersWithTrainTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsIsNull() {
            addCriterion("peers_with_train_terror_points is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsIsNotNull() {
            addCriterion("peers_with_train_terror_points is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_points =", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsNotEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_points <>", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsGreaterThan(Integer value) {
            addCriterion("peers_with_train_terror_points >", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_points >=", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsLessThan(Integer value) {
            addCriterion("peers_with_train_terror_points <", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_train_terror_points <=", value, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsIn(List<Integer> values) {
            addCriterion("peers_with_train_terror_points in", values, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsNotIn(List<Integer> values) {
            addCriterion("peers_with_train_terror_points not in", values, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_train_terror_points between", value1, value2, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithTrainTerrorPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_train_terror_points not between", value1, value2, "peersWithTrainTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsIsNull() {
            addCriterion("peers_with_plane_terror_counts is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsIsNotNull() {
            addCriterion("peers_with_plane_terror_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_counts =", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsNotEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_counts <>", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsGreaterThan(Integer value) {
            addCriterion("peers_with_plane_terror_counts >", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_counts >=", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsLessThan(Integer value) {
            addCriterion("peers_with_plane_terror_counts <", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_counts <=", value, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsIn(List<Integer> values) {
            addCriterion("peers_with_plane_terror_counts in", values, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsNotIn(List<Integer> values) {
            addCriterion("peers_with_plane_terror_counts not in", values, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_plane_terror_counts between", value1, value2, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_plane_terror_counts not between", value1, value2, "peersWithPlaneTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsIsNull() {
            addCriterion("peers_with_plane_terror_points is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsIsNotNull() {
            addCriterion("peers_with_plane_terror_points is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_points =", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsNotEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_points <>", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsGreaterThan(Integer value) {
            addCriterion("peers_with_plane_terror_points >", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_points >=", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsLessThan(Integer value) {
            addCriterion("peers_with_plane_terror_points <", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_plane_terror_points <=", value, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsIn(List<Integer> values) {
            addCriterion("peers_with_plane_terror_points in", values, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsNotIn(List<Integer> values) {
            addCriterion("peers_with_plane_terror_points not in", values, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_plane_terror_points between", value1, value2, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithPlaneTerrorPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_plane_terror_points not between", value1, value2, "peersWithPlaneTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsIsNull() {
            addCriterion("peers_with_car_terror_counts is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsIsNotNull() {
            addCriterion("peers_with_car_terror_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_counts =", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsNotEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_counts <>", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsGreaterThan(Integer value) {
            addCriterion("peers_with_car_terror_counts >", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_counts >=", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsLessThan(Integer value) {
            addCriterion("peers_with_car_terror_counts <", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_counts <=", value, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsIn(List<Integer> values) {
            addCriterion("peers_with_car_terror_counts in", values, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsNotIn(List<Integer> values) {
            addCriterion("peers_with_car_terror_counts not in", values, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_car_terror_counts between", value1, value2, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_car_terror_counts not between", value1, value2, "peersWithCarTerrorCounts");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsIsNull() {
            addCriterion("peers_with_car_terror_points is null");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsIsNotNull() {
            addCriterion("peers_with_car_terror_points is not null");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_points =", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsNotEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_points <>", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsGreaterThan(Integer value) {
            addCriterion("peers_with_car_terror_points >", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_points >=", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsLessThan(Integer value) {
            addCriterion("peers_with_car_terror_points <", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsLessThanOrEqualTo(Integer value) {
            addCriterion("peers_with_car_terror_points <=", value, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsIn(List<Integer> values) {
            addCriterion("peers_with_car_terror_points in", values, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsNotIn(List<Integer> values) {
            addCriterion("peers_with_car_terror_points not in", values, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_car_terror_points between", value1, value2, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andPeersWithCarTerrorPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("peers_with_car_terror_points not between", value1, value2, "peersWithCarTerrorPoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsIsNull() {
            addCriterion("telephone_points is null");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsIsNotNull() {
            addCriterion("telephone_points is not null");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsEqualTo(Integer value) {
            addCriterion("telephone_points =", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsNotEqualTo(Integer value) {
            addCriterion("telephone_points <>", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsGreaterThan(Integer value) {
            addCriterion("telephone_points >", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_points >=", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsLessThan(Integer value) {
            addCriterion("telephone_points <", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_points <=", value, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsIn(List<Integer> values) {
            addCriterion("telephone_points in", values, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsNotIn(List<Integer> values) {
            addCriterion("telephone_points not in", values, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_points between", value1, value2, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephonePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_points not between", value1, value2, "telephonePoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsIsNull() {
            addCriterion("telephone_total_points is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsIsNotNull() {
            addCriterion("telephone_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsEqualTo(Integer value) {
            addCriterion("telephone_total_points =", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsNotEqualTo(Integer value) {
            addCriterion("telephone_total_points <>", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsGreaterThan(Integer value) {
            addCriterion("telephone_total_points >", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_total_points >=", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsLessThan(Integer value) {
            addCriterion("telephone_total_points <", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_total_points <=", value, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsIn(List<Integer> values) {
            addCriterion("telephone_total_points in", values, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsNotIn(List<Integer> values) {
            addCriterion("telephone_total_points not in", values, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_total_points between", value1, value2, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_total_points not between", value1, value2, "telephoneTotalPoints");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsIsNull() {
            addCriterion("phone_has_terror_message_counts is null");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsIsNotNull() {
            addCriterion("phone_has_terror_message_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsEqualTo(Integer value) {
            addCriterion("phone_has_terror_message_counts =", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsNotEqualTo(Integer value) {
            addCriterion("phone_has_terror_message_counts <>", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsGreaterThan(Integer value) {
            addCriterion("phone_has_terror_message_counts >", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_has_terror_message_counts >=", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsLessThan(Integer value) {
            addCriterion("phone_has_terror_message_counts <", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsLessThanOrEqualTo(Integer value) {
            addCriterion("phone_has_terror_message_counts <=", value, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsIn(List<Integer> values) {
            addCriterion("phone_has_terror_message_counts in", values, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsNotIn(List<Integer> values) {
            addCriterion("phone_has_terror_message_counts not in", values, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsBetween(Integer value1, Integer value2) {
            addCriterion("phone_has_terror_message_counts between", value1, value2, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorMessageCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_has_terror_message_counts not between", value1, value2, "phoneHasTerrorMessageCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsIsNull() {
            addCriterion("phone_in_terror_existence_counts is null");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsIsNotNull() {
            addCriterion("phone_in_terror_existence_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsEqualTo(Integer value) {
            addCriterion("phone_in_terror_existence_counts =", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsNotEqualTo(Integer value) {
            addCriterion("phone_in_terror_existence_counts <>", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsGreaterThan(Integer value) {
            addCriterion("phone_in_terror_existence_counts >", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_in_terror_existence_counts >=", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsLessThan(Integer value) {
            addCriterion("phone_in_terror_existence_counts <", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsLessThanOrEqualTo(Integer value) {
            addCriterion("phone_in_terror_existence_counts <=", value, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsIn(List<Integer> values) {
            addCriterion("phone_in_terror_existence_counts in", values, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsNotIn(List<Integer> values) {
            addCriterion("phone_in_terror_existence_counts not in", values, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsBetween(Integer value1, Integer value2) {
            addCriterion("phone_in_terror_existence_counts between", value1, value2, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorExistenceCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_in_terror_existence_counts not between", value1, value2, "phoneInTerrorExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsIsNull() {
            addCriterion("phone_in_terror_contact_counts is null");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsIsNotNull() {
            addCriterion("phone_in_terror_contact_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsEqualTo(Integer value) {
            addCriterion("phone_in_terror_contact_counts =", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsNotEqualTo(Integer value) {
            addCriterion("phone_in_terror_contact_counts <>", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsGreaterThan(Integer value) {
            addCriterion("phone_in_terror_contact_counts >", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_in_terror_contact_counts >=", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsLessThan(Integer value) {
            addCriterion("phone_in_terror_contact_counts <", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsLessThanOrEqualTo(Integer value) {
            addCriterion("phone_in_terror_contact_counts <=", value, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsIn(List<Integer> values) {
            addCriterion("phone_in_terror_contact_counts in", values, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsNotIn(List<Integer> values) {
            addCriterion("phone_in_terror_contact_counts not in", values, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsBetween(Integer value1, Integer value2) {
            addCriterion("phone_in_terror_contact_counts between", value1, value2, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneInTerrorContactCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_in_terror_contact_counts not between", value1, value2, "phoneInTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsIsNull() {
            addCriterion("phone_has_terror_call_counts is null");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsIsNotNull() {
            addCriterion("phone_has_terror_call_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsEqualTo(Integer value) {
            addCriterion("phone_has_terror_call_counts =", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsNotEqualTo(Integer value) {
            addCriterion("phone_has_terror_call_counts <>", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsGreaterThan(Integer value) {
            addCriterion("phone_has_terror_call_counts >", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_has_terror_call_counts >=", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsLessThan(Integer value) {
            addCriterion("phone_has_terror_call_counts <", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsLessThanOrEqualTo(Integer value) {
            addCriterion("phone_has_terror_call_counts <=", value, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsIn(List<Integer> values) {
            addCriterion("phone_has_terror_call_counts in", values, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsNotIn(List<Integer> values) {
            addCriterion("phone_has_terror_call_counts not in", values, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsBetween(Integer value1, Integer value2) {
            addCriterion("phone_has_terror_call_counts between", value1, value2, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andPhoneHasTerrorCallCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_has_terror_call_counts not between", value1, value2, "phoneHasTerrorCallCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsIsNull() {
            addCriterion("wechat_has_terror_contact_counts is null");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsIsNotNull() {
            addCriterion("wechat_has_terror_contact_counts is not null");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsEqualTo(Integer value) {
            addCriterion("wechat_has_terror_contact_counts =", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsNotEqualTo(Integer value) {
            addCriterion("wechat_has_terror_contact_counts <>", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsGreaterThan(Integer value) {
            addCriterion("wechat_has_terror_contact_counts >", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechat_has_terror_contact_counts >=", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsLessThan(Integer value) {
            addCriterion("wechat_has_terror_contact_counts <", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsLessThanOrEqualTo(Integer value) {
            addCriterion("wechat_has_terror_contact_counts <=", value, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsIn(List<Integer> values) {
            addCriterion("wechat_has_terror_contact_counts in", values, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsNotIn(List<Integer> values) {
            addCriterion("wechat_has_terror_contact_counts not in", values, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsBetween(Integer value1, Integer value2) {
            addCriterion("wechat_has_terror_contact_counts between", value1, value2, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasTerrorContactCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("wechat_has_terror_contact_counts not between", value1, value2, "wechatHasTerrorContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsIsNull() {
            addCriterion("wechat_in_terror_group_counts is null");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsIsNotNull() {
            addCriterion("wechat_in_terror_group_counts is not null");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsEqualTo(Integer value) {
            addCriterion("wechat_in_terror_group_counts =", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsNotEqualTo(Integer value) {
            addCriterion("wechat_in_terror_group_counts <>", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsGreaterThan(Integer value) {
            addCriterion("wechat_in_terror_group_counts >", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechat_in_terror_group_counts >=", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsLessThan(Integer value) {
            addCriterion("wechat_in_terror_group_counts <", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsLessThanOrEqualTo(Integer value) {
            addCriterion("wechat_in_terror_group_counts <=", value, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsIn(List<Integer> values) {
            addCriterion("wechat_in_terror_group_counts in", values, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsNotIn(List<Integer> values) {
            addCriterion("wechat_in_terror_group_counts not in", values, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsBetween(Integer value1, Integer value2) {
            addCriterion("wechat_in_terror_group_counts between", value1, value2, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInTerrorGroupCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("wechat_in_terror_group_counts not between", value1, value2, "wechatInTerrorGroupCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsIsNull() {
            addCriterion("internetbar_out_and_in_points is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsIsNotNull() {
            addCriterion("internetbar_out_and_in_points is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsEqualTo(Integer value) {
            addCriterion("internetbar_out_and_in_points =", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsNotEqualTo(Integer value) {
            addCriterion("internetbar_out_and_in_points <>", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsGreaterThan(Integer value) {
            addCriterion("internetbar_out_and_in_points >", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_out_and_in_points >=", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsLessThan(Integer value) {
            addCriterion("internetbar_out_and_in_points <", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_out_and_in_points <=", value, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsIn(List<Integer> values) {
            addCriterion("internetbar_out_and_in_points in", values, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsNotIn(List<Integer> values) {
            addCriterion("internetbar_out_and_in_points not in", values, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_out_and_in_points between", value1, value2, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarOutAndInPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_out_and_in_points not between", value1, value2, "internetbarOutAndInPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsIsNull() {
            addCriterion("internetbar_total_points is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsIsNotNull() {
            addCriterion("internetbar_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsEqualTo(Integer value) {
            addCriterion("internetbar_total_points =", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsNotEqualTo(Integer value) {
            addCriterion("internetbar_total_points <>", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsGreaterThan(Integer value) {
            addCriterion("internetbar_total_points >", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_total_points >=", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsLessThan(Integer value) {
            addCriterion("internetbar_total_points <", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_total_points <=", value, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsIn(List<Integer> values) {
            addCriterion("internetbar_total_points in", values, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsNotIn(List<Integer> values) {
            addCriterion("internetbar_total_points not in", values, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_total_points between", value1, value2, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_total_points not between", value1, value2, "internetbarTotalPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsIsNull() {
            addCriterion("terror_with_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsIsNotNull() {
            addCriterion("terror_with_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_counts =", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_counts <>", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("terror_with_narcotics_counts >", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_counts >=", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsLessThan(Integer value) {
            addCriterion("terror_with_narcotics_counts <", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_counts <=", value, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsIn(List<Integer> values) {
            addCriterion("terror_with_narcotics_counts in", values, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("terror_with_narcotics_counts not in", values, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("terror_with_narcotics_counts between", value1, value2, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("terror_with_narcotics_counts not between", value1, value2, "terrorWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsIsNull() {
            addCriterion("terror_with_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsIsNotNull() {
            addCriterion("terror_with_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_points =", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_points <>", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("terror_with_narcotics_points >", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_points >=", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsLessThan(Integer value) {
            addCriterion("terror_with_narcotics_points <", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("terror_with_narcotics_points <=", value, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsIn(List<Integer> values) {
            addCriterion("terror_with_narcotics_points in", values, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("terror_with_narcotics_points not in", values, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("terror_with_narcotics_points between", value1, value2, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTerrorWithNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("terror_with_narcotics_points not between", value1, value2, "terrorWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsIsNull() {
            addCriterion("internetbar_last_time_counts is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsIsNotNull() {
            addCriterion("internetbar_last_time_counts is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsEqualTo(Integer value) {
            addCriterion("internetbar_last_time_counts =", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsNotEqualTo(Integer value) {
            addCriterion("internetbar_last_time_counts <>", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsGreaterThan(Integer value) {
            addCriterion("internetbar_last_time_counts >", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_last_time_counts >=", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsLessThan(Integer value) {
            addCriterion("internetbar_last_time_counts <", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_last_time_counts <=", value, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsIn(List<Integer> values) {
            addCriterion("internetbar_last_time_counts in", values, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsNotIn(List<Integer> values) {
            addCriterion("internetbar_last_time_counts not in", values, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_last_time_counts between", value1, value2, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimeCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_last_time_counts not between", value1, value2, "internetbarLastTimeCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsIsNull() {
            addCriterion("internetbar_last_time_points is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsIsNotNull() {
            addCriterion("internetbar_last_time_points is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsEqualTo(Integer value) {
            addCriterion("internetbar_last_time_points =", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsNotEqualTo(Integer value) {
            addCriterion("internetbar_last_time_points <>", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsGreaterThan(Integer value) {
            addCriterion("internetbar_last_time_points >", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_last_time_points >=", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsLessThan(Integer value) {
            addCriterion("internetbar_last_time_points <", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_last_time_points <=", value, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsIn(List<Integer> values) {
            addCriterion("internetbar_last_time_points in", values, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsNotIn(List<Integer> values) {
            addCriterion("internetbar_last_time_points not in", values, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_last_time_points between", value1, value2, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarLastTimePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_last_time_points not between", value1, value2, "internetbarLastTimePoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIsNull() {
            addCriterion("total_points is null");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIsNotNull() {
            addCriterion("total_points is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPointsEqualTo(Integer value) {
            addCriterion("total_points =", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotEqualTo(Integer value) {
            addCriterion("total_points <>", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsGreaterThan(Integer value) {
            addCriterion("total_points >", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_points >=", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsLessThan(Integer value) {
            addCriterion("total_points <", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsLessThanOrEqualTo(Integer value) {
            addCriterion("total_points <=", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIn(List<Integer> values) {
            addCriterion("total_points in", values, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotIn(List<Integer> values) {
            addCriterion("total_points not in", values, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsBetween(Integer value1, Integer value2) {
            addCriterion("total_points between", value1, value2, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("total_points not between", value1, value2, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("creation_date is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("creation_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("creation_date =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("creation_date <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("creation_date >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_date >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("creation_date <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("creation_date <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("creation_date in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("creation_date not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("creation_date between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("creation_date not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateIsNull() {
            addCriterion("up_time_date is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateIsNotNull() {
            addCriterion("up_time_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateEqualTo(Date value) {
            addCriterion("up_time_date =", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateNotEqualTo(Date value) {
            addCriterion("up_time_date <>", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateGreaterThan(Date value) {
            addCriterion("up_time_date >", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("up_time_date >=", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateLessThan(Date value) {
            addCriterion("up_time_date <", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateLessThanOrEqualTo(Date value) {
            addCriterion("up_time_date <=", value, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateIn(List<Date> values) {
            addCriterion("up_time_date in", values, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateNotIn(List<Date> values) {
            addCriterion("up_time_date not in", values, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateBetween(Date value1, Date value2) {
            addCriterion("up_time_date between", value1, value2, "upTimeDate");
            return (Criteria) this;
        }

        public Criteria andUpTimeDateNotBetween(Date value1, Date value2) {
            addCriterion("up_time_date not between", value1, value2, "upTimeDate");
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