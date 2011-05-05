package com.github.alexschwartz.triangletester;

public class TriangleOracle {

    public enum TriangleType { Scalene, Invalid };

    public TriangleType analyze(int side1, int side2, int side3) {
        if (side3 >= side1 + side2) { 
            return TriangleType.Invalid;
        }
        return TriangleType.Scalene;
    }

}
