package eecs1021;

import UsefulClasses.RandomMelody;
import jm.JMC;

public class LabJPart2b {
    public static void main(String[] args) {

        RandomMelody rm = new RandomMelody("SampleFile");//Pass your name
        //include 5 pitches of a song you would like to play
        int[] pitchArray = { JMC.G3, JMC.G3, JMC.A3, JMC.G3, JMC.C4};
        rm.addASong(JMC.PIANO,pitchArray);
        rm.play();
        System.out.println("done playing");
        rm.save();
        System.out.println("saved");
        rm.clear();
        rm.play();
        System.out.println("done playing cleared");

    }
}