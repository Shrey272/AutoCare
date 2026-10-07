package dao;

import model.Service;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    public boolean addService(Service s) {

        String sql =
                "INSERT INTO service_type "
                + "(service_name,description,price) "
                + "VALUES(?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    s.getServiceName());

            ps.setString(
                    2,
                    s.getDescription());

            ps.setDouble(3, s.getPrice());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Service> getAllServices() {

        List<Service> list =
                new ArrayList<Service>();

        String sql =
                "SELECT * FROM service_type "
                + "ORDER BY service_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Service s =
                        new Service();

                s.setServiceId(
                        rs.getInt(
                                "service_id"));

                s.setServiceName(
                        rs.getString(
                                "service_name"));

                s.setDescription(
                        rs.getString(
                                "description"));

                s.setPrice(
                        rs.getDouble("price"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Service getServiceById(int id) {

        String sql =
                "SELECT * FROM service_type "
                + "WHERE service_id=?";

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

                Service s =
                        new Service();

                s.setServiceId(
                        rs.getInt(
                                "service_id"));

                s.setServiceName(
                        rs.getString(
                                "service_name"));

                s.setDescription(
                        rs.getString(
                                "description"));

                s.setPrice(
                        rs.getDouble("price"));

                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean updateService(Service s) {

        String sql =
                "UPDATE service_type SET "
                + "service_name=?,"
                + "description=?,price=? "
                + "WHERE service_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    s.getServiceName());

            ps.setString(
                    2,
                    s.getDescription());

            ps.setDouble(3, s.getPrice());

            ps.setInt(
                    4,
                    s.getServiceId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteService(int id) {

        String sql =
                "DELETE FROM service_type "
                + "WHERE service_id=?";

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