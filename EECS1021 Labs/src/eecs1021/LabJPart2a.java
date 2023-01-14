package eecs1021;

import UsefulClasses.RandomMelody;
import jm.JMC;

public class LabJPart2a {
    public static void main(String[] args) {

        RandomMelody rm = new RandomMelody("TAName");//Pass your name

        //include 24 pitches of a song you would like to play
        int[] pitchArray = { JMC.G3, JMC.G3, JMC.A3, JMC.G3, JMC.C4, JMC.B3, JMC.G3, JMC.G3, JMC.A3, JMC.G3, JMC.C4, JMC.B3, JMC.G3, JMC.G3, JMC.A3, JMC.G3, JMC.C4, JMC.B3, JMC.G3, JMC.G3, JMC.A3, JMC.G3, JMC.C4, JMC.B3,};
        rm.addASong(JMC.PIANO,pitchArray);
        //rm.play();
        rm.save();
        //rm.clear();

    }
}