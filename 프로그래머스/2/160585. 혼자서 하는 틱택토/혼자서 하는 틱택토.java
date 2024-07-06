import java.util.*;
class Solution {
    public int solution(String[] board) {
        int [][]bo= new int[3][3];
        int onum=0;
        int xnum=0;
        boolean wino=false;
        boolean winx=false;
        for(int q=0;q<3;q++)
        {
            for(int w=0;w<3;w++)
            {
                if(board[q].substring(w,w+1).equals("O"))
                {
                    bo[q][w]=1;
                    onum++;
                }
                else if(board[q].substring(w,w+1).equals("X"))
                {
                    bo[q][w]=-1;
                    xnum++;
                }
                else
                    bo[q][w]=0;
            }
        }
        
        if(1<onum-xnum||0>onum-xnum)
            return 0;
        
        for(int q=0;q<3;q++)
        {
            int checkx=0;
            int checky=0;
            for(int w=0;w<3;w++)
            {
                checkx+=bo[q][w];
                checky+=bo[w][q];
            }
            
            if(checkx==3||checky==3)
            {
                if(winx)
                    return 0;
                wino=true;
            }
            if(checkx==-3||checky==-3)
            {
                if(wino)
                    return 0;
                winx=true;
            }
        }
        
        if(bo[0][0]+bo[1][1]+bo[2][2]==3||bo[2][0]+bo[1][1]+bo[0][2]==3)
            wino=true;
        if(bo[0][0]+bo[1][1]+bo[2][2]==-3||bo[2][0]+bo[1][1]+bo[0][2]==-3)
            winx=true;
        
        if(wino&&onum-xnum!=1)
            return 0;
        if(winx&&onum-xnum!=0)
            return 0;
        
        return 1;
    }
}