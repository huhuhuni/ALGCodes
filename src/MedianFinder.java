import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minhp;
    PriorityQueue<Integer> maxhp;
    public MedianFinder() {
        minhp = new PriorityQueue<>((a,b)->b-a);
        maxhp = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxhp.size() == minhp.size()){
            if (maxhp.isEmpty() || num <= maxhp.peek()) minhp.offer(num);
            else {
                minhp.offer(maxhp.poll());
                maxhp.offer(num);
            }
        }else {
            if (num >= minhp.peek()) maxhp.offer(num);
            else {
                maxhp.offer(minhp.poll());
                minhp.offer(num);
            }
        }
    }

    public double findMedian() {
        if (maxhp.size() + minhp.size() == 0) return 0;
        if (maxhp.size() == minhp.size()){
            return ((double)minhp.peek() + (double)maxhp.peek())/2;
        }else {
            return (double)minhp.peek();
        }
    }
}
