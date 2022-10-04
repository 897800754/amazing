package leetcode.arr;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 
 * 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 
 * 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class Demo {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].length % 2 == 1) {
                if (A[i][A[i].length / 2] == 1) {
                    A[i][A[i].length / 2] = 0;
                } else {
                    A[i][A[i].length / 2] = 1;
                }
            }
            int begin = 0;
            int end = A[i].length - 1;
            while (begin < end) {
                if (A[i][begin] == A[i][end]) {
                    if (A[i][begin] == 1) {
                        A[i][begin] = A[i][end] = 0;
                    } else {
                        A[i][begin] = A[i][end] = 1;
                    }
                }
                begin++;
                end--;
            }
        }
        return A;
    }
}
