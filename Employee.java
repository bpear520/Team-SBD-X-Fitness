import java.util.ArrayList;

public class Employee {
    private ArrayList<DailyFitnessRecord> dailyFitnessRecords = new ArrayList<DailyFitnessRecord>() ;
    private int numFitnessRecords = dailyFitnessRecords.size();
    private PersonalRecord personalrecods;
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
     * @return the personalrecods
     */
    public PersonalRecord getPersonalrecods() {
        return personalrecods;
    }

    /**
     * @param personalrecods the personalrecods to set
     */
    public void setPersonalrecods(PersonalRecord personalrecods) {
        this.personalrecods = personalrecods;
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
        return numFitnessRecords;
    }

    /**
     * @param numFitnessRecords the numFitnessRecords to set
     */
    public void setNumFitnessRecords(int numFitnessRecords) {
        this.numFitnessRecords = numFitnessRecords;
    }




}
