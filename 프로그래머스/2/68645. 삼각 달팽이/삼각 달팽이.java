class Solution {
    int num=1;
    int max;
    int m;
    void rs(int[][] a,int q,int w,int e)
    {
        if(e==1)
        {
            while(true)
            {
                a[q][w]=num++;
                if(num>max)
                    break;
                if(q+1>=m||a[q+1][w]!=0)
                    rs(a,q,++w,2);
                q++;
                if(num>max)
                    break;
            }
        }
        if(e==2)
        {
            while(true)
            {
                a[q][w]=num++;
                if(num>max)
                    break;
                if(w+1>=m||a[q][w+1]!=0)
                    rs(a,--q,--w,3);
                w++;
                if(num>max)
                    break;
            }
        }
        if(e==3)
        {
            while(true)
            {
                a[q][w]=num++;
                if(num>max)
                    break;
                if(a[q-1][w-1]!=0)
                    rs(a,++q,w,1);
                w--; q--;
                if(num>max)
                    break;
            }
        }
    }
    public int[] solution(int n) {
        m=n;
        max=n*(n+1)/2;
        int e=0;
        int[][] a=new int[n][n];
        int[] answer = new int[max];
        
        for(int q=0;q<n;q++)
            for(int w=0;w<n;w++)
                a[q][w]=0;
        
        rs(a,0,0,1);
        
        for(int q=0;q<n;q++)
            for(int w=0;w<q+1;w++)
                answer[e++]=a[q][w];
    
        return answer;
    }
}