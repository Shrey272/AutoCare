package controller;

import dao.CustomerDAO;
import model.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CustomerServlet")
public class CustomerServlet
        extends HttpServlet {

    private CustomerDAO dao;

    @Override
    public void init() {
        dao = new CustomerDAO();
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
                    "/customer/addCustomer.jsp")
                    .forward(
                            request,
                            response);

        } else if ("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            request.setAttribute(
                    "customer",
                    dao.getCustomerById(id));

            request.getRequestDispatcher(
                    "/customer/editCustomer.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            dao.deleteCustomer(id);

            response.sendRedirect(
                    request.getContextPath()
                    + "/CustomerServlet");

        } else {

            request.setAttribute(
                    "customerList",
                    dao.getAllCustomers());

            request.getRequestDispatcher(
                    "/customer/viewCustomers.jsp")
                    .forward(
                            request,
                            response);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        request.setCharacterEncoding(
                "UTF-8");

        String action =
                request.getParameter("action");

        if ("insert".equals(action)) {

            Customer c =
                    new Customer(
                            request.getParameter(
                                    "name"),
                            request.getParameter(
                                    "email"),
                            request.getParameter(
                                    "mobile"),
                            request.getParameter(
                                    "address")
                    );

            dao.addCustomer(c);

        } else if ("update".equals(action)) {

            Customer c =
                    new Customer(
                            Integer.parseInt(
                                    request.getParameter(
                                            "customerId")),
                            request.getParameter(
                                    "name"),
                            request.getParameter(
                                    "email"),
                            request.getParameter(
                                    "mobile"),
                            request.getParameter(
                                    "address")
                    );

            dao.updateCustomer(c);
        }

        response.sendRedirect(
                request.getContextPath()
                + "/CustomerServlet");
    }
}