package com.demomodel.bean.master;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/* {
"id": 11,   
"creationDate":20200204,
"districtCode":"baskte",    
"name": "tom",
  "idCard":"saa",
  "personType":"",
  "isResident":22,
  "gendar":21,   
  "monitorStatus":"布控",  
  "alertStatus":"ass",
  "similarPercent":221.2,
  "faceImgUrl":"da",
  "deviceId":"sb",
  "imgUrl":"ds",
  }
*/
public class ImplicitTerrorists {
    private Integer id;

    private Date creationDate;
    private String endtionDate;  //结束时间
    private String starttionDate;//开始时间
    
    private String districtCode;
  
    private String name;

    private String idNum;

    private String personType;

    private Integer isResident;

    private Integer gendar;

    private String monitorStatus;

    private String alertStatus;

    private BigDecimal similarPercent;

    private String faceImgUrl;

    private String deviceId;

    private String imgUrl;
  
    
    public String getStarttionDate() {
		return starttionDate;
	}

	public void setStarttionDate(String starttionDate) {
		this.starttionDate = starttionDate;
	}

	public String getEndtionDate() {
		return endtionDate;
	}

	public void setEndtionDate(String endtionDate) {
		this.endtionDate = endtionDate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
    
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
    	
    	this.creationDate =creationDate;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idNum;
    }

    public void setIdCard(String idCard) {
        this.idNum = idCard == null ? null : idCard.trim();
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType == null ? null : personType.trim();
    }

    public Integer getIsResident() {
        return isResident;
    }

    public void setIsResident(Integer isResident) {
        this.isResident = isResident;
    }

    public Integer getGendar() {
        return gendar;
    }

    public void setGendar(Integer gendar) {
        this.gendar = gendar;
    }

    public String getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(String monitorStatus) {
        this.monitorStatus = monitorStatus == null ? null : monitorStatus.trim();
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus == null ? null : alertStatus.trim();
    }

    public BigDecimal getSimilarPercent() {
        return similarPercent;
    }

    public void setSimilarPercent(BigDecimal similarPercent) {
        this.similarPercent = similarPercent;
    }

    public String getFaceImgUrl() {
        return faceImgUrl;
    }

    public void setFaceImgUrl(String faceImgUrl) {
        this.faceImgUrl = faceImgUrl == null ? null : faceImgUrl.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

	@Override
	public String toString() {
		return "ImplicitTerrorists [id=" + id + ", creationDate=" + creationDate + ", endtionDate=" + endtionDate
				+ ", starttionDate=" + starttionDate + ", districtCode=" + districtCode + ", name=" + name + ", idCard="
				+ idNum + ", personType=" + personType + ", isResident=" + isResident + ", gendar=" + gendar
				+ ", monitorStatus=" + monitorStatus + ", alertStatus=" + alertStatus + ", similarPercent="
				+ similarPercent + ", faceImgUrl=" + faceImgUrl + ", deviceId=" + deviceId + ", imgUrl=" + imgUrl + "]";
	}  

  	
    
}