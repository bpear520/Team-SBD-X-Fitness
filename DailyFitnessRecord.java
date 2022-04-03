
public class DailyFitnessRecord {

    private String date;
    private String sleepQuality;
    private int calories;
    private boolean workedOut;

    public DailyFitnessRecord(String date, String sleepQuality, int calories, boolean workedOut) {
        this.setDate(date);
        this.sleepQuality = sleepQuality;
        this.calories = calories;
        this.workedOut = workedOut;
    }
    public String getSleepQuality() {
        return sleepQuality;
    }
    public void setSleepQuality(String sleepQuality) {
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
                        sleepQuality + ";" +
                        Integer.toString(calories) + ";" +
                        Boolean.toString(workedOut) + ";";

        return toFile;
    }

}
