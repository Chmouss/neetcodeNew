package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContainsAnagramV2 {

    void main(){
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mapFrequenceListeMots = new HashMap<>(); //mot courant et liste mots ?

        for (String string: strs){
            int[] nbOccurencesLettres = new int [26]; //a = 0, z = 25
            for (char character : string.toCharArray()){
                nbOccurencesLettres[character - 'a']++; //incrémentation a l'index de la lettre (character - a car a = 0 donc décalage si on ne "soustrait" pas)
            }

            String key = Arrays.toString(nbOccurencesLettres);
            mapFrequenceListeMots.putIfAbsent(key, new ArrayList<>());
            mapFrequenceListeMots.get(key).add(string);
        }

        return new ArrayList<>(mapFrequenceListeMots.values());
    }

}
