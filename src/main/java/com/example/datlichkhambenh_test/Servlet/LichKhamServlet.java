package com.example.datlichkhambenh_test.Servlet;

import com.example.datlichkhambenh_test.Entity.LichKhamEntity;
import com.example.datlichkhambenh_test.Repository.LichKhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LichKhamServlet", value = {
        "/LichKham/load"
})
public class LichKhamServlet extends HttpServlet {
    private List<LichKhamEntity> listLK = new ArrayList<>();
    private LichKhamRepository repoLk = new LichKhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("load")) {
            this.getAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listLK = repoLk.getLichKham();
        req.setAttribute("listLK", listLK);
        req.getRequestDispatcher("/View/LichKham/LichKham.jsp").forward(req, resp);
    }
}