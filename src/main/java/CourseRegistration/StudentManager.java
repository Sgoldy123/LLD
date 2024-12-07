package CourseRegistration;
import java.util.*;
public class StudentManager {
    Map<String,Student> studentMap;

    private static StudentManager studentManager=new StudentManager();
    private CourseRegisterationSystem courseRegisterationSystem = CourseRegisterationSystem.getCourseManager();
    public  static StudentManager getStudentManager(){
        return studentManager;
    }

    private StudentManager() {
        this.studentMap = new HashMap<>();
    }

    public Map<String,Student> getStudentMap(){
        return studentMap;
    }

    public void ListOfCourseEnrolledByStudent(String studentId){
        for(String courseCode: studentMap.get(studentId).getCourses()){
            System.out.println(courseRegisterationSystem.getCourseMap().get(courseCode).getName());
        }
    }
}
