
public class DailyFitnessRecord {

    private String date;
    private int sleepQuality;
    private int calories;
    private boolean workedOut;

    public DailyFitnessRecord(String date, int sleepQuality, int calories, boolean workedOut) {
        this.setDate(date);
        this.sleepQuality = sleepQuality;
        this.calories = calories;
        this.workedOut = workedOut;
    }
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
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public String formatToFile() {
        String toFile = date + ";" +
                        Integer.toString(sleepQuality) + ";" +
                        Integer.toString(calories) + ";" +
                        Boolean.toString(workedOut) + ";";

        return toFile;
    }

}
