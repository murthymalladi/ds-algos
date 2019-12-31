package patterns.topk;

import java.util.*;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2) {
//                if (o1.getValue() > o2.getValue()) {
//                    return -1;
//                }
//                else if (o1.getValue() < o2.getValue()) {
//                    return 1;
//                }
//                else {
//                    return o2.getKey() - o1.getKey();
//                }
                return o2.getValue() - o1.getValue();
            }
        });

        maxHeap.addAll(map.entrySet());
        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++)
              result.append(entry.getKey());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
