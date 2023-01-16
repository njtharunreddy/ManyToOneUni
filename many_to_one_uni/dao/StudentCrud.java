package many_to_one_uni.dao;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni.dto.Student;

public class StudentCrud {
	public EntityManager getEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveStudent(Student student ) {
		EntityManager entityManager=getEntity();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityManager.persist(student.getSchool());	
	entityTransaction.commit();
		
	}
	public void updateStudent(int id,Student student) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(student!=null) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityManager.merge(student.getSchool());	
		entityTransaction.commit();
	}
	}
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntity();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Student student=entityManager.find(Student.class, id);
		if(student!=null) {
		entityTransaction.begin();
		entityManager.remove(student);
		entityManager.remove(student.getSchool());	
		entityTransaction.commit();
	}
		
			
			
		}
	public Student getById(int id) {
		EntityManager entityManager=getEntity();
		Student student=entityManager.find(Student.class, id);
		return student;
	}
	public void getByAll(Student student) {
		EntityManager entityManager=getEntity();
		Query query=entityManager.createQuery("select e from Student e");
	  System.out.println(query);
	}
}
