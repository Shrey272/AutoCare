<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Vehicle - AutoCare</title>
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
            <a href="<%=request.getContextPath()%>/VehicleServlet" class="nav-link active"><i class="fas fa-car"></i> Vehicles</a>
            <a href="<%=request.getContextPath()%>/MechanicServlet" class="nav-link"><i class="fas fa-wrench"></i> Mechanics</a>
            <a href="<%=request.getContextPath()%>/ServiceServlet" class="nav-link"><i class="fas fa-cogs"></i> Services</a>
            <a href="<%=request.getContextPath()%>/BookingServlet" class="nav-link"><i class="fas fa-calendar-check"></i> Bookings</a>
            <a href="<%=request.getContextPath()%>/BillServlet" class="nav-link"><i class="fas fa-file-invoice-dollar"></i> Bills</a>
        </div>
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </nav>

    <div class="container" style="display: flex; justify-content: center; align-items: center; min-height: 80vh;">
        <div class="form-box">
            <a href="VehicleServlet" class="form-back"><i class="fas fa-arrow-left"></i> Back to Vehicles</a>
            <h2>Add New Vehicle</h2>
            <p class="form-subtitle">Enter vehicle details below</p>
            
            <form action="VehicleServlet?action=insert" method="post">
                <div class="form-group">
                    <label for="customerId">Customer</label>
                    <select id="customerId" name="customerId" class="form-control" required>
                        <option value="">Select Customer</option>
                        <%
                            List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
                            if (customerList != null) {
                                for (Customer c : customerList) {
                        %>
                        <option value="<%= c.getCustomerId() %>"><%= c.getName() %></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="vehicleNumber">Vehicle Number</label>
                    <input type="text" id="vehicleNumber" name="vehicleNumber" class="form-control" placeholder="Enter vehicle number" required>
                </div>
                
                <div class="form-group">
                    <label for="brand">Brand</label>
                    <input type="text" id="brand" name="brand" class="form-control" placeholder="Enter brand" required>
                </div>
                
                <div class="form-group">
                    <label for="model">Model</label>
                    <input type="text" id="model" name="model" class="form-control" placeholder="Enter model" required>
                </div>
                
                <div class="form-group">
                    <label for="vehicleType">Vehicle Type</label>
                    <select id="vehicleType" name="vehicleType" class="form-control" required>
                        <option value="Car">Car</option>
                        <option value="Bike">Bike</option>
                        <option value="Scooter">Scooter</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
                
                <button type="submit" class="btn btn-lg"><i class="fas fa-plus"></i> Add Vehicle</button>
            </form>
        </div>
    </div>
</body>
</html>