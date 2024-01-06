import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> (a[1] - b[1]));
        int end=targets[0][1];
        for(int q=0;q<targets.length;q++)
        { 
            int s=targets[q][0];
            int e=targets[q][1];
            if(end<=s){
                answer++;
                end=e;
            }
        }
        answer++;
        return answer;
    }
}