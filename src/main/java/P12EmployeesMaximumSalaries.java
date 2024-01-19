import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT  max(e.salary) from Employee e GROUP BY e.department.name HAVING  max(e.salary) NOT BETWEEN  30000 AND 70000", BigDecimal.class);
        List<BigDecimal> salaryResultList = query.getResultList();
        Query queryForNames = entityManager.createQuery("SELECT  e.department.name from Employee e GROUP BY e.department.name HAVING  max(e.salary) NOT BETWEEN  30000 AND 70000", String.class);
        List<String> departmentNameResultList = queryForNames.getResultList();
        for (int i = 0; i < departmentNameResultList.size() ; i++) {
            System.out.println(departmentNameResultList.get(i) + " " + salaryResultList.get(i));
        }
        entityManager.getTransaction().commit();
    }
}
