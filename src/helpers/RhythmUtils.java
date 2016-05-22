/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lebowski
 */
public class RhythmUtils {

    /**
     *
     * @param rootPattern an ArrayList of <code>Booleans</code> where TRUE
     * stands for onset and FALSE for offset.
     * @param targetPattern an ArrayList of <code>Booleans</code> where TRUE
     * stands for onset and FALSE for offset.
     * @return <code>int</code> representing the distance of the 2 patterns.
     */
    public static int getDistance(ArrayList<Boolean> rootPattern,
            ArrayList<Boolean> targetPattern) {

        int distance = 0;

        for (int i = 0; i < rootPattern.size(); i++) {

            if (rootPattern.get(i) == true) {
                // Find the closest onset. 2000 is a inapplicable distance
                int tempDistance = 2000;

                for (int j = 0; j < targetPattern.size(); j++) {
                    if (targetPattern.get(j)) {

                        int tTempDistance = Math.abs(i - j);

                        if (tTempDistance <= tempDistance) {
                            tempDistance = tTempDistance;
                            if (tempDistance == 0) {
                                break;
                            }
                        }
                    }
                }
                if (tempDistance != 2000) {
                    distance += tempDistance;
                }
            }
        }
        return distance;
    }

    /**
     * @param pattern an ArrayList of <code>Booleans</code> where TRUE stands
     * for onset and FALSE for offset.
     */
    public static void printPattern(ArrayList<Boolean> pattern) {
        System.out.println("Pattern:");
        for (int i = 0; i < pattern.size(); i++) {
            if (pattern.get(i)) {
                System.out.print("X");
            } else {
                System.out.print("o");
            }
        }
        System.out.println("----");
    }

    public static void union(List<Boolean> baseList, List<Boolean> addedList) {
        for (int i = 0; i < addedList.size(); i++) {
            if (addedList.get(i)) {
                baseList.add(Boolean.TRUE);
            } else {
                baseList.add(Boolean.FALSE);
            }
        }
    }
}
