package controller;

import dao.CustomerDAO;
import dao.VehicleDAO;

import model.Vehicle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/VehicleServlet")
public class VehicleServlet
        extends HttpServlet {

    private VehicleDAO vehicleDAO;
    private CustomerDAO customerDAO;

    @Override
    public void init() {

        vehicleDAO =
                new VehicleDAO();

        customerDAO =
                new CustomerDAO();
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

            request.setAttribute(
                    "customerList",
                    customerDAO
                    .getAllCustomers());

            request.getRequestDispatcher(
                    "/vehicle/addVehicle.jsp")
                    .forward(
                            request,
                            response);

        } else if ("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            request.setAttribute(
                    "vehicle",
                    vehicleDAO
                    .getVehicleById(id));

            request.setAttribute(
                    "customerList",
                    customerDAO
                    .getAllCustomers());

            request.getRequestDispatcher(
                    "/vehicle/editVehicle.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            vehicleDAO.deleteVehicle(
                    Integer.parseInt(
                            request.getParameter(
                                    "id")));

            response.sendRedirect(
                    request.getContextPath()
                    + "/VehicleServlet");

        } else {

            request.setAttribute(
                    "vehicleList",
                    vehicleDAO
                    .getAllVehicles());

            request.getRequestDispatcher(
                    "/vehicle/viewVehicles.jsp")
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

        int customerId =
                Integer.parseInt(
                        request.getParameter(
                                "customerId"));

        String vehicleNumber =
                request.getParameter(
                        "vehicleNumber");

        String brand =
                request.getParameter("brand");

        String model =
                request.getParameter("model");

        String type =
                request.getParameter(
                        "vehicleType");

        if ("insert".equals(action)) {

            vehicleDAO.addVehicle(
                    new Vehicle(
                            customerId,
                            vehicleNumber,
                            brand,
                            model,
                            type));

        } else if ("update".equals(action)) {

            int vehicleId =
                    Integer.parseInt(
                            request.getParameter(
                                    "vehicleId"));

            vehicleDAO.updateVehicle(
                    new Vehicle(
                            vehicleId,
                            customerId,
                            vehicleNumber,
                            brand,
                            model,
                            type));
        }

        response.sendRedirect(
                request.getContextPath()
                + "/VehicleServlet");
    }
}