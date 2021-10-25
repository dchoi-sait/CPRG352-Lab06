/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 775262
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }

        if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        List<String> shoppingList = (ArrayList<String>) session.getAttribute("items");

        if (action.equals("register")) {
            session.setAttribute("username", request.getParameter("username"));
            shoppingList = new ArrayList<>();
            session.setAttribute("items", shoppingList);

        }

        if (action.equals("add")) {
            String item = request.getParameter("item");
            shoppingList.add(item);

        }

        if (action.equals("delete")) {
            String el = request.getParameter("itemEl");
            if (el != null) {
                shoppingList.remove(el);
            }

        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
