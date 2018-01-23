package com.xmsmartcity.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
/*
 * 
 * 说明：这个类为手工启动事务提供支持，但是不建议使用手工启动事务的方法，能用注解启动的，尽量使用注解启动
 *
 * */
public class TransactionHelper {
	
	public static Map newTrans(){
		//获取Spring容器的对象
        WebApplicationContext contextLoader = ContextLoader.getCurrentWebApplicationContext();
        //设置属性的默认属性
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //设置事务的传播行为，此处是设置为开启一个新事物
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        //设置事务的隔离级别，此处是读已经提交
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //从spring容器对象中获取DataSourceTransactionManager，这个根据配置文件中配置的id名（transactionManager）
        DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) contextLoader.getBean("transactionManager");
        //获取事务状态对象
        TransactionStatus transactionStatus = (TransactionStatus) transactionManager.getTransaction(definition);
        
        HashMap map = new HashMap();
        map.put("Manager", transactionManager);
        map.put("Status", transactionStatus);
        return map;
       
	}
	
	public static void commitTrans(DataSourceTransactionManager transactionManager,TransactionStatus transactionStatus){
		transactionManager.commit(transactionStatus);
	}
	
	public static void rollbackTrans(DataSourceTransactionManager transactionManager,TransactionStatus transactionStatus){
		transactionManager.rollback(transactionStatus);
	}

}
