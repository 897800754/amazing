package leetcode.structure.arr;

/**
 * https://leetcode.cn/problems/valid-sudoku/description/
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_36_有效的数独 {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'b');
        System.out.println((int) '9');
        System.out.println((int) '0');
        System.out.println((int) '9' - (int) '0');
    }


    /**
     * 一次遍历二维表
     * <p>
     * 通过三个多维数组
     *
     * 记录行,列,九宫格每个数字出现的次数,由于是9*9是固定的,所以hash表可以用数组代替
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] table = new int[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ele = board[i][j];
                if (ele == '.') {
                    continue;
                }
                //记录行,char类型-1直接转为int
                int index = ele - '0' - 1;
                row[i][index]++;
                //记录列
                col[j][index]++;
                //记录3*3格.
                table[i / 3][j / 3][index]++;

                if (row[i][index] > 1 || col[j][index] > 1 || table[i / 3][j / 3][index] > 1) {
                    return false;
                }
            }
        }
        return true;
    }


}




