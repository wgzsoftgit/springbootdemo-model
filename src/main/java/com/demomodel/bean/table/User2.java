package com.demomodel.bean.table;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
/**
 * @Entity代表这是一个实体类，
 * @Table(name=”user”)用来对应数据库中的use表，@Id用来表达主键，@Column(name=”id”)表明一个id属性。 
@GeneratedValue使主键自增
 * @author wgz
 * @date 创建时间：2020年4月24日 上午8:52:53
 */

//@Entity
//@Table(name = "user")
public class User2 implements Serializable {

    private static final long serialVersionUID = 1L;

   // @Id
   // @GeneratedValue
    private Long id;
   // @Column(name = "username")
    private String userName;
    //@Column(name = "password")
    private String passWord;

    public User2() {
        super();
    }

    public User2(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}