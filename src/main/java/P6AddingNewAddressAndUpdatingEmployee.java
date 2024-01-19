import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class P6AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Scanner scanner= new Scanner(System.in);
        String lastName = scanner.nextLine();
        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);
        Query query = entityManager.createQuery("UPDATE Employee e SET e.address = :newAddress  WHERE e.lastName = :last");
        query.setParameter("newAddress", address);
        query.setParameter("last", lastName);
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}
