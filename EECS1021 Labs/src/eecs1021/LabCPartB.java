package eecs1021;
import java.util.Timer;
import java.util.TimerTask;

public class LabCPartB {
    public static void main(String args[]){
        final int[] count = {0};
        long starttime = System.currentTimeMillis();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                count[0]++;
                System.out.println("Task performed " + count[0] + " times in " + ((System.currentTimeMillis())-starttime) + " ms");
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(task, 0, 1000);
    }
}