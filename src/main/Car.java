package main;

public class Car {
    private final long start;
    private long time;
    
    public Car(){
        start = System.currentTimeMillis();
    }
    
    public long kill(){
        time = System.currentTimeMillis() - start;
        return time;
    }
}
