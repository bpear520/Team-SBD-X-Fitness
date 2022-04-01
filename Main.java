public class Main {

    private static Controller controller;
    private static Display display = new Display();


    public static void main(String[] args) {

        controller = Controller.getInstance();

        controller.initDatabase();
        display.displayLogin();


    }
}
