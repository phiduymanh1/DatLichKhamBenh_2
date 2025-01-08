package com.example.datlichkhambenh_test.Servlet;

import com.example.datlichkhambenh_test.Entity.BacSiEntity;
import com.example.datlichkhambenh_test.Repository.BacSiRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BacSiServlet", value = {"/BacSi/load", "/BacSi/detail", "/BacSi/add" , "/BacSi/404"})
public class BacSiServlet extends HttpServlet {
    BacSiRepository repoBacSi = new BacSiRepository();
    List<BacSiEntity> listBS = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("load")) {
            this.getAll(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.equals("/BacSi/404")) {
            System.out.println("Loi 404");
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listBS = repoBacSi.getAll();
        request.setAttribute("listBS", listBS);
        request.getRequestDispatcher("/View/BacSi/BacSi.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maBs");
        BacSiEntity bs = repoBacSi.getOne(ma);
        request.setAttribute("bs", bs);
        this.getAll(request, response);
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BacSiEntity bs = new BacSiEntity();
        BeanUtils.populate(bs, request.getParameterMap());
        repoBacSi.addOrUpdate(bs);
        this.getAll(request, response);

    }
    // abc xyz
    //123

}
