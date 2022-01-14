import java.util.*;

public class 找最大独特和 {
    int findMaxObservableSum(int[] stockPrice,int k){
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int n = stockPrice.length;
        int temp = 0;
        for (int j = 0; j < k; j++){
            if (map.containsKey(stockPrice[j])) {
                map.put(stockPrice[j],map.get(stockPrice[j])+1);
            } else {
                map.put(stockPrice[j],1);
            }
            temp += stockPrice[j];
        }
        if (map.size() == k) max = max > temp ? max : temp;
        //System.out.println(temp);
        for (int i = k; i < n; i++){
            temp -= stockPrice[i-k];
            temp += stockPrice[i];
            if (map.containsKey(stockPrice[i])) {
                map.put(stockPrice[i],map.get(stockPrice[i])+1);
            } else {
                map.put(stockPrice[i],1);
            }
            map.put(stockPrice[i-k],map.get(stockPrice[i-k])-1);
            if (map.get(stockPrice[i-k]) <= 0) map.remove(stockPrice[i-k]);
            if (map.size() == k) max = max > temp ? max : temp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 找最大独特和().findMaxObservableSum(new int[]{1,2,7,7,4,3,6},3));
        
    }
}
