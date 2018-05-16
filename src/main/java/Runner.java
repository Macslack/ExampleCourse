import db.*;
import models.*;

import java.util.Date;
import java.util.List;

public class Runner {

     public static void main(String[] args) {


         Date startDate = new Date(2018,5,16);
         Date endDate = new Date(2019,5,16);
        Course course = new Course("testCourse", CourseLevel.BENG, startDate, endDate);
        Instructor instructor = new Instructor("testInstructor");
        Student student = new Student("testStudent1", 100, 10, course);
        Student student2 = new Student ("testStudent2", 200, 20, course);
        Lesson lesson = new Lesson("testLesson", 25, course, instructor );
        Lesson lesson2 = new Lesson("testLesson2", 30, course, instructor);
        DBHelper.save(course);

        DBHelper.save(instructor);
        DBHelper.save(student);
        DBHelper.save(student2);
        DBHelper.save(lesson);
        DBHelper.save(lesson2);
        List<Student> students = DBHelper.getAll(Student.class);
        List<Lesson> lessons = DBHelper.getAll(Lesson.class);
         Course courseFound = DBHelper.find(Course.class,course.getId());

         DBHelper.addStudentToLesson(student, lesson);
         DBHelper.addStudentToLesson(student2, lesson);

         List<Lesson> lessonsList = DBStudent.getLessonsForStudent(student2);
         List<Student> studentlist = DBLesson.getStudentsForLesson(lesson);

         DBHelper.delete(student);

         List<Student> students1 = DBCourse.getStudents(course);
         List<Lesson> lessons2 = DBCourse.getLessons(course);
         List<Lesson> lessons3 = DBInstructor.getLessons(instructor);





    }
}
