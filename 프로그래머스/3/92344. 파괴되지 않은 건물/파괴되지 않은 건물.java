import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int check=0;
        int[][] num=new int[board.length][board[0].length];
        for(int q=0;q<skill.length;q++)
        {
            if(skill[q][0]==1)
                check=-1;
            else
                check=1;
            int a=skill[q][1];
            int b=skill[q][2];
            int c=skill[q][3]+1;
            int d=skill[q][4]+1;
            
            num[a][b]+=check*skill[q][5];
            if(c<board.length)
                num[c][b]+=check*skill[q][5]*-1;
            if(d<board[0].length)
                num[a][d]+=check*skill[q][5]*-1;
            if(c<board.length&&d<board[0].length)
                num[c][d]+=check*skill[q][5];
        }
        for(int q=0;q<num.length;q++)
        {
            for(int w=1;w<num[0].length;w++)
            {
                num[q][w]+=num[q][w-1];
            }
        }
        for(int q=1;q<num.length;q++)
        {
            for(int w=0;w<num[0].length;w++)
            {
                num[q][w]+=num[q-1][w];
            }
        }
        
        for(int q=0;q<board.length;q++)
        {
            for(int w=0;w<board[0].length;w++)
            {
                board[q][w]+=num[q][w];
                if (board[q][w]>0)
                    answer++;
            }
        }
        return answer;
    }
}