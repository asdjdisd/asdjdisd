import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {

        int q=0;
        int num=t*m+p;
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        
        while(a.length()<=num)
        {
            a.append(Integer.toString(q,n));
            q++;
        }

        for(int w=0;w<t;w++)
        {
            b.append(a.charAt(p-1));
            p+=m;
        }
        return b.toString().toUpperCase();
    }
}