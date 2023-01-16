package many_to_one_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.Bank;
import many_to_one_uni.dto.Branch;

public class BranchMain {

	public static void main(String[] args) {
		Branch branch = new Branch();

		branch.setIfsc("12345");
		branch.setBname("SBINagawara");
		branch.setAddress("Nagawara");
		branch.setManager("Martin");
		branch.setPhone(768979699);

		Branch branch1 = new Branch();

		branch1.setIfsc("123");
		branch1.setBname("SBI Manyata");
		branch1.setAddress("Manyata");
		branch1.setManager("Hudly");
		branch1.setPhone(768965643);

		Branch branch2 = new Branch();

		branch2.setIfsc("98765");
		branch2.setBname("SBI KalyanNagar");
		branch2.setAddress("KalyanNagar");
		branch2.setManager("Raju");
		branch2.setPhone(554643689);

		Bank bank = new Bank();
		bank.setName("SBI");
		bank.setHeadOffice("Delhi");
		bank.setCeo("Dimple");
		
		branch.setBank(bank);
		branch1.setBank(bank);
		branch2.setBank(bank);
		
		
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
 entityTransaction.begin();
 entityManager.persist(bank);
 entityManager.persist(branch);
 entityManager.persist(branch1);
 entityManager.persist(branch2);
 entityTransaction.commit();

	}

}
