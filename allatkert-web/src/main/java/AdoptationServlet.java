import hu.alkfejl.dao.*;
import hu.alkfejl.model.Adoptation;
import hu.alkfejl.model.AdoptationWeb;
import hu.alkfejl.model.AdoptiveWeb;
import hu.alkfejl.model.AnimalWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adoptation")
public class AdoptationServlet extends HttpServlet {

    private final AdoptationDao dao = new AdoptationDaoImpl();
    private final AnimalDao daoAnimal = new AnimalDaoImpl();
    private final AdoptiveDao daoAdoptive = new AdoptiveDaoImpl();
    private int id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        AnimalWeb animalWeb = daoAnimal.getAnimalById(id);
        List<AdoptiveWeb> adoptiveList = daoAdoptive.list();
        request.setAttribute("animalWeb", animalWeb);
        request.setAttribute("adoptiveList", adoptiveList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adoptation.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest requ, HttpServletResponse respo) throws ServletException, IOException {
        respo.setContentType ("text/html; charset=UTF-8");
        requ.setCharacterEncoding ("UTF-8");
        respo.setCharacterEncoding("UTF-8");
        AdoptationWeb adoptationWeb = new AdoptationWeb(20, id, requ.getParameter("date"), requ.getParameter("donationType"), Integer.parseInt(requ.getParameter("donationValue")), requ.getParameter("donationFreq"));
        //int adoptiveId, int animalId, String date, String donationType, int donationValue, String donationFreq
        dao.add(adoptationWeb);
        respo.sendRedirect("animallist.jsp");
    }

}