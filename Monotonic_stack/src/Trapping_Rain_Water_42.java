public class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftHigh = new int[len];
        int[] rightHigh = new int[len];
        leftHigh[0] = 0;
        rightHigh[len - 1] = 0;
        int sum = 0;
        for(int i = 1; i < len; i ++)
        {
            leftHigh[i] = Math.max(height[i - 1], leftHigh[i - 1]);
        }
        for(int i = len - 2; i >= 0; i --)
        {
            rightHigh[i] = Math.max(height[i + 1], rightHigh[i + 1]);
        }

        for(int i = 0; i < len; i ++)
        {
            int vol = Math.min(leftHigh[i], rightHigh[i]) - height[i];
            if(vol > 0) sum += vol;
        }
        return sum;
    }
}
