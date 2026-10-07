<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Mechanic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Mechanics - AutoCare</title>
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
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="nav-link active"><i class="fas fa-wrench"></i> Mechanics</a>
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container">
        <div class="breadcrumb">Dashboard &gt; Mechanics</div>
        <div class="page-header">
            <h2>Mechanic List</h2>
            <a href="<%=request.getContextPath()%>/mechanic/addMechanic.jsp" class="btn btn-success"><i class="fas fa-plus"></i> + Add Mechanic</a>
        </div>

        <div class="table-container">
            <% List<Mechanic> list = (List<Mechanic>) request.getAttribute("mechanicList");
               if (list == null || list.isEmpty()) { %>
                <div class="empty-state"><i class="fas fa-wrench"></i> No mechanics found.</div>
            <% } else { %>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Mobile</th>
                            <th>Specialization</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Mechanic m : list) { %>
                            <tr>
                                <td><%= m.getMechanicId() %></td>
                                <td><%= m.getName() %></td>
                                <td><%= m.getMobile() %></td>
                                <td><%= m.getSpecialization() %></td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/MechanicServlet?action=edit&id=<%= m.getMechanicId() %>" class="btn btn-warning"><i class="fas fa-edit"></i></a>
                                    <a href="<%=request.getContextPath()%>/MechanicServlet?action=delete&id=<%= m.getMechanicId() %>" class="btn btn-danger" onclick="return confirm('Delete this mechanic?');"><i class="fas fa-trash"></i></a>
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