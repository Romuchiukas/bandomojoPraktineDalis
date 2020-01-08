package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pazymiai")
public class Pazymys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int pazymysId;

    @Column(name = "pazymys")
    private int pazymys;

    @Column(name="data")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentas_id")
    private Studentas studentas;


    public Pazymys() {
    }

    public Pazymys(int pazymysId, int pazymys, LocalDate data, Studentas studentas) {
        this.pazymysId = pazymysId;
        this.pazymys = pazymys;
        this.data = data;
        this.studentas = studentas;
    }

    public int getPazymysId() {
        return pazymysId;
    }

    public void setPazymysId(int pazymysId) {
        this.pazymysId = pazymysId;
    }

    public int getPazymys() {
        return pazymys;
    }

    public void setPazymys(int pazymys) {
        this.pazymys = pazymys;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    @Override
    public String toString() {
        return " " + pazymys + " - " + data + " ";
    }


}
