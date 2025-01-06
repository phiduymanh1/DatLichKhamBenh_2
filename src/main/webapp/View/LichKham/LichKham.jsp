<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhp
  Date: 12/17/2024
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lịch khám</title>
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
      <li class="nav-item">
        <a class="nav-link text-light" href="/LichKham/load/load">Lịch khám</a>
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
          <label for="disabledTextInput" class="form-label">Mã Lịch Khám</label>
          <input type="text" id="disabledTextInput" class="form-control" name="maLk" >
        </div>
        <div>
          <label class="form-label">Mã Bệnh Nhân</label>
          <input class="form-control" type="text" name="benhNhan">
        </div>
        <div>
          <label class="form-label">Mã Bác Sĩ</label> <br>
          <input type="text" name="bacSi" id="moTa" class="form-control">
        </div>
        <div>
          <label class="form-label">Ngày Khám</label>
          <input class="form-control" type="date" name="ngayKham">
        </div>
        <div>
          <label class="form-label">Giờ Khám</label>
          <input class="form-control" type="time" name="gioKham">
        </div>
        <div>
          <label class="form-label">Trạng Thái</label>
          <input class="form-control" type="number" name="trangThai">
        </div>
        <br><br>
        <button type="submit" class="btn btn-primary">Add</button>
      </fieldset>
    </form>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã Lịch Khám</th>
        <th scope="col">Mã Bệnh Nhân</th>
        <th scope="col">Mã Bác Sĩ</th>
        <th scope="col">Ngày Khám</th>
        <th scope="col">Giờ Khám</th>
        <th scope="col">Trạng Thái</th>
        <th scope="col">Hành Động</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="lk" items="${listLK}" varStatus="i">
        <tr>
          <td>${i.index +1}</td>
          <td>${lk.maLk}</td>
          <td>${lk.benhNhan.maBn}</td>
          <td>${lk.bacSi.maBs}</td>
          <td>${lk.ngayKham}</td>
          <td>${lk.gioKham}</td>
          <td>${lk.trangThai}</td>
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
