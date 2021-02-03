package movi.service;

import java.util.List;

public class commons {
    public static int FindMaximumInList(List<Integer> integerList){
        int maxFrequencyId=-1;
        int maxFrequency=-1;
        for(int i=0;i<integerList.size();i++){
            //   System.out.println(integerList.get(i));
            if(maxFrequency<integerList.get(i)){
                maxFrequency=integerList.get(i);
                maxFrequencyId=i;
            }
        }
        return maxFrequencyId;
    }

}
