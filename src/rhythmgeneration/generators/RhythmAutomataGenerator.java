/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rhythmgeneration.generators;

import helpers.rhythmUtils;
import java.util.ArrayList;


/**
 *
 * @author lebowski
 */
public class RhythmAutomataGenerator {
    /**
     * The function returns a pattern when either maxIterations or maxDistance
     * is reached.
     * 
     * @param inputPattern an ArrayList of <code>Booleans</code> where TRUE stands for
     * onset and FALSE for offset.
     * @param rules,  an ArrayList of <code>Strings</code> where every string 
     * contains only a single character.
     * @param maxIterations an <code>Int</code> representing the maximum amount
     * of iterations. 
     * @param maxDistance, an <code>Int</code> representing the maximum distance
     * between the initial rhythm and the rhythm on the specific iteration.
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for
     * onset and FALSE for offset
     */
    public ArrayList<Boolean> voiceGenerator(ArrayList<Boolean> inputPattern, 
            ArrayList<String> rules, int maxIterations, int maxDistance ) {
        ArrayList<Boolean> outputPattern = inputPattern;
        rhythmUtils.printPattern(inputPattern);        
        for (int i = 0; i < maxIterations; i++) {
            outputPattern = generatePattern(outputPattern, rules);
            rhythmUtils.printPattern(outputPattern);
            if (rhythmUtils.getDistance(inputPattern, outputPattern) 
                    > maxDistance) {
                break;
            }
        }
        return outputPattern;
    }
    
    /**
     * 
     * @param inputPattern an ArrayList of <code>Booleans</code> where TRUE stands for
     * onset and FALSE for offset.
     * @param rules,  an ArrayList of <code>Strings</code> where every string 
     * contains only a single character.
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for
     * onset and FALSE for offset
     */    
    public ArrayList<Boolean> generatePattern(ArrayList<Boolean> inputPattern, 
            ArrayList<String> rules) {
        ArrayList<Boolean> outputPattern = (ArrayList)inputPattern.clone();
        int neighborsSum;
        for (int i = 0; i < inputPattern.size(); i++) {
            neighborsSum = 0;
            if (i==0) {
                // First cell
                if(inputPattern.get(0)) {
                    neighborsSum++;
                }
                try {
                  if(inputPattern.get(1)) {
                        neighborsSum++;
                  }
                } catch (IndexOutOfBoundsException e) {
                    //Suppress an out of bounds exceptiond
                }
            } else if(i == (inputPattern.size()-1)) {
                // Last cell
                if(inputPattern.get(i)) {
                    neighborsSum++;
                }
                if(inputPattern.get(i-1)) {
                    neighborsSum++;
                }
            }
            else {
                if(inputPattern.get(i)) {
                    neighborsSum++;
                }
                if(inputPattern.get(i-1)) {
                    neighborsSum++;
                }
                if(inputPattern.get(i+1)) {
                    neighborsSum++;
                }
            }
            outputPattern.set(i, calculateCellValue(inputPattern.get(i), neighborsSum, rules));
        }
        return outputPattern;
    }
   /**
     * 
     * @param initialValue a <code>Boolean</code> representing the initial 
     * value of the note. 
     * @param neighborsSum an <code>Int</code> representing the sum of all 
     * neighboring onsets. 
     * @param rules, an ArrayList of <code>Strings</code> where every string 
     * contains only a single character.
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for
     * onset and FALSE for offset
     */
    public Boolean calculateCellValue(Boolean initialValue, int neighborsSum, ArrayList<String> rules) {
        switch (rules.get(neighborsSum)) {
           case "N":
                 return true;
           case "R": 
                 return false;
           case "F":
                 return !initialValue;
           case "U":
                 return initialValue;
           default:
               return initialValue;
       }
    }
}
