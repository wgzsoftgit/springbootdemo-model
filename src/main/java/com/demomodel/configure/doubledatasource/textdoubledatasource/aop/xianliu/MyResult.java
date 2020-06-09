package com.demomodel.configure.doubledatasource.textdoubledatasource.aop.xianliu;

import java.util.List;

public class MyResult {
        private Integer status;
        private String msg;
        private List<Object> data;
 
        public MyResult(Integer status, String msg, List<Object> data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }
 
        public static MyResult OK(String msg, List<Object> data) {
            return new MyResult(200, msg, data);
        }
 
        public static MyResult Error(Integer status, String msg) {
            return new MyResult(status, msg, null);
        }

		public Integer getStatus() {
			return status;
		}

		public String getMsg() {
			return msg;
		}

		public List<Object> getData() {
			return data;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void setData(List<Object> data) {
			this.data = data;
		}
        
}
//https://blog.csdn.net/qq_39816039/java/article/details/83988517