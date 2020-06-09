package com.demomodel.query.Schedulequery.bean;
/**
 * CREATE TABLE `schedule_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `cron` varchar(255) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0 代表开启，1代表关闭',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
————————————————
版权声明：本文为CSDN博主「前方太黑暗」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/xcc_2269861428/java/article/details/99996185
 * @author wgz
 * @date 创建时间：2020年5月18日 上午1:25:52
 */
public class ScheduleConfig {
    private Long id;
 
    private String jobName;
 
    private String className;
 
    private String method;
 
    private String cron;
 
    private Integer status;
    
  
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getJobName() {
        return jobName;
    }
 
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
 
    public String getClassName() {
        return className;
    }
 
    public void setClassName(String className) {
        this.className = className;
    }
 
    public String getMethod() {
        return method;
    }
 
    public void setMethod(String method) {
        this.method = method;
    }
 
    public String getCron() {
        return cron;
    }
 
    public void setCron(String cron) {
        this.cron = cron;
    }
}
//：https://blog.csdn.net/xcc_2269861428/java/article/details/99996185