package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_118_杨辉三角 {

    public static void main(String[] args) {
//        System.out.println(generate(2));
//        System.out.println(generate(3));
//        System.out.println(generate(4));
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> subRes = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    subRes.add(1);
                    continue;
                }
                List<Integer> integers = res.get(i - 2);
                subRes.add(integers.get(j - 2) + integers.get(j - 1));
            }
            res.add(subRes);
            //首,尾节点值都为1.
            //arr[i][j] = arr[i-1][j-1]+arr[i-1][j]
        }
        return res;
    }
}




