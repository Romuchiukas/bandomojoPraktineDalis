package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "studentai")
public class Studentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)", unique = true)
    private Integer id;

    @Column(name = "vardas")
    private String vardas;

    @Column(name = "pavarde")
    private String pavarde;

    @Column(name = "el_pastas")
    private String elPastas;


    @OneToMany(mappedBy = "studentas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pazymys> pazymiai;

//    public Studentas() {
//    }
//
//    public Studentas(Integer id, String vardas, String pavarde, String elPastas) {
//        this.id = id;
//        this.vardas = vardas;
//        this.pavarde = pavarde;
//        this.elPastas = elPastas;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public Set<Pazymys> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(Set<Pazymys> pazymiai) {
        this.pazymiai = pazymiai;
    }

    @Override
    public String toString() {
        return "\n "  + pavarde  + " " +
                vardas  +
                ", El.Pastas'" + elPastas + '\'' +
                " \n ";
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, vardas, pavarde, elPastas);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Studentas studentas = (Studentas) o;
//        return Objects.equals(id, studentas.id) &&
//                Objects.equals(vardas, studentas.vardas) &&
//                Objects.equals(pavarde, studentas.pavarde) &&
//                Objects.equals(elPastas, studentas.elPastas);
//
}
