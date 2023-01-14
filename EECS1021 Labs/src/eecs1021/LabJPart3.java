package eecs1021;
import UsefulClasses.RandomMelody;
import jm.JMC;
import jm.util.Play;
import jm.util.Read;
import jm.util.View;
import jm.constants.Pitches;
import jm.constants.RhythmValues;
import jm.music.data.*;
import jm.util.Play;
import jm.util.Write;

public class LabJPart3 {
    public static void main(String[] args) {
        String fileName = "src/Files/1272439_1.mid";
        Play.mid(fileName);
        Score newScore = new Score("1272439_1");
        Read.midi(newScore, fileName);
        View.sketch(newScore);
    }
}
