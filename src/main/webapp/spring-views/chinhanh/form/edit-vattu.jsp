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
						${message}
						<!-- Multi Columns Form -->
						<form:form action="quanlyvattu/cn1/chinhanh/edit.htm"
							method="post" modelAttribute="vt" class="row g-3">
							<%-- <div class="col-md-2">
								<label for="inputState" class="form-label">Chi Nhánh</label>
								<form:select path="chiNhanh">
									 
										 <form:options value="${chiNhanhHT}" label="${chiNhanhHT.chiNhanh} "></form:options> 
										 <form:input path="chiNhanh" value="${chiNhanhHT}" label="${chiNhanhHT.chiNhanh} "  />
								</form:select>
							</div> --%>
							<div class="col-md-5">
								
								<form:input type="hidden" class="form-control" id="inputEmail5"
									path="maVT" />
							</div>
							<div class="col-md-5">
								<label for="inputEmail5" class="form-label">Tên VT</label>
								<form:input type="text" class="form-control" id="inputEmail5"
									path="tenVT" />
							</div>
							<div class="col-md-4">
								<label for="inputState" class="form-label">Đơn vị tính</label> <br>
								<form:input path="donViTinh" />
								<br>
							</div>

							<div class="col-md-6">
								<div class="col-md-10">
									<label for="inputCity" class="form-label">Số lượng tồn</label>
									<form:input type="number" min="1" max="10000" 
										path="soLuongTon" />
								</div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Sửa</button>
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
	<jsp:include page="/template/cn1/chinhanh/footer.jsp" />


</body>

</html>