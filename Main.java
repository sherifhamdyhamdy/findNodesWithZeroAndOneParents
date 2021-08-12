package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };


        zeroParent(parentChildPairs);
        zeroParentHashMap(parentChildPairs);

    }

    static void zeroParentHashMap(int[][] parentChildPairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            if (map.containsKey(parentChildPairs[i][1]))
                map.put(parentChildPairs[i][1], map.get(parentChildPairs[i][1]) + 1);
            else
                map.put(parentChildPairs[i][1], 1);

            if (!map.containsKey(parentChildPairs[i][0]))
                map.put(parentChildPairs[i][0], 0);

        }
        List<Integer> zeroParent = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        map.forEach((key, value) -> {
            if (value == 0)
                zeroParent.add(key);

            if (value == 1)
                oneParent.add(key);

        });

        System.out.println(zeroParent);
        System.out.println(oneParent);
    }

    static void zeroParent(int[][] parentChildPairs) {
        List<Integer> parentList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();

        List<Integer> zeroParentList = new ArrayList<>();
        List<Integer> oneParentList = new ArrayList<>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            parentList.add(parentChildPairs[i][0]);
            childList.add(parentChildPairs[i][1]);
        }


        for (Integer p : parentList) {
            int counter = 0;
            for (Integer ch : childList) {
                if (p.equals(ch)) {
                    counter++;
                }
            }
            if (counter == 0 && !zeroParentList.contains(p))
                zeroParentList.add(p);

        }

        for (int i = 1; i < childList.size(); i++) {
            int parentCounter = 0;
            for (int j = 0; j < childList.size(); j++) {
                if (childList.get(i) == childList.get(j)) {
                    parentCounter++;
                }

            }
            if (parentCounter == 1) {
                oneParentList.add(childList.get(i));
            }

        }

        System.out.println(zeroParentList);
        System.out.println(oneParentList);

    }
}
