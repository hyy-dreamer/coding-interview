import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[nums1.length];
        for(int num : nums2)
        {
            while(!st.isEmpty() && num > st.peek())
            {
                mp.put(st.pop(), num);
            }
            st.add(num);
        }

        for(int i = 0; i < nums1.length; i ++)
        {
            ans[i] = mp.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
//maintain a decreasing stack
//most important thing to notice is that the value is unique