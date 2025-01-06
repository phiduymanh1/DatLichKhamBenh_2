package com.example.datlichkhambenh_test.Servlet;


import com.example.datlichkhambenh_test.Entity.DichVuKhamEntity;
import com.example.datlichkhambenh_test.Request.DichVuKhamRequest;
import com.example.datlichkhambenh_test.Request.HoaDonRequest;
import com.example.datlichkhambenh_test.Response.DichVuKhamResponse;
import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import com.example.datlichkhambenh_test.Services.iplm.DichVuKhamIplm;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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
        } else if (uri.equals("/dichVuKham/detail")) {
            this.detail(request,response);
        }else if (uri.equals("/dichVuKham/delete")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDvk = request.getParameter("maDvk");
        dichVuKhamIplm.delete(maDvk);
        load(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDvk = request.getParameter("maDvk");
        DichVuKhamResponse dichVuKhamResponse = dichVuKhamIplm.getOne(maDvk);
        request.setAttribute("dvk",dichVuKhamResponse);
        request.getRequestDispatcher("/View/DichVuKham/DichVuKhamDetail.jsp").forward(request,response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DichVuKhamResponse> listdvk = dichVuKhamIplm.getAll();
        request.setAttribute("listdvk",listdvk);
        request.getRequestDispatcher("/View/DichVuKham/DichVuKham.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/dichVuKham/add")){
            this.add(request,response);
        }else if (uri.equals("/dichVuKham/update")){
            this.update(request,response);
        }
    }
    @SneakyThrows
    private void update(HttpServletRequest request, HttpServletResponse response) {
        String maDvk = request.getParameter("maDvk");
//        DichVuKhamResponse dichVuKhamResponse = dichVuKhamIplm.getOne(maDvk);
        DichVuKhamRequest dichVuKhamRequest = new DichVuKhamRequest();
//        BeanUtils.copyProperties(dichVuKhamRequest,dichVuKhamResponse);
        BeanUtils.populate(dichVuKhamRequest,request.getParameterMap());
        dichVuKhamIplm.Update(dichVuKhamRequest);
        load(request, response);
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) {
//        String maDvk = request.getParameter("maDvk");
        DichVuKhamRequest dichVuKhamRequest = new DichVuKhamRequest();
        BeanUtils.populate(dichVuKhamRequest,request.getParameterMap());
        dichVuKhamIplm.Add(dichVuKhamRequest);
        load(request, response);
    }
}
