package ArraysAndHashing;

import java.util.Arrays;

public class TwoSum {

    void main(){
        int[] nums = {3,4,5,6};
        int target = 7;
        int[] result = twoSum(nums, target);
        //System.out.println(result[0] + " " + result[1]);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        int[] twoSumsToReturn = new int[2];

        for (int i = 0 ; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){ //version opti => j = i +1 et donc if i!=j pas nécéssaire
                if(i != j){
                    if(target - nums[j] == nums[i]) {
                        twoSumsToReturn[0] = i;
                        twoSumsToReturn[1] = j;
                        return twoSumsToReturn;
                    }
                }
            }
        }

        return twoSumsToReturn;
    }

}
