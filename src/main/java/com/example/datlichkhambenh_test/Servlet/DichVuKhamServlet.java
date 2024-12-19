package com.example.datlichkhambenh_test.Servlet;


import com.example.datlichkhambenh_test.Response.DichVuKhamResponse;
import com.example.datlichkhambenh_test.Services.iplm.DichVuKhamIplm;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DichVuKhamServlet", value = {
        "/dichVuKham/load",
        "/dichVuKham/add",
        "/dichVuKham/detail",
        "/dichVuKham/update",
        "/dichVuKham/delete",
})
public class DichVuKhamServlet extends HttpServlet {
    DichVuKhamIplm dichVuKhamIplm = new DichVuKhamIplm();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/dichVuKham/load")){
            this.load(request,response);
        }
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DichVuKhamResponse> listdvk = dichVuKhamIplm.getAll();
        request.setAttribute("listdvk",listdvk);
        request.getRequestDispatcher("/View/DichVuKham/DichVuKham.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
