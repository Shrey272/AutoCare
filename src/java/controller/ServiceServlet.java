package controller;

import dao.ServiceDAO;
import model.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServiceServlet")
public class ServiceServlet
        extends HttpServlet {

    private ServiceDAO dao;

    @Override
    public void init() {
        dao = new ServiceDAO();
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
                    "/service/addService.jsp")
                    .forward(
                            request,
                            response);

        } else if ("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            request.setAttribute(
                    "service",
                    dao.getServiceById(id));

            request.getRequestDispatcher(
                    "/service/editService.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            dao.deleteService(
                    Integer.parseInt(
                            request.getParameter(
                                    "id")));

            response.sendRedirect(
                    request.getContextPath()
                    + "/ServiceServlet");

        } else {

            request.setAttribute(
                    "serviceList",
                    dao.getAllServices());

            request.getRequestDispatcher(
                    "/service/viewServices.jsp")
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
                request.getParameter(
                        "serviceName");

        String description =
                request.getParameter(
                        "description");

        double price =
                Double.parseDouble(
                        request.getParameter(
                                "price"));

        if ("insert".equals(action)) {

            dao.addService(
                    new Service(
                            name,
                            description,
                            price));

        } else if ("update".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "serviceId"));

            dao.updateService(
                    new Service(
                            id,
                            name,
                            description,
                            price));
        }

        response.sendRedirect(
                request.getContextPath()
                + "/ServiceServlet");
    }
}