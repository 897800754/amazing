package cn.cg.bloomfilter;

import com.google.common.base.Preconditions;
import org.springframework.data.redis.core.RedisTemplate;

public class BloomRedisService {

    private RedisTemplate<String, Object> redisTemplate;

    private BloomFilterHelper bloomFilterHelper;

    public void setBloomFilterHelper(BloomFilterHelper bloomFilterHelper) {
        this.bloomFilterHelper = bloomFilterHelper;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 根据给定的布隆过滤器添加值
     * 这里可以考虑LUA脚本进行优化，减少传输次数
     * 如 eval "redis.call('setbit',KEYS[1],ARGV[1],1) redis.call('setbit',KEYS[1],ARGV[2],1) " 1 mybool  243 5143
     * 但是又需要衡量操作的时间，与如果次数很多导致的传输的数据量很大容易阻塞问题
     */
    public <T> void addByBloomFilter(String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            redisTemplate.opsForValue().setBit(key, i, true);
        }
    }

    /**
     * 根据给定的布隆过滤器判断值是否存在
     */
    public <T> boolean includeByBloomFilter(String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            if (!redisTemplate.opsForValue().getBit(key, i)) {
                return false;
            }
        }
        return true;
    }
}
