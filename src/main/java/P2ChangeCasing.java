import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class P2ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = query.getResultList();
        for (Town town : resultList) {
            if(town.getName().length() <=5 ) {
                String name = town.getName();
                String toUpper = name.toUpperCase();
                town.setName(toUpper);
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
    }
}
