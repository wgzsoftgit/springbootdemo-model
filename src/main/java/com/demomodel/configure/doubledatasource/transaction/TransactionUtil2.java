package com.demomodel.configure.doubledatasource.transaction;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//@Component("transactionUtil")
@Component
 public final class TransactionUtil2 {
	public static TransactionUtil2 transactionUtil;
      /**
       * 初始化数据源
       */
      @Autowired
      private DataSourceTransactionManager dataSourceTransactionManager;
 
//    //  @PostConstruct
//      public void init() {
//    	  transactionUtil = this;
//    	  transactionUtil.dataSourceTransactionManager = this.dataSourceTransactionManager;
//      }
     /**
      * 开启事务
      * 
      * @return
      */
     public TransactionStatus begin() {
    	 
         TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
         System.out.println(" 开启事务成功 ");
         return transaction;
    }
 
     /**
      * 提交事物
      * 
      * @param transaction
      */
     public void commit(TransactionStatus transaction) {
         dataSourceTransactionManager.commit(transaction);
         System.out.println(" 事物提交成功 "); 
    }
 
     /**
      * 回滚事务
      * 
      * @param transaction
      */
     public void rollback(TransactionStatus transaction) {
         dataSourceTransactionManager.rollback(transaction);
         System.err.println(" 事物进行回滚 ");
    }
 }
