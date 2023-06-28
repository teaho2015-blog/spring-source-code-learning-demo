package net.teaho.demo.sentinel.core;

import com.alibaba.csp.sentinel.slots.statistic.base.LeapArray;
import com.alibaba.csp.sentinel.slots.statistic.data.MetricBucket;
import com.alibaba.csp.sentinel.slots.statistic.metric.BucketLeapArray;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 * @date 2023-03
 */
public class LeapArrayTest {

    @Test
    public void testLeapArray() {
        LeapArray<MetricBucket> longLeapArray = new BucketLeapArray(2, 1000);
        System.out.println(longLeapArray.currentWaiting());
        System.out.println(longLeapArray.currentWindow());
        System.out.println(longLeapArray.getWindowValue(System.currentTimeMillis()));

    }


}
