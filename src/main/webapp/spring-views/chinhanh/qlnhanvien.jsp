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
		<h1>Nhân viên</h1>
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
									<th scope="col">Mã NV</th>
									<th scope="col">Họ</th>
									<th scope="col">Tên</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Ngày sinh</th>
									<th scope="col">Lương</label></th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">001</th>
									<td>Phạmđạkhạhjkshfhdshfhdskfhjkdshfdhjkfhkjdhkjsdhkj</td>
									<td>Phương</td>
									<td>TP.HCM</td>
									<td>01-01-2001</td>
									<td>1 USD</td>
									<td><a href="edit-nhanvien.html"
										class="fa fa-pencil-square-o"></a> <a href="#"
										class="fa fa-times-circle"></a>
								</tr>

							</tbody>
						</table>
						<!-- End Table with stripped rows -->
						<a href="quanlynhanvien/chinhanh/add.htm" class="fa fa-plus"></a>
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