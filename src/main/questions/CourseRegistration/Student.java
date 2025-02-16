package CourseRegistration;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Student {
    private String id;
    private String name;
    private List<String> courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        courses=new ArrayList<>();
    }

}
