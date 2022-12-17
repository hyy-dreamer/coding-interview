import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] newNum = new int[nums.length * 2];
        int[] ans = new int[nums.length * 2];
        Arrays.fill(ans, -1);
        for(int i = 0; i < nums.length; i ++)
        {
            newNum[i] = nums[i];
        }
        for(int i = nums.length; i < nums.length * 2; i ++)
        {
            newNum[i] = nums[i - nums.length];
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < newNum.length; i ++)
        {
            int curr = newNum[i];
            while(!st.isEmpty() && curr > newNum[st.peek()])
            {
                ans[st.pop()] = curr;
            }
            st.add(i);
        }
        int[] res = new int[ans.length / 2];
        for(int i = 0; i < ans.length / 2; i ++)
        {
            res[i] = ans[i];
        }
        return res;
    }
}

// the element is not unique, try use index not value