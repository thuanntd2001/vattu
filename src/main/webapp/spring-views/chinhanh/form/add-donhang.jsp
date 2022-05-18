<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>QLVT</title>
<!-- ======= Head ======= -->
<jsp:include page="/template/cn1/chinhanh/head.jsp" />

</head>
<body>

	<!-- ======= Header ======= -->
	<jsp:include page="/template/cn1/chinhanh/header.jsp" />

	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<jsp:include page="/template/cn1/chinhanh/sidebar.jsp" />

	<!-- End Sidebar-->


	  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Nhân viên</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="Kho.html">Kho</a></li>
          <li class="breadcrumb-item"><a href="Donhang.html">Đơn hàng</a></li>
          <li class="breadcrumb-item active">Thêm đơn đặt hàng</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-sm">
          <div class="col-lg-15">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Thêm đơn đặt hàng</h5>



							<form:form action="quanlydonhang/cn1/chinhanh/add.htm"
							method="post" modelAttribute="dh" class="row g-3">
					
							<div class="col-md-5">
								 <label for="inputEmail5" class="form-label">Mã số DDH</label>
                        		 <form:input type="email" class="form-control" id="inputEmail5" path="maSoDDH"/>
							</div>
							<div class="col-md-5">
								<label for="inputPassword5" class="form-label">Nhà cung cấp</label>
								<form:input type="text" class="form-control" id="inputPassword5" path="nhaCC" />
							</div>
							<div class="col-md-5">
								<label for="inputPassword5" class="form-label">Mã Kho</label>
								<form:input type="text" class="form-control" id="inputPassword5" path="" />
							</div>




							

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Tạo</button>
								<button type="reset" class="btn btn-secondary">Reset</button>
							</div>
						</form:form>




						</div>
                </div>
              </div>
            </div>


            <div class="col-sm">
              <div class="col-lg-15">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">Kho</h5>
                    <table class="table table-bordered border-primary">
                      <thead>
                        <tr>
                          <th scope="col">Mã Kho</th>
                          <th scope="col">Tên Kho</th>
                          <th scope="col">Địa chỉ</th>
                          <th scope="col">Mã chi nhánh</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th scope="row">001</th>
                          <td>Đồng Nai</td>
                          <td>Đồng Nai</td>
                          <td>01</td>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
      </div>
    </section>

  </main><!-- End #main -->
	<!-- End #main -->
	<jsp:include page="/template/cn1/chinhanh/footer.jsp" />


</body>

</html>