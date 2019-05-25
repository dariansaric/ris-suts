package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scripts/*")
public class ScriptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String scriptName = req.getRequestURI().replace("/suts/scripts/", "");
        resp.setContentType("application/json");

        req.getRequestDispatcher("/WEB-INF/scripts/" + scriptName).forward(req, resp);
    }
}
