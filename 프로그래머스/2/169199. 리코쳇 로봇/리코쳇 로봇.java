import java.util.*;

class Solution {
    int bfs(int x, int y, String board[][]) {
        int count = 0;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y});

        while (!qu.isEmpty()) {
            int size = qu.size(); 
            for (int i = 0; i < size; i++) {
                int a[] = qu.poll();

                for (int q = 0; q < 4; q++) {
                    int nx = a[0] + dx[q];
                    int ny = a[1] + dy[q];

                    if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)
                        continue;
                    else if (board[nx][ny].equals("D"))
                        continue;
                    else {
                        while (true) {
                            nx += dx[q];
                            ny += dy[q];

                            if (nx < 0 || ny < 0 || nx > board.length - 1 || ny > board[0].length - 1) {
                                nx -= dx[q];
                                ny -= dy[q];
                                break;
                            }

                            if (board[nx][ny].equals("D")) {
                                nx -= dx[q];
                                ny -= dy[q];
                                break;
                            }
                        }
                    }

                    if (board[nx][ny].equals("G")) {
                        return ++count;
                    } else if (board[nx][ny].equals(".")) {
                        qu.add(new int[]{nx, ny});
                        board[nx][ny] = ",";
                    } else {
                        continue;
                    }
                }
            }
            count++; 
        }
        return -1;
    }

    public int solution(String[] board) {
        int answer = -1;
        int x = 0;
        int y = 0;
        String b[][] = new String[board.length][board[0].length()];

        for (int q = 0; q < board.length; q++)
            for (int w = 0; w < board[0].length(); w++)
                b[q][w] = board[q].substring(w, w + 1);

        for (int q = 0; q < b.length; q++) {
            for (int w = 0; w < b[0].length; w++) {
                if (b[q][w].equals("R")) {
                    answer = bfs(q, w, b);
                    break;
                }
            }
        }
        return answer;
    }
}