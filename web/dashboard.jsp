<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AutoCare - Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <nav class="navbar">
        <div class="nav-brand"><i class="fas fa-car-side"></i><span>AutoCare</span></div>
        <button class="nav-toggle" onclick="document.querySelector('.nav-links').classList.toggle('open')"><i class="fas fa-bars"></i></button>
        <div class="nav-links">
            <a href="<%=request.getContextPath()%>/dashboard.jsp" class="nav-link active"><i class="fas fa-th-large"></i> Dashboard</a>
            <a href="<%=request.getContextPath()%>/CustomerServlet" class="nav-link"><i class="fas fa-users"></i> Customers</a>
            <a href="<%=request.getContextPath()%>/VehicleServlet" class="nav-link"><i class="fas fa-car"></i> Vehicles</a>
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="nav-link"><i class="fas fa-wrench"></i> Mechanics</a>
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container">
        <div class="welcome-banner">
            <h2>Welcome back, <%=admin%>!</h2>
            <p>Manage your auto care center from one place.</p>
        </div>

        <div class="dashboard-grid">
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/CustomerServlet'">
                <div class="dash-card-icon icon-blue"><i class="fas fa-users"></i></div>
                <div class="dash-card-info">
                    <h3>Customers</h3>
                    <p>Manage customer details</p>
                    <a href="<%=request.getContextPath()%>/CustomerServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
            
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/VehicleServlet'">
                <div class="dash-card-icon icon-green"><i class="fas fa-car"></i></div>
                <div class="dash-card-info">
                    <h3>Vehicles</h3>
                    <p>Manage vehicle records</p>
                    <a href="<%=request.getContextPath()%>/VehicleServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
            
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/MechanicServlet'">
                <div class="dash-card-icon icon-orange"><i class="fas fa-wrench"></i></div>
                <div class="dash-card-info">
                    <h3>Mechanics</h3>
                    <p>Manage mechanic staff</p>
                    <a href="<%=request.getContextPath()%>/MechanicServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
            
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/ServiceServlet'">
                <div class="dash-card-icon icon-purple"><i class="fas fa-cogs"></i></div>
                <div class="dash-card-info">
                    <h3>Services</h3>
                    <p>Manage service catalog</p>
                    <a href="<%=request.getContextPath()%>/ServiceServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
            
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/BookingServlet'">
                <div class="dash-card-icon icon-teal"><i class="fas fa-calendar-check"></i></div>
                <div class="dash-card-info">
                    <h3>Bookings</h3>
                    <p>Manage appointments</p>
                    <a href="<%=request.getContextPath()%>/BookingServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
            
            <div class="dash-card" onclick="location.href='<%=request.getContextPath()%>/BillServlet'">
                <div class="dash-card-icon icon-rose"><i class="fas fa-file-invoice-dollar"></i></div>
                <div class="dash-card-info">
                    <h3>Billing</h3>
                    <p>Manage invoices</p>
                    <a href="<%=request.getContextPath()%>/BillServlet" class="dash-card-link">Manage → </a>
                </div>
            </div>
        </div>
    </div>
    
    <div class="footer">&copy; 2024 AutoCare Management System</div>
</body>
</html>