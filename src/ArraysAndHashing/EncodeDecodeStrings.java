package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeStrings {

    void main(){
        List<String> strs = List.of("neet","code","love","you");
        System.out.println("avant encode = " + strs);
        System.out.println("apres encode = ");
        System.out.println(encode(strs));
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String string: strs){
            sb.append(string);
            sb.append(" ");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> listOfStrings = new ArrayList<>();
        char[] charArray = str.toCharArray();

        for (char character: charArray){
            //not done but check V2
        }

        return listOfStrings;
    }

}
