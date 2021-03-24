package net.teaho.demo.spring.cloud.context.named.app;

/**
 * @author teaho2015@gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
public interface Rule {

    String loadRule();


    class Default implements Rule {

        @Override
        public String loadRule() {
            return "defaultRule";
        }
    }
}

