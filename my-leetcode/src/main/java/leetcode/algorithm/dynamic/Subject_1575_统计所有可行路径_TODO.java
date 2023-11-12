package leetcode.algorithm.dynamic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 想不明白 做不出来
 * 类名称: Subject_1575_统计所有可行路径
 * 创建人: chengang
 * 创建时间: 2023-07-10 15:48:42
 * 描述: Subject 1575 Counts all feasible paths
 * 父类:
 * 版本: 1.0.0
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * <p>
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 * <p>
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 * <p>
 * 请你返回从 start 到 finish 所有可能路径的数目。
 * <p>
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 */
public class Subject_1575_统计所有可行路径_TODO {

    public static void main(String[] args) {
        System.out.println(countRoutes0(new int[]{1, 2, 3}, 0, 2, 40));
//        System.out.println(countRoutes0(new int[]{4, 3, 1}, 1, 0, 6));
//        System.out.println(countRoutes0(new int[]{5, 2, 1}, 0, 2, 3));

    }

    static int mod = 1000000007;

    // 缓存器：用于记录「特定状态」下的结果
    // cache[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
    static int[][] cache;


    /**
     * @param locations 城市位置数组
     * @param start     起始城市
     * @param finish    目的地城市
     * @param fuel      汽油总量
     * @return 所有可能得路径
     * 剪枝场景1:有油到达终点
     * 2.没有油了
     *
     * <p>*
     * dfs
     */
    public static int countRoutes0(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        // 初始化缓存器
        // 之所以要初始化为 -1
        // 是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(locations, start, finish, fuel);
    }


    /**
     * 计算「路径数量」
     *
     * @param ls   入参 locations
     * @param u    当前所在位置（ls 的下标）
     * @param end  目标哦位置（ls 的下标）
     * @param fuel 剩余油量
     * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
     */
    static int dfs(int[] ls, int u, int end, int fuel) {
        // 如果缓存器中已经有答案，直接返回
        if (cache[u][fuel] != -1) {
            return cache[u][fuel];
        }

        int n = ls.length;
        // base case 1：如果油量为 0，且不在目标位置
        // 将结果 0 写入缓存器并返回
        if (fuel == 0 && u != end) {
            cache[u][fuel] = 0;
            return 0;
        }

        // base case 2：油量不为 0，且无法到达任何位置
        // 将结果 0 写入缓存器并返回
        boolean hasNext = false;
        for (int i = 0; i < n; i++) {
            if (i != u) {
                int need = Math.abs(ls[u] - ls[i]);
                if (fuel >= need) {
                    hasNext = true;
                    break;
                }
            }
        }
        if (fuel != 0 && !hasNext) {
            cache[u][fuel] = u == end ? 1 : 0;
            return cache[u][fuel];
        }

        // 计算油量为 fuel，从位置 u 到 end 的路径数量
        // 由于每个点都可以经过多次，如果 u = end，那么本身就算一条路径
        int sum = u == end ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != u) {
                int need = Math.abs(ls[i] - ls[u]);
                if (fuel >= need) {
                    sum += dfs(ls, i, end, fuel - need);
                    sum %= mod;
                }
            }
        }
        cache[u][fuel] = sum;
        return sum;
    }

    /**
     * @param locations
     * @param from      出发地
     * @param to        目的地值
     * @param finish    最终目的地
     * @param fuel      剩余油量
     * @param path      经过的地点
     * @param res       结果
     */
    private static void backtrack(int[] locations, int from, int to, int start, int finish, int fuel, ArrayList<List<Integer>> res, List<Integer> path) {
        //初始化第一个元素
        if (to == start && to == from) {
            path.add(to);
        }
        //油不够了
        if (fuel < 0 || fuel - Math.abs(locations[from] - locations[to]) < 0) {
            return;
        }
        //到达目的地
        if (to == finish) {
            res.add(new ArrayList<>(path));
//            return;
        }
        //发起回溯
        for (int i = 0; i < locations.length; i++) {
//        循序经过的城市超过一次
            //不允许原地踏步
            if (path.get(path.size() - 1) == i) {
                continue;
            }
            path.add(i);
            backtrack(locations, to, i, start, finish, fuel - Math.abs(locations[from] - locations[to]), res, path);
            path.remove(path.size() - 1);
        }
    }


}
