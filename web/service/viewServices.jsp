<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Service" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Services - AutoCare</title>
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
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link active"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container">
        <div class="breadcrumb">Dashboard &gt; Services</div>
        <div class="page-header">
            <h2>Service List</h2>
            <a href="<%=request.getContextPath()%>/service/addService.jsp" class="btn btn-success"><i class="fas fa-plus"></i> + Add Service</a>
        </div>

        <div class="table-container">
            <% List<Service> list = (List<Service>) request.getAttribute("serviceList");
               if (list == null || list.isEmpty()) { %>
                <div class="empty-state"><i class="fas fa-cogs"></i> No services found.</div>
            <% } else { %>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Service Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Service s : list) { %>
                            <tr>
                                <td><%= s.getServiceId() %></td>
                                <td><%= s.getServiceName() %></td>
                                <td><%= s.getDescription() %></td>
                                <td>&#8377; <%= s.getPrice() %></td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/ServiceServlet?action=edit&id=<%= s.getServiceId() %>" class="btn btn-warning"><i class="fas fa-edit"></i></a>
                                    <a href="<%=request.getContextPath()%>/ServiceServlet?action=delete&id=<%= s.getServiceId() %>" class="btn btn-danger" onclick="return confirm('Delete this service?');"><i class="fas fa-trash"></i></a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } %>
        </div>
    </div>
</body>
</html>