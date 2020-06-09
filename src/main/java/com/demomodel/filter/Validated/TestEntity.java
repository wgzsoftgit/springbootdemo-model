package com.demomodel.filter.Validated;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity implements Serializable {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "add不能为空")
    private String add;

    @NotBlank(message = "phone不能为空")
    private String phone;
}
//https://blog.csdn.net/weixin_45768481/java/article/details/106267976