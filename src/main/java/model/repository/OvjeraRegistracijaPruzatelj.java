package model.repository;

import java.util.Objects;


public class OvjeraRegistracijaPruzatelj {
    private long sifraRegistracija;
    private long sifraDuznosnik;
    private boolean status;

    public OvjeraRegistracijaPruzatelj(long sifraRegistracija, long sifraDuznosnik, boolean status) {
        this.sifraRegistracija = sifraRegistracija;
        this.sifraDuznosnik = sifraDuznosnik;
        this.status = status;
    }

    public OvjeraRegistracijaPruzatelj() {
    }

    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    public long getSifraDuznosnik() {
        return sifraDuznosnik;
    }

    public void setSifraDuznosnik(long sifraDuznosnik) {
        this.sifraDuznosnik = sifraDuznosnik;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OvjeraRegistracijaPruzatelj that = (OvjeraRegistracijaPruzatelj) o;
        return sifraRegistracija == that.sifraRegistracija &&
                sifraDuznosnik == that.sifraDuznosnik &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, sifraDuznosnik, status);
    }
}
