import java.util.*;
class Solution {
    int sum=0;
    int count=0;
    int index=2;
    int dx[]={1,0,-1,0};
    int dy[]={0,-1,0,1};
    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    Set<Integer> l = new HashSet<>();

    public void bfs(int x, int y, int[][] land) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    land[x][y] = index; 
   
    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        count++;
        
        for (int q = 0; q < 4; q++) {
            int nx = current[0] + dx[q];
            int ny = current[1] + dy[q];

            if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length && land[nx][ny] == 1) {
                queue.add(new int[]{nx, ny});
                land[nx][ny] = index;
                }
            }
        }
        m.put(index,count);
        count=0;
        index++;
    }
    public int solution(int[][] land) {
        int answer=0;
        
        for(int q=0;q<land[0].length;q++)
        {
            sum=0;
            for(int w=0;w<land.length;w++)
            {
                if(land[w][q]==1)
                {
                    bfs(w,q,land);
                }
                if(land[w][q]!=0&&land[w][q]!=1)
                    l.add(land[w][q]);    
            }
            for (int e : l) 
                sum += m.get(e);
            l.clear();
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
