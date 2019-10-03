package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.billInfo;

public class BillinfoHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetsDatabase");

	public void insertBill(billInfo b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	public List<billInfo> getBills() {
		EntityManager em = emfactory.createEntityManager();
		List<billInfo> allBills = em.createQuery("SELECT b FROM billInfo b").getResultList();
		return allBills;
	}

	public billInfo searchForListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		billInfo found = em.find(billInfo.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(billInfo listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<billInfo> typedQuery = em.createQuery("select d from ListDetails d where d.id = :selectedid",
				billInfo.class);
		typedQuery.setParameter("selectedid", listToDelete.getId());
		typedQuery.setMaxResults(1);

		billInfo result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public void updateList(billInfo toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
