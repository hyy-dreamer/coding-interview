import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {
    public int largestRectangleArea(int[] heights)
    {
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i ++)
        {
            int curr = i == len ? 0 : heights[i];
            if(st.isEmpty() || heights[st.peek()] <= curr)
            {
                st.add(i);
            }
            else
            {
                int tmp = st.pop();
                maxArea = Math.max(maxArea, heights[tmp] * (st.isEmpty() ? i : i - 1 - st.peek()));
                i -= 1;
            }
        }
        return maxArea;
    }
}
// we can maintain an increasing stack
// 1 2 3 1