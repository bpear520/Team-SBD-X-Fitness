
public class Achievement {

    private boolean tenDailyWorkout;
    private boolean twentyDailyWorkout;
    private boolean threePerfectDays;
    private boolean sixPerfectDays;
    private boolean twentyPerfectDays;
    private boolean goalWeight;

    public Achievement() {

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

    public boolean isGoalWeight() {
        return goalWeight;
    }
    public void setGoalWeight(boolean goalWeight) {
        this.goalWeight = goalWeight;
    }
}
