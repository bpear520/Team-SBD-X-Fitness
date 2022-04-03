import java.util.ArrayList;

public class Employee {
    private ArrayList<DailyFitnessRecord> dailyFitnessRecords = new ArrayList<DailyFitnessRecord>() ;
    private int numFitnessRecords;
    private PersonalRecord personalRecord;
    private Achievement achievements;
    private String password;


    public Employee(ArrayList<DailyFitnessRecord> fitnessRecord, PersonalRecord personalrecods, Achievement achievements, String password) {
        super();
        this.setFitnessRecord(fitnessRecord);
        this.setPersonalrecods(personalrecods);
        this.setAchievements(achievements);
        this.setPassword(password);

    }

    public Employee(ArrayList<DailyFitnessRecord> fitnessRecord, PersonalRecord personalrecods, String password) {
        super();
        this.setFitnessRecord(fitnessRecord);
        this.setPersonalrecods(personalrecods);
        this.setPassword(password);

    }

    public Employee() {}

    private void setFitnessRecord(ArrayList<DailyFitnessRecord> fitnessRecord) {
        this.dailyFitnessRecords = fitnessRecord;

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

    public void saveInfo() {}
    public void viewNextWeek() {}
    public void viewPreviousWeek() {}
    public void login(String username, String password) {}

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
}
