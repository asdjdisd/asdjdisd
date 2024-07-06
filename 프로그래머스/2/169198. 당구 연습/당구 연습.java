import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int length=balls.length;
        int[] answer = new int[length];
        for(int q=0;q<length;q++)
        {
            int bx=balls[q][0];
            int by=balls[q][1];
            int check=Integer.MAX_VALUE;
            if(!(startY==by&&startX>bx))
            {
                int left = -bx;
                int leftdis=(startX-left)*(startX-left)+(startY-by)*(startY-by);
                check=Math.min(check,leftdis);
            }
            if(!(startY==by&&startX<bx))
            {
                int right = 2*m-bx;
                int rightdis=(startX-right)*(startX-right)+(startY-by)*(startY-by);
                check=Math.min(check,rightdis);
            }
            if(!(startX==bx&&startY<by))
            {
                int up = 2*n-by;
                int updis=(startX-bx)*(startX-bx)+(startY-up)*(startY-up);
                check=Math.min(check,updis);
            }
            if(!(startX==bx&&startY>by))
            {
                int down = -by;
                int downdis=(startX-bx)*(startX-bx)+(startY-down)*(startY-down);
                check=Math.min(check,downdis);
            }
            answer[q]=check;
        }
        return answer;
    }
}