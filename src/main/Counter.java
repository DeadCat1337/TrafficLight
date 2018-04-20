package main;

public class Counter {
    double time[];
    int num[];
    
    public Counter(){
        time = new double[4];
        num = new int[4];
    }
    
    public void add(long time, int side){
        num[side]++;
        this.time[side] += time;
    }
    
    public double getTime(int side){
        if(num[side] == 0){
            return 0;
        }
        return time[side]/num[side];
    }
    
    public double getTime(){
        return (getTime(0)+getTime(1)+getTime(2)+getTime(3))/4;
    }
}
