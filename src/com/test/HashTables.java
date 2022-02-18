package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class HashTables {
    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Entry>[] entries = new LinkedList[5];

    private int index(int key) {
        return key % entries.length;
    }

    public void put(int key, String value) {
        var index = index(key);
        var chainEntry = entries[index];
        var entry = new Entry(key, value);
        if (chainEntry == null) {

            var linkedList = new LinkedList<Entry>();
            linkedList.addLast(entry);
            entries[index] = linkedList;
        } else {
            for (var e : chainEntry) {
                if (e.key == key) {
                    e.value = value;
                    break;
                }
            }
            chainEntry.addLast(entry);
        }
        System.out.println("Index inserted at " + index);
    }

    public String get(int key) {
        var index = index(key);
        var entry = entries[index];
        if (entry != null) {

            for (var e : entry) {
                if (e.key == key) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public void remove(int key) {
        var index = index(key);
        var entry = entries[index];
        if (entry != null) {

            for (var e : entry) {
                if (e.key == key) {
                    entry.remove(e);
                    return;
                }
            }
        }
    }

    public String uniquePairs(Integer[] input, int difference) {
        var intSet = new HashMap<Integer,Integer>();
        for (int i : input) {
            intSet.put(i,i);
        }
        var stringBuilder = new StringBuilder();
        stringBuilder.append("Pairs: ");
        for (int i : input) {
            var sum = i + difference;
            var diff = i - difference;
            if (intSet.containsKey(sum) ) {
        stringBuilder.append(i).append("-").append(intSet.get(sum)).append(" ");
            }
            else if (intSet.containsKey(diff)) {
        stringBuilder.append(i).append("-").append(intSet.get(diff)).append(" ");
            }

        }
        return stringBuilder.toString();
    }
}
