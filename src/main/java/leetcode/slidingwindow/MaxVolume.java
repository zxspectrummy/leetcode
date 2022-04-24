package leetcode.slidingwindow;

public class MaxVolume {
    public int maxArea(int[] height) {
        int n= height.length;
        int ans= 0;
        int start=0, end=n-1;

        while(start<end){
            int area= Math.min(height[start], height[end]) * (end-start);
            ans = Math.max(ans, area);

            if(height[start] > height[end])
                end--;
            else
                start++;
        }

        return ans;
}

    public void run() {
        /*
        i:0 j:6
        i:1 j:6
        i:1 j:5

        * */
        int[] heights = new int[]{1, 3, 2, 5, 25, 24, 5};
        //int[] heights = new int[] {1,2,4,3};
        System.out.println(maxArea(heights));
    }

    public static void main(String[] args) {
        new MaxVolume().run();
    }
}
