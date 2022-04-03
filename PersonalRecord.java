
public class PersonalRecord {

    private String firstName;
    private String surName;
	private String otherName;
	private String gender;
	private String title;
	private String	DOB;
	private String department;
	private int height;
	private int weight;
	private int goalWeight;
	private boolean isAdmin;
	public PersonalRecord(String firstName, String surName, String otherName, String gender, String title, String dOB, String department,
			int height, int weight, int goalWeight, boolean isAdmin) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.setOtherName(otherName);
		this.gender = gender;
		this.title = title;
		this.DOB = dOB;
		this.department = department;
		this.height = height;
		this.weight = weight;
		this.goalWeight = goalWeight;
		this.isAdmin = isAdmin;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getGoalWeight() {
		return goalWeight;
	}
	public void setGoalWeight(int goalWeight) {
		this.goalWeight = goalWeight;
	}
    /**
     * @return the otherName
     */
    public String getOtherName() {
        return otherName;
    }
    /**
     * @param otherName the otherName to set
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
    /**
     * @return the isAdmin
     */
    public boolean isAdmin() {
        return isAdmin;
    }
    /**
     * @param isAdmin the isAdmin to set
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String formatToFile() {
        String toFile = surName.toString().trim() + ";" +
                firstName.toString().trim() + ";" +
                otherName.toString().trim() + ";" +
                gender.toString().trim() + ";" +
                title.toString().trim() + ";" +
                DOB.toString().trim() + ";" +
                department.toString().trim() + ";" +
                height + ";" +
                weight + ";" +
                goalWeight + ";" +
                isAdmin + ";";

        return toFile;
    }
}
