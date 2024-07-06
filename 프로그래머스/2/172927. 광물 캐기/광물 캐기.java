import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int length=minerals.length;

        boolean check =true;
        
        int[] min=new int[length];
        for(int q=0;q<length;q++)
        {
            int w=0;
            if(minerals[q].equals("diamond"))
                w=25;
            else if(minerals[q].equals("iron"))
                w=5;
            else if(minerals[q].equals("stone"))
                w=1;
            min[q]=w;
        }
        
        int piknum=(length+4)/5;
        
        int[][] min2=new int[piknum][2];
        for(int q=0;q<piknum;q++)
        {
            int n=q*5;
            int sum=0;
            for(int w=0;w<5;w++)
            {
                if(n+w<length)
                    sum+=min[n+w];
            }
            min2[q][0]=sum;
            min2[q][1]=q;
        }
        
        //곡갱이 개수가 적을경우 맨 마지막 광물 계산에서 제외
        int checknum=0;
        for(int q=0;q<3;q++)
            checknum+=picks[q];
        
        if(checknum<piknum)
            min2[piknum-1][0]=0;
        
        Arrays.sort(min2,(a,b)->(b[0]-a[0]));
        
        for(int q=0;q<piknum;q++)
        {
            int n=min2[q][1];
            n*=5;
            int pick=0;
            if(picks[0]>0)
            {
                pick=1;
                picks[0]-=1;
            }
            else if(picks[1]>0)
            {
                pick=2;
                picks[1]-=1;
            }
            else if(picks[2]>0)
            {
                pick=3;
                picks[2]-=1;
            }
            else
                break;
            
            for(int w=n;w<n+5;w++)
            {
                if(w<length)
                {
                    if(pick==1)
                    {
                        answer++;
                    }
                    else if(pick==2)
                    {
                        if(minerals[w].equals("diamond"))
                            answer+=5;
                        else
                            answer++;
                    }
                    else if(pick==3)
                    {
                        if(minerals[w].equals("diamond"))
                            answer+=25;
                        else if(minerals[w].equals("iron"))
                            answer+=5;
                        else
                            answer++;
                    }
                }
            }
        }
        return answer;
    }
}