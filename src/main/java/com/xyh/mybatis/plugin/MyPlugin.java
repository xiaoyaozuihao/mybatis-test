package com.xyh.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @description:
 * @author: xuyh
 * @create: 2019/7/7
 **/
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args ={Statement.class})})
public class MyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("我的插件开始工作------");
//        System.out.println(invocation.getArgs());
//        System.out.println(invocation.getMethod());
//        System.out.println(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(invocation.getTarget());
        Object parameterObject = metaObject.getValue("parameterHandler.parameterObject");
        metaObject.setValue("parameterHandler.parameterObject",2);
        System.out.println("传入的参数值"+parameterObject);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        //返回包装对象
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("打印插件的属性信息"+properties);
    }
}
