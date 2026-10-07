package controller;

import dao.MechanicDAO;
import model.Mechanic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MechanicServlet")
public class MechanicServlet
        extends HttpServlet {

    private MechanicDAO dao;

    @Override
    public void init() {
        dao = new MechanicDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String action =
                request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        if ("new".equals(action)) {

            request.getRequestDispatcher(
                    "/mechanic/addMechanic.jsp")
                    .forward(
                            request,
                            response);

        } else if ("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            request.setAttribute(
                    "mechanic",
                    dao.getMechanicById(id));

            request.getRequestDispatcher(
                    "/mechanic/editMechanic.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            dao.deleteMechanic(
                    Integer.parseInt(
                            request.getParameter(
                                    "id")));

            response.sendRedirect(
                    request.getContextPath()
                    + "/MechanicServlet");

        } else {

            request.setAttribute(
                    "mechanicList",
                    dao.getAllMechanics());

            request.getRequestDispatcher(
                    "/mechanic/viewMechanics.jsp")
                    .forward(
                            request,
                            response);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String action =
                request.getParameter("action");

        String name =
                request.getParameter("name");

        String mobile =
                request.getParameter("mobile");

        String specialization =
                request.getParameter(
                        "specialization");

        if ("insert".equals(action)) {

            dao.addMechanic(
                    new Mechanic(
                            name,
                            mobile,
                            specialization));

        } else if ("update".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "mechanicId"));

            dao.updateMechanic(
                    new Mechanic(
                            id,
                            name,
                            mobile,
                            specialization));
        }

        response.sendRedirect(
                request.getContextPath()
                + "/MechanicServlet");
    }
}