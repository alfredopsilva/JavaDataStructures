package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashTable = new HashMap<>();
        for (int number : array1) {
            myHashTable.put(number, true);
        }

        for (int number : array2) {
            if (myHashTable.containsKey(number))
                return true;

        }
        return false;
    }

    public static ArrayList<Integer> findDuplicates(int[] collection) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int number : collection) {
            if (!myHashMap.containsKey(number)) {
                myHashMap.put(number, false);
            } else {
                if (!result.contains(number))
                    result.add(number);
            }
        }
        return result;
    }

    public static Character firstNonRepeatingChar(String value) {
        HashMap<Character, Integer> myHashMap = new HashMap<>();

        for (int i = 0; i < value.length(); i++) {
            if (!myHashMap.containsKey(value.charAt(i))) {
                myHashMap.put(value.charAt(i), 1);
            } else {
                int temp = myHashMap.get(value.charAt(i));
                temp += 1;
                myHashMap.put(value.charAt(i), temp);
            }
        }
        for (int i = 0; i < value.length(); i++) {
            if (myHashMap.get(value.charAt(i)) == 1) {
                return value.charAt(i);
            }
        }
        return null;
    }

    public static Character courseFirstNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical, group);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            int complement = target - temp;
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(temp, i);
            }
        }
        return new int[] {};

    }

    public static int[] subarraySum(int[] numbers, int target) {

        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            currentSum += numbers[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[] { sumIndex.get(currentSum - target) + 1, i };
            } else {
                sumIndex.put(currentSum, i);
            }
        }
        return new int[] {};
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Collection<Integer> hashResult = new HashSet<>(myList);
        return new ArrayList<>(hashResult);
    }

    public static boolean hasUniqueChars(String string) {
        List<Character> chars = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collection<Character> result = new HashSet<>(chars);
        return chars.size() == result.size();
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        HashSet<Integer> mySet = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int number : arr1) {
            mySet.add(number);
        }

        for (int number : arr2) {
            int complement = target - number;
            if (mySet.contains(complement)) {
                pairs.add(new int[] { complement, number });
            }
        }
        return pairs;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int number : nums) {
            numSet.add(number);
        }
        int longestStreak = 0;

        for (int number : numSet) {
            if (!numSet.contains(number - 1)) {
                int currentNum = number;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
