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
public class TestStructMain {

    public static void main(String[] args) {

        // 配置规则.
        initFlowRules();

        ContextUtil.enter("entrance1", "appA");
        Entry nodeA = null;
        try {
            nodeA = SphU.entry("nodeA");
        } catch (BlockException e) {
            // 处理被流控的逻辑
            System.out.println("1 blocked!");
        }
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();

        ContextUtil.enter("entrance2", "appB");
        try {
            nodeA = SphU.entry("nodeB");
        } catch (BlockException e) {
            // 处理被流控的逻辑
            System.out.println("node b blocked!");
        }
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();

        ContextUtil.enter("entrance2", "appA");
        try {
            nodeA = SphU.entry("nodeA");
        } catch (BlockException e) {
            // 处理被流控的逻辑
            System.out.println("nodeA 2 blocked!");
        }
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();


        try {
            nodeA = SphU.entry("nodeC");
        } catch (BlockException e) {
            // 处理被流控的逻辑
            System.out.println("nodeC blocked!");
        }
        if (nodeA != null) {
            nodeA.exit();
        }


    }

    private static void initFlowRules(){
    }
}
