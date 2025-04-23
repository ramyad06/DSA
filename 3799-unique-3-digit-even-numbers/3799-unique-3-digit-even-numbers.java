import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> validNumbers = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        Arrays.sort(digits); 
        generatePermutations(digits, used, new ArrayList<>(), validNumbers);
        return validNumbers.size();
    }

    private void generatePermutations(int[] digits, boolean[] used, List<Integer> current, Set<Integer> validNumbers) {
        if (current.size() == 3) {
            int num = current.get(0) * 100 + current.get(1) * 10 + current.get(2);
            if (num % 2 == 0) {
                validNumbers.add(num);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            if (current.size() == 0 && digits[i] == 0) continue;
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.add(digits[i]);
            generatePermutations(digits, used, current, validNumbers);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
