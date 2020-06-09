package com.demomodel.filter.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class Prop {

@NotNull(message = "pid不能为空")
@Min(value = 1, message = "pid必须为正整数")
private Long pid;

@NotNull(message = "vid不能为空")
@Min(value = 1, message = "vid必须为正整数")
private Long vid;

@NotBlank(message = "pidName不能为空")
private String pidName;

@NotBlank(message = "vidName不能为空")
private String vidName;
}