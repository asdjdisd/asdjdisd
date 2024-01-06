class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        String a[]=new String[gifts.length];
        int an[]=new int[friends.length];
        String b[]=new String[gifts.length];
        int bn[]=new int[friends.length];
        int cn[]=new int[friends.length];
        int[][] g=new int [friends.length][friends.length];
        for(int q=0;q<friends.length;q++)
        {
            for(int w=0;w<friends.length;w++)
                g[q][w]=0;
        }
        for(int q=0;q<gifts.length;q++)
        {
            String c[]=gifts[q].split(" ");
            a[q]=c[0];
            b[q]=c[1];
            int x=0;
            int y=0;
            for(int w=0;w<friends.length;w++)
            {
                
                if(a[q].equals(friends[w]))
                {
                    an[w]++;
                    x=w;
                }
                if(b[q].equals(friends[w]))
                {
                    bn[w]++;
                    y=w;
                }
            }
            g[x][y]++;
        }
        for(int q=0;q<friends.length;q++)
        {
            cn[q]=an[q]-bn[q];
        }
        for(int q=0;q<friends.length;q++)
        {
            int sum=0;
            for(int w=0;w<friends.length;w++)
            {
                if(q==w)
                    continue;
                if(g[q][w]==g[w][q])
                    sum=(cn[q]>cn[w])?sum+1:sum;
                if(g[q][w]>g[w][q])
                    sum++;
            }
            answer=Math.max(answer,sum);
        }
        return answer;
    }
}