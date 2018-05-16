package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson {

    private String title;
    private int classRoomNumber;
    private Course course;
    private Set<Student> students;
    private int id;
    private Instructor instructor;

    public Lesson() {
    }

    public Lesson(String title, int classRoomNumber, Course course, Instructor instructor) {
        this.title = title;
        this.classRoomNumber = classRoomNumber;
        this.course = course;
        this.students = new HashSet<Student>();
        this.instructor = instructor;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "class_room_number")
    public int getClassRoomNumber() {
        return classRoomNumber;
    }

    public void setClassRoomNumber(int classRoomNumber) {
        this.classRoomNumber = classRoomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_lesson",
            inverseJoinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn (name = "lesson_id", nullable = false , updatable = false)})
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }

}
