package net.teaho.demo.hystrix.core;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
public class HystrixCommandTest {
    @Test
    public void testHystrixCommand() {
        for (int i = 0; i < 10; i++) {
            UserCommand userCommand = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("User")));
            System.out.println(userCommand.execute().toString());
        }
    }

    @Test
    public void testHystrixCommandExecute() throws ExecutionException, InterruptedException {
        UserCommand userCommand = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("User")));
        System.out.println(userCommand.execute());

        UserCommand userCommand2 = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("User")));
        System.out.println(userCommand2.queue().get());

        UserCommand userCommand3 = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("User")));
        userCommand3.observe().subscribe(System.out::println);

        UserCommand userCommand4 = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("User")));
        System.out.println(userCommand4.toObservable().toBlocking().toFuture().get());

    }

}
