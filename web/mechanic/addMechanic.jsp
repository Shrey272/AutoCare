<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Mechanic - AutoCare</title>
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
        <div class="form-box">
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="form-back"><i class="fas fa-arrow-left"></i> Back to Mechanics</a>
            <h2>Add New Mechanic</h2>
            <p class="form-subtitle">Enter mechanic details below</p>
            <div class="form-divider"></div>
            
            <form action="<%=request.getContextPath()%>/MechanicServlet?action=insert" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" required placeholder="Enter full name">
                </div>
                <div class="form-group">
                    <label>Mobile</label>
                    <input type="text" name="mobile" required placeholder="Enter mobile number">
                </div>
                <div class="form-group">
                    <label>Specialization</label>
                    <input type="text" name="specialization" required placeholder="e.g. Engine, Electrical, Body Work">
                </div>
                <button class="btn btn-lg" type="submit"><i class="fas fa-plus"></i> Add Mechanic</button>
            </form>
        </div>
    </div>
</body>
</html>