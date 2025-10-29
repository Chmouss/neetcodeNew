package ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {

    void main() {

        int[] inputNums = {1,2,3,3};
        int[] inputNums2 = {1,2,3,4};

        System.out.println(hasDuplicate(inputNums));
        System.out.println(hasDuplicate(inputNums2));

    }

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> setExistingNumbers = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if(!setExistingNumbers.add(nums[i]))
                return true;
        }

        return false;

    }
}
