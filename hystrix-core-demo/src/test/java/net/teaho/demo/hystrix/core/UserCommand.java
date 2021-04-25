package net.teaho.demo.hystrix.core;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
public class UserCommand extends HystrixCommand<User> {
    protected UserCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    protected UserCommand(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool) {
        super(group, threadPool);
    }

    protected UserCommand(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected UserCommand(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, threadPool, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected UserCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected User run() throws Exception {
        /* simulate performing network call to retrieve user information */
        try {
            Thread.sleep((int) (Math.random() * 10) + 2);
        } catch (InterruptedException e) {
            // do nothing
        }

        /* fail 50% of the time to show how fallback works */
        if (Math.random() > 0.5) {
            throw new RuntimeException("random failure processing UserAccount network response");
        }

        /* latency spike 50% of the time so timeouts can be triggered occasionally */
        if (Math.random() > 0.5) {
            // random latency spike
            try {
                Thread.sleep((int) (Math.random() * 300) + 25);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
        return User.builder()
            .name("teaho")
            .height("179")
            .email("teaho2015@gmail.com")
            .build();
    }

    @Override
    protected User getFallback() {

        return User.builder()
            .name("fallback user")
            .height("190")
            .email("fallback@gmail.com")
            .build();
    }
}
