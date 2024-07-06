import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> que=new LinkedList<>();
        que.add(y);
        while(!que.isEmpty())
        {
            int qsize=que.size();
            for(int q=0;q<qsize;q++)
            {
                int check=que.poll();
                int a=check-n;
                if(check==x)
                    return answer;
                if(a>=x)
                    que.add(a);
            
                if(check%2==0)
                {
                    a=check/2;
                    if(a>=x)
                        que.add(a);
                }
                if(check%3==0)
                {
                    a=check/3;
                    if(a>=x)
                        que.add(a);
                }
            }
            answer++;
        }
        return -1;
    }
}