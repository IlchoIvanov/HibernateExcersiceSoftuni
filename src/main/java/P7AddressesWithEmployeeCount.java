import entities.Address;

import javax.persistence.*;
import java.util.List;

public class P7AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Query query = entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class).setMaxResults(10);
        List<Address> resultList = query.getResultList();
        resultList.stream().forEach(System.out::println);

        entityManager.getTransaction().commit();
    }
}
