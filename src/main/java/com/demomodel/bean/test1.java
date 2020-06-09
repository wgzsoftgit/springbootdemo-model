package com.demomodel.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成getter,setter等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class test1 {
    String name;
    String age;
    String sex;
}
//https://blog.csdn.net/ChenXvYuan_001/java/article/details/84961992