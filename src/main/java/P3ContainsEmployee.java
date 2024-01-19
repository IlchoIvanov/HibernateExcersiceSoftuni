import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class P3ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Scanner scanner= new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String firstNameFromInput = input[0];
        String lastNameFromInput = input[1];
        Long result = entityManager.createQuery
                ("SELECT count(e) FROM Employee e WHERE e.firstName = :name1 AND e.lastName = :name2", Long.class)
       .setParameter("name1", firstNameFromInput).setParameter("name2", lastNameFromInput).getSingleResult();
       if(result>0){
           System.out.println("Yes");
       }else{
           System.out.println("No");
       }
        entityManager.getTransaction().commit();
    }
}
