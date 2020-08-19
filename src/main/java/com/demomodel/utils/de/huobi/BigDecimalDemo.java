package com.demomodel.utils.de.huobi;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalDemo {
	public static void main(String[] args) {
		 BigDecimal a =new BigDecimal(0.1);
	        System.out.println("a values is:"+a);//a values is:0.1000000000000000055511151231257827021181583404541015625
	        System.out.println("=====================");
	        BigDecimal b =new BigDecimal("0.1");  //推荐使用
	        System.out.println("b values is:"+b);//b values is:0.1
	        
	        
	        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用 
	        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用 
	        percent.setMaximumFractionDigits(3); //百分比小数点最多3位 
	        
	        BigDecimal loanAmount = new BigDecimal("15000.480000000000000000000000006"); //贷款金额
	        BigDecimal interestRate = new BigDecimal("0.008"); //利率   
	        BigDecimal interest = loanAmount.multiply(interestRate); //相乘
	     //贷款金额: ￥15,000.48 利率: 0.8% 利息: ￥120.00
	        System.out.println("贷款金额:\t" + currency.format(loanAmount)); 
	        System.out.println("利率:\t" + percent.format(interestRate)); 
	        System.out.println("利息:\t" + currency.format(interest)); 
	}
}
/**
原因分析：

1）参数类型为double的构造方法的结果有一定的不可预知性。有人可能认为在Java中写入newBigDecimal(0.1)
所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。
这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。这样，
传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。

2）String 构造方法是完全可预知的：写入 newBigDecimal(“0.1”) 将创建一个 BigDecimal，它正好等于预期的 0.1。
因此，比较而言， 通常建议优先使用String构造方法。

3）当double必须用作BigDecimal的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：
先使用Double.toString(double)方法，然后使用BigDecimal(String)构造方法，将double转换为String。
要获取该结果，请使用static valueOf(double)方法。

*/