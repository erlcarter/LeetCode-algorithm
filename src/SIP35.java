/**
 * 35. Search Insert Position
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例1：
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例2：
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例3：
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例4：
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SIP35 {

    public static void main(String[] args) {
        int result;
        int[] n = {1,3,5,6};
        int[] target = {5,2,7,0,4,1};
        for (int i=0;i<target.length;i++){
            result = new SIP35().searchInsert(n,target[i]);
            System.out.println(result);
        }
    }

    /**
     * 解题思路 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length,i,j;
        boolean flag = target>nums[(length-1)/2]?true:false;
        if (length == 0 || nums[0]<0)
            return -1;
        if (flag){
            for (i=length/2;i<length;i++){
                if (target == nums[i] || target<nums[i])
                    return i;
            }
           //遍历结束后索引更新到下一位置
            return length;
        }else{
            for (j=0;j<length/2;j++){
                if (target == nums[j] || target<nums[j])
                    return j;
            }
            //遍历结束后索引更新到下一位置
            return length/2+1;
        }
    }

}
