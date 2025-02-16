package CourseRegistration;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Registration {
    private Course course;
    private Student student;
    private LocalDateTime localDateTime;

    public Registration(Course course, Student student, LocalDateTime localDateTime) {
        this.course = course;
        this.student = student;
        this.localDateTime = localDateTime;
    }
}
