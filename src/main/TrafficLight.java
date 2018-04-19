package main;

public class TrafficLight implements Runnable {

    public static final int DEFAULT_TIME = 90;
    public final static int SIDE_UP = 1, SIDE_DOWN = 2, 
            SIDE_RIGHT = 3, SIDE_LEFT = 4;
    
    private final TrafficLight tls[];
    private final int side;
    private Counter c;
    
    private boolean state = false;
    private boolean gen = true;
    private double density = 0.5;
    private int cars = 0;
    private int time = DEFAULT_TIME;

    
    public TrafficLight(TrafficLight tls[], int side, Counter c) {
        this.tls = new TrafficLight[4];
        for(int i = 0; i < 4; i++){
            this.tls[i] = tls[i];
        }
        this.side = side;
        this.c = c;
    }

    public void setState(boolean st) {
        
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public boolean getState() {
        return state;
    }

    public int getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }

    public double getDensity() {
        return density;
    }

    public void tick() {
        time -= cars;
    }

    public void generate() {
        cars++;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tick();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
