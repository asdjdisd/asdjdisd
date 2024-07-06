import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 1;
        double max=Math.pow(d,2);
        long x=0;
        long y=0;
        long q=1;
        while(x<d)
        {
            x+=k;
            if(x>d)
            {
                x-=k;
                break;
            }
            answer++;
        }
        while(x>0)
        {
            y+=k;
            while((x*x)+(y*y)>max)
                x-=k;
            if(x<0||y>d)
                break;
            answer+=x/k+1;
        }
        
        return answer;
    }
}