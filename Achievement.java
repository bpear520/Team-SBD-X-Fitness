import java.util.ArrayList;

public class Achievement {

    private boolean tenDailyWorkout = false;
    private boolean twentyDailyWorkout = false;
    private boolean threePerfectDays = false;
    private boolean sixPerfectDays = false;
    private boolean twentyPerfectDays = false;
    private boolean goalWeight = false;
    private int recCalories;
    private Employee emp;

    Controller controller = Controller.getInstance();
    private ArrayList<DailyFitnessRecord> curEmpFitRec = new ArrayList<DailyFitnessRecord>();
    private int numRecords;

    public Achievement(Employee emp) {
        this.emp = emp;
        curEmpFitRec = emp.getFitnessRecords();
        numRecords = curEmpFitRec.size();
        updateAchievements();
    }

    public void updateAchievements() {
        setWorkoutAchievements();
        setPerfectDayAchievements();
        setGoalWeightAcheivement();
    }

    public void setWorkoutAchievements() {
        int dailyWorkoutCount = 0;

        for(int i = 0; i < numRecords - 1; i++) {
            if(curEmpFitRec.get(i).isWorkedOut()) {
                dailyWorkoutCount++;
            }
        }

        if(dailyWorkoutCount >= 10 && dailyWorkoutCount < 20) {
            setTenDailyWorkout();
        } else if (dailyWorkoutCount >= 20) {
            setTwentyDailyWorkout();
        }
    }

    public void setPerfectDayAchievements() {
        boolean caloriesMet = false;
        boolean workedOut = false;
        boolean greatSleep = false;
        int perfectDayCount = 0;

        getRecCalories();
        perfectDayCount = getPerfectDayCount(caloriesMet, workedOut, greatSleep, perfectDayCount);
        setPerfectDays(perfectDayCount);
    }

    /**
     * @param perfectDayCount
     */
    private void setPerfectDays(int perfectDayCount) {
        if(perfectDayCount >= 3 && perfectDayCount < 6) {
            setThreePerfectDays();
        } else if (perfectDayCount >= 6 && perfectDayCount < 20) {
            setSixPerfectDays();
        } else if (perfectDayCount >= 20) {
            setTwentyPerfectDays();
        }
    }

    /**
     *
     */
    private void getRecCalories() {
        if(emp.getPersonalrecods().getGender() == "Male") {
            recCalories = 2500;
        } else {
            recCalories = 1900;
        }
    }

    /**
     * @param caloriesMet
     * @param workedOut
     * @param greatSleep
     * @param perfectDayCount
     * @return
     */
    private int getPerfectDayCount(boolean caloriesMet, boolean workedOut, boolean greatSleep, int perfectDayCount) {
        for(int i = 0; i < numRecords - 1; i++) {
            if(curEmpFitRec.get(i).getCalories() <= recCalories) {
                caloriesMet = true;
            }

            if(curEmpFitRec.get(i).isWorkedOut()) {
                workedOut = true;
            }

            if(curEmpFitRec.get(i).getSleepQuality().equals("Great")) {
                greatSleep = true;
            }

            if(caloriesMet && workedOut && greatSleep) {
                perfectDayCount++;
            }
        }
        return perfectDayCount;
    }

    private void setGoalWeightAcheivement() {
        if(emp.getPersonalrecods().getWeight() == emp.getPersonalrecods().getGoalWeight()) {
            goalWeight = true;
        }
    }

    public void setThreePerfectDays() {
        this.threePerfectDays = true;
    }

    public void setSixPerfectDays() {
        this.sixPerfectDays = true;
    }

    public void setTwentyPerfectDays() {
        this.twentyPerfectDays = true;
    }

    public void setTenDailyWorkout(){
        this.tenDailyWorkout = true;
    }

    public void setTwentyDailyWorkout(){
        this.twentyDailyWorkout = true;
    }

    public boolean isTenDailyWorkout() {
        return tenDailyWorkout;
    }

    public boolean isTwentyDailyWorkout() {
        return twentyDailyWorkout;
    }

    public boolean isThreePerfectDays() {
        return threePerfectDays;
    }

    public boolean isSixPerfectDays() {
        return sixPerfectDays;
    }

    public boolean isTwentyPerfectDays() {
        return twentyPerfectDays;
    }

    public boolean isGoalWeight() {
        return goalWeight;
    }
    public void setGoalWeight(boolean goalWeight) {
        this.goalWeight = goalWeight;
    }
}
