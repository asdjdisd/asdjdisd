import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum=brown+yellow;
        int[] answer=new int[2];
        loop:
        for(int q=3;q<brown;q++)
            for(int w=q;w<brown;w++)
                if(sum==q*w&&brown==(q*2+w*2)-4)
                {
                    answer[0]=w;
                    answer[1]=q;
                    break loop;
                }      
        return answer;
    }
}