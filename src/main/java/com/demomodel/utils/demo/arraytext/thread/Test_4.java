package com.demomodel.utils.demo.arraytext.thread;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class Test_4 {
    /**
     * 多线程处理list
     *com.demomodel.query.threadPool.ImplRunnable.ThreadPoolTest  参考用线程池
     * @param data  数据list
     * @param threadNum  线程数
     */
    public synchronized void handleList(List<String> data, int threadNum) {
        int length = data.size();
        int tl = length % threadNum == 0 ? length / threadNum : (length
                / threadNum + 1);

        for (int i = 0; i < threadNum; i++) {
            int end = (i + 1) * tl;
            HandleThread thread = new HandleThread("线程[" + (i + 1) + "] ",  data, i * tl, end > length ? length : end);
            thread.start();
//            try {
//            	thread.join();//等待所有
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
        }
    }

    class HandleThread extends Thread {
        private String threadName;
        private List<String> data;
        private int start;
        private int end;

        public HandleThread(String threadName, List<String> data, int start, int end) {
            this.threadName = threadName;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        public void run() {
            List<String> subList = data.subList(start, end)/*.add("^&*")*/;
            try {
				sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(threadName+"处理了"+subList.size()+"条！"+subList);
        }

    }

    public static void main(String[] args) {
        Test_4 test = new Test_4();
        // 准备数据
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 1618; i++) {
            data.add("item" + i);
        }
        test.handleList(data, 50);
        System.out.println(ArrayUtils.toString(data));
    }
}