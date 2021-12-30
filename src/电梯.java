import java.util.ArrayList;
import java.util.List;
//现在有一部电梯，在某一楼层N，你只可以乘坐这个电梯向上或者向下K层（K是N的所有因子），
// 给定当前楼层和目标楼层，求最少需要乘坐多少次电梯从当前楼层到达目标楼层。
public class 电梯 {
    int min = 0;
    public int lift(int N,int start,int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++){
            if (N%i == 0) list.add(i);
        }
        min = Math.abs(start - target);
        dfs(N,list,start,target,1);
        return min;
    }
    void dfs(int N,List<Integer> list,int start,int target,int count){
        if (count >= min) return;
        for(Integer i : list){
            if (start + i == target || start - i == target) min = count;
            else if (start + i <= N) {
                dfs(N,list,start+i,target,count+1);
            }else if (start - i >0) {
                dfs(N,list,start-i,target,count+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 电梯().lift(8888,1,7777));
    }
}
