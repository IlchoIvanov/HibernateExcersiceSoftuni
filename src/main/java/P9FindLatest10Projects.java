import com.sun.jdi.PathSearchingVirtualMachine;
import entities.Project;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

public class P9FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name ASC", Project.class).setMaxResults(10);
        List<Project> resultList = query.getResultList();
        resultList.stream().sorted(Comparator.comparing(p-> p.getName())).forEach(System.out::println);
        entityManager.getTransaction().commit();
    }
}
