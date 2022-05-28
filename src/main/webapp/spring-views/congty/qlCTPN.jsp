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
<jsp:include page="/template/cn1/congty/head.jsp" />

</head>
<body>

	<!-- ======= Header ======= -->
	<jsp:include page="/template/cn1/congty/header.jsp" />

	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<jsp:include page="/template/cn1/congty/sidebar.jsp" />

	<!-- End Sidebar-->


	<main id="main" class="main">

	<div class="pagetitle">
		<h1>Đơn hàng</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href=""quanlykho/cn1/congty.htm"">Kho</a></li>
				<li class="breadcrumb-item"><a
					href="quanlydondathang/cn1/congty.htm">Đơn hàng</a></li>
				<li class="breadcrumb-item"><a
					href="quanlyphieunhap/cn1/congty.htm">Phiếu nhập</a></li>
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
									<th scope="col">tên VT</th>
									<th scope="col">Số Lượng</th>
									<th scope="col">Đơn giá</th>
							
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${ddhs }" var="k">
									<tr>

										<th scope="row">${k.phieuNhap.maPN}</th>
										<td>${k.vatTu.tenVT}</td>
										<td>${k.soLuong}</td>
										<td>${k.donGia}VNĐ</td>

										
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

	<jsp:include page="/template/cn1/congty/footer.jsp" />


</body>

</html>