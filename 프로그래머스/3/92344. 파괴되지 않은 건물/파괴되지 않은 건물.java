import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int check=0;
        int[][] num=new int[board.length+1][board[0].length+1];
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
            //누적합 (x1, y1) ~ (x2, y2)까지에 n만큼의 변화를 주고 싶다면,
            //(x1, y1) = n, (x2+1, y1) = -n, (x1, y2+1) = -n, (x2+1, y2+1) = n 만큼의 값을 더해줌
            num[a][b]+=check*skill[q][5];
            num[c][b]+=check*skill[q][5]*-1;
            num[a][d]+=check*skill[q][5]*-1;
            num[c][d]+=check*skill[q][5];
        }
        
        for(int q=0;q<num.length;q++)//가로 누적합
            for(int w=1;w<num[0].length;w++)
                num[q][w]+=num[q][w-1];
        for(int q=1;q<num.length;q++)//세로 누적합
            for(int w=0;w<num[0].length;w++)
                num[q][w]+=num[q-1][w];
        
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