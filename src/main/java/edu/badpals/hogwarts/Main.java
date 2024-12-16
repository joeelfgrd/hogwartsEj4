package edu.badpals.hogwarts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();

        try{

            entityManager.getTransaction().begin();
            Long teacherId= 81L;
            String jpql =
                    """ 
                    SELECT p.firstName 
                    FROM Person p 
                    JOIN Enrollment e ON p.id = e.personEnrollment.id
                    JOIN Course c ON e.courseEnrollment.id = c.id
                    WHERE c.teacher.id = :teacherId
                    """;


            TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
            query.setParameter("teacherId", teacherId);
            List<String> nombres = query.getResultList();
            System.out.println("Alumnos del profesor con ID " + teacherId + ":");
            for (String nombre : nombres) {
                System.out.println(nombre);
            }
            entityManager.getTransaction().commit()






            TypedQuery<HousePoint> query2 = entityManager.createNamedQuery("HousePoint.FindMaxPoints", HousePoint.class);
            List<HousePoint> MaxHousePoints = query2.getResultList();
            System.out.println("Alumno con mas puntos recibidos:");
            for (String  : nombres) {
                System.out.println(nombre);
            }
            ;
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }


}

