import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        for(long q=left,num=0;q<=right;q++,num++)
        {
            int a=(int)(q/n);
            int b=(int)(q%n);
            answer[(int)num]=Math.max(a,b)+1;
        }
        return answer;
    }
}