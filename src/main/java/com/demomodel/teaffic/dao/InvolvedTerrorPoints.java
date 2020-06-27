package com.demomodel.teaffic.dao;

import java.util.Date;

public class InvolvedTerrorPoints {
    private Integer id;

    private String name;

    private String gender;

    private String nation;

    private String birthday;

    private String idNum;

    private String birthPlace;

    private Integer highOutAndInCounts;

    private Integer highTotalPoints;

    private Integer highRiskPlace;

    private Integer highRiskPlacePoints;

    private Integer templeOutAndInCounts;

    private Integer templeTotalPoints;

    private Integer templeDoubleAccessCount;

    private Integer templeDoubleAccessPoints;

    private Integer peersOutAndInCounts;

    private Integer peersTotalPoints;

    private Integer peersWithTerrorCounts;

    private Integer peersWithTerrorPoints;

    private Integer peersWithTrainTerrorCounts;

    private Integer peersWithTrainTerrorPoints;

    private Integer peersWithPlaneTerrorCounts;

    private Integer peersWithPlaneTerrorPoints;

    private Integer peersWithCarTerrorCounts;

    private Integer peersWithCarTerrorPoints;

    private Integer telephonePoints;

    private Integer telephoneTotalPoints;

    private Integer phoneHasTerrorMessageCounts;

    private Integer phoneInTerrorExistenceCounts;

    private Integer phoneInTerrorContactCounts;

    private Integer phoneHasTerrorCallCounts;

    private Integer wechatHasTerrorContactCounts;

    private Integer wechatInTerrorGroupCounts;

    private Integer internetbarOutAndInPoints;

    private Integer internetbarTotalPoints;

    private Integer terrorWithNarcoticsCounts;

    private Integer terrorWithNarcoticsPoints;

    private Integer internetbarLastTimeCounts;

    private Integer internetbarLastTimePoints;

    private Integer totalPoints;

    private Date creationDate;

    private Date upTimeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public Integer getHighOutAndInCounts() {
        return highOutAndInCounts;
    }

    public void setHighOutAndInCounts(Integer highOutAndInCounts) {
        this.highOutAndInCounts = highOutAndInCounts;
    }

    public Integer getHighTotalPoints() {
        return highTotalPoints;
    }

    public void setHighTotalPoints(Integer highTotalPoints) {
        this.highTotalPoints = highTotalPoints;
    }

    public Integer getHighRiskPlace() {
        return highRiskPlace;
    }

    public void setHighRiskPlace(Integer highRiskPlace) {
        this.highRiskPlace = highRiskPlace;
    }

    public Integer getHighRiskPlacePoints() {
        return highRiskPlacePoints;
    }

    public void setHighRiskPlacePoints(Integer highRiskPlacePoints) {
        this.highRiskPlacePoints = highRiskPlacePoints;
    }

    public Integer getTempleOutAndInCounts() {
        return templeOutAndInCounts;
    }

    public void setTempleOutAndInCounts(Integer templeOutAndInCounts) {
        this.templeOutAndInCounts = templeOutAndInCounts;
    }

    public Integer getTempleTotalPoints() {
        return templeTotalPoints;
    }

    public void setTempleTotalPoints(Integer templeTotalPoints) {
        this.templeTotalPoints = templeTotalPoints;
    }

    public Integer getTempleDoubleAccessCount() {
        return templeDoubleAccessCount;
    }

    public void setTempleDoubleAccessCount(Integer templeDoubleAccessCount) {
        this.templeDoubleAccessCount = templeDoubleAccessCount;
    }

    public Integer getTempleDoubleAccessPoints() {
        return templeDoubleAccessPoints;
    }

    public void setTempleDoubleAccessPoints(Integer templeDoubleAccessPoints) {
        this.templeDoubleAccessPoints = templeDoubleAccessPoints;
    }

    public Integer getPeersOutAndInCounts() {
        return peersOutAndInCounts;
    }

    public void setPeersOutAndInCounts(Integer peersOutAndInCounts) {
        this.peersOutAndInCounts = peersOutAndInCounts;
    }

    public Integer getPeersTotalPoints() {
        return peersTotalPoints;
    }

    public void setPeersTotalPoints(Integer peersTotalPoints) {
        this.peersTotalPoints = peersTotalPoints;
    }

    public Integer getPeersWithTerrorCounts() {
        return peersWithTerrorCounts;
    }

    public void setPeersWithTerrorCounts(Integer peersWithTerrorCounts) {
        this.peersWithTerrorCounts = peersWithTerrorCounts;
    }

    public Integer getPeersWithTerrorPoints() {
        return peersWithTerrorPoints;
    }

    public void setPeersWithTerrorPoints(Integer peersWithTerrorPoints) {
        this.peersWithTerrorPoints = peersWithTerrorPoints;
    }

    public Integer getPeersWithTrainTerrorCounts() {
        return peersWithTrainTerrorCounts;
    }

    public void setPeersWithTrainTerrorCounts(Integer peersWithTrainTerrorCounts) {
        this.peersWithTrainTerrorCounts = peersWithTrainTerrorCounts;
    }

    public Integer getPeersWithTrainTerrorPoints() {
        return peersWithTrainTerrorPoints;
    }

    public void setPeersWithTrainTerrorPoints(Integer peersWithTrainTerrorPoints) {
        this.peersWithTrainTerrorPoints = peersWithTrainTerrorPoints;
    }

