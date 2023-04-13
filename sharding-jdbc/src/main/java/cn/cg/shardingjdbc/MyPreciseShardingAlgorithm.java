package cn.cg.shardingjdbc;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 准备的分片策略
 *
 * @author: cg
 * @date: 2022-11-30 17:24
 **/
@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
    /**
     * @param availableTargetNames 物理表 - 集合
     * @param preciseShardingValue 分偏键值
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> preciseShardingValue) {
        Map<Integer, String> tableMap = availableTargetNames.stream().collect(Collectors.toMap(x -> Integer.parseInt(x.substring(5)), y -> y));


        Integer value = preciseShardingValue.getValue();

        Integer tableValue = value % 2 + 1;

        String tableName = tableMap.get(tableValue);
        log.info("[MyShardingAlgorithm]  tableName ---->>>>>  {}", tableName);
        return tableName;
    }
}
