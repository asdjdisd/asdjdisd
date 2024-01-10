import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int q=0;q<r2;q++)
        {
            double a=Math.pow(q,2);
            int max=(int)Math.sqrt(Math.pow(r2,2)-a);
            int min=(int)Math.ceil(Math.sqrt(Math.pow(r1,2)-a));
            if(min<1)
                min=1;
            answer+=max-min+1;
        }
        return answer*4;
    }
}