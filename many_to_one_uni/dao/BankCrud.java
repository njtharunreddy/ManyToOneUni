package many_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.Bank;
import many_to_one_uni.dto.Branch;

public class BankCrud {
	public EntityManager getEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveBank(Bank bank ) {
		EntityManager entityManager=getEntity();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(bank);	
	entityTransaction.commit();
		
	}
	public void updateBank(int id,Bank bank) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(bank!=null) {
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
	}
			}
}
