package dao;

import model.Booking;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public boolean addBooking(Booking b) {

        String sql =
                "INSERT INTO service_booking "
                + "(customer_id,vehicle_id,"
                + "service_id,mechanic_id,"
                + "booking_date,status) "
                + "VALUES(?,?,?,?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, b.getCustomerId());
            ps.setInt(2, b.getVehicleId());
            ps.setInt(3, b.getServiceId());

            if (b.getMechanicId() > 0) {
                ps.setInt(
                        4,
                        b.getMechanicId());
            } else {
                ps.setNull(
                        4,
                        Types.INTEGER);
            }

            ps.setDate(
                    5,
                    Date.valueOf(
                            b.getBookingDate()));

            ps.setString(
                    6,
                    b.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Booking> getAllBookings() {

        List<Booking> list =
                new ArrayList<Booking>();

        String sql =
                "SELECT b.*, "
                + "c.name AS customer_name, "
                + "v.vehicle_number, "
                + "s.service_name, "
                + "m.name AS mechanic_name "
                + "FROM service_booking b "
                + "JOIN customer c "
                + "ON b.customer_id=c.customer_id "
                + "JOIN vehicle v "
                + "ON b.vehicle_id=v.vehicle_id "
                + "JOIN service_type s "
                + "ON b.service_id=s.service_id "
                + "LEFT JOIN mechanic m "
                + "ON b.mechanic_id=m.mechanic_id "
                + "ORDER BY b.booking_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Booking b =
                        new Booking();

                b.setBookingId(
                        rs.getInt(
                                "booking_id"));

                b.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                b.setVehicleId(
                        rs.getInt(
                                "vehicle_id"));

                b.setServiceId(
                        rs.getInt(
                                "service_id"));

                b.setMechanicId(
                        rs.getInt(
                                "mechanic_id"));

                b.setBookingDate(
                        rs.getString(
                                "booking_date"));

                b.setStatus(
                        rs.getString("status"));

                b.setCustomerName(
                        rs.getString(
                                "customer_name"));

                b.setVehicleNumber(
                        rs.getString(
                                "vehicle_number"));

                b.setServiceName(
                        rs.getString(
                                "service_name"));

                b.setMechanicName(
                        rs.getString(
                                "mechanic_name"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Booking getBookingById(int id) {

        String sql =
                "SELECT * FROM service_booking "
                + "WHERE booking_id=?";

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

                Booking b =
                        new Booking();

                b.setBookingId(
                        rs.getInt(
                                "booking_id"));

                b.setCustomerId(
                        rs.getInt(
                                "customer_id"));

                b.setVehicleId(
                        rs.getInt(
                                "vehicle_id"));

                b.setServiceId(
                        rs.getInt(
                                "service_id"));

                b.setMechanicId(
                        rs.getInt(
                                "mechanic_id"));

                b.setBookingDate(
                        rs.getString(
                                "booking_date"));

                b.setStatus(
                        rs.getString("status"));

                return b;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean updateBooking(Booking b) {

        String sql =
                "UPDATE service_booking SET "
                + "customer_id=?,vehicle_id=?,"
                + "service_id=?,mechanic_id=?,"
                + "booking_date=?,status=? "
                + "WHERE booking_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, b.getCustomerId());
            ps.setInt(2, b.getVehicleId());
            ps.setInt(3, b.getServiceId());

            if (b.getMechanicId() > 0) {
                ps.setInt(
                        4,
                        b.getMechanicId());
            } else {
                ps.setNull(
                        4,
                        Types.INTEGER);
            }

            ps.setDate(
                    5,
                    Date.valueOf(
                            b.getBookingDate()));

            ps.setString(
                    6,
                    b.getStatus());

            ps.setInt(
                    7,
                    b.getBookingId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteBooking(int id) {

        String sql =
                "DELETE FROM service_booking "
                + "WHERE booking_id=?";

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