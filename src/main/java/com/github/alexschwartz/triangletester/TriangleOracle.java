package com.github.alexschwartz.triangletester;

import java.util.Map;
import java.util.TreeMap;

public class TriangleOracle {

    public enum TriangleType { Scalene, Invalid }; 
    Map<Integer, Integer> entries = new TreeMap<Integer,Integer>();
    int sum = 0;
    int maxLength = 0;

    public TriangleType analyze(int side1, int side2, int side3) {
        storeSideLength(side1);
        storeSideLength(side2);
        storeSideLength(side3);

        if (2*maxLength >= sum) { 
            return TriangleType.Invalid;
        }
        return TriangleType.Scalene;
    }
    
    void storeSideLength(int length) {
        Integer entry = entries.get(length);
        int oldNumber =  entry == null ? 0 : entry;
        entries.put(length, oldNumber + 1); 
        
        sum += length;
        
        if (maxLength < length) {
            maxLength = length;
        }
    }

}
