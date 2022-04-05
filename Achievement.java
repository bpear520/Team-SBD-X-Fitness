

public class Achievement {

    private boolean tenDailyWorkout;
    private boolean twentyDailyWorkout;
    private boolean threePerfectDays;
    private boolean sixPerfectDays;
    private boolean twentyPerfectDays;
    private boolean goalWeightReached;

    public Achievement(boolean tenDailyWorkout, boolean twentyDailyWorkout, boolean threePerfectDays, boolean sixPerfectDays, boolean twentyPerfectDays, boolean goalWeightReached) {
       this.tenDailyWorkout = tenDailyWorkout;
       this.twentyDailyWorkout = twentyDailyWorkout;
       this.threePerfectDays = threePerfectDays;
       this.sixPerfectDays = sixPerfectDays;
       this.twentyPerfectDays = twentyPerfectDays;
       this.goalWeightReached = goalWeightReached;
    }

    public boolean isTenDailyWorkout() {
        return tenDailyWorkout;
    }

    public void setTenDailyWorkout(boolean tenDailyWorkout) {
        this.tenDailyWorkout = tenDailyWorkout;
    }

    public boolean isTwentyDailyWorkout() {
        return twentyDailyWorkout;
    }

    public void setTwentyDailyWorkout(boolean twentyDailyWorkout) {
        this.twentyDailyWorkout = twentyDailyWorkout;
    }

    public boolean isThreePerfectDays() {
        return threePerfectDays;
    }

    public void setThreePerfectDays(boolean threePerfectDays) {
        this.threePerfectDays = threePerfectDays;
    }

    public boolean isSixPerfectDays() {
        return sixPerfectDays;
    }

    public void setSixPerfectDays(boolean sixPerfectDays) {
        this.sixPerfectDays = sixPerfectDays;
    }

    public boolean isTwentyPerfectDays() {
        return twentyPerfectDays;
    }

    public void setTwentyPerfectDays(boolean twentyPerfectDays) {
        this.twentyPerfectDays = twentyPerfectDays;
    }

    public boolean isGoalWeightReached() {
        return goalWeightReached;
    }

    public void setGoalWeightReached(boolean goalWeightReached) {
        this.goalWeightReached = goalWeightReached;
    }

    public String formatToFile() {
        String toFile = String.valueOf(tenDailyWorkout) + ";" +
                        String.valueOf(twentyDailyWorkout) + ";" +
                        String.valueOf(threePerfectDays) + ";" +
                        String.valueOf(sixPerfectDays) + ";" +
                        String.valueOf(twentyPerfectDays) + ";" +
                        String.valueOf(goalWeightReached) + ";";
        return toFile;
    }






}
