/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mididrumkit;

import entities.Rhythm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class MidiPlayer implements JMC {

    /**
     *
     * @param args, is a <code>String</code> that contains as a first field the
     * name of the midi file that will store the results in.
     * @param rhythm, is a <code>Vector<String></code> that contains the rhythm.
     *
     */
    public static void play(Rhythm rhythm) {
        Score pattern1 = new Score("JMDemo - Kit");
        Part drums = new Part("Drums", 0, 9); // 9 = MIDI channel 10
        Phrase phrBD = new Phrase(0.0);
        Phrase phrSD = new Phrase(0.0);
        Phrase phrHH = new Phrase(0.0);

        //Let us know things have started
        System.out.println("Creating drum patterns . . .");

        HashMap<Integer, ArrayList<Boolean>> drumVoices = rhythm.getDrumVoices();
        Iterator it = drumVoices.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int voice = 0;
            ArrayList<Boolean> voicePattern = (ArrayList<Boolean>) pair.getValue();
            for (int i = 0; i < voicePattern.size(); i++) {
                switch ((int) pair.getKey()) {
                    case Rhythm.BASS_DRUM:
                        if (voicePattern.get(i)) {
                            phrBD.addNote(new Note(Rhythm.BASS_DRUM, C));
                        } else {
                            phrBD.addNote(new Note(REST, C));
                        }
                        break;
                    case Rhythm.HIGH_HAT:
                        if (voicePattern.get(i)) {
                            phrBD.addNote(new Note(Rhythm.HIGH_HAT, C));
                        } else {
                            phrBD.addNote(new Note(REST, C));
                        }
                        break;
                    case Rhythm.SNARE:
                         if (voicePattern.get(i)) {
                            phrBD.addNote(new Note(Rhythm.SNARE, C));
                        } else {
                            phrBD.addNote(new Note(REST, C));
                        }
                       break;
                }
            }
            it.remove();
        }
        // make bass drum
        for (int i = 0; i < 4; i++) {
        }

        // make snare drum
        for (int i = 0; i < 4; i++) {
            Note rest = new Note(REST, C); //rest
            phrSD.addNote(rest);
            Note note = new Note(38, C);
            phrSD.addNote(note);
        }

        // make hats
        for (int i = 0; i < 15; i++) {
            Note note = new Note(42, Q);
            phrHH.addNote(note);
        }
        Note note = new Note(46, Q); // open hi hat
        phrHH.addNote(note);

        // loop the drum pattern for 16 bars
        Mod.repeat(phrBD, 7);
        Mod.repeat(phrSD, 7);
        Mod.repeat(phrHH, 7);

        // add phrases to the instrument (part)
        drums.addPhrase(phrBD);
        drums.addPhrase(phrSD);
        drums.addPhrase(phrHH);

        // add the drum part to a score.
        pattern1.addPart(drums);

        // write the score to a MIDIfile
        //Write.midi(pattern1, "Kit.mid");
        Play.midi(pattern1);

    }
}
