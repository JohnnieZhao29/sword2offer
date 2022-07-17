package D4;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2)。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)
 * 返回左上角 (row1,col1) 、右下角(row2,col2)的子矩阵的元素总和。
 *
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [
 *      [
 *          [
 *              [3,0,1,4,2],
 *              [5,6,3,2,1],
 *              [1,2,0,1,5],
 *              [4,1,0,1,7],
 *              [1,0,3,0,5]
 *          ]
 *      ],
 *      [2,1,4,3],
 *      [1,1,2,2],
 *      [1,2,2,4]
 * ]
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *

 */

public class I4 {
}
class NumMatrix {

    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row > 0){
            int col = matrix[0].length;
            sums = new int[row + 1][col + 1];
            // 初始化前缀和矩阵
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1]
                            + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]
                +sums[row1][col1];
    }
}
