package cn.cg.shardingjdbc;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;

/**
 * @author: cg
 * @date: 2022-11-30 18:38
 **/
@Slf4j
public class MyHintShardingAlgorithm implements HintShardingAlgorithm<String> {
    /**
     * 自定义Hint 实现算法
     * 能够保证绕过Sharding-JDBC SQL解析过程
     *
     * @param availableTargetNames
     * @param hintShardingValue    不再从SQL 解析中获取值，而是直接通过hintManager.addTableShardingValue("t_order", 1)参数指定
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> hintShardingValue) {
        for (String s : availableTargetNames) {
            System.out.println(s);
        }
        return availableTargetNames;
    }
}
