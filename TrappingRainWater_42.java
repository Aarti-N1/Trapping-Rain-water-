package hard;

public class TrappingRainWater_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trapDynamicProgramming(height));

	}
	public static int trapDynamicProgramming(int[] height) {
		int[]maxLeft = new int[height.length];
		int[]maxRight = new int[height.length];
		for(int i=0;i<height.length;i++) {
			if(i==0) {
				maxLeft[i] = height[i];
			}else {
				maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
			}
		}
		for(int j=height.length-1; j>=0;j--) {
			if(j== height.length-1) {
				maxRight[j] = height[j];
			}else {
				maxRight[j] = Math.max(maxRight[j+1], height[j]);
			}
		}
		int ans=0;
		for(int i =0;i<height.length;i++) {
			ans = ans + Math.min(maxLeft[i], maxRight[i]) - height[i];
		}
		return ans;
	}
	
	public static int trapTwoPointer(int[] height) {
		int ans = 0, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
		int leftPointer = 0, rightPointer = height.length - 1;
		while (leftPointer < rightPointer) {
			if (height[leftPointer] < height[rightPointer]) { //Water bounded by left wall hence update left
				if (height[leftPointer] >= leftMax) {
					leftMax = height[leftPointer];
				} else {
					ans = ans + (leftMax - height[leftPointer]);
				}
				leftPointer++;
			} else {										//Water bounded by right wall hence update right
				if (height[rightPointer] >= rightMax) {
					rightMax = height[rightPointer];
				} else {
					ans = ans + (rightMax - height[rightPointer]);
				}
				rightPointer--;
			}
		}
		return ans;

	}
}
