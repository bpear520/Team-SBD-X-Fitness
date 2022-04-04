import java.util.ArrayList;

public class Employee {
    private ArrayList<DailyFitnessRecord> dailyFitnessRecords;
    private int numFitnessRecords;
    private PersonalRecord personalRecord;
    private Achievement achievements;
    private String password;


    public Employee(ArrayList<DailyFitnessRecord> fitnessRecord, PersonalRecord personalrecods, Achievement achievements, String password) {

        this.setFitnessRecord(fitnessRecord);
        this.setPersonalrecods(personalrecods);
        this.setAchievements(achievements);
        this.setPassword(password);

    }

    public Employee(ArrayList<DailyFitnessRecord> fitnessRecord, PersonalRecord personalrecods, String password) {

        this.setFitnessRecord(fitnessRecord);
        this.setPersonalrecods(personalrecods);
        this.setPassword(password);
    }

    public Employee() {}

    public void setFitnessRecord(ArrayList<DailyFitnessRecord> fitnessRecord) {
        if(fitnessRecord == null) {
            dailyFitnessRecords = new ArrayList<DailyFitnessRecord>();
        } else {
            this.dailyFitnessRecords = fitnessRecord;
        }


    }

    public Employee(PersonalRecord personalrecods2, String password) {
        this.setPersonalrecods(personalrecods2);
        this.setPassword(password);
    }

    public void viewRecords() {

    }

    public PersonalRecord inputPersonalRecord() {
        return null;
    }

    public DailyFitnessRecord inputDailyFitnessRecord() {
        return null;
    }


    public ArrayList<DailyFitnessRecord> getFitnessRecords(){
        return this.dailyFitnessRecords;
    }

    /**
     * @return the personalRecords
     */
    public PersonalRecord getPersonalrecods() {
        return personalRecord;
    }

    /**
     * @param personalrecods the personalRecords to set
     */
    public void setPersonalrecods(PersonalRecord personalrecods) {
        this.personalRecord = personalrecods;
    }

    /**
     * @return the achievements
     */
    public Achievement getAchievements() {
        return achievements;
    }

    /**
     * @param achievements the achievements to set
     */
    public void setAchievements(Achievement achievements) {
        this.achievements = achievements;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password2 the password to set
     */
    public void setPassword(String password2) {
        this.password = password2;
    }

    /**
     * @return the numFitnessRecords
     */
    public int getNumFitnessRecords() {
        setNumFitnessRecords();
        return numFitnessRecords;
    }

    /**
     * @param numFitnessRecords the numFitnessRecords to set
     */
    public void setNumFitnessRecords() {

        if(dailyFitnessRecords == null) {
            this.numFitnessRecords = 0;
        } else {
            this.numFitnessRecords = dailyFitnessRecords.size();
        }

    }

    public String formatToFile() {
        String toFile;
        setNumFitnessRecords();
        toFile = personalRecord.formatToFile() +
                 numFitnessRecords + ";";
        for(int i = 0; i < numFitnessRecords; i++) {
            toFile = toFile +  dailyFitnessRecords.get(i).formatToFile();
        }
        toFile += password + ";\n";
        return toFile;
    }

    public int getAverageCalories() {
        if(numFitnessRecords == 0) {
            return 0;
        }

        int averageCalories = 0;

        for(int i = 0; i < numFitnessRecords - 1; i++)
            averageCalories += dailyFitnessRecords.get(i).getCalories();


        averageCalories = averageCalories/numFitnessRecords;

        return averageCalories;
    }

    public int getNumTimesWorkedOut() {
        if(numFitnessRecords == 0) {
            return 0;
        }

        int numTimesWorkedOut = 0;

        for(int i = 0; i < numFitnessRecords - 1; i++) {
            if(dailyFitnessRecords.get(i).isWorkedOut())
                numTimesWorkedOut++;
        }

        return numTimesWorkedOut;
    }

    public String getAverageSleepQuality() {
       setNumFitnessRecords();

        if(numFitnessRecords == 0) {
            return "No Records yet";
        }

        String sleepQual;
        double sleepNum = 0;
        String rtnSleepQual = null;

        for(int i = 0; i < numFitnessRecords - 1; i++) {
            sleepQual = dailyFitnessRecords.get(i).getSleepQuality();

            switch(sleepQual) {
                case "Poor": sleepNum += 1;
                    break;
                case "Okay": sleepNum += 2;
                    break;
                case "Great": sleepNum += 3;
                    break;
            }
        }
        sleepNum = sleepNum/numFitnessRecords;

        int roundedSleepNum;

        if(sleepNum > 0 && sleepNum < 1) {
            roundedSleepNum = (int) Math.ceil(sleepNum);
        } else if (sleepNum > 3) {
            roundedSleepNum = (int) Math.floor(sleepNum);
        } else {
            roundedSleepNum = (int) Math.rint(sleepNum);
        }





        switch(roundedSleepNum) {
            case 1: rtnSleepQual = "Poor";
                break;
            case 2: rtnSleepQual = "Okay";
                break;
            case 3: rtnSleepQual = "Great";
                break;
        }

        return rtnSleepQual;
    }
}
