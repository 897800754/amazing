package cn.cg.shardingjdbc;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.Collections;

/**
 * 准备的分片策略
 *
 * @author: cg
 * @date: 2022-11-30 17:24
 **/
@Slf4j
public class MyRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        Range<Integer> valueRange = rangeShardingValue.getValueRange();
        if (valueRange.contains(1)) {
            return Collections.singletonList(collection.stream().findFirst().orElse(null));
        }
        return collection;


    }
}
