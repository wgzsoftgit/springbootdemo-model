package com.demomodel.mybatis.ThreadPoolUtilMybatis.util;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;


import io.netty.util.concurrent.Future;
//这个是util类，要想完成功能还要一个类去继承它
//类描述：线程池查询 
public  class ThreadPoolUtil{
	
 
	private static final Logger  log = Logger.getLogger(ThreadPoolUtil.class);
	
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8, 3000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2000)) {
		  protected void afterExecute(Runnable r, Throwable t) {   
		        super.afterExecute(r, t);   
		        printException(r, t);   //&&
		    }   
	};
 
	LinkedBlockingQueue<Runnable> queue = (LinkedBlockingQueue<Runnable>) executor.getQueue();
	
	List<ThreadEntity> li = new ArrayList<ThreadEntity>();//查询的参数list
	
	Method refle ;
 
public void getStart() {
		
		Integer countTool = li.size();//决定要启动的线程数量
		System.err.println("计数器com.demomodel.mybatis.ThreadPoolUtilMybatis.util.ThreadPoolUtil"+countTool);
		final CountDownLatch countDownLatch = new CountDownLatch(countTool);//线程计数器
		
		final List<ThreadEntity> Threadli = new ArrayList<ThreadEntity>();//查询的参数list
		
		Threadli.addAll(li);
		
		for ( int i =0 ;i<Threadli.size();i++) {//开始开辟线程
	//&& ApplicationContextProvider   获取实例类bean对象
		final Object  oc = ApplicationContextProvider.getBean(Threadli.get(i).getClazz());
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object> resultli = new ArrayList<>();
 
		Class<? extends Object> tgg =  oc.getClass();
		Method[] me = tgg.getDeclaredMethods();
		String name = Threadli.get(i).getMethodName();
		map = Threadli.get(i).getCondition();
		
		for (Method method : me) {
			if(name!=null && method.getName().equals(name)) {
				if(!method.isAccessible()) { //判断是不是公共方法
					method.setAccessible(true);
				}
				Parameter[] p =  method.getParameters();
				for (int j = 0; j < (p==null?0:p.length); j++) { //  将参数全部取出来
					for (Entry<String, Object> e :map.entrySet()) {
					
						if( e.getKey().equals(p[j].getName())) {//1.8提供的新方法可以取出参数名
							resultli.add(e.getValue());
						} 
					}
				}
				setRefle(method);  //&& 下
			}
		}
				executor.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println(oc+"对象"+resultli.toArray());
									meta(oc,resultli.toArray());//&& 
									countDownLatch.countDown();//完成计数器减一
					}
				});
		}
		
		try {
			countDownLatch.await();//所有子线程 执行完成之后 主线程再继续向下 
			found();//调用子类&& 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
 //子类实现
public void meta(Object oc, Object[] objects) {}
//子类实现
public void found() {}
 
private static void printException(Runnable r, Throwable t) { 
    if (t == null && r instanceof Future<?>) {   
        try {   
            Future<?> future = (Future<?>) r;   
            if (future.isDone())   
                future.get();   
        } catch (CancellationException ce) {   
            t = ce;   
        } catch (ExecutionException ee) {   
            t = ee.getCause();   
        } catch (InterruptedException ie) {   
            Thread.currentThread().interrupt(); // ignore/reset   
        }   
    }   
    if (t != null)   
        log.error(t.getMessage(), t);   
}
 
public Method getRefle() {
			return refle;
		}
 
public void setRefle(Method refle) {
			this.refle = refle;
		}
 
public List<ThreadEntity> getLi() {
			return li;
		}
}
//https://blog.csdn.net/qq_36090711/java/article/details/79165577