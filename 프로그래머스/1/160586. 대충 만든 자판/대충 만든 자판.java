import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int count=0;
        int check=101;
        for(int q=0;q<targets.length;q++)
        {
            count=0;
            for(int w=0;w<targets[q].length();w++)
            {
                check=101;
                for(int e=0;e<keymap.length;e++)
                {
                    for(int r=0;r<keymap[e].length();r++)
                    {
                        if(targets[q].charAt(w)==keymap[e].charAt(r))
                        {
                            check=Math.min(check,r+1);
                            break;
                        }
                    }
                }
                /*if(check==101)
                {
                    int[] ans={-1};
                    return ans;
                }  */
                if(check==101)
                {
                    count=-1;
                    break;
                }
                count+=check; 
            }
            answer[q]=count;
        }
        return answer;
    }
}