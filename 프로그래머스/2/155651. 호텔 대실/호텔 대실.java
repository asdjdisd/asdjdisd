import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time=new int [book_time.length][2];
        for(int q=0;q<book_time.length;q++)
        {
            for(int w=0;w<2;w++)
            {
                String a[]=book_time[q][w].split(":");
                int h=Integer.parseInt(a[0]);
                int m=Integer.parseInt(a[1]);
                time[q][w]=h*60+m;
            }
        } 
        Arrays.sort(time, (a, b) -> (a[0] - b[0]));
        
        for(int q=0;q<time.length;q++)
            time[q][1]+=10;
        
        
        for(int q=time[0][0];q<=1450;q++)
        {
            int sum=0;
            for(int w=0;w<time.length;w++)
            {
                if(time[w][0]<=q&&time[w][1]>q)
                    sum++;
            }
            answer=Math.max(answer,sum);
        }
        return answer;
    }
}