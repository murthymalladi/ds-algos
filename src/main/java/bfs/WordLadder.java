//package bfs;
//
//import java.util.*;
//
///**
// * Created by dmalladi on 12/14/2018.
// */
//
//class StringObj {
//    public String orig;
//    public String transformation;
//    public StringObj(String a, String b) {
//        orig = a;
//        transformation = b;
//    }
//}
//public class WordLadder {
//
//    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[]  wordList = {"hot","dot","dog","lot","log","cog"};
//        int len = ladderLength(beginWord,endWord,wordList);
//        System.out.println(len);
//    }
//
//    public static int ladderLength(String beginWord, String endWord, String[] wordList) {
//        HashSet<String> dictionary = new HashSet<String>(Arrays.asList(wordList));
//        HashSet<String> seen = new HashSet<>();
//        Queue<StringObj> queue = new LinkedList<>();
//
//        queue.add(new StringObj(beginWord,beginWord));
//        seen.add(beginWord);
//        int steps = 0;
//        int minSteps = Integer.MAX_VALUE;
//        while(queue.size() != 0) {
//            int size = queue.size();
//            steps++;
//            for (int i = 0; i < size; i++) {
//                StringObj curr = queue.poll();
//                if (curr.transformation.equals(endWord)) {
//                    if (steps <= minSteps) {
//                        minSteps = steps;
//
//                    }
//
//                }
//                for (int j = 0; j < curr.length(); j++) {
//
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        String newStr = curr.substring(0,j) + ch + curr.substring(j+1);
//                        if (!seen.add(newStr))
//                            continue;
//                        if (!dictionary.contains(newStr))
//                            continue;
//                        queue.add(newStr);
//
//                    }
//                }
//            }
//
//        }
//
//        return 0;
//    }
//}
