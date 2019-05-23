package service;

import dao.DAOProvider;
import model.PruzateljUslugaEntity;
import model.repository.PruzateljUsluga;

import java.util.ArrayList;
import java.util.List;

public class PruzateljUslugaService {

    private static PruzateljUsluga convertToObject(PruzateljUslugaEntity e) {
        return e == null ? null : new PruzateljUsluga(
                e.getOib(),
                e.getAdresa());
    }

    public static List<PruzateljUsluga> dohvatiPruzatelje() {
        List<PruzateljUslugaEntity> le = DAOProvider.getDAO().dohvatiPruzatelje();
        List<PruzateljUsluga> lo = new ArrayList<>(le.size());

        le.forEach(e -> lo.add(convertToObject(e)));
        return lo;
    }

    public static PruzateljUsluga dohvatiPruzatelja(String oib) {
        return convertToObject(DAOProvider.getDAO().dohvatiPruzatelja(oib));
    }

    public static boolean pohraniPruzatelja(PruzateljUsluga o) {
        return DAOProvider.getDAO().pohraniPruzatelja(o);
    }

    public static boolean azurirajPruzatelja(PruzateljUsluga o) {
        return DAOProvider.getDAO().azurirajPruzatelja(o);
    }
}
