import entities.Pazymys;
import entities.Studentas;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        spausdintiStudentoInf();
        uzkrautiDuomenis();
        kursoVidurkis(2018);
    }

    static void spausdintiStudentoInf() {

        EntityManager em = HibernateUtils.getEntityManager();

        Studentas studentas = em.find(Studentas.class, 1);
        System.out.println("*** " + studentas.getId() + " " + studentas.getVardas() + " " + studentas.getPavarde());

    }


    static void uzkrautiDuomenis() {

        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT * FROM db_dienynas.studentai ORDER BY pavarde", Studentas.class);

        List<Studentas> studentai = q.getResultList();

        for (Studentas s : studentai){
            System.out.println(" Studentas: id - " + s.getId() + " "
                    + s.getPavarde() + " " + s.getVardas());
        }

        System.out.println(" ----> " + studentai.size() + " " + studentai.getClass());
        em.getTransaction().commit();
    }

    static void kursoVidurkis(int metai){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();

        List<Pazymys> pazymiai = em.createQuery("from Pazymys").getResultList();

       // List<Pazymys> pazymiai = q.getResultList();

       double avg =  pazymiai.stream()
               .mapToInt(p -> p.getPazymys())
               .average()
               .orElse(0.0);

        System.out.println("Kurso vidurkis --> " + avg);

        //System.out.println(pazymiai.size() + " " +  pazymiai.getClass());
    }
}