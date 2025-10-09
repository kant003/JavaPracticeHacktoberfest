import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem number 1, Two Sum.
 * <p>
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */
public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> d = new HashMap<>();
    int l = nums.length;
    int[] res = new int[2];
    for (int i = 0; i < l; i++) {
      int e = target - nums[i];
      if (d.containsKey(e)) {
        res[0] = d.get(e);
        res[1] = i;
        break;
      }
      d.put(nums[i], i);
    }
    return res;
  }

  public static void main(String[] args) {
    // runtime 2ms, beats 98.94%
    final var result = TwoSum.twoSum(new int[] { 3, 2, 4 }, 6);
    assertThis(result.length == 2);
    assertThis(result[0] == 1);
    assertThis(result[1] == 2);
  }

  private static void assertThis(boolean condition) {
    if (!condition) {
      throw new AssertionError();
    }
  }
}
