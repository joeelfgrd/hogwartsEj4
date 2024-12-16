package edu.badpals.hogwarts;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "HousePoint.FindMaxPoints",
        query = "select receiver ,SUM(h.points ) from HousePoint h group by h.receiver ORDER BY SUM(h.points) DESC limit 1")
@Table(name = "house_points", schema = "hogwarts")
public class HousePoint {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver")
    private edu.badpals.hogwarts.Person giver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver")
    private edu.badpals.hogwarts.Person receiver;

    @Column(name = "points")
    private Integer points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public edu.badpals.hogwarts.Person getGiver() {
        return giver;
    }

    public void setGiver(edu.badpals.hogwarts.Person giver) {
        this.giver = giver;
    }

    public edu.badpals.hogwarts.Person getReceiver() {
        return receiver;
    }

    public void setReceiver(edu.badpals.hogwarts.Person receiver) {
        this.receiver = receiver;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}