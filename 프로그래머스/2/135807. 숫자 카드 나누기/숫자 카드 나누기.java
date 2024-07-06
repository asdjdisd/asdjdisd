import java.util.*;
class Solution {
    public int gcd(int a,int b)//최대공약수
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> list=new ArrayList<>();
        int checkA=0;
        int checkB=0;
        //1
        int check=arrayA[0];
        for(int q=1;q<arrayA.length;q++)
        {
            check=gcd(check,arrayA[q]);
            if(check==1)
                break;
        }
        
        for(int q=2;q<Math.sqrt(check);q++)
        {
            if(check%q==0)
                list.add(q);
        }
        list.add(check);
        
        Collections.sort(list,Collections.reverseOrder());
        for(int q=0;q<list.size();q++)
        {
            int num=0;
            for(int w=0;w<arrayB.length;w++)
            {
                if(arrayB[w]%list.get(q)==0)
                    break;
                else
                    num++;
            }
            if(num==arrayB.length)
            {
                checkA=check;
                break;
            }
                
        }
        list.clear();
        
        
        //2
        check=arrayB[0];
        for(int q=1;q<arrayB.length;q++)
        {
            check=gcd(check,arrayB[q]);
            if(check==1)
                break;
        }
        
        for(int q=2;q<Math.sqrt(check);q++)
        {
            if(check%q==0)
                list.add(q);
        }
        list.add(check);
        
        Collections.sort(list,Collections.reverseOrder());
        for(int q=0;q<list.size();q++)
        {
            int num=0;
            for(int w=0;w<arrayA.length;w++)
            {
                if(arrayA[w]%list.get(q)==0)
                    break;
                else
                    num++;
            }
            if(num==arrayA.length)
            {
                checkB=check;
                break;
            }
        }
        return Math.max(checkA,checkB);
    }
}