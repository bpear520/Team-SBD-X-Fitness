
public class Display {



    private mainMenu menuScreen;
    private newUser newUserScreen;
    private loginMenu loginScreen;

    public void displayData() {}
    public void displayNextWeek() {}
    public void displayPrevWeek() {}
    public void getDailyFitnessRecord() {}
    public void getPersonalRecord() {}
    public void displayEmployeeList() {}
    public void displayReport() {}





    public void displayNewUser() {
        newUserScreen = new newUser();
    }

    public void displayLogin() {
        loginScreen = new loginMenu();
    }

    public void displayMainMenu() {
        menuScreen = new mainMenu();
    }

    /**
     * @return the menu
     */
    public mainMenu getMenu() {
        return menuScreen;
    }
    /**
     * @param menu the menu to set
     */
    public void setMenu(mainMenu menu) {
        this.menuScreen = menu;
    }
    /**
     * @return the newUser
     */
    public newUser getNewUser() {
        return newUserScreen;
    }
    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(newUser newUser) {
        this.newUserScreen = newUser;
    }


}
