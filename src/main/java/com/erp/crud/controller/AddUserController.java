package com.erp.crud.controller;

import com.erp.crud.dao.User;
import com.erp.crud.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-user")
public class AddUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = new UserModel();
     /*   User user = new User(null,
                req.getParameter("username"),
                req.getParameter("password"),
                req.getParameter("email"),
                req.getParameter("full_name"));
        */

        String requestType = req.getParameter("type");

        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setFullname(req.getParameter("full_name"));
        user.setPassword(req.getParameter("password"));
        user.setUsername(req.getParameter("username"));

        if (requestType.equals("insert")) {
            userModel.addUser(user);
            resp.sendRedirect(req.getContextPath() + "/home"); // to return me to the home servlet.
        } else if (requestType.equals("update")) {
            Integer userId = Integer.parseInt(req.getParameter("user_id_x"));
            user.setUserId(userId);
            userModel.updateUser(user);
            resp.sendRedirect(req.getContextPath() + "/delete?ID=" + userId + "&action=update");
        }

    }
}
