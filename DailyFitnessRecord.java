
public class DailyFitnessRecord {
    public DailyFitnessRecord(int sleepQuality, int calories, boolean workedOut) {
        this.sleepQuality = sleepQuality;
        this.calories = calories;
        this.workedOut = workedOut;
    }
    private int sleepQuality;
    private int calories;
    private boolean workedOut;
    
    public int getSleepQuality() {
        return sleepQuality;
    }
    public void setSleepQuality(int sleepQuality) {
        this.sleepQuality = sleepQuality;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public boolean isWorkedOut() {
        return workedOut;
    }
    public void setWorkedOut(boolean workedOut) {
        this.workedOut = workedOut;
    }
    
}
