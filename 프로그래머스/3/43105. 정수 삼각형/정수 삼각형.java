import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int num=triangle.length;
        int[][] a=new int[num][];
        for(int q=0;q<num;q++)
        {
            a[q]=triangle[q].clone();
        }

        for(int q=num-1;q>0;q--)
        {
            for(int w=0;w<q;w++)
            {
                a[q-1][w]+=a[q][w]>a[q][w+1]?a[q][w]:a[q][w+1];
            }
        }
        return a[0][0];
    }
}