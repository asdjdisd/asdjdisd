import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int row = beginning.length;
        int col = beginning[0].length;
        int minFlips = Integer.MAX_VALUE;

        // 모든 행을 뒤집는 조합을 시도
        for (int mask = 0; mask < (1 << row); mask++) {
            int[][] flipped = new int[row][col];
            for (int i = 0; i < row; i++) {
                flipped[i] = Arrays.copyOf(beginning[i], col);
            }
            int flipCount = 0;

            // 행을 뒤집기
            for (int i = 0; i < row; i++) {
                if ((mask & (1 << i)) != 0) {
                    flipCount++;
                    for (int j = 0; j < col; j++) {
                        flipped[i][j] = 1 - flipped[i][j];
                    }
                }
            }

            // 각 열을 확인하여 뒤집기
            for (int j = 0; j < col; j++) {
                boolean needFlip = false;
                for (int i = 0; i < row; i++) {
                    if (flipped[i][j] != target[i][j]) {
                        needFlip = true;
                        break;
                    }
                }
                if (needFlip) {
                    flipCount++;
                    for (int i = 0; i < row; i++) {
                        flipped[i][j] = 1 - flipped[i][j];
                    }
                }
            }

            // 목표 상태와 일치하는지 확인
            boolean match = true;
            for (int i = 0; i < row; i++) {
                if (!Arrays.equals(flipped[i], target[i])) {
                    match = false;
                    break;
                }
            }

            // 최솟값 갱신
            if (match) {
                minFlips = Math.min(minFlips, flipCount);
            }
        }

        return minFlips == Integer.MAX_VALUE ? -1 : minFlips;
    }
}