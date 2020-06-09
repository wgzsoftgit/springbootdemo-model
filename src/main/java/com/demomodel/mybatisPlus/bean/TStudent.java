package com.demomodel.mybatisPlus.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * <p>
 * 学员表
 * </p>
 *
 * @author zzg123
 * @since 2018-07-15
 */
public class TStudent implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;
    private String sname;
    private String sex;
 
 
    public Integer getSid() {
        return sid;
    }
 
    public void setSid(Integer sid) {
        this.sid = sid;
    }
 
    public String getSname() {
        return sname;
    }
 
    public void setSname(String sname) {
        this.sname = sname;
    }
 
    public String getSex() {
        return sex;
    }
 
    public void setSex(String sex) {
        this.sex = sex;
    }
 
    @Override
    public String toString() {
        return "TStudent{" +
        ", sid=" + sid +
        ", sname=" + sname +
        ", sex=" + sex +
        "}";
    }
}

//https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086