package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Emp;

public class EmpDAO {

    // INSERT EMPLOYEE
    public void insertEmp(Emp e) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Emp VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, e.getEmpNo());
            ps.setString(2, e.getEmpName());
            ps.setInt(3, e.getBasicSalary());

            ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // FETCH ALL EMPLOYEES
    public List<Emp> getAllEmployees() {
        List<Emp> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Emp";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Emp e = new Emp();
                e.setEmpNo(rs.getInt(1));
                e.setEmpName(rs.getString(2));
                e.setBasicSalary(rs.getInt(3));

                list.add(e);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}