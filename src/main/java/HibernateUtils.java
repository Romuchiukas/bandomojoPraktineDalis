import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

    private static EntityManagerFactory emf;

    static {
        try{
        emf = Persistence.createEntityManagerFactory("PU");
        }catch (Throwable t){
            t.printStackTrace();
            throw new ExceptionInInitializerError(t);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
