package com.example.datlichkhambenh_test.Servlet;


import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import com.example.datlichkhambenh_test.Services.iplm.HoaDonIplm;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HoaDonServlet", value = {
        "/hoadon/load",
        "/hoadon/detail",
        "/hoadon/add",
        "/hoadon/update",
        "/hoadon/delete",
})
public class HoaDonServlet extends HttpServlet {
    HoaDonIplm hoaDonIplm = new HoaDonIplm();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoadon/load")){
            this.load(request, response);
        }if (uri.equals("/hoadon/detail")){
            this.detail(request,response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHoaDon = request.getParameter("maHoaDon");
        HoaDonResponse hoaDon = hoaDonIplm.getOne(maHoaDon);
        request.setAttribute("hd",hoaDon);
        request.getRequestDispatcher("/View/HoaDon/HoaDonDetail.jsp").forward(request,response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HoaDonResponse> listhd = hoaDonIplm.getAll();
        request.setAttribute("listhd",listhd);
        request.getRequestDispatcher("/View/HoaDon/HoaDon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
