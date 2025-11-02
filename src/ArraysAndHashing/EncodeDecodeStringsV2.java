package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStringsV2 {

    void main(){
        List<String> listOfStrings = List.of("neet", "code", "love", "you");
        System.out.println("défault list = " + listOfStrings);
        String listEncoded = encode(listOfStrings);
        System.out.println("encoded list = " + listEncoded);
        List<String> decodedList = decode(listEncoded);
        System.out.println("défault list = " + decodedList);
    }

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        //the idea here is to create a "code" that is the length of each word plus a special char to delimit and know the size of each word
        for (String string: strs){
            int size = string.length(); //gets the size of the string so we can add that BEFORE each string to know the size of each word
            sb.append(size);
            sb.append("#"); //special caracter added to delimit the size (ex if we have a word that is 12 chars long, we don't read "1" and then get an issue
            sb.append(string);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> listOfStringsToReturn = new ArrayList<>();
        char[] charArrayStringToDecode = str.toCharArray();

        // size here for easy reset and not resetting the variable on each loop
        // as a string because we are using chars so we don't mess up if it would be a number with multiple digits
        String sizeOfCurrentString = "";
        for (int i = 0; i < charArrayStringToDecode.length; i++){ //itere sur tout le tab de chars

            if(charArrayStringToDecode[i] != '#'){ // si pas #, on est encore dans le nombre de la taille du mot
                sizeOfCurrentString += charArrayStringToDecode[i];
            } else {
                int size = Integer.parseInt(sizeOfCurrentString); //recup taille en int
                StringBuilder sb = new StringBuilder();
                for (int j = i + 1; j <= i + size; j++) { //double indice pour recup le mot
                    sb.append(charArrayStringToDecode[j]);
                }
                listOfStringsToReturn.add(sb.toString());
                i = i + size; //on fait jump le i, sinon on risque de tomber sur un autre # et ça va poser probleme
                sizeOfCurrentString = ""; //reset taille important !
            }
        }

        return listOfStringsToReturn;
    }

}
