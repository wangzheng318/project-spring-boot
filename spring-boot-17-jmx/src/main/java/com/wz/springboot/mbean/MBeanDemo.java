package com.wz.springboot.mbean;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MBeanDemo {
    public static void main(String[] args) throws Exception {

        // MBean 服务器 - Agent Level
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // 注册对象
        SimpleData simpleData = new SimpleData();

        // 注册名称
        ObjectName objectName = createObjectName(simpleData);

        // 注册 MBean - SimpleDataMBean
        mBeanServer.registerMBean(simpleData, objectName);

        // 服务器不马上停止
        Thread.sleep(Long.MAX_VALUE);

    }

    private static ObjectName createObjectName(Object mbean) throws MalformedObjectNameException {

        Class<?> mBeanClass = mbean.getClass();

        // e,g : com.segmentfault.springbootlesson17.mbean
        String packageName = mBeanClass.getPackage().getName();
        String className = mBeanClass.getSimpleName();

        return new ObjectName(packageName + ":type=" + className);

    }
}
