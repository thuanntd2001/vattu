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
		<h1>Xem Báo Cáo</h1>
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
									<th scope="col">Tên báo cáo</th>
									<th scope="col">Xem</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<th scope="row">Danh sách nhân viên</th>
										<td><a href="baocaodanhsachnhanvien/cn1/chinhanh.htm" class="fa fa-eye"></a></td>
									</tr>
									<tr>
										<th scope="row">Danh sách vật tư</th>
										<td><a href="baocaodanhsachvattu/cn1/chinhanh.htm" class="fa fa-eye"></a></td>
									</tr>
									<tr>
										<th scope="row">Đơn đặt hàng không có phiếu nhập</th>
										<td><a href="baocaodondathangkhongcophieunhap/cn1/chinhanh.htm" class="fa fa-eye"></a></td>
									</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</section>

	</main>
	<!-- End #main -->

	<jsp:include page="/template/cn1/chinhanh/footer.jsp" />
</body>

</html>