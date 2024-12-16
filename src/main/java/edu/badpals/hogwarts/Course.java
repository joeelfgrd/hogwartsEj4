package edu.badpals.hogwarts;

import jakarta.persistence.*;

@Entity
@Table(name = "course", schema = "hogwarts")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private edu.badpals.hogwarts.Person teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public edu.badpals.hogwarts.Person getTeacher() {
        return teacher;
    }

    public void setTeacher(edu.badpals.hogwarts.Person teacher) {
        this.teacher = teacher;
    }

}