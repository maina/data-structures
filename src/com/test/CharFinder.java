package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CharFinder {
    public void firstRepeatedCharacter(String input){
        var chars=input.toLowerCase().toCharArray();
        var hashMap= new HashSet<>();
        for(char c : chars){
            if(!hashMap.contains(c)) {
                hashMap.add(c);
            }else{
                System.out.println("First repeated character is "+c);
                break;
            }
        }
    }
    public void firstNonRepeatedCharacter(String input){
        var chars=input.toLowerCase().toCharArray();
        var hashMap= new HashMap<Character,Integer>();
        for(char c : chars){
            if(!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            }else{
                var counter= hashMap.get(c) +1;
                hashMap.put(c,counter);
            }
        }
        for(char c : chars){
            if(hashMap.get(c).compareTo(1)==0){
                System.out.println("First"+c);
                break;
            }
        }
    }
}
