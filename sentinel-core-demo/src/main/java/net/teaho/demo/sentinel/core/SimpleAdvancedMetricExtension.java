package net.teaho.demo.sentinel.core;

import com.alibaba.csp.sentinel.metric.extension.AdvancedMetricExtension;
import com.alibaba.csp.sentinel.slotchain.ResourceWrapper;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author teaho2015@gmail.com
 * @date 2023-06
 */
public class SimpleAdvancedMetricExtension implements AdvancedMetricExtension {

    @Override
    public void onPass(ResourceWrapper rw, int batchCount, Object[] args) {
        System.out.println("onpass" + rw + batchCount + args);
    }

    @Override
    public void onBlocked(ResourceWrapper rw, int batchCount, String origin, BlockException e, Object[] args) {
        System.out.println("onBlocked" + rw + batchCount + origin + e + args);

    }

    @Override
    public void onComplete(ResourceWrapper rw, long rt, int batchCount, Object[] args) {
        System.out.println("onBlockonCompleteed" + rw + batchCount + rt + args);

    }

    @Override
    public void onError(ResourceWrapper rw, Throwable throwable, int batchCount, Object[] args) {
        System.out.println("onError" + rw + batchCount + throwable + args);

    }

    @Override
    public void addPass(String resource, int n, Object... args) {

    }

    @Override
    public void addBlock(String resource, int n, String origin, BlockException blockException, Object... args) {

    }

    @Override
    public void addSuccess(String resource, int n, Object... args) {

    }

    @Override
    public void addException(String resource, int n, Throwable throwable) {

    }

    @Override
    public void addRt(String resource, long rt, Object... args) {

    }

    @Override
    public void increaseThreadNum(String resource, Object... args) {

    }

    @Override
    public void decreaseThreadNum(String resource, Object... args) {

    }
}
