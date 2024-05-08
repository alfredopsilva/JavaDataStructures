package HashTable;

import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        ArrayList<String> teste = myHashTable.keys();
        System.out.println(teste);
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
}
