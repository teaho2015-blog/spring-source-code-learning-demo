package net.teaho.demo.dubbo.spi.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.*;

/**
 * @author teaho2015@gmail.com
 * @since 2020-07
 */
@Slf4j
public class MonitorFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String shortMethodName = this.getShortMethodName(invoker, invocation);
        log.info(shortMethodName);
        return invoker.invoke(invocation);
    }

    /**
     * 构造短方法名，样式：(短类名.方法名)
     *
     * @return
     */
    private String getShortMethodName(Invoker<?> invoker, Invocation invocation) {
        String interfaceName = invoker.getInterface().getName();
        String shortInterfaceName = interfaceName.substring(interfaceName.lastIndexOf(".") + 1);
        return shortInterfaceName + "." + invocation.getMethodName();
    }

}
