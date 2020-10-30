//测试读取List的线程类，大概34秒
package com.demomodel.utils.demo.arraytext.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * List多线程并发读取读取现有的list对象
 * com.demomodel.query.threadPool.ImplRunnable.ThreadPoolTest  参考用线程池
 * @author wgz
 * @date 创建时间：2020年9月27日 下午2:53:24
 */
public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        Map<Long,Integer> map = new HashMap<Long,Integer>();

        for(int i = 0;i<2000;i++){
            list.add(""+i);
        }

        //系统核心数
        int pcount = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();

        for(int i=0;i<pcount;i++){

           Thread t = new MyThread1(list,map);
            map.put(t.getId(),Integer.valueOf(i));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println(list.get(i));
        }
        System.out.println("----"+(System.currentTimeMillis() - start));
    }
}

//线程类
