package leetcode.structure.arr.matrix;

/**
 * https://leetcode.cn/problems/rotate-image/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_73_矩阵置零 {

    public static void main(String[] args) {

    }


    public void setZeroes0(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.max(m, n);

    }

    public void setZeroes(int[][] matrix) {
        boolean[] m = new boolean[matrix.length];
        boolean[] n = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = true;
                    n[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (m[i] || n[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}




