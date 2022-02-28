public class 两个背包 {
    static int n = 4;
    static int[] v={6,5,5,4,3};
    static int[] w={1,1,1,1,1};
    public static void main(String[] args){
        int AV = 8;
        int BV = 9;
        System.out.println(get(1,AV,BV));
    }
    public static int get(int i,int AV, int BV){
        if(i==n)if(AV>=v[n]||BV>=v[n])return w[n];
        else return 0;
            int res = 0;
            if(v[i]<=AV) res = Math.max(get(i+1,AV-v[i],BV)+w[i],res);
            if(v[i]<=BV) res = Math.max(get(i+1,0,BV-v[i])+w[i],res);
            res = Math.max(get(i+1,AV,BV),res);
            return res;
        }

}
