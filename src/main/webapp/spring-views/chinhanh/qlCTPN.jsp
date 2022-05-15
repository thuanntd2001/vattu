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
				<li class="breadcrumb-item"><a href="Phieunhap.html">Phiếu
						Nhập</a></li>
				<li class="breadcrumb-item active">Chi tiết phiếu nhập</li>
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
									<th scope="col">Mã PN</th>
									<th scope="col">Mã VT</th>
									<th scope="col">Số Lượng</th>
									<th scope="col">Đơn giá</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${ddhs }" var="k">
									<tr>

										<th scope="row">${k.phieuNhap.maPN}</th>
										<td>${k.vatTu.maVT}</td>
										<td>${k.soLuong}</td>
										<td>${k.donGia}VNĐ</td>

										<td><a href="edit-PX.html" class="fa fa-pencil-square-o"></a>
									</tr>
								</c:forEach>

							</tbody>
						</table>
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