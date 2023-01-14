package eecs1021;

import jm.music.data.*;
import jm.util.Play;
import jm.constants.*; // Pitches.E0, RhythmValues.TN, etc.

public class LabIPart2 {
    public static void main(String[] args) {
        Play.midi(new Note(Pitches.A3, RhythmValues.TN));
        Play.midi(new Note(Pitches.B3, RhythmValues.TN));
        Play.midi(new Note(Pitches.D3, RhythmValues.TN));
        Play.midi(new Note(Pitches.B3, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.F4, RhythmValues.TN));
        Play.midi(new Note(Pitches.E3, RhythmValues.TN));
        // Alternatively:
        // Play.midi(new Note(JMC.G3, 0.75*JMC.TN));
    }
}
