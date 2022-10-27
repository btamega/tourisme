///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package bean;
//
//import java.sql.SQLException;
//
///**
// *
// * @author dell
// */
//public class LoginDAO {
//   public static boolean validate(String user, String password) {
//		Connection con = null;
//		PreparedStatement ps = null;
//
//		try {
//			con = DataConnect.getConnection();
//			ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
//			ps.setString(1, user);
//			ps.setString(2, password);
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				//result found, means valid inputs
//				return true;
//			}
//		} catch (SQLException ex) {
//			System.out.println("Login error -->" + ex.getMessage());
//			return false;
//		} finally {
//			DataConnect.close(con);
//		}
//		return false;
//	} 
//}
