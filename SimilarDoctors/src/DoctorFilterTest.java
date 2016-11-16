import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jennifer on 11/16/16.
 */
public class DoctorFilterTest {
    /*
     *  test filter result is right, will filter out results of same ID, different gender & specialty,
     *  and sort order will be reviewScore > age > numOfPatientsPerMonth
     */
    @Test
    public static void testFilterResult() {
        Doctor testDoctor = new Doctor("17233", "Yale", "Jay", "male", 29, "Acupuncture", 83, 150);
        List<Doctor> doctors = Arrays.asList(
                new Doctor("17233", "Yale", "Jay", "male", 29, "Acupuncture", 83, 150),
                new Doctor("17210", "James", "Jones", "male", 30, "Acupuncture", 84, 150),
                new Doctor("17211", "Helen", "Sun", "female", 35, "Neurology", 85, 250),
                new Doctor("17212", "Quyen", "Easterly", "male", 40, "Acupuncture", 90, 100),
                new Doctor("17213", "Chu", "Christner", "male", 25, "Acupuncture", 90, 100),
                new Doctor("17214", "June", "Gilford", "male", 31, "Neurology", 60, 67),
                new Doctor("17215", "Neil", "Wemple", "female", 28, "Cardiology", 65, 333),
                new Doctor("17216", "Margeret", "Thon", "female", 53, "Acupuncture", 83, 234),
                new Doctor("17217", "Jane", "Foo", "male", 43, "Optometry", 40, 432),
                new Doctor("17218", "Loni", "Chain", "male", 37, "Dentistry", 90, 789),
                new Doctor("17219", "Nida", "Fu", "male", 32, "Cardiology", 88, 645),
                new Doctor("17220", "Zoo", "Tama", "female", 39, "Neurology", 95, 286),
                new Doctor("17221", "Qun", "Westhill", "male", 40, "Acupuncture", 86, 100)
        );
        DoctorFilter df = new DoctorFilter(doctors);
        List<Doctor> resultDoctors = df.findSimilarDoctors(testDoctor);
        df.printResultList();
        assertTrue(resultDoctors.get(0).getDoctorId().equals("17210"));
        //1st priority: reviewScore
        assertTrue(resultDoctors.get(1).getDoctorId().equals("17221"));
        //2nd priority: age
        assertTrue(resultDoctors.get(2).getDoctorId().equals("17213"));
        //3nd priority: number of patients per month
        assertTrue(resultDoctors.get(3).getDoctorId().equals("17212"));
    }

    /*
     *  results with size larger than limit(5) will be truncated
     */
    @Test
    public static void testResultOverSize() {
        Doctor testDoctor = new Doctor("17233", "Yale", "Jay", "male", 29, "Acupuncture", 83, 150);
        List<Doctor> doctors = Arrays.asList(
                new Doctor("17233", "Yale", "Jay", "male", 29, "Acupuncture", 83, 150),
                new Doctor("17210", "James", "Jones", "male", 30, "Acupuncture", 84, 150),
                new Doctor("17211", "Helen", "Sun", "female", 35, "Neurology", 85, 250),
                new Doctor("17212", "Quyen", "Easterly", "male", 40, "Acupuncture", 90, 100),
                new Doctor("17213", "Chu", "Christner", "male", 25, "Acupuncture", 90, 100),
                new Doctor("17214", "June", "Gilford", "male", 31, "Neurology", 60, 67),
                new Doctor("17215", "Neil", "Wemple", "female", 28, "Cardiology", 65, 333),
                new Doctor("17216", "Margeret", "Thon", "female", 53, "Acupuncture", 83, 234),
                new Doctor("17217", "Jane", "Foo", "male", 43, "Optometry", 40, 432),
                new Doctor("17218", "Loni", "Chain", "male", 37, "Dentistry", 90, 789),
                new Doctor("17219", "Nida", "Fu", "male", 32, "Cardiology", 88, 645),
                new Doctor("17220", "Zoo", "Tama", "female", 39, "Neurology", 95, 286),
                new Doctor("17221", "Qun", "Westhill", "male", 40, "Acupuncture", 86, 100),
                new Doctor("17222", "Jay", "Zhou", "male", 45, "Acupuncture", 76, 130),
                new Doctor("17223", "Trun", "Hilla", "male", 33, "Acupuncture", 80, 100)
        );
        DoctorFilter df = new DoctorFilter(doctors);
        List<Doctor> resultDoctors = df.findSimilarDoctors(testDoctor);
        df.printResultList();
        assertTrue(resultDoctors.size() == 5);
    }

    /*
     *  no match results will return empty List
     */
    @Test
    public static void testResultEmpty() {
        Doctor testDoctor1 = new Doctor("17233", "Yale", "Jay", "male", 29, "Pain Medicine", 83, 150);
        Doctor testDoctor2 = new Doctor("17233", "Yale", "Jay", "female", 29, "Acupuncture", 83, 150);
        Doctor testDoctor3 = new Doctor("17215", "Neil", "Wemple", "female", 28, "Pain", 65, 333);
        List<Doctor> doctors = Arrays.asList(
                new Doctor("17233", "Yale", "Jay", "male", 29, "Acupuncture", 83, 150),
                new Doctor("17210", "James", "Jones", "male", 30, "Acupuncture", 84, 150),
                new Doctor("17211", "Helen", "Sun", "female", 35, "Neurology", 85, 250),
                new Doctor("17212", "Quyen", "Easterly", "male", 40, "Acupuncture", 90, 100),
                new Doctor("17213", "Chu", "Christner", "male", 25, "Acupuncture", 90, 100),
                new Doctor("17214", "June", "Gilford", "male", 31, "Neurology", 60, 67),
                new Doctor("17215", "Neil", "Wemple", "female", 28, "Pain", 65, 333),
                new Doctor("17217", "Jane", "Foo", "male", 43, "Optometry", 40, 432),
                new Doctor("17218", "Loni", "Chain", "male", 37, "Dentistry", 90, 789),
                new Doctor("17219", "Nida", "Fu", "male", 32, "Cardiology", 88, 645),
                new Doctor("17220", "Zoo", "Tama", "female", 39, "Neurology", 95, 286),
                new Doctor("17221", "Qun", "Westhill", "male", 40, "Acupuncture", 86, 100),
                new Doctor("17222", "Jay", "Zhou", "male", 45, "Acupuncture", 76, 130),
                new Doctor("17223", "Trun", "Hilla", "male", 33, "Acupuncture", 80, 100)
        );
        DoctorFilter df = new DoctorFilter(doctors);
        //no match specialty
        List<Doctor> resultDoctors1 = df.findSimilarDoctors(testDoctor1);
        df.printResultList();
        //no match gender
        List<Doctor> resultDoctors2 = df.findSimilarDoctors(testDoctor2);
        df.printResultList();
        //only match has same id
        List<Doctor> resultDoctors3 = df.findSimilarDoctors(testDoctor2);
        df.printResultList();
        assertTrue(resultDoctors1.size() == 0 && resultDoctors2.size() == 0 && resultDoctors3.size() == 0);
    }




    public static void main(String args[]) {
        DoctorFilterTest.testFilterResult();
        DoctorFilterTest.testResultOverSize();
        DoctorFilterTest.testResultEmpty();
    }

}