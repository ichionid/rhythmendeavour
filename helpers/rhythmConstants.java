/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author lebowski
 */
public class rhythmConstants {
    public static final String hihat = "hh";
    public static final String crash = "cr";
    public static final String china = "ch";
    public static final String ride = "rd";
    public static final String tom_high = "th";
    public static final String tom_medium = "tm";
    public static final String tom_low = "tl";
    public static final String snare_drum = "sd";
    public static final String bass_drum = "bd";
    
    public static String[] getDrumVoiceConstants(){
      String[] drumVoiceConstants;
      drumVoiceConstants = new String[]{
          rhythmConstants.hihat,
          rhythmConstants.crash,
          rhythmConstants.china,
          rhythmConstants.ride,
          rhythmConstants.tom_high,
          rhythmConstants.tom_medium,
          rhythmConstants.tom_low,
          rhythmConstants.snare_drum,
          rhythmConstants.bass_drum,
      };
      return drumVoiceConstants;
    }
}
