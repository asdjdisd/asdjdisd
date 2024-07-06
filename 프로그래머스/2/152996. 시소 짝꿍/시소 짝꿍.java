import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] l=new int[1001];
        for(int q=0;q<weights.length;q++)
            l[weights[q]]++;
        for(int q=100;q<1001;q++)
        {
            if(l[q]>0)
            {
                if(l[q]>1)
                    answer+=(long)l[q]*(l[q]-1)/2;
                
                if(q*2<1001&&l[q*2]>0)
                    answer+=(long)l[q]*l[q*2];
                
                if(q%2==0&&q*3/2<1001&&l[q*3/2]>0)
                    answer+=(long)l[q]*l[q*3/2];
                
                if(q%3==0&&q*4/3<1001&&l[q*4/3]>0)
                    answer+=(long)l[q]*l[q*4/3];
            }
        }
        return answer;
    }
}