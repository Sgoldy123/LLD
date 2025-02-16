package CourseRegistration;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String code;
    private String name;
    private String instructor;
    private Integer enrollCapacity;
    private Integer currCapacity;

    public Course(String code, String name, String instructor, Integer enrollCapacity) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
        this.enrollCapacity = enrollCapacity;
        this.currCapacity=0;
    }
}
