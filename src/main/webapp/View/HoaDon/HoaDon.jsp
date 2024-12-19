<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhp
  Date: 12/13/2024
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <header class="row bg-primary p-2">
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link active text-light" aria-current="page" href="#">Trang chủ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="#">Bác sĩ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="#">Bệnh nhân</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="/dichVuKham/load">Dịch vụ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="/hoadon/load">Hóa đơn</a>
            </li>
        </ul>
    </header>
<%--    <nav class="row bg-primary p-2">Nav</nav>--%>
<%--    <section class="row">--%>
<%--        <aside class="col-sm-4 bg-success p-5">Side bar</aside>--%>
<%--        <article class="col-sm-8 bg-info p-5">Main content</article>--%>
<%--    </section>--%>
    <section>
<%----%><br><br><br><br><br>
    <a href="/View/HoaDon/HoaDonDetail.jsp"><button type="button" class="btn btn-success">Thêm hóa đơn</button></a>
    <br><br><br>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã Hóa Đơn</th>
                <th scope="col">Mã Bệnh Nhân</th>
                <th scope="col">Mã Bác Sĩ</th>
                <th scope="col">Ngày Khám</th>
                <th scope="col">Tổng Tiền</th>
                <th scope="col">Thanh Toán</th>
                <th scope="col">Trạng Thái</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="hd" items="${listhd}" varStatus="i">
                    <tr>
                        <td>${i.index +1}</td>
                        <td>${hd.maHd}</td>
                        <td>${hd.maBn}</td>
                        <td>${hd.maBs}</td>
                        <td>${hd.ngayKham}</td>
                        <td>${hd.tongTien}</td>
                        <td>${hd.thanhToan}</td>
                        <td>${hd.trangThai}</td>
                        <td>
                            <a href="/hoadon/detail?maHoaDon=${hd.maHd}"><button type="button" class="btn btn-primary">Detail</button></a>
                            <button type="button" class="btn btn-danger">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <footer class="row bg-secondary p-3">
        <p style="text-align: center" class="text-light">Đặt Lịch Khám Bệnh</p>
    </footer>
</div>
</body>
</html>
