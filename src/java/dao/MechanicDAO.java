package dao;

import model.Mechanic;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MechanicDAO {

    public boolean addMechanic(Mechanic m) {

        String sql =
                "INSERT INTO mechanic "
                + "(name,mobile,specialization) "
                + "VALUES(?,?,?)";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getMobile());

            ps.setString(
                    3,
                    m.getSpecialization());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Mechanic> getAllMechanics() {

        List<Mechanic> list =
                new ArrayList<Mechanic>();

        String sql =
                "SELECT * FROM mechanic "
                + "ORDER BY mechanic_id DESC";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Mechanic m =
                        new Mechanic();

                m.setMechanicId(
                        rs.getInt(
                                "mechanic_id"));

                m.setName(
                        rs.getString("name"));

                m.setMobile(
                        rs.getString("mobile"));

                m.setSpecialization(
                        rs.getString(
                                "specialization"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Mechanic getMechanicById(int id) {

        String sql =
                "SELECT * FROM mechanic "
                + "WHERE mechanic_id=?";

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

                Mechanic m =
                        new Mechanic();

                m.setMechanicId(
                        rs.getInt(
                                "mechanic_id"));

                m.setName(
                        rs.getString("name"));

                m.setMobile(
                        rs.getString("mobile"));

                m.setSpecialization(
                        rs.getString(
                                "specialization"));

                return m;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean updateMechanic(Mechanic m) {

        String sql =
                "UPDATE mechanic SET "
                + "name=?,mobile=?,"
                + "specialization=? "
                + "WHERE mechanic_id=?";

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getMobile());

            ps.setString(
                    3,
                    m.getSpecialization());

            ps.setInt(
                    4,
                    m.getMechanicId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteMechanic(int id) {

        String sql =
                "DELETE FROM mechanic "
                + "WHERE mechanic_id=?";

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