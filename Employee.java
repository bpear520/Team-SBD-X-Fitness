public class Employee {
    private DailyFitnessRecord fitnessRecord;
    private PersonalRecord personalrecods;
    private Achievement achievements;
    private String password;


    public Employee(DailyFitnessRecord fitnessRecord, PersonalRecord personalrecods, Achievement achievements, String password) {
        super();
        this.setFitnessRecord(fitnessRecord);
        this.setPersonalrecods(personalrecods);
        this.setAchievements(achievements);
        this.setPassword(password);

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

    /**
     * @return the fitnessRecord
     */
    public DailyFitnessRecord getFitnessRecord() {
        return fitnessRecord;
    }

    /**
     * @param fitnessRecord the fitnessRecord to set
     */
    public void setFitnessRecord(DailyFitnessRecord fitnessRecord) {
        this.fitnessRecord = fitnessRecord;
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }




}
