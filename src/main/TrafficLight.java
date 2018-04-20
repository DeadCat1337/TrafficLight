package main;

import java.util.ArrayDeque;

public class TrafficLight implements Runnable {

    public static final int DEFAULT_TIME = 90;
    public final static int SIDE_UP = 0, SIDE_DOWN = 1,
            SIDE_RIGHT = 2, SIDE_LEFT = 3;

    private final TrafficLight tls[];
    private final int side;
    private Counter c;

    private boolean state = false;
    private boolean gen = true;
    private boolean ready = true;
    private double density = 0.5;
    private int time = DEFAULT_TIME;

    private ArrayDeque<Car> cars;

    public TrafficLight(TrafficLight tls[], int side, Counter c) {
        this.tls = tls;
        this.side = side;
        this.c = c;
        cars = new ArrayDeque<>();
    }

    public void setState(boolean st) {

    }

    public void setDensity(double density) {
        this.density = density;
    }

    public boolean getState() {
        return state;
    }

    public int getCars() {
        return cars.size();
    }

    public int getTime() {
        return time;
    }

    public double getDensity() {
        return density;
    }

    public boolean isReady() {
        return ready;
    }

    public void tick() {
        generate();
    }

    public void generate() {
        if (Math.random() < density) {
            cars.addLast(new Car());
            System.out.println("Side: " + side + "; Car++ : " + cars.size());
        } else {
            System.out.println("Side: " + side + "; Car : " + cars.size());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (tls[0].isReady() && tls[1].isReady()
                        && tls[2].isReady() && tls[3].isReady()) {
                    ready = false;
                    if(side == 0) {
                        tls[1].notify();
                    }
                    System.err.println("Start: " + side);
                    Thread.sleep(1000);
                    tick();
                    ready = true;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
