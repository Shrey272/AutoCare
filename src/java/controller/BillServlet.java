package controller;

import dao.BillDAO;
import dao.BookingDAO;

import model.Bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BillServlet")
public class BillServlet
        extends HttpServlet {

    private BillDAO billDAO;
    private BookingDAO bookingDAO;

    @Override
    public void init() {

        billDAO =
                new BillDAO();

        bookingDAO =
                new BookingDAO();
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
                    "bookingList",
                    bookingDAO
                    .getAllBookings());

            request.getRequestDispatcher(
                    "/bill/generateBill.jsp")
                    .forward(
                            request,
                            response);

        } else if ("delete".equals(action)) {

            billDAO.deleteBill(
                    Integer.parseInt(
                            request.getParameter(
                                    "id")));

            response.sendRedirect(
                    request.getContextPath()
                    + "/BillServlet");

        } else {

            request.setAttribute(
                    "billList",
                    billDAO.getAllBills());

            request.getRequestDispatcher(
                    "/bill/viewBills.jsp")
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

        Bill b =
                new Bill();

        b.setBookingId(
                Integer.parseInt(
                        request.getParameter(
                                "bookingId")));

        b.setAmount(
                Double.parseDouble(
                        request.getParameter(
                                "amount")));

        b.setPaymentStatus(
                request.getParameter(
                        "paymentStatus"));

        b.setPaymentDate(
                request.getParameter(
                        "paymentDate"));

        billDAO.addBill(b);

        response.sendRedirect(
                request.getContextPath()
                + "/BillServlet");
    }
}