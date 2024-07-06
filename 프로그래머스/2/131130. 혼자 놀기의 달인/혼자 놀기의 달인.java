import java.util.*;
class Solution {
    public int run(int[] cards,int check)
    {
        int a=0;
        while(true)
        {
            if(cards[check]!=0)
            {
                int temp=cards[check];
                cards[check]=0;
                check=temp-1;
                a++;
            }
            else
                return a;
        }
    }
    public int solution(int[] cards) {
        
        int check=0;
        List<Integer> list=new ArrayList<>();

        for(int q=0;q<cards.length;q++)
        {
            if(cards[q]!=0)
            {
                check=q;
                list.add(run(cards,check));
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        int a=0;
        int b=0;
        if(list.size()>0)
            a=list.get(0);
        if(list.size()>1)
            b=list.get(1);
        return a*b;
    }
}