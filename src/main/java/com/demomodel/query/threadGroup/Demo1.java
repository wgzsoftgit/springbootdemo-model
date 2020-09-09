package com.demomodel.query.threadGroup;

import java.util.concurrent.TimeUnit;


public  class  Demo1{
	
	public static  class R1 implements  Runnable{

		@Override
		public void run(){

			System.out.println("threadName:"+Thread.currentThread().getName());

			try{

				TimeUnit.SECONDS.sleep(3);

			}catch(InterruptedException e){

				e.printStackTrace();

			}

		}

	}

	public  static void main(String[] args) throws InterruptedException{


ThreadGroup  threadGroup1 =new ThreadGroup("thread-group-1");

        
Thread t1 =new Thread(threadGroup1,new R1(),"t1");

        
Thread t2 =new Thread(threadGroup1,new R1(),"t2");

        t1.start();

        t2.start();

        
TimeUnit.SECONDS.sleep(1);

        
System.out.println("threadGroup1活动线程数:"+threadGroup1.activeCount());

        
System.out.println("threadGroup1活动线程组:"+ threadGroup1.activeGroupCount());

        
System.out.println("threadGroup1线程组名称:"+ threadGroup1.getName());

        
System.out.println("threadGroup1父线程组名称:"+threadGroup1.getParent().getName());

        
System.out.println("----------------------");

        
ThreadGroup threadGroup2 =new ThreadGroup(threadGroup1,"thread-group-2");

        
Thread t3 =new Thread(threadGroup2,new R1(),"t3");

        
Thread t4 = new Thread(threadGroup2,new R1(),"t4");

        t3.start();

        t4.start();
        t4.setDaemon ( true);//设置守护线程 setDaemon（）方法必须在线程的start（）方法之前调用，在后面调用会报异常，并且不起效
        
TimeUnit.SECONDS.sleep(1);

        
System.out.println("threadGroup2活动线程数:" + threadGroup2.activeCount());

        
System.out.println("threadGroup2活动线程组:" + threadGroup2.activeGroupCount());

        
System.out.println("threadGroup2线程组名称:" + threadGroup2.getName());

       System.out.println("threadGroup2父线程组名称:" + threadGroup2.getParent().getName());



        
System.out.println("----------------------");

        
System.out.println("threadGroup1活动线程数:" + threadGroup1.activeCount());

        
System.out.println("threadGroup1活动线程组:" + threadGroup1.activeGroupCount());

  
System.out.println("-------44---------------");       
threadGroup1.list();


System.out.println("停止线程组："+threadGroup1.getName()+"中的所有子孙线程");       
threadGroup1.interrupt();
     
TimeUnit.SECONDS.sleep(2);
	}

}