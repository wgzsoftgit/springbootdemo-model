package com.demomodel.query.Schedulequery.conf;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.demomodel.query.Schedulequery.bean.ScheduleConfig;
import com.demomodel.query.Schedulequery.dao.ScheduleDao;
import com.demomodel.query.Schedulequery.getbean.ApplicationContextHelper;


//只读一次数据库
@Component
public class ScheduleSetting implements SchedulingConfigurer {
 
    @Autowired
    private ScheduleDao scheduleDao;
 
    @Override 
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 获取所有任务
        List<ScheduleConfig> scheduleList = scheduleDao.getScheduleList();
        System.err.println("########################################################");
        System.out.println("com.demomodel.query.Schedulequery.conf.ScheduleSetting"+scheduleList.size());
         for (ScheduleConfig s : scheduleList){
        	 if(s.getStatus()==0) { 
        		 //  && getRunnable()    && getTrigger()
                 scheduledTaskRegistrar.addTriggerTask(getRunnable(s), getTrigger(s)); 
        	 }
        	
         }    
    }
 
   
    /**
     * 转换首字母小写
     *
     * @param str
     * @return
     */
    public static String lowerFirstCapse(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
 
    /**
     * runnable
     * @param scheduleConfig
     * @return
     */
    private Runnable getRunnable(ScheduleConfig scheduleConfig){
        return new Runnable() {
            @Override
            public void run() {
                Class<?> clazz;
                try {
                	//反射加载类
                    clazz = Class.forName(scheduleConfig.getClassName());
                    String className = lowerFirstCapse(clazz.getSimpleName());//&& 下
                    
                    //  springboot 获取对象
                    Object bean = (Object) ApplicationContextHelper.getBean(className);
                    Method method = ReflectionUtils.findMethod(bean.getClass(), scheduleConfig.getMethod());
                    ReflectionUtils.invokeMethod(method, bean);
                } catch (ClassNotFoundException e) {
                     e.printStackTrace();
                }
            }
        };
    }
 
    /**
     * Trigger
     * @param scheduleConfig
     * @return
     */
    private Trigger getTrigger(ScheduleConfig scheduleConfig){
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger(scheduleConfig.getCron());
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        };  
 
    }
}
//https://blog.csdn.net/xcc_2269861428/java/article/details/99996185