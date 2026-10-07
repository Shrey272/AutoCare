<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Customer - AutoCare</title>
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

    <div class="container" style="display: flex; justify-content: center; align-items: center; min-height: 80vh;">
        <div class="form-box">
            <a href="CustomerServlet" class="form-back"><i class="fas fa-arrow-left"></i> Back to Customers</a>
            <h2>Edit Customer</h2>
            <p class="form-subtitle">Update customer information</p>
            
            <% Customer c = (Customer) request.getAttribute("customer"); %>
            
            <form action="CustomerServlet?action=update" method="post">
                <input type="hidden" name="customerId" value="<%= c != null ? c.getCustomerId() : "" %>">
                
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control" value="<%= c != null ? c.getName() : "" %>" required>
                </div>
                
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" class="form-control" value="<%= c != null ? c.getEmail() : "" %>" required>
                </div>
                
                <div class="form-group">
                    <label for="mobile">Mobile</label>
                    <input type="text" id="mobile" name="mobile" class="form-control" value="<%= c != null ? c.getMobile() : "" %>" required>
                </div>
                
                <div class="form-group">
                    <label for="address">Address</label>
                    <textarea id="address" name="address" class="form-control" required><%= c != null ? c.getAddress() : "" %></textarea>
                </div>
                
                <button type="submit" class="btn btn-lg"><i class="fas fa-save"></i> Update Customer</button>
            </form>
        </div>
    </div>
</body>
</html>