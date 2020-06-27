package com.demomodel.teaffic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TraffickingNarcoticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TraffickingNarcoticsExample() {
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

        public Criteria andHotelOutAndInCountsIsNull() {
            addCriterion("hotel_out_and_in_counts is null");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsIsNotNull() {
            addCriterion("hotel_out_and_in_counts is not null");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsEqualTo(Integer value) {
            addCriterion("hotel_out_and_in_counts =", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsNotEqualTo(Integer value) {
            addCriterion("hotel_out_and_in_counts <>", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsGreaterThan(Integer value) {
            addCriterion("hotel_out_and_in_counts >", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_out_and_in_counts >=", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsLessThan(Integer value) {
            addCriterion("hotel_out_and_in_counts <", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_out_and_in_counts <=", value, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsIn(List<Integer> values) {
            addCriterion("hotel_out_and_in_counts in", values, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsNotIn(List<Integer> values) {
            addCriterion("hotel_out_and_in_counts not in", values, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_out_and_in_counts between", value1, value2, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelOutAndInCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_out_and_in_counts not between", value1, value2, "hotelOutAndInCounts");
            return (Criteria) this;
        }

        public Criteria andHotelPointsIsNull() {
            addCriterion("hotel_points is null");
            return (Criteria) this;
        }

        public Criteria andHotelPointsIsNotNull() {
            addCriterion("hotel_points is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPointsEqualTo(Integer value) {
            addCriterion("hotel_points =", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsNotEqualTo(Integer value) {
            addCriterion("hotel_points <>", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsGreaterThan(Integer value) {
            addCriterion("hotel_points >", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_points >=", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsLessThan(Integer value) {
            addCriterion("hotel_points <", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_points <=", value, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsIn(List<Integer> values) {
            addCriterion("hotel_points in", values, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsNotIn(List<Integer> values) {
            addCriterion("hotel_points not in", values, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_points between", value1, value2, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_points not between", value1, value2, "hotelPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsIsNull() {
            addCriterion("hotel_lasttime_room_counts is null");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsIsNotNull() {
            addCriterion("hotel_lasttime_room_counts is not null");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_counts =", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsNotEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_counts <>", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsGreaterThan(Integer value) {
            addCriterion("hotel_lasttime_room_counts >", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_counts >=", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsLessThan(Integer value) {
            addCriterion("hotel_lasttime_room_counts <", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_counts <=", value, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsIn(List<Integer> values) {
            addCriterion("hotel_lasttime_room_counts in", values, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsNotIn(List<Integer> values) {
            addCriterion("hotel_lasttime_room_counts not in", values, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_lasttime_room_counts between", value1, value2, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_lasttime_room_counts not between", value1, value2, "hotelLasttimeRoomCounts");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsIsNull() {
            addCriterion("hotel_lasttime_room_points is null");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsIsNotNull() {
            addCriterion("hotel_lasttime_room_points is not null");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_points =", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsNotEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_points <>", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsGreaterThan(Integer value) {
            addCriterion("hotel_lasttime_room_points >", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_points >=", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsLessThan(Integer value) {
            addCriterion("hotel_lasttime_room_points <", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_lasttime_room_points <=", value, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsIn(List<Integer> values) {
            addCriterion("hotel_lasttime_room_points in", values, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsNotIn(List<Integer> values) {
            addCriterion("hotel_lasttime_room_points not in", values, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_lasttime_room_points between", value1, value2, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelLasttimeRoomPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_lasttime_room_points not between", value1, value2, "hotelLasttimeRoomPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsIsNull() {
            addCriterion("hotel_share_with_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsIsNotNull() {
            addCriterion("hotel_share_with_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts =", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts <>", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts >", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts >=", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsLessThan(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts <", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_counts <=", value, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsIn(List<Integer> values) {
            addCriterion("hotel_share_with_narcotics_counts in", values, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("hotel_share_with_narcotics_counts not in", values, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_share_with_narcotics_counts between", value1, value2, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_share_with_narcotics_counts not between", value1, value2, "hotelShareWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsIsNull() {
            addCriterion("hotel_share_with_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsIsNotNull() {
            addCriterion("hotel_share_with_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_points =", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_points <>", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("hotel_share_with_narcotics_points >", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_points >=", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsLessThan(Integer value) {
            addCriterion("hotel_share_with_narcotics_points <", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_share_with_narcotics_points <=", value, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsIn(List<Integer> values) {
            addCriterion("hotel_share_with_narcotics_points in", values, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("hotel_share_with_narcotics_points not in", values, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("hotel_share_with_narcotics_points between", value1, value2, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andHotelShareWithNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_share_with_narcotics_points not between", value1, value2, "hotelShareWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountIsNull() {
            addCriterion("recreation_out_and_in_count is null");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountIsNotNull() {
            addCriterion("recreation_out_and_in_count is not null");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountEqualTo(Integer value) {
            addCriterion("recreation_out_and_in_count =", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountNotEqualTo(Integer value) {
            addCriterion("recreation_out_and_in_count <>", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountGreaterThan(Integer value) {
            addCriterion("recreation_out_and_in_count >", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("recreation_out_and_in_count >=", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountLessThan(Integer value) {
            addCriterion("recreation_out_and_in_count <", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountLessThanOrEqualTo(Integer value) {
            addCriterion("recreation_out_and_in_count <=", value, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountIn(List<Integer> values) {
            addCriterion("recreation_out_and_in_count in", values, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountNotIn(List<Integer> values) {
            addCriterion("recreation_out_and_in_count not in", values, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountBetween(Integer value1, Integer value2) {
            addCriterion("recreation_out_and_in_count between", value1, value2, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationOutAndInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("recreation_out_and_in_count not between", value1, value2, "recreationOutAndInCount");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsIsNull() {
            addCriterion("recreation__points is null");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsIsNotNull() {
            addCriterion("recreation__points is not null");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsEqualTo(Integer value) {
            addCriterion("recreation__points =", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsNotEqualTo(Integer value) {
            addCriterion("recreation__points <>", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsGreaterThan(Integer value) {
            addCriterion("recreation__points >", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("recreation__points >=", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsLessThan(Integer value) {
            addCriterion("recreation__points <", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsLessThanOrEqualTo(Integer value) {
            addCriterion("recreation__points <=", value, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsIn(List<Integer> values) {
            addCriterion("recreation__points in", values, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsNotIn(List<Integer> values) {
            addCriterion("recreation__points not in", values, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsBetween(Integer value1, Integer value2) {
            addCriterion("recreation__points between", value1, value2, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("recreation__points not between", value1, value2, "recreationPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsIsNull() {
            addCriterion("recreation_with_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsIsNotNull() {
            addCriterion("recreation_with_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_counts =", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_counts <>", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("recreation_with_narcotics_counts >", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_counts >=", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsLessThan(Integer value) {
            addCriterion("recreation_with_narcotics_counts <", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_counts <=", value, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsIn(List<Integer> values) {
            addCriterion("recreation_with_narcotics_counts in", values, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("recreation_with_narcotics_counts not in", values, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("recreation_with_narcotics_counts between", value1, value2, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("recreation_with_narcotics_counts not between", value1, value2, "recreationWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsIsNull() {
            addCriterion("recreation_with_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsIsNotNull() {
            addCriterion("recreation_with_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_points =", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_points <>", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("recreation_with_narcotics_points >", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_points >=", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsLessThan(Integer value) {
            addCriterion("recreation_with_narcotics_points <", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("recreation_with_narcotics_points <=", value, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsIn(List<Integer> values) {
            addCriterion("recreation_with_narcotics_points in", values, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("recreation_with_narcotics_points not in", values, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("recreation_with_narcotics_points between", value1, value2, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andRecreationWithNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("recreation_with_narcotics_points not between", value1, value2, "recreationWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsIsNull() {
            addCriterion("travel_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelPointsIsNotNull() {
            addCriterion("travel_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelPointsEqualTo(Integer value) {
            addCriterion("travel_points =", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsNotEqualTo(Integer value) {
            addCriterion("travel_points <>", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsGreaterThan(Integer value) {
            addCriterion("travel_points >", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_points >=", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsLessThan(Integer value) {
            addCriterion("travel_points <", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_points <=", value, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsIn(List<Integer> values) {
            addCriterion("travel_points in", values, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsNotIn(List<Integer> values) {
            addCriterion("travel_points not in", values, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_points between", value1, value2, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_points not between", value1, value2, "travelPoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsIsNull() {
            addCriterion("travel_place_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsIsNotNull() {
            addCriterion("travel_place_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsEqualTo(Integer value) {
            addCriterion("travel_place_points =", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsNotEqualTo(Integer value) {
            addCriterion("travel_place_points <>", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsGreaterThan(Integer value) {
            addCriterion("travel_place_points >", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_place_points >=", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsLessThan(Integer value) {
            addCriterion("travel_place_points <", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_place_points <=", value, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsIn(List<Integer> values) {
            addCriterion("travel_place_points in", values, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsNotIn(List<Integer> values) {
            addCriterion("travel_place_points not in", values, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_place_points between", value1, value2, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelPlacePointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_place_points not between", value1, value2, "travelPlacePoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsIsNull() {
            addCriterion("travel_with_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsIsNotNull() {
            addCriterion("travel_with_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_counts =", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_counts <>", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("travel_with_narcotics_counts >", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_counts >=", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsLessThan(Integer value) {
            addCriterion("travel_with_narcotics_counts <", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_counts <=", value, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsIn(List<Integer> values) {
            addCriterion("travel_with_narcotics_counts in", values, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("travel_with_narcotics_counts not in", values, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_narcotics_counts between", value1, value2, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_narcotics_counts not between", value1, value2, "travelWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsIsNull() {
            addCriterion("travel_with_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsIsNotNull() {
            addCriterion("travel_with_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_points =", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_points <>", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("travel_with_narcotics_points >", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_points >=", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsLessThan(Integer value) {
            addCriterion("travel_with_narcotics_points <", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_narcotics_points <=", value, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsIn(List<Integer> values) {
            addCriterion("travel_with_narcotics_points in", values, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("travel_with_narcotics_points not in", values, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_narcotics_points between", value1, value2, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_narcotics_points not between", value1, value2, "travelWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsIsNull() {
            addCriterion("travel_with_train_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsIsNotNull() {
            addCriterion("travel_with_train_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_counts =", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_counts <>", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("travel_with_train_narcotics_counts >", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_counts >=", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsLessThan(Integer value) {
            addCriterion("travel_with_train_narcotics_counts <", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_counts <=", value, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsIn(List<Integer> values) {
            addCriterion("travel_with_train_narcotics_counts in", values, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("travel_with_train_narcotics_counts not in", values, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_train_narcotics_counts between", value1, value2, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_train_narcotics_counts not between", value1, value2, "travelWithTrainNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsIsNull() {
            addCriterion("travel_with_train_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsIsNotNull() {
            addCriterion("travel_with_train_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_points =", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_points <>", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("travel_with_train_narcotics_points >", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_points >=", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsLessThan(Integer value) {
            addCriterion("travel_with_train_narcotics_points <", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_train_narcotics_points <=", value, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsIn(List<Integer> values) {
            addCriterion("travel_with_train_narcotics_points in", values, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("travel_with_train_narcotics_points not in", values, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_train_narcotics_points between", value1, value2, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithTrainNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_train_narcotics_points not between", value1, value2, "travelWithTrainNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsIsNull() {
            addCriterion("travel_with_plane_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsIsNotNull() {
            addCriterion("travel_with_plane_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts =", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts <>", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts >", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts >=", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsLessThan(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts <", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_counts <=", value, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsIn(List<Integer> values) {
            addCriterion("travel_with_plane_narcotics_counts in", values, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("travel_with_plane_narcotics_counts not in", values, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_plane_narcotics_counts between", value1, value2, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_plane_narcotics_counts not between", value1, value2, "travelWithPlaneNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsIsNull() {
            addCriterion("travel_with_plane_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsIsNotNull() {
            addCriterion("travel_with_plane_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_points =", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_points <>", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("travel_with_plane_narcotics_points >", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_points >=", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsLessThan(Integer value) {
            addCriterion("travel_with_plane_narcotics_points <", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_plane_narcotics_points <=", value, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsIn(List<Integer> values) {
            addCriterion("travel_with_plane_narcotics_points in", values, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("travel_with_plane_narcotics_points not in", values, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_plane_narcotics_points between", value1, value2, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithPlaneNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_plane_narcotics_points not between", value1, value2, "travelWithPlaneNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsIsNull() {
            addCriterion("travel_with_car_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsIsNotNull() {
            addCriterion("travel_with_car_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_counts =", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_counts <>", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("travel_with_car_narcotics_counts >", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_counts >=", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsLessThan(Integer value) {
            addCriterion("travel_with_car_narcotics_counts <", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_counts <=", value, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsIn(List<Integer> values) {
            addCriterion("travel_with_car_narcotics_counts in", values, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("travel_with_car_narcotics_counts not in", values, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_car_narcotics_counts between", value1, value2, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_car_narcotics_counts not between", value1, value2, "travelWithCarNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsIsNull() {
            addCriterion("travel_with_car_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsIsNotNull() {
            addCriterion("travel_with_car_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_points =", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_points <>", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("travel_with_car_narcotics_points >", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_points >=", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsLessThan(Integer value) {
            addCriterion("travel_with_car_narcotics_points <", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("travel_with_car_narcotics_points <=", value, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsIn(List<Integer> values) {
            addCriterion("travel_with_car_narcotics_points in", values, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("travel_with_car_narcotics_points not in", values, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_car_narcotics_points between", value1, value2, "travelWithCarNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andTravelWithCarNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_with_car_narcotics_points not between", value1, value2, "travelWithCarNarcoticsPoints");
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

        public Criteria andTelephoneTotalCountsIsNull() {
            addCriterion("telephone_total_counts is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsIsNotNull() {
            addCriterion("telephone_total_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsEqualTo(Integer value) {
            addCriterion("telephone_total_counts =", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsNotEqualTo(Integer value) {
            addCriterion("telephone_total_counts <>", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsGreaterThan(Integer value) {
            addCriterion("telephone_total_counts >", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_total_counts >=", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsLessThan(Integer value) {
            addCriterion("telephone_total_counts <", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_total_counts <=", value, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsIn(List<Integer> values) {
            addCriterion("telephone_total_counts in", values, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsNotIn(List<Integer> values) {
            addCriterion("telephone_total_counts not in", values, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_total_counts between", value1, value2, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneTotalCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_total_counts not between", value1, value2, "telephoneTotalCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsIsNull() {
            addCriterion("telephone_has_narcotics_message_counts is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsIsNotNull() {
            addCriterion("telephone_has_narcotics_message_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts =", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsNotEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts <>", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsGreaterThan(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts >", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts >=", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsLessThan(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts <", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_message_counts <=", value, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsIn(List<Integer> values) {
            addCriterion("telephone_has_narcotics_message_counts in", values, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsNotIn(List<Integer> values) {
            addCriterion("telephone_has_narcotics_message_counts not in", values, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_has_narcotics_message_counts between", value1, value2, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsMessageCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_has_narcotics_message_counts not between", value1, value2, "telephoneHasNarcoticsMessageCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsIsNull() {
            addCriterion("telephone_has_narcotics_existence_counts is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsIsNotNull() {
            addCriterion("telephone_has_narcotics_existence_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts =", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsNotEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts <>", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsGreaterThan(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts >", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts >=", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsLessThan(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts <", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_has_narcotics_existence_counts <=", value, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsIn(List<Integer> values) {
            addCriterion("telephone_has_narcotics_existence_counts in", values, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsNotIn(List<Integer> values) {
            addCriterion("telephone_has_narcotics_existence_counts not in", values, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_has_narcotics_existence_counts between", value1, value2, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneHasNarcoticsExistenceCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_has_narcotics_existence_counts not between", value1, value2, "telephoneHasNarcoticsExistenceCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsIsNull() {
            addCriterion("telephone_in_narcotics_contact_counts is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsIsNotNull() {
            addCriterion("telephone_in_narcotics_contact_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts =", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsNotEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts <>", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsGreaterThan(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts >", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts >=", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsLessThan(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts <", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_contact_counts <=", value, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsIn(List<Integer> values) {
            addCriterion("telephone_in_narcotics_contact_counts in", values, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsNotIn(List<Integer> values) {
            addCriterion("telephone_in_narcotics_contact_counts not in", values, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_in_narcotics_contact_counts between", value1, value2, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsContactCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_in_narcotics_contact_counts not between", value1, value2, "telephoneInNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsIsNull() {
            addCriterion("telephone_in_narcotics_call_counts is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsIsNotNull() {
            addCriterion("telephone_in_narcotics_call_counts is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts =", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsNotEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts <>", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsGreaterThan(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts >", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts >=", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsLessThan(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts <", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsLessThanOrEqualTo(Integer value) {
            addCriterion("telephone_in_narcotics_call_counts <=", value, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsIn(List<Integer> values) {
            addCriterion("telephone_in_narcotics_call_counts in", values, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsNotIn(List<Integer> values) {
            addCriterion("telephone_in_narcotics_call_counts not in", values, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsBetween(Integer value1, Integer value2) {
            addCriterion("telephone_in_narcotics_call_counts between", value1, value2, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andTelephoneInNarcoticsCallCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("telephone_in_narcotics_call_counts not between", value1, value2, "telephoneInNarcoticsCallCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsIsNull() {
            addCriterion("wechat_has_narcotics_contact_counts is null");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsIsNotNull() {
            addCriterion("wechat_has_narcotics_contact_counts is not null");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsEqualTo(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts =", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsNotEqualTo(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts <>", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsGreaterThan(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts >", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts >=", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsLessThan(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts <", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsLessThanOrEqualTo(Integer value) {
            addCriterion("wechat_has_narcotics_contact_counts <=", value, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsIn(List<Integer> values) {
            addCriterion("wechat_has_narcotics_contact_counts in", values, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsNotIn(List<Integer> values) {
            addCriterion("wechat_has_narcotics_contact_counts not in", values, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsBetween(Integer value1, Integer value2) {
            addCriterion("wechat_has_narcotics_contact_counts between", value1, value2, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatHasNarcoticsContactCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("wechat_has_narcotics_contact_counts not between", value1, value2, "wechatHasNarcoticsContactCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsIsNull() {
            addCriterion("wechat_in_narcotics_group_counts is null");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsIsNotNull() {
            addCriterion("wechat_in_narcotics_group_counts is not null");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsEqualTo(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts =", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsNotEqualTo(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts <>", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsGreaterThan(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts >", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts >=", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsLessThan(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts <", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsLessThanOrEqualTo(Integer value) {
            addCriterion("wechat_in_narcotics_group_counts <=", value, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsIn(List<Integer> values) {
            addCriterion("wechat_in_narcotics_group_counts in", values, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsNotIn(List<Integer> values) {
            addCriterion("wechat_in_narcotics_group_counts not in", values, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsBetween(Integer value1, Integer value2) {
            addCriterion("wechat_in_narcotics_group_counts between", value1, value2, "wechatInNarcoticsGroupCounts");
            return (Criteria) this;
        }

        public Criteria andWechatInNarcoticsGroupCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("wechat_in_narcotics_group_counts not between", value1, value2, "wechatInNarcoticsGroupCounts");
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

        public Criteria andInternetbarPointsIsNull() {
            addCriterion("internetbar_points is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsIsNotNull() {
            addCriterion("internetbar_points is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsEqualTo(Integer value) {
            addCriterion("internetbar_points =", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsNotEqualTo(Integer value) {
            addCriterion("internetbar_points <>", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsGreaterThan(Integer value) {
            addCriterion("internetbar_points >", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_points >=", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsLessThan(Integer value) {
            addCriterion("internetbar_points <", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_points <=", value, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsIn(List<Integer> values) {
            addCriterion("internetbar_points in", values, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsNotIn(List<Integer> values) {
            addCriterion("internetbar_points not in", values, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_points between", value1, value2, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_points not between", value1, value2, "internetbarPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsIsNull() {
            addCriterion("internetbar_with_narcotics_counts is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsIsNotNull() {
            addCriterion("internetbar_with_narcotics_counts is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_counts =", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsNotEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_counts <>", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsGreaterThan(Integer value) {
            addCriterion("internetbar_with_narcotics_counts >", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_counts >=", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsLessThan(Integer value) {
            addCriterion("internetbar_with_narcotics_counts <", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_counts <=", value, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsIn(List<Integer> values) {
            addCriterion("internetbar_with_narcotics_counts in", values, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsNotIn(List<Integer> values) {
            addCriterion("internetbar_with_narcotics_counts not in", values, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_with_narcotics_counts between", value1, value2, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_with_narcotics_counts not between", value1, value2, "internetbarWithNarcoticsCounts");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsIsNull() {
            addCriterion("internetbar_with_narcotics_points is null");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsIsNotNull() {
            addCriterion("internetbar_with_narcotics_points is not null");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_points =", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsNotEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_points <>", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsGreaterThan(Integer value) {
            addCriterion("internetbar_with_narcotics_points >", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_points >=", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsLessThan(Integer value) {
            addCriterion("internetbar_with_narcotics_points <", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsLessThanOrEqualTo(Integer value) {
            addCriterion("internetbar_with_narcotics_points <=", value, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsIn(List<Integer> values) {
            addCriterion("internetbar_with_narcotics_points in", values, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsNotIn(List<Integer> values) {
            addCriterion("internetbar_with_narcotics_points not in", values, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_with_narcotics_points between", value1, value2, "internetbarWithNarcoticsPoints");
            return (Criteria) this;
        }

        public Criteria andInternetbarWithNarcoticsPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("internetbar_with_narcotics_points not between", value1, value2, "internetbarWithNarcoticsPoints");
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