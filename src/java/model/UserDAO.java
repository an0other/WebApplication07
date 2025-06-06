/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import util.DbUtils;

/**
 *
 * @author an0other
 */
public class UserDAO {

//    List<UserDTO> user_list = new ArrayList<UserDTO>();
    public UserDAO() {
//        user_list.add(new UserDTO("admin", "admin", "admin", "AD", true));
//        user_list.add(new UserDTO("se123", "hcm", "Tran Quang Thanh", "MB", true));
//        user_list.add(new UserDTO("se234", "hcm", "CC", "MB", true));
    }

    public boolean login(String userID, String password) {
//        for (UserDTO userDTO : user_list) {
//            if(userDTO.getUserID().equalsIgnoreCase(userID)
//                    && userDTO.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
        if (this.getUserById(userID) != null) {
            if (this.getUserById(userID).getPassword().equals(password) && this.getUserById(userID).isStatus() == true) {
                return true;
            }
        }
        return false;
    }

    public UserDTO getUserById(String id) {
//        for (UserDTO userDTO : user_list) {
//            if(userDTO.getUserID().equalsIgnoreCase(id)){
//                return userDTO;
//            }
//        }
//        return null;serDTO user=null;
        UserDTO user = null;
        try {

            //B1: Tao sql statememt
            String sql = "select * from tblUsers where userID=?";

            //B2: Tao connect den database
            Connection conn = DbUtils.getConnection();

            //B3: Tao ham thuc thi cau lenh sql
//            Statement st = conn.createStatement();
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, id);
            //B4: Thuc thi cau lenh sql
            //Query tra ve thuong duoc luu trong ResultSet la mot linked list
            ResultSet rs = pr.executeQuery();

            //B5: Duyet bang
            while (rs.next()) {
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");
                user = new UserDTO(userID, password, fullName, roleID, status);
            }
        } catch (Exception e) {
        }

        return user;
    }
}
