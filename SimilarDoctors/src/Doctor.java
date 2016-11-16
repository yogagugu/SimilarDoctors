/**
 * Created by Jennifer on 11/16/16.
 */
public class Doctor {
    private String doctorId;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String specialty;
    private int reviewScore;
    private int numOfPatientsPerMonth;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getNumOfPatientsPerMonth() {
        return numOfPatientsPerMonth;
    }

    public void setNumOfPatientsPerMonth(int numOfPatientsPerMonth) {
        this.numOfPatientsPerMonth = numOfPatientsPerMonth;
    }

    public Doctor(String doctorId, String firstName, String lastName, String gender,
                  int age, String specialty, int reviewScore, int numOfPatientsPerMonth) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.specialty = specialty;
        this.reviewScore = reviewScore;
        this.numOfPatientsPerMonth = numOfPatientsPerMonth;
    }
}
