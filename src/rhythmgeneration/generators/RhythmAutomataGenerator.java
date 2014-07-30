/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rhythmgeneration.generators;

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
     * @param input an ArrayList of <code>Booleans</code> where TRUE stands for
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
    public ArrayList<Boolean> voiceGenerator(ArrayList<Boolean> input, 
            ArrayList<String> rules, int maxIterations, int maxDistance ) {
        return input;
    }
        
}
