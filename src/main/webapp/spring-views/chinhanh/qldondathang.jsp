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
		<h1>Đơn Đặt Hàng</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="Kho.html">Kho</a></li>
				<li class="breadcrumb-item active">Đơn đặt hàng</li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">

						<!-- Bordered Table -->
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Mã số DDH</th>
									<th scope="col">Ngày nhập</th>
									<th scope="col">Nhà cung cấp</th>
									<th scope="col">Mã NV</th>
									<th scope="col">Mã Kho</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ddhs }"
											var="k">
											<tr>

												<th scope="row">${k.maSoDDH}</th>
												<td>${k.ngay}</td>
												<td>${k.nhaCC}</td>
												<td>${k.nhanVien.maNV}</td>
												<td>${k.kho.maKho}</td>
												<td><a href="CTDDH.html" class="fa fa-eye"></a> <a
													href="Phieunhap.html" class="fa fa-indent"></a> <a
													href="edit-Donhang.html" class="fa fa-pencil-square-o"></a></td>
											</tr>
										</c:forEach>
							</tbody>
						</table>
						<a href="quanlydondathang/chinhanh/add.htm" class="fa fa-plus"></a>
					</div>
				</div>

			</div>
		</div>
	</section>

	</main>
	<!-- End #main -->
	<jsp:include page="/template/chinhanh/footer.jsp" />


</body>

</html>