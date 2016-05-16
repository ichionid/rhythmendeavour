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

    private ArrayList<String> rules;
    private int maxIterations;
    private int maxDistance;

    public ArrayList<String> getRules() {
        return rules;
    }

    public void setRules(ArrayList<String> rules) {
        this.rules = rules;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    /**
     * The function returns a pattern when either maxIterations or maxDistance
     * is reached.
     *
     * @param inputPattern an ArrayList of <code>Booleans</code> where TRUE
     * stands for onset and FALSE for offset.
     * 
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for onset
     * and FALSE for offset
     */
    public ArrayList<Boolean> generate(ArrayList<Boolean> inputPattern) {
        ArrayList<Boolean> outputPattern = inputPattern;
        rhythmUtils.printPattern(inputPattern);
        System.out.println("Startig to iterate(Max iterations:" + this.maxIterations + ")");
        for (int i = 0; i < this.maxIterations; i++) {
            outputPattern = generatePattern(outputPattern, this.rules);
            rhythmUtils.printPattern(outputPattern);
            if (rhythmUtils.getDistance(inputPattern, outputPattern)
                    > this.maxDistance) {
                break;
            }
        }
        return outputPattern;
    }

    /**
     *
     * @param inputPattern an ArrayList of <code>Booleans</code> where TRUE
     * stands for onset and FALSE for offset.
     * @param rules, an ArrayList of <code>Strings</code> where every string
     * contains only a single character.
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for onset
     * and FALSE for offset
     */
    public ArrayList<Boolean> generatePattern(ArrayList<Boolean> inputPattern,
            ArrayList<String> rules) {

        ArrayList<Boolean> outputPattern = (ArrayList) inputPattern.clone();
        int neighborsSum;

        for (int i = 0; i < inputPattern.size(); i++) {
            // Calculate sum for every single cell.
            neighborsSum = 0;
            if (i == 0) {
                // Calculate sum for first cell
                if (inputPattern.get(0)) {
                    neighborsSum++;
                }
                try {
                    if (inputPattern.get(1)) {
                        neighborsSum++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    //Suppress an out of bounds exceptiond
                }
            } else if (i == (inputPattern.size() - 1)) {
                // Calculate sum for last cell
                if (inputPattern.get(i)) {
                    neighborsSum++;
                }
                if (inputPattern.get(i - 1)) {
                    neighborsSum++;
                }
            } else {
                if (inputPattern.get(i)) {
                    neighborsSum++;
                }
                if (inputPattern.get(i - 1)) {
                    neighborsSum++
;                }
                if (inputPattern.get(i + 1)) {
                    neighborsSum++;
                }
            }
            outputPattern.set(i, calculateCellValue(inputPattern.get(i), neighborsSum, rules));
        }
        return outputPattern;
    }

    /**
     *
     * @param initialValue a <code>Boolean</code> representing the initial value
     * of the note.
     * @param neighborsSum an <code>Int</code> representing the sum of all
     * neighboring onsets.
     * @param rules, an ArrayList of <code>Strings</code> where every string
     * contains only a single character.
     * @return an ArrayList of <code>Booleans</code> where TRUE stands for onset
     * and FALSE for offset NFUU
     */
    private Boolean calculateCellValue(Boolean initialValue, int neighborsSum, ArrayList<String> rules) {
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
