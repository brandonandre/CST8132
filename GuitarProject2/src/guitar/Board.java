package guitar;
/*
 * Copyright (c) 1999 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

import javax.sound.midi.*;

/*
 * adapted from code written by Brian Lichtenwalter  
 */
public class Board {
  public final static int STEEL_STRING_GUITAR = 25;

  Synthesizer synthesizer;
  Instrument instruments[];
  MidiChannel channel;
  private static Board board = new Board();
  
  //Reason why we made this private is because we don't want other classes. 
  private Board() {
    try {
      if (synthesizer == null) {
        if ((synthesizer = MidiSystem.getSynthesizer()) == null) {
          System.out.println("getSynthesizer() failed!");
          return;
        }
      }
      synthesizer.open();
    } catch (Exception ex) {
      ex.printStackTrace();
      return;
    }

    Soundbank sb = synthesizer.getDefaultSoundbank();
    if (sb != null) {
      instruments = synthesizer.getDefaultSoundbank().getInstruments();
      synthesizer.loadInstrument(instruments[STEEL_STRING_GUITAR]);
    }
    channel = (synthesizer.getChannels())[0];
    channel.programChange(STEEL_STRING_GUITAR);
  }

  public void close() {
    if (synthesizer != null) {
      synthesizer.close();
    }

    synthesizer = null;
    instruments = null;
  }

  public void soundNote(int note) {
    channel.noteOn(note, 64);
  }

  //It's attached to the actual class, not the objects. So there is only one instance. 
  public static Board getInstance() {
    return board;
  }
}
