package dao;

import model.Bill;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    public boolean addBill(Bill b) {

        String sql =
                "INSERT INTO bill "
                + "(booking_id,amount,"
                + "payment_status,payment_date) "
                + "VALUES(?,?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    b.getBookingId());

            ps.setDouble(
                    2,
                    b.getAmount());

            ps.setString(
                    3,
                    b.getPaymentStatus());

            if (b.getPaymentDate() == null
                    || b.getPaymentDate()
                    .trim().isEmpty()) {

                ps.setNull(
                        4,
                        Types.DATE);

            } else {

                ps.setDate(
                        4,
                        Date.valueOf(
                                b.getPaymentDate()));
            }

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Bill> getAllBills() {

        List<Bill> list =
                new ArrayList<Bill>();

        String sql =
                "SELECT bl.*, "
                + "c.name AS customer_name, "
                + "v.vehicle_number, "
                + "s.service_name "
                + "FROM bill bl "
                + "JOIN service_booking b "
                + "ON bl.booking_id=b.booking_id "
                + "JOIN customer c "
                + "ON b.customer_id=c.customer_id "
                + "JOIN vehicle v "
                + "ON b.vehicle_id=v.vehicle_id "
                + "JOIN service_type s "
                + "ON b.service_id=s.service_id "
                + "ORDER BY bl.bill_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Bill b = new Bill();

                b.setBillId(
                        rs.getInt(
                                "bill_id"));

                b.setBookingId(
                        rs.getInt(
                                "booking_id"));

                b.setAmount(
                        rs.getDouble(
                                "amount"));

                b.setPaymentStatus(
                        rs.getString(
                                "payment_status"));

                b.setPaymentDate(
                        rs.getString(
                                "payment_date"));

                b.setCustomerName(
                        rs.getString(
                                "customer_name"));

                b.setVehicleNumber(
                        rs.getString(
                                "vehicle_number"));

                b.setServiceName(
                        rs.getString(
                                "service_name"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean deleteBill(int id) {

        String sql =
                "DELETE FROM bill "
                + "WHERE bill_id=?";

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