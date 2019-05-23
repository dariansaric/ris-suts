package service;

import dao.DAOProvider;
import model.entity.PravnaOsobaEntity;
import model.repository.PravnaOsoba;

public class PravnaOsobaService {
    private static PravnaOsoba convertToObject(PravnaOsobaEntity e) {
        return e == null ? null :
                new PravnaOsoba(
                        e.getOib(),
                        e.getNaziv(),
                        e.getDatumOsnivanja(),
                        e.getPocetniKapital());

    }

    public static PravnaOsoba dohvatiPravnuOsobu(String oib) {
        return convertToObject(DAOProvider.getDAO().dohvatiPravnuOsobu(oib));
    }

    public static boolean azuzirajPravnuOsobu(PravnaOsoba o) {
        return DAOProvider.getDAO().azurirajPravnuOsobu(o);
    }
}
