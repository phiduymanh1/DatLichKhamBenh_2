<%--
  Created by IntelliJ IDEA.
  User: manhp
  Date: 12/26/2024
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DichVuKhamDetail</title>
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
        <form action="/dichVuKham/update" method="post">
            <fieldset>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Mã Dịch Vụ Khám</label>
                    <input type="text" id="disabledTextInput" class="form-control" name="maDvk" value="${dvk.maDvk}">
                </div>
                <div>
                    <label class="form-label">Tên Dịch Vụ Khám</label>
                    <input class="form-control" type="text" name="tenDvk" id="tenDvk" value="${dvk.tenDvk}">
                </div>
                <div>
                    <label class="form-label">Mô tả</label> <br>
                    <textarea name="moTa" id="moTa" style="width: 100%" rows="3" value="${dvk.moTa}">${dvk.moTa}</textarea>
                </div>
                <div>
                    <label class="form-label">Giá tiền</label>
                    <input class="form-control" type="number" name="giaTien" id="giaTien" value="${dvk.giaTien}">
                </div>
                <br><br>
                <button type="submit" class="btn btn-primary">Update</button>
            </fieldset>
        </form>
    </section>
    <footer class="row bg-secondary p-3">
        <p style="text-align: center" class="text-light">Đặt Lịch Khám Bệnh</p>
    </footer>
</div>
</body>
</html>
