package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "instuctors")
public class Instructor {
    private String name;
    private Set<Lesson> lessons;
    private int id;

    public Instructor() {
    }

    public Instructor(String name) {
        this.name = name;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "instructor")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
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
}
