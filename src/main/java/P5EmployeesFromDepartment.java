import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class P5EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = 'Research and Development' ORDER BY salary, id", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.stream().forEach(System.out::println);


        entityManager.getTransaction().commit();
    }
}
