/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.UserDTO;

/**
 *
 * @author an0other
 */
public class AuthUtils {

    public static UserDTO getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (UserDTO) session.getAttribute("User");
    }

    public static boolean isLoggedIn(HttpServletRequest request) {
        return getCurrentUser(request) != null;
    }

    public static boolean hasRole(HttpServletRequest request, String role) {
        UserDTO user = getCurrentUser(request);
        if (user != null) {
            return user.getRoleID().equals(role);
        }
        return false;
    }

    public static boolean isAdmin(HttpServletRequest request) {
        return hasRole(request, "AD");
    }

    public static boolean isManaget(HttpServletRequest request) {
        return hasRole(request, "MN");
    }

    public static boolean isMember(HttpServletRequest request) {
        return hasRole(request, "MB");
    }

    public static String getLogginURL(HttpServletRequest request) {
        return "MainController";
    }

    public static String getAccessDeniedMessage(HttpServletRequest request, String action) {
        return "You can not access to " + action + ". Please contact administrator.";
    }
}
