/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rhythmendeavour;

import helpers.rhythmUtils;
import java.util.ArrayList;
import rhythmgeneration.generators.RhythmAutomataGenerator;

/**
 *
 * @author lebowski-8
 */
public class Rhythmendeavour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Boolean> root = new ArrayList();
        root.add(true);
        root.add(true);
        root.add(false);
        root.add(true);
        root.add(false);
        root.add(false);
        root.add(true);
        root.add(false);
        
        RhythmAutomataGenerator rag = new RhythmAutomataGenerator();
        ArrayList<String> rules = new ArrayList();
        rules.add("N");
        rules.add("F");
        rules.add("U");
        rules.add("U");
        rag.voiceGenerator(root, rules, 40, 30);
 
    }
    
}
