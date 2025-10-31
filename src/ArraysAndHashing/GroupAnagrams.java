package ArraysAndHashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    void main(){
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        //optimiser en utilisant un set ?(hashmap<hashset .... ? ) a voir si possible et si utile

        //List<HashMap<Character, Integer>> listeMapsExistantes = new ArrayList<>();
        //String[] stringsArray;
        HashMap<HashMap<Character, Integer>, List<String>> mapMapsStrings = new HashMap<>(); // string pour garder le mot :)

        for (String string: strs){ //iteration sur toutes les string input
            HashMap<Character, Integer> mapFrequencesCurrentString = new HashMap<>(); // map frequence char, index qui est reset a chaque iteration

            for (int i = 0; i < string.length(); i++){ //replissage de la map frequences
                char currentChar = string.charAt(i);
                mapFrequencesCurrentString.put(currentChar, mapFrequencesCurrentString.getOrDefault((currentChar), 0) + 1);
            }

            if(!mapMapsStrings.containsKey(mapFrequencesCurrentString)){
                //si existe pas, on crée une arraylist pour garder les mots, on ajoute le mot dedans et on met le tout dans la map (mapFrequence, motS)
                List<String> arrayList = new ArrayList<>();
                arrayList.add(string);
                mapMapsStrings.put(mapFrequencesCurrentString, arrayList);
            } else {
                //existe déja, on récupere l'arraylist, on ajoute la string et on remet le tout
                mapMapsStrings.get(mapFrequencesCurrentString).add(string);
                mapMapsStrings.put(mapFrequencesCurrentString, mapMapsStrings.get(mapFrequencesCurrentString));
            }

        }


        List<List<String>> listOfListOfWords = new ArrayList<>();

        ////iteration sur les maps, si map similaire on groupe ensemble dans un subarray
        // On parcourt les valeurs de la map pour ajouter chaque groupe d'anagrammes dans la liste finale
        for (List<String> group : mapMapsStrings.values()) {
            listOfListOfWords.add(group);
        }

        return listOfListOfWords;
    }

}
