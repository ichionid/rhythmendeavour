/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rhythmendeavour;

import entities.Rhythm;
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
        ArrayList<Boolean> snareDrum = new ArrayList();
        ArrayList<Boolean> hh = new ArrayList();
        ArrayList<Boolean> bd = new ArrayList();
        for (int i = 0; i < 4; i++) {
            snareDrum.add(Boolean.FALSE);
            snareDrum.add(Boolean.FALSE);
            snareDrum.add(Boolean.TRUE);
            snareDrum.add(Boolean.FALSE);
            hh.add(Boolean.TRUE);
            hh.add(Boolean.FALSE);
            hh.add(Boolean.TRUE);
            hh.add(Boolean.FALSE);
            bd.add(Boolean.TRUE);
            bd.add(Boolean.FALSE);
            bd.add(Boolean.FALSE);
            bd.add(Boolean.FALSE);
        }
        Rhythm rhythm = new Rhythm();
        rhythm.setBassDrum(bd);
        rhythm.setHighHat(hh);
        rhythm.setSnare(snareDrum);
        
        
        // Rhythm automata will generate a groove for every different voice.
        /*RhythmAutomataGenerator rag = new RhythmAutomataGenerator();
        ArrayList<String> rules = new ArrayList();
        rules.add("N");
        rules.add("F");
        rules.add("U");
        rules.add("U");
        rag.setRules(rules);
        rag.setMaxDistance(10);
        rag.setMaxIterations(1);*/
        //rag.generate(root);
        //Map<String, Integer> aMap = new HashMap<String, Integer>();
        //aMap.put("a" , Integer.valueOf(1));
    }

}
