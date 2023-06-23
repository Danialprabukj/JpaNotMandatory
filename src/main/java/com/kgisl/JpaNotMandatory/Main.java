package com.kgisl.JpaNotMandatory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setAdditionalInfo("Additional information");

        // Save student in the database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(student);
        tx.commit();

        // Retrieve student from the database
        Student retrievedStudent = em.find(Student.class, student.getId());

        // Display the retrieved student
        System.out.println("Student ID: " + retrievedStudent.getId());
        System.out.println("Student Name: " + retrievedStudent.getName());

        // The additionalInfo field will not be persisted in the database
        System.out.println("Additional Info: " + retrievedStudent.getAdditionalInfo());

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}