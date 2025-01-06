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
        <form action="/hoadon/add" method="post">
            <fieldset>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Mã Hóa Đơn</label>
                    <input type="text" id="disabledTextInput" class="form-control" name="maHd" value="${hd.maHd}">
                </div>
                <div class="mb-3">
                    <label for="disabledSelect" class="form-label">Bác Sĩ</label>
                    <select id="disabledSelect" class="form-select" name="maBs">
                        <c:forEach items="${listbs}" var="bs">
                            <option value="${bs.maBs}" ${bs.maBs == hd.maBs ? 'SELECTED' : ''}>${bs.tenBs}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="benhNhan" class="form-label">Bệnh nhân</label>
                    <select id="benhNhan" class="form-select" name="maBn">
                        <c:forEach items="${listbn}" var="bn">
                            <option value="${bn.maBn}" ${bn.maBn == hd.maBn ? 'SELECTED' : ''}>${bn.tenBn}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label class="form-label">Ngày khám</label>
                    <input class="form-control" type="date" name="ngayKham" id="ngayKham" value="${hd.ngayKham}">
                </div>
                <div>
                    <label class="form-label">Tổng tiền</label>
                    <input class="form-control" type="number" name="tongTien" id="tongTien" value="${hd.tongTien}">
                </div>
                <div>
                    <label class="form-label">Tiền cần thanh toán</label>
                    <input class="form-control" type="number" name="thanhToan" id="thanhToan" value="${hd.thanhToan}">
                </div>
                <div>
                    <label class="form-label">Tiền thừa</label>
                    <input class="form-control" type="number" name="tienThua" id="tienThua" value="${hd.tienThua}">
                </div>
                <div>
                    <label class="form-label">Trạng thái</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="trangThai" id="trangThai" value="Đã Thanh Toán" ${hd.trangThai == "Đã Thanh Toán" ? "checked" : ""}>
                        <label class="form-check-label" for="trangThai" >
                            Đã thanh toán
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="trangThai" id="trangThaiChua" value="Chưa Thanh Toán"  ${hd.trangThai == "Chưa Thanh Toán" ? "checked" : ""}>
                        <label class="form-check-label" for="trangThaiChua" >
                            Chưa thanh toán
                        </label>
                    </div>
                </div>
                <br><br>
                <div class="mb-3">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="disabledFieldsetCheck">
                        <label class="form-check-label" for="disabledFieldsetCheck">
                            Xác nhận tạo hóa đơn
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </fieldset>
        </form>
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
                <th scope="col">Tiền Thừa</th>
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
                        <td>${hd.tienThua}</td>
                        <td>${hd.trangThai}</td>
                        <td>
                            <a href="/hoadon/detail?maHoaDon=${hd.maHd}"><button type="button" class="btn btn-primary">Detail</button></a>
                            <a href="/hoadon/delete?maHoaDon=${hd.maHd}"><button type="button" class="btn btn-danger">Delete</button></a>
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
