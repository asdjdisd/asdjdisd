import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long countd=0;
        long countp=0;
        int dmax=Integer.MIN_VALUE;
        int pmax=Integer.MIN_VALUE;
        for(int q=0;q<n;q++)
        {
            countd+=deliveries[q];
            countp+=pickups[q];
            if(deliveries[q]!=0)
                dmax=q;
            if(pickups[q]!=0)
                pmax=q;
        }

        while(countd>0||countp>0)
        {
            answer+=(Math.max(dmax,pmax)+1)*2;
            for(int q=0;q<cap;q++)
            {
                if(dmax>=0)
                {
                    deliveries[dmax]--;
                    countd--;
                    while(dmax>=0&&deliveries[dmax]==0)
                        dmax--;
                }
                if(pmax>=0)
                {
                    pickups[pmax]--;
                    countp--;
                    while(pmax>=0&&pickups[pmax]==0)
                        pmax--;
                }
            }
            
        }
        return answer;
    }
}