import java.util.Stack;

public class Online_Stock_Span_901 {
    Stack<int[]> st;
    int index = 1;
    public Online_Stock_Span_901() {
        st = new Stack<>();
    }

    public int next(int price) {
        while(!st.isEmpty() && price >= st.peek()[1])
        {
            st.pop();
        }
        int tmp = st.isEmpty() ? index : index - st.peek()[0];
        st.add(new int[]{index, price});
        index ++;
        return tmp;
    }
}
//similar to daily temperatures, we need to store the index and the value