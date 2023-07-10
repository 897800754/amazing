package leetcode.algorithm.dynamic;


import java.util.ArrayList;
import java.util.List;

/**
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
public class Subject_1575_统计所有可行路径 {

    public static void main(String[] args) {
        System.out.println(countRoutes(new int[]{1, 2, 3}, 0, 2, 40));
//        System.out.println(countRoutes(new int[]{4, 3, 1}, 1, 0, 6));

    }

    /**
     * @param locations 城市位置数组
     * @param start     起始城市
     * @param finish    目的地城市
     * @param fuel      汽油总量
     * @return 所有可能得路径
     * <p>
     * 当fuel>=0且 start!=finish时,
     */
    public static int countRoutes0(int[] locations, int start, int finish, int fuel) {
        return -1;
        //todo
    }

    /**
     * 记录所有路径所需要的油量
     * k ->
     * dp[k]
     *
     * @param locations 城市位置数组
     * @param start     起始城市
     * @param finish    目的地城市
     * @param fuel      汽油总量
     * @return 所有可能得路径
     * 回溯算法貌似会超出内存的限制
     */
    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        //回溯+剪枝
        //剪枝条件 1:汽油不够了.2:到达目的地了
        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(locations, start, start, start, finish, fuel, res, path);
        System.out.println(res);
        return res.size();
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
