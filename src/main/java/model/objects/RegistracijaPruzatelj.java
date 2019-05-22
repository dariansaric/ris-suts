package model.objects;

import java.util.Objects;

public class RegistracijaPruzatelj {
    private long sifraRegistracija;
    private String oib;

    public RegistracijaPruzatelj() {
    }

    public RegistracijaPruzatelj(long sifraRegistracija, String oib) {
        this.sifraRegistracija = sifraRegistracija;
        this.oib = oib;
    }


    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistracijaPruzatelj that = (RegistracijaPruzatelj) o;
        return sifraRegistracija == that.sifraRegistracija &&
                Objects.equals(oib, that.oib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, oib);
    }
}
