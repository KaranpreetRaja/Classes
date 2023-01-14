package eecs1021;

import jm.util.Play;
import jm.constants.*;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class LabIPart1 {
    public static void main(String[] args) {
        Play.midi(new Note(Pitches.G3, RhythmValues.TN));
        Play.midi(new Note(Pitches.G3, RhythmValues.TN));
        Play.midi(new Note(Pitches.A3, RhythmValues.TN));
        Play.midi(new Note(Pitches.G3, RhythmValues.TN));
        Play.midi(new Note(Pitches.C4, RhythmValues.TN));
        Play.midi(new Note(Pitches.B3, RhythmValues.TN));
        // Alternatively:
        // Play.midi(new Note(JMC.G3, 0.75*JMC.TN));
    }
}