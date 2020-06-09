package com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao;
/**
 * DROP TABLE IF EXISTS `demotxt`;
CREATE TABLE `demotxt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nsmre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 INSERT INTO `demotxt` VALUES (1, '第一数据源', '12', 'sd', 'ds');
 * @author wgz
 * @date 创建时间：2020年5月9日 上午10:34:38
 */
public class Demotxt {
    private Integer id;

    private String demo;

    private String sate;

    private String nsmre;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate == null ? null : sate.trim();
    }

    public String getNsmre() {
        return nsmre;
    }

    public void setNsmre(String nsmre) {
        this.nsmre = nsmre == null ? null : nsmre.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}