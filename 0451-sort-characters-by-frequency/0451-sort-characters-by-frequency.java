import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Pair> freqList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            freqList.add(new Pair(entry.getValue(), entry.getKey()));
        }

        freqList.sort((p1, p2) -> {
            if (p1.freq != p2.freq) return p2.freq - p1.freq; 
            return p1.ch - p2.ch; 
        });

        StringBuilder result = new StringBuilder();
        for (Pair p : freqList) {
            result.append(String.valueOf(p.ch).repeat(p.freq));
        }

        return result.toString();
    }

    static class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}
