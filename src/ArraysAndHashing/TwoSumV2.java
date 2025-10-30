package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumV2 {

    void main(){
        int[] nums = {3,4,5,6};
        int target = 7;
        int[] result = twoSum(nums, target);
        //System.out.println(result[0] + " " + result[1]);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        //version "hashmap" two passes

        HashMap<Integer, Integer> mapIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) { // fill the map
            mapIndices.put(nums[i], i); //NUMBER, INDEX ! (easier for map.get)
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(mapIndices.containsKey(diff) && mapIndices.get(diff) != i){
                return new int[] {i, mapIndices.get(diff)};
            }
        }
        return new int [0];
    }

}
