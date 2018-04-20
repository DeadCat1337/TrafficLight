package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Crossway {
    
    private TrafficLight rd[];
    private Counter c;
    
    public Crossway(){
        rd = new TrafficLight[4];
        c = new Counter();
        for(int i = 0; i < 4; i++){
            rd[i] = new TrafficLight(rd, i, c);
        }
        Thread t[] = new Thread[4];
        for(int i = 0; i < 4; i++){
            t[i] = new Thread(rd[i]);
            t[i].start();
        }
    }
    
    
}
