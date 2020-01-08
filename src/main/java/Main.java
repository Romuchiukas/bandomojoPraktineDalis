import entities.Pazymys;
import entities.Studentas;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        spausdintiStudentoInf();
        uzkrautiDuomenis();
//        kursoVidurkis(2018);
    }

    static void spausdintiStudentoInf() {

        EntityManager em = HibernateUtils.getEntityManager();

        Studentas studentas = em.find(Studentas.class, 1);
        System.out.println("*** " + studentas.getId() + " " + studentas.getVardas() + " " + studentas.getPavarde());

    }


    static void uzkrautiDuomenis() {

        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
//        Query q = em.createNativeQuery("SELECT * FROM db_dienynas.studentai ORDER BY pavarde", Studentas.class);

        Query q = em.createNativeQuery("SELECT * FROM studentai  LEFT outer JOIN pazymiai ON pazymiai.studentas_id = studentai.id ORDER BY vardas", Studentas.class);

        List<Studentas> studentai = q.getResultList();

        // ATSPAUSDINA VISUS STUDENTUS SU PAZYMIU LISTU BET DUBLIUOJASI
//        for (Studentas s : studentai){
//            System.out.println("\n STUDENTAS: id - " + s.getId() + ", "
//                    + s.getPavarde() + " " + s.getVardas() + ", el.pastas - " + s.getElPastas() + " \n" + s.getPazymiai());
//        }

        //ATSPAUSDINA STUDENTUS BET SUBLIUOJASI PAGAL TAI KIEK TURI PAZYMIU
//        studentai.forEach(s -> System.out.println("STUDENTAS: id - " + s.getId() + ", "
//                    + s.getPavarde() + " " + s.getVardas() + ", el.pastas - " + s.getElPastas() + " \n"
//                + " " +s.getPazymiai().size()
//        ));

        //ATSPAUSDINA ANALOGISKAI
//        System.out.println(" Studentas   "+studentai);
//
//        System.out.println("\n ----> " + studentai.size() + " " + studentai.getClass());

        System.out.println("\n STUDENTAI -->");
        studentai.forEach( s -> s.getPazymiai().forEach(
                pazymys -> {
                    System.out.println(pazymys.getStudentas() + " Pazymys: " + pazymys.getPazymys() + " / "+ pazymys.getData());
                }
        ));

        em.getTransaction().commit();
        em.close();
    }

    static void kursoVidurkis(int metai){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();

        List<Pazymys> pazymiai = new ArrayList<>();
        pazymiai  = em.createQuery("from Pazymys").getResultList();

       double avg =  pazymiai.stream()
               .mapToInt(p -> p.getPazymys())
               .average()
               .orElse(0.0);

        System.out.println("\n Kurso vidurkis ===> " + avg);

//        System.out.println(pazymiai.size() + " " +  pazymiai.getClass());
        em.getTransaction().commit();
        em.close();
    }
}