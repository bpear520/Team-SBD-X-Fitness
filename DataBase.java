import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataBase{
    public ArrayList<Employee> employeeList = new ArrayList<Employee>();

    private int employeeCount = 0;
    public DataBase() {}

    public void loadFromFile() {
        Scanner fileReader;

        try {
            File dataFile = new File("x_fitness_db.txt");
            fileReader = new Scanner(dataFile);

            while(fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String lineFrag[] = currentLine.split(";");
                ArrayList<DailyFitnessRecord> fitnessRecord = new ArrayList<DailyFitnessRecord>();

                PersonalRecord pr = buildPersonalRecord(lineFrag);
                String password = lineFrag[11];
                Achievement newAchievement = buildAcheivements(lineFrag);
                int numFitnessRecords = Integer.parseInt(lineFrag[18]);

                int j = 19; //Fitness records will always start at index 19, add four at the end of the loop to increment to the next fitness record
                for(int i = 0; i < numFitnessRecords; i++) {

                    DailyFitnessRecord newRec = buildFitnessRecord(lineFrag, j);

                    fitnessRecord.add(newRec);
                    j += 5;
                }

                Employee newEmp = new Employee(fitnessRecord, pr, password, newAchievement);
                employeeList.add(newEmp);
            }
            fileReader.close();
        } catch (FileNotFoundException  error )
        {
            System.out.println("File Not Found");
        }
    }

    /**
     * @param lineFrag
     * @param j
     * @return
     */
    private DailyFitnessRecord buildFitnessRecord(String[] lineFrag, int j) {

        String fitnessRec_date = lineFrag[j];
        String fitnessRec_sleepQual = lineFrag[j+1];
        int fitnessRec_cal = Integer.parseInt(lineFrag[j+2]);
        boolean fitnessRec_workedOut = Boolean.parseBoolean(lineFrag[j+3]);
        int fitnessRec_currentWeight = Integer.parseInt(lineFrag[j+4]);

        DailyFitnessRecord newRec = new DailyFitnessRecord(fitnessRec_date, fitnessRec_sleepQual, fitnessRec_cal, fitnessRec_workedOut, fitnessRec_currentWeight);
        return newRec;
    }

    /**
     * @param lineFrag
     * @return
     */
    private Achievement buildAcheivements(String[] lineFrag) {
        boolean tenDailyWorkouts = Boolean.parseBoolean(lineFrag[12]);
        boolean twentyDailyWorkouts = Boolean.parseBoolean(lineFrag[13]);
        boolean threePerfectDays = Boolean.parseBoolean(lineFrag[14]);
        boolean sixPerfectDays = Boolean.parseBoolean(lineFrag[15]);
        boolean twentyPerfectDays = Boolean.parseBoolean(lineFrag[16]);
        boolean goalWeightReached = Boolean.parseBoolean(lineFrag[17]);

        Achievement newAchievement = new Achievement(tenDailyWorkouts, twentyDailyWorkouts, threePerfectDays, sixPerfectDays, twentyPerfectDays, goalWeightReached);
        return newAchievement;
    }

    /**
     * @param lineFrag
     * @return
     */
    private PersonalRecord buildPersonalRecord(String[] lineFrag) {
        String surName = lineFrag[0];
        String firstName = lineFrag[1];
        String otherName = lineFrag[2];
        String gender = lineFrag[3];
        String title = lineFrag[4];
        String DOB = lineFrag[5];
        String department = lineFrag[6];
        int height = Integer.parseInt(lineFrag[7]);
        int weight = Integer.parseInt(lineFrag[8]);
        int goalWeight = Integer.parseInt(lineFrag[9]);
        boolean isAdmin = Boolean.parseBoolean(lineFrag[10]);
        PersonalRecord pr = new PersonalRecord(firstName, surName, otherName, gender, title, DOB, department, height, weight, goalWeight, isAdmin);
        return pr;
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("x_fitness_db1.txt");

            for (int i = 0; i < employeeList.size(); i++) {
                writer.write(employeeList.get(i).formatToFile());
            }
            writer.close();
        } catch (IOException error) {
            System.out.println("problem saving");
        }
    }

    public boolean containsLogIn(String firstName, String password) {
        Employee tempEmp = new Employee();
        boolean match = false;

        System.out.println(employeeList.size());
        for(int i = 0; i < employeeList.size(); i++) {
            tempEmp = employeeList.get(i);
            System.out.println(tempEmp.getPersonalrecods().getFirstName().toString());
            if(userNameMatch(tempEmp, firstName) && passwordMatch(tempEmp, password))
            {
                return true;
            }
        }
        return match;
    }

    public Employee getExistingUser(String userName, String password) {
        Employee tempEmp = new Employee();
        for(int i = 0; i < employeeList.size(); i++) {
            tempEmp = employeeList.get(i);

            if(userNameMatch(tempEmp, userName) && passwordMatch(tempEmp, password))
            {
                return tempEmp;
            }
        }
        return null;
    }

    public Boolean userNameMatch(Employee temp, String userName) {
        return temp.getPersonalrecods().getFirstName().equals(userName);
    }

    public Boolean passwordMatch(Employee temp, String password) {
        return temp.getPassword().equals(password);
    }

    public int getNumberOfEmployees() {
        if(employeeList == null) {
            return 0;
        } else {
            return employeeList.size();
        }

    }


   //*******************GETTERS AND SETTERS*************************//
    /**
     * @return the employeeList
     */
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    /**
     * @param employeeList the employeeList to set
     */
    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    /**
     * @return the employeeCount
     */
    public int getEmployeeCount() {
        return employeeCount;
    }
    /**
     * @param employeeCount the employeeCount to set
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

}
