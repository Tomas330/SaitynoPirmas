package org.example.tchatzilias;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlElement
    private int id;
    @XmlElement
    private String carName;
    @XmlElement
    private String variklis;
    @XmlElement
    private String kurotipas;
    @XmlElement
    private String pavarudeze;
    @XmlElement
    private int rida;
    @XmlElement
    private int kaina;

    public Car() {
    }

    public Car(int id, String carName, String variklis, String kurotipas, String pavarudeze, int rida, int kaina) {
        this.id = id;
        this.carName = carName;
        this.variklis = variklis;
        this.kurotipas = kurotipas;
        this.pavarudeze = pavarudeze;
        this.rida = rida;
        this.kaina = kaina;
    }
    public Car(String carName, String variklis, String kurotipas, String pavarudeze, int rida, int kaina) {
        this.carName = carName;
        this.variklis = variklis;
        this.kurotipas = kurotipas;
        this.pavarudeze = pavarudeze;
        this.rida = rida;
        this.kaina = kaina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void getCarName(String carName) {this.carName = this.carName;}

    public String getVariklis() {
        return variklis;
    }

    public void setVariklis(String variklis) {
        this.variklis = variklis;
    }

    public String getKurotipas() {
        return kurotipas;
    }

    public void setKurotipas(String kurotipas) {
        this.kurotipas = kurotipas;
    }

    public String getPavarudeze() {
        return pavarudeze;
    }

    public void setPavarudeze(String pavarudeze) {
        this.pavarudeze = pavarudeze;
    }

    public int getRida() {
        return rida;
    }

    public void setRida(int rida) {
        this.rida = rida;
    }

    public int getKaina() {
        return kaina;
    }

    public void setKaina(int kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return String.format("\tCar:\n\t\t\t\t" + "CarName = %s\n\t\t\t\t" + "Variklis = %s\n\t\t\t\t" +
                        "KuroTipas = %s\n\t\t\t\t" + "PavaruDeze = %s\n\t\t\t\t" + "Rida = %s\n\t\t\t\t" + "Kaina = %s\n\t\t\t\t",
                this.carName,
                this.variklis,
                this.pavarudeze,
                this.kurotipas,
                this.rida,
                this.kaina);
    }
}
