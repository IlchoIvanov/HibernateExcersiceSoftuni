import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class P4EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Query query = entityManager.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000", String.class);
        List<String> resultList = query.getResultList();
        resultList.stream().forEach(System.out::println);

        entityManager.getTransaction().commit();
    }
}
