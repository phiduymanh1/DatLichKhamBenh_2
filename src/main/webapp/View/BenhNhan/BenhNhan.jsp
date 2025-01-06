<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NGUYEN DOAN
  Date: 24/12/2024
  Time: 10:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bệnh nhân</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <header class="row bg-primary p-2">
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link active text-light" aria-current="page" href="#">Trang chủ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="/BacSi/load">Bác sĩ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="/BenhNhan/load">Bệnh nhân</a>
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
        <form action="" method="post">
            <fieldset>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Mã Bệnh Nhân:</label>
                    <input type="text" id="disabledTextInput" class="form-control" name="maBn" >
                </div>
                <div>
                    <label class="form-label">Tên Bệnh Nhân</label>
                    <input class="form-control" type="text" name="tenBn">
                </div>
                <div>
                    <label class="form-label">Số Điện Thoại</label> <br>
                    <input class="form-control" type="text" name="soDienThoai" id="moTa" >
                </div>
                <div>
                    <label class="form-label">Địa Chỉ</label>
                    <input class="form-control" type="number" name="diaChi">
                </div>
                <div>
                    <label class="form-label">Email</label>
                    <input class="form-control" type="number" name="email">
                </div>
                <div>
                    <label class="form-label">Giới tính</label>
                    <input type="radio" name="gioiTinh" class="form-check-input">Nam
                    <input type="radio" name="gioiTinh" class="form-check-input">Nữ
                </div>
                <div>
                    <label>Ngày sinh</label>
                    <input class="form-control" type="date" name="ngaySinh">
                </div>
                <br><br>
                <button type="submit" class="btn btn-primary">Add</button>
            </fieldset>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã bệnh nhân</th>
                <th scope="col">Tên bệnh nhân</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Email</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="bn" items="${listBN}" varStatus="i">
                <tr>
                    <td>${i.index +1}</td>
                    <td>${bn.maBn}</td>
                    <td>${bn.tenBn}</td>
                    <td>${bn.soDienThoai}</td>
                    <td>${bn.diaChi}</td>
                    <td>${bn.email}</td>
                    <td>${bn.gioiTinh}</td>
                    <td>${bn.ngaySinh}</td>
                    <td>
                        <button type="button" class="btn btn-primary">Detail</button>
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
