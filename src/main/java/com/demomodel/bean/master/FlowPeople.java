package com.demomodel.bean.master;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.demomodel.bean.master.page.Pagetion;
import com.fasterxml.jackson.annotation.JsonFormat;


public class FlowPeople {
    private Integer id;
    //注解@JsonFormat主要是后台到前台的时间格式的转换
   // 注解@DataFormAT主要是前后到后台的时间格式的转换
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")//返回前端的数据格式
    private Date flowcreateTime;
    
  

    private String flowName;

    private String flowIdcard;

    private Integer flowUpodateCount;

    private String flowNativePlace;

    private String flowRegion;

    private String flowAddress;

    private Date flowLatelyUpdate;
    
  private Pagetion pagetion;  //分页
  private String starttionDate;  //变量接收开始时间
  private String endtionDate;//结束时间        sql 与flowcreateTime比较
    
	public Pagetion getPagetion() {
	return pagetion;
}

public void setPagetion(Pagetion pagetion) {
	this.pagetion = pagetion;
}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFlowcreateTime() {
        return flowcreateTime;
    }

    public void setFlowcreateTime(Date flowcreateTime) {
        this.flowcreateTime = flowcreateTime;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getFlowIdcard() {
        return flowIdcard;
    }

    public void setFlowIdcard(String flowIdcard) {
        this.flowIdcard = flowIdcard == null ? null : flowIdcard.trim();
    }

    public Integer getFlowUpodateCount() {
        return flowUpodateCount;
    }

    public void setFlowUpodateCount(Integer flowUpodateCount) {
        this.flowUpodateCount = flowUpodateCount;
    }

    public String getFlowNativePlace() {
        return flowNativePlace;
    }

    public void setFlowNativePlace(String flowNativePlace) {
        this.flowNativePlace = flowNativePlace == null ? null : flowNativePlace.trim();
    }

    public String getFlowRegion() {
        return flowRegion;
    }

    public void setFlowRegion(String flowRegion) {
        this.flowRegion = flowRegion == null ? null : flowRegion.trim();
    }

    public String getFlowAddress() {
        return flowAddress;
    }

    public void setFlowAddress(String flowAddress) {
        this.flowAddress = flowAddress == null ? null : flowAddress.trim();
    }

    public Date getFlowLatelyUpdate() {
        return flowLatelyUpdate;
    }

    public void setFlowLatelyUpdate(Date flowLatelyUpdate) {
        this.flowLatelyUpdate = flowLatelyUpdate;
    }

	public String getStarttionDate() {
		return starttionDate;
	}

	public String getEndtionDate() {
		return endtionDate;
	}

	public void setStarttionDate(String starttionDate) {
		this.starttionDate = starttionDate;
	}

	public void setEndtionDate(String endtionDate) {
		this.endtionDate = endtionDate;
	}
	//重写equals  
	/**使用方法    对象1.equals(对象2)
	 * irregularHotel1.equals(temIrregularHotel2)
	 * 只判断地址是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof FlowPeople)) return false;					
		FlowPeople irregularHotel=(FlowPeople)obj;
		return this.getFlowAddress().equals(irregularHotel.getFlowAddress());
	}
	
    
}