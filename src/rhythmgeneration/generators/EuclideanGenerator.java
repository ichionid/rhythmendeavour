/*
 * Euclidean generator is used for creating rhythms out of no previous rhythm.
 */
package rhythmgeneration.generators;

import helpers.RhythmUtils;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rhythmgeneration.interfaces.Generator;

/**
 *
 * @author lebowski
 */
public class EuclideanGenerator {

    public ArrayList<Boolean> generate(int onsets, int offsets) {
        ArrayList<List<Boolean>> composedElements = new ArrayList<>();
        ArrayList<List<Boolean>> freeElements = new ArrayList<>();
        for (int i = 0; i < onsets; i++) {
            ArrayList<Boolean> onset = new ArrayList<>();
            onset.add(TRUE);
            composedElements.add(onset);
        }
        // Distribute zeros
        while (offsets > 0) {
            for (int i = 0; i < onsets; i++) {
                // Distribute 0s to each and every 1.
                composedElements.get(i).add(FALSE);
                offsets--;
                if (offsets <= 0) {
                    break;
                }
            }
        }
        //The process stops when the remainder consists of only one sequence
        // (in this case the sequence [100]), or we run out of zero’s.
        if (!checkIfAllElementsAreTheSame(composedElements)) {
            checkIfSingleLastElement(composedElements, freeElements);
            while (freeElements.size() != 0) {
                for (int i = 0; i < composedElements.size(); i++) {
                    if (freeElements.size() > 0) {
                        RhythmUtils.union(composedElements.get(i), freeElements.get(0));
                        freeElements.remove(0);
                    } else {
                        // Return when elements are done
                        break;
                    }
                }
                // Clean up and check conditions to re-run algorithm.
                freeElements.clear();
                if (checkIfAllElementsAreTheSame(composedElements)) {
                    break;
                }
                checkIfSingleLastElement(composedElements, freeElements);
            }
        }
        return composeRhythmicPattern(composedElements);
    }

    private ArrayList<Boolean> composeRhythmicPattern(ArrayList<List<Boolean>> composedElements) {
        ArrayList<Boolean> pattern = new ArrayList<>();
        for (int i = 0; i < composedElements.size(); i++) {
            List<Boolean> tempElement = composedElements.get(i);
            for (int j = 0; j < tempElement.size(); j++) {
                pattern.add(tempElement.get(j));
            }
        }
        return pattern;
    }

    public Boolean checkIfAllElementsAreTheSame(ArrayList<List<Boolean>> composedElements) {
        List<Boolean> lastElement = composedElements.get(composedElements.size() - 1);
        for (int i = 0; i < composedElements.size() - 1; i++) {
            if (!identicalElements(composedElements.get(i), lastElement)) {
                return FALSE;//Even if one pattern is different return false;
            }
        }
        return TRUE;
    }

    public void checkIfSingleLastElement(ArrayList<List<Boolean>> composedElements, ArrayList<List<Boolean>> freeElements) {
        List<Boolean> lastElement = composedElements.get(composedElements.size() - 1);
        for (int i = 0; i < composedElements.size() - 1; i++) {
            if (identicalElements(composedElements.get(i), lastElement)) {
                freeElements.add(composedElements.get(i));
                composedElements.remove(i);
            }
        }
        // Remove last element which was used for comparison if we have any free elements.
        if (freeElements.size() > 0) {
            composedElements.remove(composedElements.size() - 1);
            freeElements.add(lastElement);
        }
    }

    public Boolean identicalElements(List<Boolean> elementA, List<Boolean> elementB) {
        if (elementA.size() != elementB.size()) {
            return FALSE;
        }
        for (int i = 0; i < elementA.size(); i++) {
            if (!Objects.equals(elementA.get(i), elementB.get(i))) {
                return FALSE;
            }
        }
        return TRUE;
    }
}
