import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class P13RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Scanner scanner= new Scanner(System.in);
        String townName = scanner.nextLine();
        Query queryToDeleteAddresses = entityManager.createQuery("DELETE FROM Address a WHERE a.town.name = :nameToDelete");
        queryToDeleteAddresses.setParameter("nameToDelete", townName);
        queryToDeleteAddresses.executeUpdate();
        Query queryToDeleteTown = entityManager.createQuery("DELETE FROM Town t WHERE t.name = :nameToDelete");
        queryToDeleteTown.setParameter("nameToDelete", townName);

        queryToDeleteTown.executeUpdate();
        if(deletedAddressesCount == 1){
            System.out.println("1 address in " + townName + " deleted");
        }else{
            System.out.println(deletedAddressesCount + " addresses in " + townName + " deleted");
        }
        entityManager.getTransaction().commit();
    }
}
