package agoda;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);

        return result;
    }

    public void generateSubsets(int index, int[] nums, List<Integer> currentList,
                                List<List<Integer>> result) {
        result.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            generateSubsets(index + 1, nums, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
