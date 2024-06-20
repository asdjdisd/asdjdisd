import java.util.*;
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> l =new ArrayList<>();
        String check[]={"code", "date", "maximum", "remain"};
        int under=-1,sor=-1;

        for(int q=0;q<4;q++)
        {
            if(ext.equals(check[q]))
                under=q;
            if(sort_by.equals(check[q]))
                sor=q;
        }
        
        for(int q=0;q<data.length;q++)
        {
            if(data[q][under]<val_ext)
                l.add(data[q]);
        }
        
        final int sorq=sor;
        
        Collections.sort(l, (a, b) -> a[sorq] - b[sorq]);
        
        return l;
    }
}