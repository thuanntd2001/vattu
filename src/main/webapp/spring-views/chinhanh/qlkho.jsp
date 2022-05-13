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
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<!-- Primary Color Bordered Table -->
						<table class="table table-bordered border-primary">
							<thead>
								<tr>
									<th scope="col">Mã Kho</th>
									<th scope="col">Tên Kho</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Mã chi nhánh</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">001</th>
									<td>Đồng Nai</td>
									<td>Đồng Nai</td>
									<td>01</td>
									<td><a href="Donhang.html" class="fa fa-file-text-o"> Đơn đặt hàng</a>
										<a href="PhieunhapnoDDH.html" class="fa fa-list"> Phiếu nhập</a> <a
										href="Phieuxuat.html" class="fa fa-outdent">Phiếu xuất</a></td>
							</tbody>
						</table>
						<!-- End Primary Color Bordered Table -->

					</div>
				</div>
			</div>
		</div>
	</section>

	</main>
	<!-- End #main -->
	<jsp:include page="/template/chinhanh/footer.jsp" />
	<!-- End #main -->


</body>

</html>