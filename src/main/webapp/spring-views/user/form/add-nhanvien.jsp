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
<jsp:include page="/template/cn1/user/head.jsp" />

</head>
<body>

	<!-- ======= Header ======= -->
	<jsp:include page="/template/cn1/user/header.jsp" />

	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<jsp:include page="/template/cn1/user/sidebar.jsp" />

	<!-- End Sidebar-->


	<main id="main" class="main">

	<div class="pagetitle">
		<h1>Nhân viên</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="quanlynhanvien/cn1/user.htm">Nhân Viên</a></li>
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
						${message}
						<!-- Multi Columns Form -->
						<form:form action="quanlynhanvien/cn1/user/add.htm"
							method="post" modelAttribute="nv" class="row g-3">
					
							<div class="col-md-6">
								<label for="inputEmail5" class="form-label">Họ</label>
								<form:input type="text" class="form-control" id="inputEmail5"
									path="ho" />
							</div>
							<div class="col-md-6">
								<label for="inputPassword5" class="form-label">Tên</label>
								<form:input type="text" class="form-control" id="inputPassword5"
									path="ten" />
							</div>




							<!-- 	<div class="col-md-9">
								<label for="inputDate" class="col-sm-2 col-form-label">Ngày
									sinh</label>
								<div class="col-md-10">
									<input type="date" class="form-control">
								</div>
							</div>
							 -->
							 <br>
							
								<label for="set-date" style="margin-left: 13px; margin-top: 15px">Ngày sinh:</label> 
								<div class="col-md-12">
									<input type="datetime-local" id="set-date" name="tg" style="margin-left:10px" >
								</div>
							</div>
							<div class="col-md-4">
								<label for="inputCity" class="form-label">Lương</label>
								<form:input type="number" class="form-control" id="inputCity"
									path="luong" />
							</div>
							<div class="col-md-12">
								<label for="inputAddress5" class="form-label">Đia Chỉ</label>
								<form:input type="text" class="form-control" id="inputAddres5s"
									placeholder="TPHCM" path="diaChi" />
							</div>

							<div class="text-center" style="margin-top:15px">
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
	<jsp:include page="/template/cn1/user/footer.jsp" />


</body>

</html>