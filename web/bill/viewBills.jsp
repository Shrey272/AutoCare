<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Bill" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
    List<Bill> billList = (List<Bill>) request.getAttribute("billList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AutoCare - Bills</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <nav class="navbar">
        <div class="nav-brand"><i class="fas fa-car-side"></i><span>AutoCare</span></div>
        <button class="nav-toggle" onclick="document.querySelector('.nav-links').classList.toggle('open')"><i class="fas fa-bars"></i></button>
        <div class="nav-links">
            <a href="<%=request.getContextPath()%>/dashboard.jsp" class="nav-link"><i class="fas fa-th-large"></i> Dashboard</a>
            <a href="<%=request.getContextPath()%>/CustomerServlet" class="nav-link"><i class="fas fa-users"></i> Customers</a>
            <a href="<%=request.getContextPath()%>/VehicleServlet" class="nav-link"><i class="fas fa-car"></i> Vehicles</a>
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="nav-link"><i class="fas fa-wrench"></i> Mechanics</a>
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link active"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container">
        <div class="breadcrumb">
            <a href="<%=request.getContextPath()%>/dashboard.jsp">Dashboard</a> &gt; Bills
        </div>

        <div class="page-header d-flex justify-content-between align-items-center mb-3">
            <h2>Bill Records</h2>
            <a href="<%=request.getContextPath()%>/BillServlet?action=new" class="btn btn-success"><i class="fas fa-plus"></i> Generate Bill</a>
        </div>

        <div class="table-container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Bill ID</th>
                        <th>Booking</th>
                        <th>Customer</th>
                        <th>Vehicle</th>
                        <th>Service</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (billList != null && !billList.isEmpty()) { 
                        for (Bill b : billList) { %>
                    <tr>
                        <td><%=b.getBillId()%></td>
                        <td><%=b.getBookingId()%></td>
                        <td><%=b.getCustomerName()%></td>
                        <td><%=b.getVehicleNumber()%></td>
                        <td><%=b.getServiceName()%></td>
                        <td>&#8377; <%=b.getAmount()%></td>
                        <td>
                            <span class="badge <%="Paid".equals(b.getPaymentStatus()) ? "badge-paid" : "badge-pending"%>">
                                <%=b.getPaymentStatus() != null ? b.getPaymentStatus() : "Pending"%>
                            </span>
                        </td>
                        <td><%=b.getPaymentDate() != null ? b.getPaymentDate() : "-"%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/BillServlet?action=delete&id=<%=b.getBillId()%>" 
                               class="btn btn-sm btn-danger" 
                               onclick="return confirm('Are you sure you want to delete this bill?');">
                               <i class="fas fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                    <%  } 
                       } else { %>
                    <tr>
                        <td colspan="9" class="empty-message"><i class="fas fa-file-invoice"></i> No bills found.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>