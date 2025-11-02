package ArraysAndHashing;

import java.util.*;

public class MostKFrequentElements {

    void main(){
        int[] nums = {1,2,2,2,3,3,3,3,3,4};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] mostKFrequent = new int[k]; //tab a retourner avec K valeurs

        //tab ou l'index == le nbre d'occurences d'un nombre (on skip le 0, on pourrait ne pas faire +1 pour la taille tab)
        //et la valeur == liste des nombres qui ont X occurences (X étant l'index)
        //ex: 5 ainsi que 2 apparaissent 3 fois dans nums => a l'index 3 on retrouvera [2, 5]
        ArrayList<List<Integer>> arrayCountFrequenciesList = new ArrayList<>(nums.length + 1); //plus facile a gérer que tab 2d

        HashMap<Integer, Integer> mapFrequencies = new HashMap<>(); // numero, nbOccurences

        for (Integer numero: nums){ // remplit la map de frequences
            mapFrequencies.put(numero, mapFrequencies.getOrDefault(numero, 0) + 1);
        }

        //ajout des arraylists dans l'arraylist => contenir plusieurs nombres pour 1 case comme 1 case == nb elmements qui apparaissent n fois
        for (int i = 0; i <= nums.length; i++) {
            arrayCountFrequenciesList.add(new ArrayList<>());
        }

        //iterer sur la map frequences et ajouter dans la liste du tab correspondant
        for (Map.Entry<Integer, Integer> entry : mapFrequencies.entrySet()){
            arrayCountFrequenciesList.get(entry.getValue()).add(entry.getKey()); //ajoute l'element
        }

        //iteration a l'envers du tableau pour recuperer les K valeurs les plus frequentes
        int foundMostKFrequent = 0;
        for (int i = arrayCountFrequenciesList.size()-1; i >= 0; i--){
            for (Integer currentNumberFromList: arrayCountFrequenciesList.get(i)){
                mostKFrequent[foundMostKFrequent++] = currentNumberFromList; //assigne current number a mostKFreq[0] et ensuite incrémente foundmostK
                if(foundMostKFrequent == k)
                    return mostKFrequent;
            }
        }

        return mostKFrequent;
    }
}
