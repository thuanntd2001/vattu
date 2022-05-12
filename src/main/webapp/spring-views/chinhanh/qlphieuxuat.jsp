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
   <jsp:include page="/template/chinhanh/head.jsp" /> 

</head>
<body>

	<!-- ======= Header ======= -->
	<jsp:include page="/template/chinhanh/header.jsp" /> 

	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
		<jsp:include page="/template/chinhanh/sidebar.jsp" />

	<!-- End Sidebar-->


  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Kho</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="Kho.html">Kho</a></li>
          <li class="breadcrumb-item"><a href="Donhang.html">Đơn hàng</a></li>
          <li class="breadcrumb-item active">Phiếu xuất</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              
              <!-- Bordered Table -->
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th scope="col">Mã PX</th>
                    <th scope="col">Ngày</th>
                    <th scope="col">HotenKH</th>
                    <th scope="col">Mã NV</th>
                    <th scope="col">Mã Kho</th>
                    <th scope="col">Thao tác</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">001</th>
                    <td>10-10-2010</td>
                    <td>DH-Food</td>
                    <td>001</td>
                    <td>001</td>
                    <td>
                      <a href="CTPX.html" class="fa fa-eye"></a>
                    </td>
                  </tr>                  
                </tbody>
              </table>
              <a href="add-PX1.html" class="fa fa-plus"></a>
            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->
<jsp:include page="/template/chinhanh/footer.jsp" />


</body>

</html>