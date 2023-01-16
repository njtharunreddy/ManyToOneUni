package many_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni.dto.Branch;
import many_to_one_uni.dto.Student;

public class BranchCrud {
	public EntityManager getEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveBranch(Branch branch ) {
		EntityManager entityManager=getEntity();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(branch);
	entityManager.persist(branch.getBank());	
	entityTransaction.commit();
		
	}
	public void updateBranch(int id,Branch branch) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(branch!=null) {
		entityTransaction.begin();
		entityManager.merge(branch);
		entityManager.merge(branch.getBank());	
		entityTransaction.commit();
	}
			}
	public void deleteBranch(int id) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class,id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityManager.remove(branch.getBank());	
			entityTransaction.commit();
		}
	}
	public Branch getByID(int id) {
		EntityManager entityManager=getEntity();
		Branch branch=entityManager.find(Branch.class, id);
		return branch;
	}
	public void getAll(Branch branch) {
		EntityManager entityManager=getEntity();
		Query query=entityManager.createQuery("select e from Branch e");
		  System.out.println(query);
	}

}
