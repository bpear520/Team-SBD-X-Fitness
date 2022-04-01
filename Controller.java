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
        System.out.println(employeeList.size());
    }

    public void setCurrentUser(String userName, String password) {
        this.currentUser = getExistingUser(userName, password);

    }

    public int calculateCalorieCount()
    {

        return 0;
    }
    public void sortData()
    {

    }
    public void notifyAchievement()
    {

    }

    public void setCurrentUser(Employee curUser) {
        this.currentUser = curUser;
    }

    public Employee getCurrentUser() {
        return this.currentUser;
    }

}

