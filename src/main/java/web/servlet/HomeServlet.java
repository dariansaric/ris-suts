package web.servlet;

import model.repository.PruzateljUsluga;
import service.PruzateljUslugaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: dopuniti po potrebi
        //todo: izrada stranice
        //todo:testiranje frontenda
        List<PruzateljUsluga> p = PruzateljUslugaService.dohvatiPruzatelje();

        req.setAttribute("pruzatelj", p.get(0));
        req.setAttribute("next", p.get(1).getOib());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
