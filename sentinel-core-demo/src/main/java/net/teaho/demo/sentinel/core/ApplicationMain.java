package net.teaho.demo.sentinel.core;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author teaho2015@gmail.com
 * @date 2023-03
 */
public class ApplicationMain {

    public static void main(String[] args) {

        // 配置规则.
        initFlowRules();

        for (int i=0; i<1; i++) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            Entry entry = null;
            try {
                ContextUtil.enter("entrance1", "appA");
                entry = SphU.entry("HelloWorld", EntryType.OUT, 1, new Object[0]);
                // 被保护的逻辑
                System.out.println("hello world");
                TimeUnit.MILLISECONDS.sleep(100L);
                if (System.currentTimeMillis() % 3 == 0) {
                    throw new IllegalStateException();
                }
            } catch (BlockException | InterruptedException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            } catch (Exception e) {
                //DO NOTHING
                Tracer.trace(e);
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(9);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
