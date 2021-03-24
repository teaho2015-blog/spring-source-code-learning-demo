package net.teaho.demo.spring.cloud.context.named.app;

/**
 * @author teaho2015@gmail.com
 * @date 2021-03
 * @since 1.0.0
 */
public class RuleImplA implements Rule {

    @Override
    public String loadRule() {
        return "ruleA";
    }
}
