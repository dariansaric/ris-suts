package service;


import dao.DAOProvider;
import model.FizickaOsobaEntity;
import model.repository.FizickaOsoba;

public class FizickaOsobaService {
    private static FizickaOsoba convertToObject(FizickaOsobaEntity e) {
        return e == null ? null :
                new FizickaOsoba(
                        e.getOib(),
                        e.getIme(),
                        e.getPrezime(),
                        e.getDatumRodjenja());
    }

    public static FizickaOsoba dohvatiFizickuOsobu(String oib) {
        return convertToObject(DAOProvider.getDAO().dohvatiFizickuOsobu(oib));
    }

    public static boolean azuzirajFizickuOsobu(FizickaOsoba o) {
        return DAOProvider.getDAO().azurirajFizickuOsobu(o);
    }

    public static boolean pohraniFizickuOsobu(FizickaOsoba o) {
        return DAOProvider.getDAO().pohraniFizickuOsobu(o);
    }
}
