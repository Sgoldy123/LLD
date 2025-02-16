package CourseRegistration;

import java.time.LocalDateTime;
import java.util.*;

public class CourseRegisterationSystem {

    private Map<String,Course> courseMap;
    private StudentManager studentManager=StudentManager.getStudentManager();
    private static CourseRegisterationSystem courseRegisterationSystem =new CourseRegisterationSystem();
    private List<Registration> registrations;
    private CourseRegisterationSystem() {
        this.courseMap = new HashMap<>();
        this.registrations=new ArrayList<>();
    }


    public Map<String,Course> getCourseMap(){
        return  courseMap;
    }
    public static CourseRegisterationSystem getCourseManager(){
        return courseRegisterationSystem;
    }

    public synchronized void enrollCourse(String courseCode,String studentId){
        try
        {
            Course course=courseMap.get(courseCode);
            if(course.getCurrCapacity()>=course.getEnrollCapacity()){
                throw new IllegalArgumentException("Course capacity is full");
            }

            course.setCurrCapacity(course.getCurrCapacity()+1);
            Student student=studentManager.getStudentMap().get(studentId);
            student.getCourses().add(courseCode);
            registrations.add(new Registration(course,student, LocalDateTime.now()));
        }
        catch (IllegalArgumentException e){
            System.out.println("error: "+e.getMessage());
        }
        catch (Exception e){
            System.out.println("unexpected error: "+e.getMessage());
        }

    }

    public void searchCourse(String code){
        System.out.println("Course Name: "+courseMap.get(code).getName());
    }

}
