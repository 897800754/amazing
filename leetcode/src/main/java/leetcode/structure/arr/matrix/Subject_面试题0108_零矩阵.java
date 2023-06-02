package leetcode.structure.arr.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/zero-matrix-lcci/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_面试题0108_零矩阵 {

    public static void main(String[] args) {

    }

    /**
     * 标记数组优化版
     *
     * @param matrix
     */
    public static void setZeroes0(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] mFlag = new int[m];
        int[] nFlag = new int[n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    //记录行,列
                    mFlag[i] = 1;
                    nFlag[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (mFlag[i] == 1 || nFlag[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 暴力解法-标记数组
     * 优化:空间上使用数组代替hashSet
     * 时间上两次遍历M*N矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        //hash表记录 哪些行/列需要清零
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    //记录行,列
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        if (!zeroRow.isEmpty()) {
            for (Integer integer : zeroRow) {
                for (int i = 0; i < matrix[integer].length; i++) {
                    matrix[integer][i] = 0;
                }
            }
        }
        if (!zeroCol.isEmpty()) {
            for (Integer integer : zeroCol) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][integer] = 0;
                }
            }
        }
    }
}




