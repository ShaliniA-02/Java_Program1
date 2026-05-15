package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Emp;

public class EmpDAO {

    // GET EMPLOYEES STARTING WITH CHARACTER
    public List<Emp> getByName(char ch) {

        List<Emp> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Emp WHERE Emp_Name LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ch + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Emp e = new Emp();

                e.setEmpNo(rs.getInt(1));
                e.setEmpName(rs.getString(2));
                e.setBasicSalary(rs.getInt(3));

                list.add(e);
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}