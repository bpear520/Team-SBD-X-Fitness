public final class Controller extends DataBase {

    private static Controller instance;
    public Employee currentUser = new Employee();


    private Controller() {}

    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void initDatabase() {
        loadFromFile();
    }

    public void createNewUser(Employee newUser) {
        employeeList.add(newUser);
    }

    public void setCurrentUser(String userName, String password) {
        this.currentUser = getExistingUser(userName, password);

    }

    public void updateAchievements() {
        setWorkoutAchievements();
        setPerfectDayAchievements();
        setGoalWeightAcheivement();
    }

    private void setGoalWeightAcheivement() {
        int mostRecentRecord;

        if(currentUser.getNumFitnessRecords() == 0) {
            mostRecentRecord = 0;
        } else {
            mostRecentRecord = currentUser.getNumFitnessRecords() - 1;
        }

        if(currentUser.getFitnessRecords().get(mostRecentRecord).getWeight() == currentUser.getPersonalrecods().getGoalWeight()) {
            currentUser.getAchievements().setGoalWeightReached(true);
        } else {
            currentUser.getAchievements().setGoalWeightReached(false);
        }

    }

    public void setWorkoutAchievements() {
        int dailyWorkoutCount = 0;

        for(int i = 0; i < currentUser.getNumFitnessRecords() - 1; i++) {
            if(currentUser.getFitnessRecords().get(i).isWorkedOut()) {
                dailyWorkoutCount++;
            }
        }

        if(dailyWorkoutCount >= 10 && dailyWorkoutCount < 20) {
            currentUser.getAchievements().setTenDailyWorkout(true);
        } else if (dailyWorkoutCount >= 20) {
            currentUser.getAchievements().setTwentyDailyWorkout(true);
        }
    }

    public void setPerfectDayAchievements() {

        int perfectDayCount = 0;

        getRecCalories();
        perfectDayCount = getPerfectDayCount();
        setPerfectDays(perfectDayCount);
    }

    /**
     * @param perfectDayCount
     */
    private void setPerfectDays(int perfectDayCount) {
        if(perfectDayCount >= 3 && perfectDayCount < 6) {
            currentUser.getAchievements().setThreePerfectDays(true);
        } else if (perfectDayCount >= 6 && perfectDayCount < 20) {
            currentUser.getAchievements().setSixPerfectDays(true);
        } else if (perfectDayCount >= 20) {
            currentUser.getAchievements().setTwentyPerfectDays(true);
        }
    }

    /**
     *
     */
    private int getRecCalories() {
        int recCals;

        if(currentUser.getPersonalrecods().getGender().equals("Male")) {
            recCals = 2500;
        } else {
            recCals = 1900;
        }

        return recCals;
    }

    /**
     * @param caloriesMet
     * @param workedOut
     * @param greatSleep
     * @param perfectDayCount
     * @return
     */
    private int getPerfectDayCount() {
        boolean caloriesMet;
        boolean workedOut;
        boolean greatSleep;
        int perfectDayCount = 0;

        for(int i = 0; i < currentUser.getNumFitnessRecords() - 1; i++) {
            caloriesMet = false;
            workedOut = false;
            greatSleep = false;

            if(currentUser.getFitnessRecords().get(i).getCalories() <= getRecCalories()) {
                caloriesMet = true;
            }

            if(currentUser.getFitnessRecords().get(i).isWorkedOut()) {
                workedOut = true;
            }

            if(currentUser.getFitnessRecords().get(i).getSleepQuality().equals("Great")) {
                greatSleep = true;
            }

            if(caloriesMet && workedOut && greatSleep) {
                perfectDayCount++;
            }
        }
        return perfectDayCount;
    }

    public void setCurrentUser(Employee curUser) {
        this.currentUser = curUser;
    }

    public Employee getCurrentUser() {
        return this.currentUser;
    }

}

