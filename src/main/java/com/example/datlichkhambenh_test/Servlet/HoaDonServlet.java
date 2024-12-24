package com.example.datlichkhambenh_test.Servlet;


import com.example.datlichkhambenh_test.Entity.BacSiEntity;
import com.example.datlichkhambenh_test.Entity.BenhNhanEntity;
import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import com.example.datlichkhambenh_test.Repository.BacSiRepository;
import com.example.datlichkhambenh_test.Repository.BenhNhanRepository;
import com.example.datlichkhambenh_test.Request.HoaDonRequest;
import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import com.example.datlichkhambenh_test.Services.iplm.HoaDonIplm;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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
    BenhNhanRepository benhNhanRepository = new BenhNhanRepository();
    BacSiRepository bacSiRepository = new BacSiRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoadon/load")){
            this.load(request, response);
        }else if (uri.equals("/hoadon/detail")){
            this.detail(request,response);
        }else if (uri.equals("/hoadon/delete")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHoaDon = request.getParameter("maHoaDon");
        HoaDonResponse hoaDon = hoaDonIplm.getOne(maHoaDon);
        request.setAttribute("hd",hoaDon);
        List<BacSiEntity> listbs = bacSiRepository.getAll();
        List<BenhNhanEntity> listbn = benhNhanRepository.getAll();
        request.setAttribute("listbs",listbs);
        request.setAttribute("listbn",listbn);
        request.getRequestDispatcher("/View/HoaDon/HoaDonDetail.jsp").forward(request,response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HoaDonResponse> listhd = hoaDonIplm.getAll();
        request.setAttribute("listhd",listhd);
        List<BacSiEntity> listbs = bacSiRepository.getAll();
        List<BenhNhanEntity> listbn = benhNhanRepository.getAll();
        request.setAttribute("listbs",listbs);
        request.setAttribute("listbn",listbn);
        request.getRequestDispatcher("/View/HoaDon/HoaDon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoadon/add" ) ){
            this.addOrUpdate(request,response);
        } else if (uri.equals("/hoadon/update")) {
            this.Update(request, response);
        }

    }
    @SneakyThrows
    private void Update(HttpServletRequest request, HttpServletResponse response) {
        HoaDonEntity hoaDon = new HoaDonEntity();
        String maHd = request.getParameter("maHd");
        HoaDonResponse hoaDonResponse = hoaDonIplm.getOne(maHd);


        BeanUtils.populate(hoaDonResponse,request.getParameterMap());
        BenhNhanEntity benhNhan = new BenhNhanRepository().getOne(hoaDonResponse.getMaBn());
        BacSiEntity bacSi = new BacSiRepository().getOne(hoaDonResponse.getMaBs());
        hoaDonResponse.setTenBn(benhNhan.getTenBn());
        hoaDonResponse.setTenBs(bacSi.getTenBs());
        hoaDonIplm.Update(hoaDonResponse);
        load(request, response);
    }

    @SneakyThrows
    private void addOrUpdate(HttpServletRequest request, HttpServletResponse response) {
//        String maHd = request.getParameter("maHd");

        HoaDonRequest hoaDonRequest = new HoaDonRequest();
//        hoaDonRequest.setMaHd(maHd);
        BeanUtils.populate(hoaDonRequest, request.getParameterMap());
        hoaDonIplm.Add(hoaDonRequest);
//        System.out.println(hoaDonRequest);
        load(request, response);
    }

}
