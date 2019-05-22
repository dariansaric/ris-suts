package service;

import dao.DAOProvider;
import model.entity.PruzateljUslugaEntity;
import model.repository.PruzateljUsluga;

import java.util.ArrayList;
import java.util.List;

public class PruzateljUslugaService {

    private static PruzateljUsluga convertToObject(PruzateljUslugaEntity e) {
        PruzateljUsluga o = new PruzateljUsluga();
        o.setOib(e.getOib());
        o.setAdresa(e.getAdresa());

        return o;
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
