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
		<h1>Vật tư</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="quanlyvattu/chinhanh.htm">Vật tư</a></li>
				<li class="breadcrumb-item active">Thêm Vật tư</li>
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
						<form class="row g-3">
							<div class="col-md-6">
								<label for="inputEmail5" class="form-label">Mã VT</label> <input
									type="email" class="form-control" id="inputEmail5">
							</div>
							<div class="col-md-6">
								<label for="inputPassword5" class="form-label">Tên VT</label> <input
									type="password" class="form-control" id="inputPassword5">
							</div>

							<div class="col-md-6">
								<div class="col-md-10">
									<label for="inputCity" class="form-label">Số lượng tồn</label>
									<input type="number" min="1" max="10000" step="5"
										class="form-control" id="inputCity">
								</div>
							</div>

							<div class="col-md-4">
								<label for="inputState" class="form-label">Đơn vị tính</label> <br> <select
									id="inputState" class="form-select"><br />
									<option selected>...</option>
									<option>Cái</option>
									<option>Kg</option>
								</select>
								<br>
							</div>

							
							<div >
							<br><br><br>
								<button type="submit" class="btn btn-primary">Thêm</button>

							</div>
						</form>
						<!-- End Multi Columns Form -->

					</div>
				</div>

			</div>
		</div>
	</section>

	</main>
	<!-- End #main -->

	<!-- End #main -->
	<jsp:include page="/template/chinhanh/footer.jsp" />


</body>

</html>