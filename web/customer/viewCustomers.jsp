<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List - AutoCare</title>
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
            <a href="<%=request.getContextPath()%>/CustomerServlet" class="nav-link active"><i class="fas fa-users"></i> Customers</a>
            <a href="<%=request.getContextPath()%>/VehicleServlet" class="nav-link"><i class="fas fa-car"></i> Vehicles</a>
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="nav-link"><i class="fas fa-wrench"></i> Mechanics</a>
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container">
        <div class="breadcrumb">
            Dashboard &gt; Customers
        </div>
        
        <div class="page-header">
            <h2>Customer List</h2>
            <a href="CustomerServlet?action=new" class="btn btn-success"><i class="fas fa-plus"></i> Add Customer</a>
        </div>

        <div class="table-container">
            <%
                List<Customer> list = (List<Customer>) request.getAttribute("customerList");
                if (list == null || list.isEmpty()) {
            %>
            <div class="empty-state" style="text-align: center; padding: 2rem;">
                <i class="fas fa-users" style="font-size: 3rem; color: var(--text-muted); margin-bottom: 1rem;"></i>
                <p>No customers found.</p>
            </div>
            <%
                } else {
            %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Customer c : list) {
                    %>
                    <tr>
                        <td><%= c.getCustomerId() %></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getEmail() %></td>
                        <td><%= c.getMobile() %></td>
                        <td><%= c.getAddress() %></td>
                        <td>
                            <a href="CustomerServlet?action=edit&id=<%= c.getCustomerId() %>" class="btn btn-warning btn-sm" title="Edit">
                                <i class="fas fa-edit"></i>
                            </a>
                            <a href="CustomerServlet?action=delete&id=<%= c.getCustomerId() %>" class="btn btn-danger btn-sm" title="Delete" onclick="return confirm('Are you sure you want to delete this customer?');">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>