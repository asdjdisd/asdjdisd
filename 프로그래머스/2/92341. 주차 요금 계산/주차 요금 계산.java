import java.util.*;
class Solution {
    List<Integer> l=new ArrayList<>();
    List<Integer> time=new ArrayList<>();
    
    void timec(int[] f){
        double sum=0;
        int total=0;
        if(time.size()%2==1)
            time.add(1439);
        int q=time.size()-1;
        while(q>0)
        {
            sum+=time.get(q)-time.get(q-1);
            q-=2;
        }
        
        if(sum<=f[0])
            total=f[1];
        else
        {
            sum-=f[0];
            total=f[1]+(int)Math.ceil(sum/f[2])*f[3];
        }
        l.add(total);
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        String r[][]=new String[records.length][];
        for(int q=0;q<records.length;q++)
            r[q]=records[q].split(" ");
        Arrays.sort(r,(a,b)->(Integer.parseInt(a[1])-(Integer.parseInt(b[1]))));
        
        int at[]=new int[r.length];
        String a[]=r[0][0].split(":");
        time.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
        String b=r[0][1];
        if(r.length==1)
        {
            timec(fees);
        }
        else{
        for(int q=1;q<r.length;q++)
        {
            if(q==r.length-1&&b.equals(r[q][1]))
            {
                a=r[q][0].split(":");
                time.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
                timec(fees);
            }
            else if(q==r.length-1)
            {
                timec(fees);
                time.clear();
                a=r[q][0].split(":");
                time.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
                timec(fees);
                b=r[q][1];
            }
            else if(b.equals(r[q][1]))
            {
                a=r[q][0].split(":");
                time.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
            }
            else
            {
                timec(fees);
                time.clear();
                a=r[q][0].split(":");
                time.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
                b=r[q][1];
            }
        }
        }
        int answer[]=new int[l.size()];
        for(int q=0;q<l.size();q++)
        {
            answer[q]=l.get(q);
        }
        return answer;
    }
}