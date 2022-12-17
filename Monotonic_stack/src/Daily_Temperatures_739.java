import java.util.Stack;

public class Daily_Temperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[len];
        for(int i = 0; i < len; i ++) {
            int curr = temperatures[i];
            while(!st.isEmpty() && curr > temperatures[st.peek()])
            {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.add(i);
        }
        return ans;
    }
}
