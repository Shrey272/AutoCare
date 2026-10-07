package controller;

import dao.*;
import model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookingServlet")
public class BookingServlet
        extends HttpServlet {

    private BookingDAO bookingDAO;
    private VehicleDAO vehicleDAO;
    private ServiceDAO serviceDAO;
    private MechanicDAO mechanicDAO;

    @Override
    public void init() {

        bookingDAO =
                new BookingDAO();

        vehicleDAO =
                new VehicleDAO();

        serviceDAO =
                new ServiceDAO();

        mechanicDAO =
                new MechanicDAO();
    }

    private void loadLists(
            HttpServletRequest request) {

        request.setAttribute(
                "vehicleList",
                vehicleDAO.getAllVehicles());

        request.setAttribute(
                "serviceList",
                serviceDAO.getAllServices());

        request.setAttribute(
                "mechanicList",
                mechanicDAO.getAllMechanics());
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

            loadLists(request);

            request.getRequestDispatcher(
                    "/booking/addBooking.jsp")
                    .forward(
                            request,
                            response);

        } else if ("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"));

            request.setAttribute(
                    "booking",
                    bookingDAO
                    .getBookingById(id));

            loadLists(request);

            request.getRequestDispatcher(
                    "/booking/editBooking.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            bookingDAO.deleteBooking(
                    Integer.parseInt(
                            request.getParameter(
                                    "id")));

            response.sendRedirect(
                    request.getContextPath()
                    + "/BookingServlet");

        } else {

            request.setAttribute(
                    "bookingList",
                    bookingDAO
                    .getAllBookings());

            request.getRequestDispatcher(
                    "/booking/viewBookings.jsp")
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

        int vehicleId =
                Integer.parseInt(
                        request.getParameter(
                                "vehicleId"));

        Vehicle vehicle =
                vehicleDAO
                .getVehicleById(vehicleId);

        Booking b =
                new Booking();

        b.setCustomerId(
                vehicle.getCustomerId());

        b.setVehicleId(vehicleId);

        b.setServiceId(
                Integer.parseInt(
                        request.getParameter(
                                "serviceId")));

        String mechanic =
                request.getParameter(
                        "mechanicId");

        if (mechanic == null
                || mechanic.isEmpty()) {

            b.setMechanicId(0);

        } else {

            b.setMechanicId(
                    Integer.parseInt(
                            mechanic));
        }

        b.setBookingDate(
                request.getParameter(
                        "bookingDate"));

        b.setStatus(
                request.getParameter(
                        "status"));

        String action =
                request.getParameter(
                        "action");

        if ("insert".equals(action)) {

            bookingDAO.addBooking(b);

        } else if ("update".equals(action)) {

            b.setBookingId(
                    Integer.parseInt(
                            request.getParameter(
                                    "bookingId")));

            bookingDAO.updateBooking(b);
        }

        response.sendRedirect(
                request.getContextPath()
                + "/BookingServlet");
    }
}