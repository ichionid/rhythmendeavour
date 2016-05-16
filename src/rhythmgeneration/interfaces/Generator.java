/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rhythmgeneration.interfaces;

import java.util.ArrayList;
import rhythmgeneration.generators.*;

/**
 *
 * @author lebowski
 */
public interface Generator {
   public void generate(ArrayList<Boolean> inputPattern);
}
