package leetcode.structure.arr.matrix;

/**
 * https://leetcode.cn/problems/rotate-image/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_48_旋转图像_TODO {

    public static void main(String[] args) {

    }


    public static void rotate(int[][] matrix) {
        //n=3
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            //由外而内遍历
            for (int j = 0; j < (n + 1) / 2; j++) {
                //第1.1轮 temp<-[0,0]
                //第1.2轮 temp<-[0,1]
                int temp = matrix[i][j];
                //第1.1轮 [0,0]<-[2,0]
                //第1.2轮 [0,1]<-[1,0]
                matrix[i][j] = matrix[n - j - 1][i];
                //第1.1轮 [2,0]<-[2,2]
                //第1.2轮 [1,0]<-[2,1]
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                //第1.1轮 [2,2]<-[0,2]
                //第1.2轮 [2,1]<-[1,2]
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                //第1.1轮 [0,2]<-temp
                //第1,2轮 [1,2]<-temp
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}




