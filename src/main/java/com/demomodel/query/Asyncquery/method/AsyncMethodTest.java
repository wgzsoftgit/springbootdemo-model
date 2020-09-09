package com.demomodel.query.Asyncquery.method;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.query.Asyncquery.AsyncClass.MyLog;
@RestController
@RequestMapping("/asyncMethodTest")
public class AsyncMethodTest  { 

    @Autowired
    AsyncMethod asyncMethod;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    @AfterClass
    public static void afterClass() throws Exception {
      //  MyLog.sleep(3000);
    }

    @Before
    public void setUp() throws Exception {
    }

    @RequestMapping("/test1")
    public void test1() {
        asyncMethod.foo1();
        MyLog.info("just wait");
      //  MyLog.sleep(2000);
    }
    @RequestMapping("/test2")
    public void test2() {
        for (int i = 0; i < 10; i++) {
            asyncMethod.foo2(i);
        }
    }
    @RequestMapping("/test3")
    public void test3() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncMethod.foo3(i, "gc-thread-"+i);
        }
    }

    @RequestMapping("/testE")
    public void testE() throws InterruptedException {
        try {
            Future<String> result = asyncMethod.futureE();
            //这里调用get才会获得异常
            MyLog.info(result.get());
        } catch(Exception e) {
            //e.printStackTrace();
            MyLog.info("this is excepted Exception:" + e.getMessage());
        }
        
        asyncMethod.fooE();
        MyLog.info("end call e");
        //MyLog.sleep(1000);
    }
    
    @RequestMapping("/testFuture")
    public void testFuture() throws InterruptedException, ExecutionException {
        MyLog.info("\n-----------------start-----------------------");
        Future<String> result1 = asyncMethod.futureTask1();
        CompletableFuture<String> result2 = asyncMethod.futureTask2();
        MyLog.info("result1:" + result1.get());
        MyLog.info("result2:" + result2.get());
    }
    
    @RequestMapping("/testReject")
    public void testReject() {
        MyLog.info("\n-----------------start testReject-----------------------");
        MyLog.info("start add task");
        //当超过线程词最大容量的时候，会抛出TaskRejectedException
        try {
            for (int i = 1; i < 7; i++) {
                asyncMethod.asyncSleep(i, 1);
            }
        } catch(RejectedExecutionException e) {
            MyLog.info("excepted exception:" + e.getMessage());
        }
        MyLog.info("finished add task");
      //  MyLog.sleep(100 * 1000);
//        -----------------start testReject-----------------------
//        start add task
//        excepted exception:Executor [org.apache.tomcat.util.threads.ThreadPoolExecutor@256d81c8[Running, pool size = 5, active threads = 3, queued tasks = 0, completed tasks = 0]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$2127/394114398@3ce39aeb
//        finished add task
//        task:1 end
//        task:0 end
//        task:2 end
    }
    
    @RequestMapping("/testRejectWithDeal")
    public void testRejectWithDeal() {
        MyLog.info("\n-----------------start testRejectWithDeal-----------------------");
        MyLog.info("start add task");
        //当超过线程词最大容量的时候，会抛出TaskRejectedException
        try {
            for (int i = 0; i < 10; i++) {
                asyncMethod.asyncSleep3(i, 1);
            }
        } catch(RejectedExecutionException e) {
            MyLog.info("excepted exception:" + e.getMessage());
        }
        MyLog.info("finished add task");
     //   MyLog.sleep(100 * 1000);
    }
    
    public static void main(String[] args) throws InterruptedException {
    	AsyncMethod asyncMethod=new AsyncMethod();
    	asyncMethod.foo3(3,"2");
    	asyncMethod.fooE();
		
	}
}