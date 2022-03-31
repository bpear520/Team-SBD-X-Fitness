
public class PersonalRecord {

	private String surName;
	private String firstName;
	private String otherName;
	private String gender;
	private String title;
	private int	DOB;
	private String department;
	private int height;
	private int weight;
	private int goalWeight;
	public PersonalRecord(String surName, String firstName, String otherName, String gender, String title, int dOB, String department,
			int height, int weight, int goalWeight) {
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.setOtherName(otherName);
		this.gender = gender;
		this.title = title;
		DOB = dOB;
		this.department = department;
		this.height = height;
		this.weight = weight;
		this.goalWeight = goalWeight;
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
	public int getDOB() {
		return DOB;
	}
	public void setDOB(int dOB) {
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




}
