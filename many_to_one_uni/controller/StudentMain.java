package many_to_one_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.School;
import many_to_one_uni.dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Siraj");
		student.setAddress("BLR");

		Student student1 = new Student();
		student1.setName("Siraj");
		student1.setAddress("BLR");
		
		Student student2 = new Student();
		student2.setName("Siraj");
		student2.setAddress("BLR");
		
		
		
		
		School school=new School();
		school.setName("SVN");
		school.setFees(10000);
		school.setLocation("Nagawara");
	
		student.setSchool(school);
		
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(school);
		entityManager.persist(student);
		entityManager.persist(student1); 
		entityManager.persist(student1);
		entityTransaction.commit();

	}

}
