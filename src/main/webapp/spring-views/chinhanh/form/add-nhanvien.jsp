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
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="quanlynhanvien/chinhanh.htm">Nhân Viên</a></li>
				<li class="breadcrumb-item active">Thêm Nhân viên</li>
			</ol>
		</nav>
	</div>
	<section class="section">
		<div class="row">
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thông tin nhân viên</h5>

						<!-- Multi Columns Form -->
						<form:form action="quanlynhanvien/chinhanh/add.xml" method="post"
							modelAttribute="nv" class="row g-3">
							<div class="col-md-2">
								<label for="inputState" class="form-label">Chi Nhánh</label>
								<form:select id="inputState" class="form-select" path="listOfDates">
									<form:options items="${chiNhanhs}"></form:options>
								</form:select>
							</div>
							<div class="col-md-5">
								<label for="inputEmail5" class="form-label">Họ</label> <input
									type="email" class="form-control" id="inputEmail5">
							</div>
							<div class="col-md-5">
								<label for="inputPassword5" class="form-label">Tên</label> <input
									type="password" class="form-control" id="inputPassword5">
							</div>
							<div class="col-md-7">
								<label for="inputDate" class="col-sm-2 col-form-label">Ngày
									sinh</label>
								<div class="col-md-10">
									<input type="date" class="form-control">
								</div>
							</div>
							<div class="col-md-4">
								<label for="inputCity" class="form-label">Lương</label> <input
									type="text" class="form-control" id="inputCity">
							</div>
							<div class="col-md-12">
								<label for="inputAddress5" class="form-label">Đia Chỉ</label> <input
									type="text" class="form-control" id="inputAddres5s"
									placeholder="TPHCM">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Tạo</button>
								<button type="reset" class="btn btn-secondary">Reset</button>
							</div>
						</form:form>
						<!-- End Multi Columns Form -->

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