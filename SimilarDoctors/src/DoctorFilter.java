/**
 * Created by Jennifer on 11/16/16.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoctorFilter {
    private List<Doctor> doctorList;
    private List<Doctor> resultList;
    final int MAX_RESULT_SIZE = 5;

    public DoctorFilter(List<Doctor> doctorList) {
        this.doctorList = doctorList;
        this.resultList = new ArrayList<Doctor>();
    }


    /*
     *  only numOfPatientsPerMonth, age and reviewScore can be sorted, assume the priority is
     *  reviewScore > age > numOfPatients
     */

    private class DoctorCompare implements Comparator<Doctor> {
        Doctor currentDoctor;

        public DoctorCompare(Doctor doctor) {
            currentDoctor = doctor;
        }

        @Override
        public int compare(Doctor d1, Doctor d2) {
            int diffNumOfPatients1 = Math.abs(currentDoctor.getNumOfPatientsPerMonth() - d1.getNumOfPatientsPerMonth());
            int diffNumOfPatients2 = Math.abs(currentDoctor.getNumOfPatientsPerMonth() - d2.getNumOfPatientsPerMonth());
            int diffAge1 = Math.abs(currentDoctor.getAge() - d1.getAge());
            int diffAge2 = Math.abs(currentDoctor.getAge() - d2.getAge());
            int diffReviewScore1 = Math.abs(currentDoctor.getReviewScore() - d1.getReviewScore());
            int diffReviewScore2 = Math.abs(currentDoctor.getReviewScore() - d2.getReviewScore());

            if (diffReviewScore1 < diffReviewScore2) {
                return -1;
            } else if (diffReviewScore1 > diffReviewScore2) {
                return 1;
            } else {
                if (diffAge1 < diffAge2) {
                    return -1;
                } else if (diffAge1 > diffAge2) {
                    return 1;
                } else {
                    if (diffNumOfPatients1 < diffNumOfPatients2) {
                        return -1;
                    } else if (diffNumOfPatients1 > diffNumOfPatients2) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    }

    /*
     *  Gender and Specialty are not sortable, so if either of those two fields are not equal to
     *  the given doctor's field value, we just remove current doctor from doctor list. doctorId
     *  is not comparable, but if doctorId is same to the given doctor's ID, represents same doctor,
     *  we also remove current doctor
     */

    private void filterByUnsortableFields(Doctor currentDoctor) {
        for (Doctor doctor : doctorList) {
            if (currentDoctor.getGender().equals(doctor.getGender()) &&
                    currentDoctor.getSpecialty().equals(doctor.getSpecialty()) &&
                    !currentDoctor.getDoctorId().equals(doctor.getDoctorId())) {
                resultList.add(doctor);
            }
        }
    }


    public List<Doctor> findSimilarDoctors(Doctor currentDoctor) {
        resultList = new ArrayList<Doctor>();
        filterByUnsortableFields(currentDoctor);
        Collections.sort(resultList, new DoctorCompare(currentDoctor));
        resultList = resultList.size() > MAX_RESULT_SIZE? resultList.subList(0, MAX_RESULT_SIZE) : resultList;
        return resultList;
    }

    public void printResultList() {
        System.out.println("--------------Result Doctors--------------");
        for (Doctor doctor : resultList) {
            System.out.print(doctor.getDoctorId() + " ");
            System.out.print(doctor.getLastName() + " ");
            System.out.print(doctor.getFirstName() + " ");
            System.out.print(doctor.getAge() + " ");
            System.out.print(doctor.getGender() + " ");
            System.out.print(doctor.getSpecialty() + " ");
            System.out.print(doctor.getReviewScore() + " ");
            System.out.print(doctor.getNumOfPatientsPerMonth() + " ");
            System.out.print("\n");
        }
        System.out.println("");
    }
}
