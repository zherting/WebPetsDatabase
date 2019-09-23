package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TableOwnerinfo;

public class OwnerinfoHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetsDatabase");

	public void insertItem(TableOwnerinfo Oi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(Oi);
		em.getTransaction().commit();
		em.close();
	}

	public List<TableOwnerinfo> showAllOwnerinfo() {
		EntityManager em = emfactory.createEntityManager();
		List<TableOwnerinfo> allOwnerinfo = em.createQuery("SELECT i FROM TableOwnerinfo i").getResultList();
		return allOwnerinfo;
	}

	public void deleteItem(TableOwnerinfo toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TableOwnerinfo> typedQuery = em.createQuery(
				"select oi from TableOwnerinfo oi where oi.type = :selectedType and oi.name = :selectedName and oi.owner = :selectedOwner",
				TableOwnerinfo.class);

		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());

		typedQuery.setMaxResults(1);

		TableOwnerinfo result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public List<TableOwnerinfo> searchForItemByType(String typeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TableOwnerinfo> typedQuery = em
				.createQuery("select oi from TableOwnerinfo oi where oi.type = :selectedType", TableOwnerinfo.class);
		typedQuery.setParameter("selectedType", typeName);

		List<TableOwnerinfo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<TableOwnerinfo> searchForItemByName(String petName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TableOwnerinfo> typedQuery = em
				.createQuery("select oi from TableOwnerinfo oi where oi.name = :selectedName", TableOwnerinfo.class);
		typedQuery.setParameter("selectedName", petName);

		List<TableOwnerinfo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<TableOwnerinfo> searchForItemByOwner(String ownerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TableOwnerinfo> typedQuery = em
				.createQuery("select oi from TableOwnerinfo oi where oi.owner = :selectedOwner", TableOwnerinfo.class);
		typedQuery.setParameter("selectedOwner", ownerName);

		List<TableOwnerinfo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public TableOwnerinfo searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TableOwnerinfo found = em.find(TableOwnerinfo.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(TableOwnerinfo toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}
}
