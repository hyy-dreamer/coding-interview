import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum_239 {
    public int[] maxSlidingWindow(int[] a, int k) {
        if(a == null || k <= 0)
        {
            return new int[0];
        }
        int len = a.length;
        int[] ans = new int[len - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < len; i ++)
        {
            while(!q.isEmpty() && q.peek() < i - k + 1)
            {
                q.poll();
            }
            while(!q.isEmpty() && a[q.peekLast()] < a[i])
            {
                q.pollLast();
            }
            q.add(i);
            if(i >= k - 1)
            {
                ans[index ++] = a[q.peek()];
            }
        }
        return ans;
    }
}
