package com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.dao;

import java.util.Date;
/**
 *DROP TABLE IF EXISTS `usertimes`;
CREATE TABLE `usertimes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `times` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
INSERT INTO `usertimes` VALUES (1, '2020-04-02 16:44:51', 'text第二数据源', 12, 1585817091000);
 * 
 * @author wgz
 * @date 创建时间：2020年5月9日 上午11:49:55
 */
public class Usertimes {
    private Integer id;

    private Date time;

    private String name;

    private Integer age;

    private Long times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }
}