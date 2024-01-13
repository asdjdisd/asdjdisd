import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum=brown+yellow;
        int[] answer=new int[2];
        for(int q=3;q<brown;q++)
            for(int w=3;w<brown;w++)
                if(sum==q*w)
                    if(brown==(q*2+w*2)-4)
                    {
                        answer[0]=q;
                        answer[1]=w;
                    }
        return answer;
    }
}