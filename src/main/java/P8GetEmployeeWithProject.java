import entities.Employee;

import javax.persistence.*;
import java.util.Scanner;

public class P8GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Scanner scanner= new Scanner(System.in);
        int idFromConsole = Integer.parseInt(scanner.nextLine());
        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :idFromInput", Employee.class);
        query.setParameter("idFromInput",idFromConsole);

        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee);


        entityManager.getTransaction().commit();
    }
}
