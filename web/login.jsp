<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AutoCare - Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="login-page">
        <div class="login-card">
            <div class="login-logo">
                <div class="logo-icon"><i class="fas fa-car-side"></i></div>
                <h1>AutoCare</h1>
                <p>Admin Dashboard Login</p>
            </div>
            
            <%
                String error = request.getParameter("error");
                if ("invalid".equals(error)) {
            %>
                <div class="error-msg"><i class="fas fa-exclamation-circle"></i> Invalid username or password!</div>
            <%
                } else if ("db".equals(error)) {
            %>
                <div class="error-msg"><i class="fas fa-exclamation-circle"></i> Database error occurred!</div>
            <%
                }
            %>
            
            <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Enter password" required>
                </div>
                <button type="submit" class="btn btn-lg w-100">Login</button>
            </form>
        </div>
    </div>
</body>
</html>