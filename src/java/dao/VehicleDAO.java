package dao;

import model.Vehicle;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public boolean addVehicle(Vehicle v) {

        String sql =
                "INSERT INTO vehicle "
                + "(customer_id,vehicle_number,"
                + "brand,model,vehicle_type) "
                + "VALUES(?,?,?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, v.getCustomerId());
            ps.setString(
                    2,
                    v.getVehicleNumber());

            ps.setString(3, v.getBrand());
            ps.setString(4, v.getModel());

            ps.setString(
                    5,
                    v.getVehicleType());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Vehicle> getAllVehicles() {

        List<Vehicle> list =
                new ArrayList<Vehicle>();

        String sql =
                "SELECT v.*, c.name "
                + "AS customer_name "
                + "FROM vehicle v "
                + "JOIN customer c "
                + "ON v.customer_id="
                + "c.customer_id "
                + "ORDER BY v.vehicle_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Vehicle v =
                        new Vehicle();

                v.setVehicleId(
                        rs.getInt(
                                "vehicle_id"));

                v.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                v.setCustomerName(
                        rs.getString(
                                "customer_name"));

                v.setVehicleNumber(
                        rs.getString(
                                "vehicle_number"));

                v.setBrand(
                        rs.getString("brand"));

                v.setModel(
                        rs.getString("model"));

                v.setVehicleType(
                        rs.getString(
                                "vehicle_type"));

                list.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Vehicle getVehicleById(int id) {

        String sql =
                "SELECT * FROM vehicle "
                + "WHERE vehicle_id=?";

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

                Vehicle v =
                        new Vehicle();

                v.setVehicleId(
                        rs.getInt(
                                "vehicle_id"));

                v.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                v.setVehicleNumber(
                        rs.getString(
                                "vehicle_number"));

                v.setBrand(
                        rs.getString("brand"));

                v.setModel(
                        rs.getString("model"));

                v.setVehicleType(
                        rs.getString(
                                "vehicle_type"));

                return v;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean updateVehicle(Vehicle v) {

        String sql =
                "UPDATE vehicle SET "
                + "customer_id=?,"
                + "vehicle_number=?,"
                + "brand=?,model=?,"
                + "vehicle_type=? "
                + "WHERE vehicle_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, v.getCustomerId());

            ps.setString(
                    2,
                    v.getVehicleNumber());

            ps.setString(3, v.getBrand());
            ps.setString(4, v.getModel());

            ps.setString(
                    5,
                    v.getVehicleType());

            ps.setInt(6, v.getVehicleId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteVehicle(int id) {

        String sql =
                "DELETE FROM vehicle "
                + "WHERE vehicle_id=?";

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