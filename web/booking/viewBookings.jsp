<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Booking" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Bookings - AutoCare</title>
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
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link active"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>
    <div class="container">
        <div class="breadcrumb">Dashboard &gt; Bookings</div>
        <div class="page-header">
            <h2>Booking List</h2>
            <a href="<%=request.getContextPath()%>/BookingServlet?action=new" class="btn btn-success"><i class="fas fa-plus"></i> New Booking</a>
        </div>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer</th>
                        <th>Vehicle</th>
                        <th>Service</th>
                        <th>Mechanic</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Booking> list = (List<Booking>) request.getAttribute("bookingList");
                        if (list != null && !list.isEmpty()) {
                            for (Booking b : list) {
                                String mechanicName = b.getMechanicName() == null ? "Not Assigned" : b.getMechanicName();
                                String statusClass = "badge-pending";
                                if ("Confirmed".equals(b.getStatus())) statusClass = "badge-confirmed";
                                else if ("In Service".equals(b.getStatus())) statusClass = "badge-in-service";
                                else if ("Completed".equals(b.getStatus())) statusClass = "badge-completed";
                                else if ("Cancelled".equals(b.getStatus())) statusClass = "badge-cancelled";
                    %>
                    <tr>
                        <td><%=b.getBookingId()%></td>
                        <td><%=b.getCustomerName()%></td>
                        <td><%=b.getVehicleNumber()%></td>
                        <td><%=b.getServiceName()%></td>
                        <td><%=mechanicName%></td>
                        <td><%=b.getBookingDate()%></td>
                        <td><span class="badge <%=statusClass%>"><%=b.getStatus()%></span></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/BookingServlet?action=edit&id=<%=b.getBookingId()%>" class="btn btn-warning"><i class="fas fa-edit"></i> Edit</a>
                            <a href="<%=request.getContextPath()%>/BookingServlet?action=delete&id=<%=b.getBookingId()%>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this booking?')"><i class="fas fa-trash"></i> Delete</a>
                        </td>
                    </tr>
                    <% 
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="8" style="text-align: center;"><i class="fas fa-calendar"></i> No bookings found.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>