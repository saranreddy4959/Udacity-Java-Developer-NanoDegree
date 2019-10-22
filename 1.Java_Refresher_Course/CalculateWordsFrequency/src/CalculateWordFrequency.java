import java.util.*;

public class CalculateWordFrequency {

    public static void wordFrequency (List<String> input){

        Map<String, Integer> m = new HashMap<>();
        int value =1;
        for (String i : input){
            if(m.containsKey(i) == false){

                m.put(i,value);
            }
            else{
                m.put(i,value+1);
            }
        }
       for(String w : m.keySet()){
           System.out.println(w +" | "+ m.get(w));
       }
    }

    public static void main(String[] args){
        List<String> l = Arrays.asList("abc","bcd","abc");
        wordFrequency(l);

    }
}
