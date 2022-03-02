package com.erp.crud.controller;

import com.erp.crud.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserActions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer userId = Integer.parseInt(req.getParameter("ID"));
        UserModel userModel = new UserModel();

        switch (action) {
            case "delete":
                userModel.delete(userId);
                resp.sendRedirect(req.getContextPath() + "/home");
                break;
            case "update":
                RequestDispatcher dispatcher = req.getRequestDispatcher("view_user.jsp");
                req.setAttribute("user_id", userId);
                req.setAttribute("user_details", userModel.getUserById(userId));
                dispatcher.forward(req, resp);
                break;
        }

        //  resp.getWriter().println("Do " + req.getParameter("action") + " : USER_ID : " + req.getParameter("ID"));
    }
}
