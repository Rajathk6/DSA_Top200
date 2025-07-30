public class HundredFiftyNine {
    public static void main(String[] args) {
        // Problem 159: Trapping Rain Water
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); 
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
 
        while (left < right) {
            if (height[left] < height[right]) { // left bar is shorter than right so left holds water
                if (height[left] >= leftMax) { // if the current left bar is higher than all the previous bar then it cannot hold any water so we update it to the current bar height
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left]; // if none of that is true then we subtract the max Left Bar we have found till now with the current height
                }
                left++;
            } else { // right bar is shorter than left so right holds the water
                if (height[right] >= rightMax) {  // if the current right bar is the heightest of all the previous bars then we update the maxbar to the current bar
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
            right--;
        }
        return water;
    }
}


// You find a pit because either left has a greater wall or the right as a greater wall and then we see the difference between what the max of left or right wall is and subtract with the current height