package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pazymiai")
public class Pazymys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int pazymysId;

    @Column(name = "pazymys")
    private int pazymys;

    @Column(name="data")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="studentas_id", nullable=false)
    private Studentas studentas;

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
        return "\n Pazymys, data " + pazymys + data + " ";
    }
}
