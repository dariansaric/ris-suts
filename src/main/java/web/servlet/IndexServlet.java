package web.servlet;

import model.repository.FizickaOsoba;
import model.repository.PravnaOsoba;
import model.repository.PruzateljUsluga;
import service.FizickaOsobaService;
import service.PravnaOsobaService;
import service.PruzateljUslugaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home/*")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] fields = req.getRequestURI().replace("/suts/home", "").split("/");
        if (fields.length == 1) {
            List<PruzateljUsluga> p = PruzateljUslugaService.dohvatiPruzatelje();
            req.setAttribute("lista", p);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            PruzateljUsluga p = PruzateljUslugaService.dohvatiPruzatelja(fields[1]);
//            List<PruzateljUsluga> p = PruzateljUslugaService.dohvatiPruzatelje();
            FizickaOsoba f = FizickaOsobaService.dohvatiFizickuOsobu(p.getOib());
            PravnaOsoba o = PravnaOsobaService.dohvatiPravnuOsobu(p.getOib());

            req.setAttribute("fosoba", f != null);
            req.setAttribute("pruzatelj", p);
//        req.setAttribute("next", p.get(1).getOib());
            req.setAttribute("osoba", f);
            req.setAttribute("posoba", o);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
