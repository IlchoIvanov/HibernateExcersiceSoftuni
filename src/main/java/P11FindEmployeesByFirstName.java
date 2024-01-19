import entities.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Scanner scanner= new Scanner(System.in);
        String textPattern = scanner.nextLine();

        Query query = entityManager.createQuery("select e from Employee e", Employee.class);
        List<Employee> resultList = query.getResultList();
        for (Employee employee : resultList) {
             if(employee.getFirstName().toLowerCase().startsWith(textPattern.toLowerCase()))
                System.out.printf("%s %s - %s - ($%s)%n" +
                        "", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());

        }
        entityManager.getTransaction().commit();
    }
}
