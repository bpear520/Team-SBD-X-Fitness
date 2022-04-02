import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataBase{
    public ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private ArrayList<DailyFitnessRecord> fitnessRecord = new ArrayList<DailyFitnessRecord>();
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
                int numFitnessRecords = Integer.parseInt(lineFrag[11]);

                int j = 12; //Fitness records will always start at index 12, add four at the end of the loop to increment to the next fitness record
                for(int i = 0; i < numFitnessRecords; i++) {

                    String fitnessRec_date = lineFrag[j];
                    int fitnessRec_sleepQual = Integer.parseInt(lineFrag[j+1]);
                    int fitnessRec_cal = Integer.parseInt(lineFrag[j+2]);
                    boolean fitnessRec_workedOut = Boolean.parseBoolean(lineFrag[j+3]);

                    DailyFitnessRecord newRec = new DailyFitnessRecord(fitnessRec_date, fitnessRec_sleepQual, fitnessRec_cal, fitnessRec_workedOut);
                    fitnessRecord.add(newRec);
                    j += 4;
                }
                String password = lineFrag[20];

                PersonalRecord pr = new PersonalRecord(firstName, surName, otherName, gender, title, DOB, department, height, weight, goalWeight, isAdmin);
                if(isAdmin) {
                    Administrator newAdmin = new Administrator(fitnessRecord, pr, password);
                    employeeList.add(newAdmin);
                } else {
                    Employee newEmp = new Employee(fitnessRecord, pr, password);
                    employeeList.add(newEmp);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException  error )
        {
            System.out.println("File Not Found");
        }

        System.out.println(employeeList.size());
    }

    public boolean writeToFile() {
        try {
            FileWriter writer = new FileWriter("x_fitness_db1.txt");

            for (int i = 0; i < employeeList.size(); i++) {
                writer.write(employeeList.get(i).formatToFile());
            }
            writer.close();
            return true;
        } catch (IOException error) {
            return false;
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
