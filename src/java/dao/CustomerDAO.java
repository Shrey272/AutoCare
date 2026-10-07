package dao;

import model.Customer;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public boolean addCustomer(Customer c) {

        String sql =
                "INSERT INTO customer "
                + "(name,email,mobile,address) "
                + "VALUES(?,?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getMobile());
            ps.setString(4, c.getAddress());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Customer>
            getAllCustomers() {

        List<Customer> list =
                new ArrayList<Customer>();

        String sql =
                "SELECT * FROM customer "
                + "ORDER BY customer_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Customer c =
                        new Customer();

                c.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                c.setName(
                        rs.getString("name"));

                c.setEmail(
                        rs.getString("email"));

                c.setMobile(
                        rs.getString("mobile"));

                c.setAddress(
                        rs.getString("address"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Customer getCustomerById(int id) {

        String sql =
                "SELECT * FROM customer "
                + "WHERE customer_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                Customer c =
                        new Customer();

                c.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                c.setName(
                        rs.getString("name"));

                c.setEmail(
                        rs.getString("email"));

                c.setMobile(
                        rs.getString("mobile"));

                c.setAddress(
                        rs.getString("address"));

                return c;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean updateCustomer(Customer c) {

        String sql =
                "UPDATE customer SET "
                + "name=?,email=?,mobile=?,"
                + "address=? "
                + "WHERE customer_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getMobile());
            ps.setString(4, c.getAddress());

            ps.setInt(
                    5,
                    c.getCustomerId()
            );

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteCustomer(int id) {

        String sql =
                "DELETE FROM customer "
                + "WHERE customer_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}