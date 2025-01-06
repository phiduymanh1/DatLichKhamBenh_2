package com.example.datlichkhambenh_test.Servlet;

import com.example.datlichkhambenh_test.Entity.BacSiEntity;
import com.example.datlichkhambenh_test.Entity.BenhNhanEntity;
import com.example.datlichkhambenh_test.Repository.BacSiRepository;
import com.example.datlichkhambenh_test.Repository.BenhNhanRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", value = {
        "/BenhNhan/load"
})
public class BenhNhanServlet extends HttpServlet {
    BenhNhanRepository repoBenhNhanRepository = new BenhNhanRepository();
    List<BenhNhanEntity> listBN = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("load")) {
            this.getAll(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    listBN = repoBenhNhanRepository.getAll();
    request.setAttribute("listBN",listBN);
    request.getRequestDispatcher("/View/BenhNhan/BenhNhan.jsp").forward(request,response);
    }


}
