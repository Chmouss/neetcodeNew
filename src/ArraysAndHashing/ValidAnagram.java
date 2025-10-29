package ArraysAndHashing;

import java.util.HashMap;

public class ValidAnagram {

    void main(){
        String s = "racecar";
        String t = "carrace";
        System.out.println(isAnagram(s, t));

        String a = "jar";
        String b = "jam";
        System.out.println(isAnagram(a, b));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapCharOccurencesS = new HashMap<>();
        HashMap<Character, Integer> mapCharOccurencesT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            mapCharOccurencesS.put(s.charAt(i), mapCharOccurencesS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            mapCharOccurencesT.put(t.charAt(i), mapCharOccurencesT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return mapCharOccurencesS.equals(mapCharOccurencesT);
    }

}
