package controller;

import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Read username and password from login.jsp
        request.setCharacterEncoding("UTF-8");

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        // Basic validation
        if (username == null || password == null
                || username.trim().isEmpty()
                || password.isEmpty()) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login.jsp?error=invalid"
            );

            return;
        }

        username = username.trim();

        // Debug information in NetBeans Output
        System.out.println(
                "----------------------------------"
        );

        System.out.println(
                "AUTOCARE LOGIN ATTEMPT"
        );

        System.out.println(
                "Username received = [" + username + "]"
        );

        String sql =
                "SELECT admin_id, username "
                + "FROM admin "
                + "WHERE username=? "
                + "AND password=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            System.out.println(
                    "Database connected successfully."
            );

            System.out.println(
                    "Current database = "
                    + con.getCatalog()
            );

            ps.setString(1, username);
            ps.setString(2, password);

            try (
                ResultSet rs =
                        ps.executeQuery()
            ) {

                if (rs.next()) {

                    System.out.println(
                            "LOGIN SUCCESSFUL"
                    );

                    // Create session
                    HttpSession session =
                            request.getSession();

                    session.setAttribute(
                            "admin",
                            rs.getString("username")
                    );

                    session.setAttribute(
                            "adminId",
                            rs.getInt("admin_id")
                    );

                    // Go to dashboard
                    response.sendRedirect(
                            request.getContextPath()
                            + "/dashboard.jsp"
                    );

                } else {

                    System.out.println(
                            "LOGIN FAILED: "
                            + "username/password not matched."
                    );

                    response.sendRedirect(
                            request.getContextPath()
                            + "/login.jsp?error=invalid"
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "LOGIN DATABASE ERROR"
            );

            e.printStackTrace();

            response.sendRedirect(
                    request.getContextPath()
                    + "/login.jsp?error=db"
            );
        }
    }


    // If someone opens LoginServlet directly using GET,
    // send them to login.jsp.
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(
                request.getContextPath()
                + "/login.jsp"
        );
    }
}