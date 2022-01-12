public class 整数除法 {
    int divide(int a,int b){
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        if (a == Integer.MIN_VALUE && b == 1) return  Integer.MIN_VALUE;
        long x = (long)a;
        long y = (long)b;
        boolean flag = (a > 0) ^(b > 0);
        x = Math.abs(x);
        y = Math.abs(y);
        int n = 0;
        for (int i = 31; i >= 0; i--){
            if ((x >> i) >= y){
                x -= y << i;
                n += 1 << i;
            }

        }
        return flag ? -n : n;
    }
}
