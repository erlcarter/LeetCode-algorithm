/**
 * 724.Find the central index of an array
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例1：
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例2：
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 * 说明：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class Ftcioaa724 {
    public static void main(String[] args) {
        int nums[] = {1,-1,1,1};
        int result = new Solution1().pivotIndex(nums);
        System.out.println(result);
    }
}

/**
 * 解题思路——前缀和
 * 思路：
 * 因为，中心索引左边的元素和 leftSum 等于中心索引右边的元素和 rightSum。
 * 所以，leftSum + leftSum + nums[i] = Sum (所有元素的和)。
 * 我们把 i 看作自变量，把 leftSum 看作因变量，可以得到方程：2 * leftSum = Sum - nums[i];
 * 当 i 为中心索引时，此方程成立。
 * 所以我们遍历 i ，当方程成立时 i 就是中心索引。
 *
 * 作者：lxiaocode
 * 链接：https://leetcode-cn.com/problems/find-pivot-index/solution/java-shu-xue-tui-dao-by-lxiaocode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 复杂度分析
 * 时间复杂度：O(N)，其中 N 是 nums 的长度。
 * 空间复杂度：O(1)，使用了 length,sum,leftsum 。
 *
 */
class Solution1 {
    public int pivotIndex(int[] nums) {
        int length=nums.length,leftsum=0,sum=0;
        //数组为空返回-1
        if(length == 0)
            return -1;
        //计算元素总和
        for (int j=0;j<length;j++)
            sum += nums[j];
        //计算自变量i
        for (int i=0;i<length;i++){
            if (2*leftsum == sum-nums[i]) return i;
            leftsum+=nums[i];
        }

        return -1;
    }
}
