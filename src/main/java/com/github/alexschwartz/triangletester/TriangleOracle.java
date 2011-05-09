package com.github.alexschwartz.triangletester;

import java.util.Map;
import java.util.TreeMap;

public class TriangleOracle {

    public enum TriangleType { Scalene, Invalid, Equilateral, Isosceles, Right }; 
   
    private final Map<Double, Integer> entries = new TreeMap<Double,Integer>();
    
    private double sum = 0;
    private double maxLength = 0;
    private double sumSqr;

    public TriangleType analyze(double side1, double side2, double side3) {
        storeSideLength(side1);
        storeSideLength(side2);
        storeSideLength(side3);

        if (entries.size() == 1) {
            return TriangleType.Equilateral;
        }
        
        if (2*maxLength >= sum) { 
            return TriangleType.Invalid;
        }
        
        if (entries.size() == 2) {
            return TriangleType.Isosceles;
        }
        
        // is a^2 + b^2 = c^2 ??
        double maxSqr = maxLength*maxLength;
        
        if (this.sumSqr == 2*maxSqr) { 
            return TriangleType.Right;
        }
        
        return TriangleType.Scalene;
    }
    
    void storeSideLength(final double side1) {
        final Integer entry = entries.get(side1);
        final int oldNumber =  entry == null ? 0 : entry;
        this.entries.put(side1, oldNumber + 1); 
        
        this.sum += side1;
        this.sumSqr += side1 * side1;
        
        if (this.maxLength < side1) {
            this.maxLength = side1;
        }
    }

}
