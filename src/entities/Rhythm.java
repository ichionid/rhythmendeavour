package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rhythm entity contains arrays of booleans representing different voices
 * @author lebowski
 */
public class Rhythm {
    HashMap<Integer , ArrayList<Boolean>> drumVoices  = new HashMap<Integer, ArrayList<Boolean>>();
    public static final int SNARE = 36;
    public static final int BASS_DRUM = 38;
    public static final int HIGH_HAT = 42;
    private ArrayList<Boolean> snare, bassDrum, highHat;

    public Rhythm() {
        drumVoices.put(SNARE, snare);
        drumVoices.put(BASS_DRUM, bassDrum);
        drumVoices.put(HIGH_HAT, highHat);
    }
    
    public HashMap<Integer, ArrayList<Boolean>> getDrumVoices() {
        return drumVoices;
    }

    public ArrayList<Boolean> getSnare() {
        return snare;
    }

    public void setSnare(ArrayList<Boolean> snare) {
        this.snare = snare;
    }

    public ArrayList<Boolean> getBassDrum() {
        return bassDrum;
    }

    public void setBassDrum(ArrayList<Boolean> bassDrum) {
        this.bassDrum = bassDrum;
    }

    public ArrayList<Boolean> getHighHat() {
        return highHat;
    }

    public void setHighHat(ArrayList<Boolean> highHat) {
        this.highHat = highHat;
    }
    
 }
