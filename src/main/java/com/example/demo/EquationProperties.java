package com.example.demo;

import lombok.Data;

@Data
public class EquationProperties {

    private double coefficientX;
    private double coefficientY;
    private double lowerBoundX;
    private double upperBoundX;
    private double lowerBoundY;
    private double upperBoundY;
    private double helperCoeffX;
    private double helperCoeffY;
    private double helperUpperBound;
    private double helperLowerBound;

    private String goal;

}
