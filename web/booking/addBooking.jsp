<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Vehicle" %>
<%@ page import="model.Service" %>
<%@ page import="model.Mechanic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Booking - AutoCare</title>
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
        <div class="form-box">
            <a href="<%=request.getContextPath()%>/BookingServlet" class="form-back"><i class="fas fa-arrow-left"></i> Back to Bookings</a>
            <h2>New Service Booking</h2>
            <p class="form-subtitle">Schedule a new service booking</p>
            <div class="form-divider"></div>
            <form action="<%=request.getContextPath()%>/BookingServlet?action=insert" method="post">
                <div class="form-group">
                    <label>Vehicle</label>
                    <select name="vehicleId" required>
                        <option value="">Select Vehicle</option>
                        <% 
                            List<Vehicle> vehicleList = (List<Vehicle>) request.getAttribute("vehicleList");
                            if (vehicleList != null) {
                                for (Vehicle v : vehicleList) {
                        %>
                        <option value="<%=v.getVehicleId()%>"><%=v.getVehicleNumber()%> - <%=v.getCustomerName()%></option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label>Service</label>
                    <select name="serviceId" required>
                        <option value="">Select Service</option>
                        <% 
                            List<Service> serviceList = (List<Service>) request.getAttribute("serviceList");
                            if (serviceList != null) {
                                for (Service s : serviceList) {
                        %>
                        <option value="<%=s.getServiceId()%>"><%=s.getServiceName()%> - &#8377;<%=s.getPrice()%></option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label>Mechanic</label>
                    <select name="mechanicId">
                        <option value="">Not Assigned</option>
                        <% 
                            List<Mechanic> mechanicList = (List<Mechanic>) request.getAttribute("mechanicList");
                            if (mechanicList != null) {
                                for (Mechanic m : mechanicList) {
                        %>
                        <option value="<%=m.getMechanicId()%>"><%=m.getName()%></option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label>Booking Date</label>
                    <input type="date" name="bookingDate" required>
                </div>
                <div class="form-group">
                    <label>Status</label>
                    <select name="status" required>
                        <option value="Pending">Pending</option>
                        <option value="Confirmed">Confirmed</option>
                        <option value="In Service">In Service</option>
                        <option value="Completed">Completed</option>
                        <option value="Cancelled">Cancelled</option>
                    </select>
                </div>
                <button class="btn btn-lg" type="submit"><i class="fas fa-calendar-plus"></i> Book Service</button>
            </form>
        </div>
    </div>
</body>
</html>