    public Integer getPeersWithPlaneTerrorCounts() {
        return peersWithPlaneTerrorCounts;
    }

    public void setPeersWithPlaneTerrorCounts(Integer peersWithPlaneTerrorCounts) {
        this.peersWithPlaneTerrorCounts = peersWithPlaneTerrorCounts;
    }

    public Integer getPeersWithPlaneTerrorPoints() {
        return peersWithPlaneTerrorPoints;
    }

    public void setPeersWithPlaneTerrorPoints(Integer peersWithPlaneTerrorPoints) {
        this.peersWithPlaneTerrorPoints = peersWithPlaneTerrorPoints;
    }

    public Integer getPeersWithCarTerrorCounts() {
        return peersWithCarTerrorCounts;
    }

    public void setPeersWithCarTerrorCounts(Integer peersWithCarTerrorCounts) {
        this.peersWithCarTerrorCounts = peersWithCarTerrorCounts;
    }

    public Integer getPeersWithCarTerrorPoints() {
        return peersWithCarTerrorPoints;
    }

    public void setPeersWithCarTerrorPoints(Integer peersWithCarTerrorPoints) {
        this.peersWithCarTerrorPoints = peersWithCarTerrorPoints;
    }

    public Integer getTelephonePoints() {
        return telephonePoints;
    }

    public void setTelephonePoints(Integer telephonePoints) {
        this.telephonePoints = telephonePoints;
    }

    public Integer getTelephoneTotalPoints() {
        return telephoneTotalPoints;
    }

    public void setTelephoneTotalPoints(Integer telephoneTotalPoints) {
        this.telephoneTotalPoints = telephoneTotalPoints;
    }

    public Integer getPhoneHasTerrorMessageCounts() {
        return phoneHasTerrorMessageCounts;
    }

    public void setPhoneHasTerrorMessageCounts(Integer phoneHasTerrorMessageCounts) {
        this.phoneHasTerrorMessageCounts = phoneHasTerrorMessageCounts;
    }

    public Integer getPhoneInTerrorExistenceCounts() {
        return phoneInTerrorExistenceCounts;
    }

    public void setPhoneInTerrorExistenceCounts(Integer phoneInTerrorExistenceCounts) {
        this.phoneInTerrorExistenceCounts = phoneInTerrorExistenceCounts;
    }

    public Integer getPhoneInTerrorContactCounts() {
        return phoneInTerrorContactCounts;
    }

    public void setPhoneInTerrorContactCounts(Integer phoneInTerrorContactCounts) {
        this.phoneInTerrorContactCounts = phoneInTerrorContactCounts;
    }

    public Integer getPhoneHasTerrorCallCounts() {
        return phoneHasTerrorCallCounts;
    }

    public void setPhoneHasTerrorCallCounts(Integer phoneHasTerrorCallCounts) {
        this.phoneHasTerrorCallCounts = phoneHasTerrorCallCounts;
    }

    public Integer getWechatHasTerrorContactCounts() {
        return wechatHasTerrorContactCounts;
    }

    public void setWechatHasTerrorContactCounts(Integer wechatHasTerrorContactCounts) {
        this.wechatHasTerrorContactCounts = wechatHasTerrorContactCounts;
    }

    public Integer getWechatInTerrorGroupCounts() {
        return wechatInTerrorGroupCounts;
    }

    public void setWechatInTerrorGroupCounts(Integer wechatInTerrorGroupCounts) {
        this.wechatInTerrorGroupCounts = wechatInTerrorGroupCounts;
    }

    public Integer getInternetbarOutAndInPoints() {
        return internetbarOutAndInPoints;
    }

    public void setInternetbarOutAndInPoints(Integer internetbarOutAndInPoints) {
        this.internetbarOutAndInPoints = internetbarOutAndInPoints;
    }

    public Integer getInternetbarTotalPoints() {
        return internetbarTotalPoints;
    }

    public void setInternetbarTotalPoints(Integer internetbarTotalPoints) {
        this.internetbarTotalPoints = internetbarTotalPoints;
    }

    public Integer getTerrorWithNarcoticsCounts() {
        return terrorWithNarcoticsCounts;
    }

    public void setTerrorWithNarcoticsCounts(Integer terrorWithNarcoticsCounts) {
        this.terrorWithNarcoticsCounts = terrorWithNarcoticsCounts;
    }

    public Integer getTerrorWithNarcoticsPoints() {
        return terrorWithNarcoticsPoints;
    }

    public void setTerrorWithNarcoticsPoints(Integer terrorWithNarcoticsPoints) {
        this.terrorWithNarcoticsPoints = terrorWithNarcoticsPoints;
    }

    public Integer getInternetbarLastTimeCounts() {
        return internetbarLastTimeCounts;
    }

    public void setInternetbarLastTimeCounts(Integer internetbarLastTimeCounts) {
        this.internetbarLastTimeCounts = internetbarLastTimeCounts;
    }

    public Integer getInternetbarLastTimePoints() {
        return internetbarLastTimePoints;
    }

    public void setInternetbarLastTimePoints(Integer internetbarLastTimePoints) {
        this.internetbarLastTimePoints = internetbarLastTimePoints;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpTimeDate() {
        return upTimeDate;
    }

    public void setUpTimeDate(Date upTimeDate) {
        this.upTimeDate = upTimeDate;
    }
}