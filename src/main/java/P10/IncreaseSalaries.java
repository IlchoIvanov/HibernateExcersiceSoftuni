package P10;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<String> departmentsNames = List.of("Engineering", "Tool Design", "Marketing", "Information Services");
        Query query = entityManager.createQuery("SELECT e FROM  Employee e WHERE e.department.name IN (:list)", Employee.class);
        query.setParameter("list", departmentsNames);
        List<Employee> resultList = query.getResultList();

        for (Employee employee : resultList) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.12)));
        }

          resultList.stream().forEach(e-> entityManager.persist(e));

        for (Employee employee : resultList) {
            System.out.println(employee.getFirstName() +" " +  employee.getLastName() + " ($" + employee.getSalary() + ")");
        }
        
        entityManager.getTransaction().commit();
    }
}
