import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer=0;
        row_begin--;
        row_end--;
        
        Arrays.sort(data,(a,b)->{
            int check=Integer.compare(a[col-1],b[col-1]);
            if(check!=0)
                return check;
            else
                return Integer.compare(b[0],a[0]);
        });
        
        for(int q=row_begin;q<=row_end;q++)
        {
            int num=0;
            for(int w=0;w<data[0].length;w++)
                num+=data[q][w]%(q+1);
            answer^=num;
        }
        return answer;
    }
}