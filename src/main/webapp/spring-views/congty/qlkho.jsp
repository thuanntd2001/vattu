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
									<th scope="col">Xem</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${ks }" var="k">
									<tr>

										<th scope="row">${k.maKho}</th>
										<td>${k.tenKho}</td>
										<td>${k.diaChi}</td>
										<td>${k.chiNhanh.maCN}</td>

										<td><a
											href="quanlydondathang/cn1/congty.htm?idkho=${k.maKho}"
											class="fa fa-file-text-o"> <br>Đơn đặt hàng
										</a> <a href="quanlyphieuxuat/cn1/congty.htm?idkho=${k.maKho}"
											class="fa fa-outdent"><br>Phiếu xuất</a></td>

										<td><a
											href="quanlykho/cn1/congty/edit.htm?id=${k.maKho}"
											class="fa fa-pencil-square-o"></a> <a
											href="quanlykho/cn1/congty/xoa.htm?id=${k.maKho}"
											class="fa fa-times-circle"></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- End Primary Color Bordered Table -->
						<a href="quanlykho/cn1/congty/add.htm" class="fa fa-plus"></a>
					</div>
				</div>
			</div>
		</div>
	</section>

	</main>
	<!-- End #main -->
	<jsp:include page="/template/cn1/congty/footer.jsp" />
	<!-- End #main -->


</body>

</html>