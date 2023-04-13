package cn.cg.shardingjdbc;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.Map;

/**
 * @author: cg
 * @date: 2022-11-30 20:15
 **/
@Slf4j
public class MyComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Integer> complexKeysShardingValue) {

        Map<String, Range<Integer>> columnNameAndRangeValuesMap = complexKeysShardingValue.getColumnNameAndRangeValuesMap();
        System.out.println(JsonUtil.toJsonString(columnNameAndRangeValuesMap));

        Map<String, Collection<Integer>> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        System.out.println(JsonUtil.toJsonString(columnNameAndShardingValuesMap));

        return collection;
    }
}
