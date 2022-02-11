package com.example.demo.array;

import java.time.OffsetDateTime;

/**
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class validSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean [][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                int c = board[i][j];
                if (c=='.')continue;
                int u = c- '0';
                int idx = i/3*3 + j/3;
                if (row[i][u] || col[j][u] || area[idx][u])return false;
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        return true;
    }

}
