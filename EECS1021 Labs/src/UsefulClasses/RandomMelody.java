package UsefulClasses;

import jm.constants.Pitches;
import jm.constants.RhythmValues;
import jm.music.data.*;
import jm.util.Play;
import jm.util.Write;

public class RandomMelody {
    private Score score;
    private Part prt;
    private Phrase phrase;
    private String scoreTtl;

    public RandomMelody(String scoreTittle){
        this.scoreTtl = scoreTittle;
        this.score = new Score(scoreTittle);//Name your score
        this.prt = new Part("Snare", 0, 9);
        this.phrase = new Phrase(0.0);
        this.score.add(prt);
        this.prt.add(phrase);
    }
    public static void randomRhythm(){
        System.out.println("\n\n\nStarted meathod randomRhythm");
        int pitch = 38; //lab doc said pitch was 38 and later said 50, idk which one to use
        double noteInterval;
        for(int i =1; i<=2;i++){
            noteInterval = (Math.random() * 2);
            Note note = new Note(pitch, noteInterval);
            Play.midi(note);
            System.out.println("    Playing note " + i + "/" + 2 + "    Pitch is: " + pitch + "  Note Invterval is: "+ noteInterval);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateRandomNotes(int maxInterval){
        System.out.println("\n\n\nStarted meathod generateRandomNotes");
        int pitch = 38; //lab doc said pitch was 38 and later said 50, idk which one to use
        double noteInterval;
        for(int i=1; i<=24;i++){
            noteInterval = Math.random() * maxInterval;
            Note note = new Note(pitch, noteInterval);
            Play.midi(note);
            System.out.println("    Playing note " + i + "/" + 24 + "    Pitch is: " + pitch + "  Note Invterval is: "+ noteInterval);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static double[] modifiedGenerateRandomNotes(int maxInterval){
        double[] noteInterval = new double[24];
        for(int i=0; i<24;i++){
            noteInterval[i] = Math.random() * maxInterval;
        }
        return noteInterval;
    }

    public void addASong(int instrument, int[] pitchLst){
        this.score = new Score(this.scoreTtl);//Name your score
        this.prt = new Part("New Part", instrument, 9);
        this.phrase = new Phrase(0.0);
        phrase.addNoteList(pitchLst, modifiedGenerateRandomNotes(5)); // Max interval was not defined. I set it to a random value
        this.score.add(prt);
        this.prt.add(phrase);
    }

    public void play(){
        Play.midi(this.score);
    }

    public void save(){
        Write.midi(this.score, (this.scoreTtl+".mid"));
    }

    public void clear(){
        this.score = new Score(this.scoreTtl);//Name your score
        this.prt = new Part("Snare", 0, 9);
        this.phrase = new Phrase(0.0);
        score.add(prt);
        prt.add(phrase);
    }

}
