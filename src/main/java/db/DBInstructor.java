package db;

import models.Instructor;
import models.Lesson;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBInstructor {

    private static Session session;

    public static List<Lesson> getLessons(Instructor instructor){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessonList = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("instructor", instructor));
            lessonList = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lessonList;
    }
}
