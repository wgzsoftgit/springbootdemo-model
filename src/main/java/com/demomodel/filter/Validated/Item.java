package com.demomodel.filter.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class Item {
/**
 * @Validated：用在方法入参上无法单独提供嵌套验证功能。不能用在成员属性（字段）上，也无法提示框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。

@Valid：用在方法入参上无法单独提供嵌套验证功能。能够用在成员属性（字段）上，提示验证框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。

 */
@NotNull(message = "id不能为空")
@Min(value = 1, message = "id必须为正整数")
private Long id;

@Valid // 嵌套验证必须用@Valid
@NotNull(message = "props不能为空")
@Size(min = 1, message = "props至少要有一个自定义属性")
private List<Prop> props;
}