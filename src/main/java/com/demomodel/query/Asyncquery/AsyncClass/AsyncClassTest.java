package com.demomodel.query.Asyncquery.AsyncClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AsyncClassTest")
public class AsyncClassTest  {

    @Autowired
    AsyncClass asyncClass;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @RequestMapping("/AsyncClassTest2")
    public void test() throws InterruptedException {
    	long start = System.currentTimeMillis();
        asyncClass.foo();
        asyncClass.foo(10);
       // MyLog.sleep(100);
        asyncClass.bar(3);
    	long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

}