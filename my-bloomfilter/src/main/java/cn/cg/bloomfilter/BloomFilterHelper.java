package cn.cg.bloomfilter;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

/**
 * 算法过程：
 * 1. 首先需要k个hash函数，每个函数可以把key散列成为1个整数
 * 2. 初始化时，需要一个长度为n比特的数组，每个比特位初始化为0
 * 3. 某个key加入集合时，用k个hash函数计算出k个散列值，并把数组中对应的比特位置为1
 * 4. 判断某个key是否在集合时，用k个hash函数计算出k个散列值，并查询数组中对应的比特位，如果所有的比特位都是1，认为在集合中。
 * @description: 布隆过滤器，摘录自Google-guava包
 **/
public class BloomFilterHelper<T> {
    private int numHashFunctions;

    private int bitSize;

    private Funnel<T> funnel;

    public BloomFilterHelper(Funnel<T> funnel, int expectedInsertions, double fpp) {
        Preconditions.checkArgument(funnel != null, "funnel不能为空");
        this.funnel = funnel;
        // 计算bit数组长度
        bitSize = optimalNumOfBits(expectedInsertions, fpp);
        // 计算hash方法执行次数
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, bitSize);
    }

    public int[] murmurHashOffset(T value) {
        int[] offset = new int[numHashFunctions];

        //有点类似于hashmap中采用高32位与低32位相与获得hash值
        long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong();
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        //采用对低32进行变更以达到随机哈希函数的效果
        for (int i = 1; i <= numHashFunctions; i++) {
            int nextHash = hash1 + i * hash2;
            if (nextHash < 0) {
                nextHash = ~nextHash;
            }
            offset[i - 1] = nextHash % bitSize;
        }
        return offset;
    }

    /**
     * 计算bit数组长度
     * Math.log(2) = 0.6931471805599453;（取0.693147来用）
     * (Math.log(2) * Math.log(2)) = 0.48045237;
     * 假设传入n为1,000,000  , p为0.01;
     * Math.log(0.01) = -4.605170185988091;
     * 则返回值为9,585,071 ,即差不多是预设容量的10倍
     *
     * 要知道 1MB = 1024KB , 1KB = 1024B ,1B=8bit。
     * 也就是对一百万数据预计花费的内存为1.143MB的内存
     */
    private int optimalNumOfBits(long n, double p) {
        if (p == 0) {
            // 设定最小期望长度
            p = Double.MIN_VALUE;
        }
        return (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 计算hash方法执行次数
     */
    private int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }
}
