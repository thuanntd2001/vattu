<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Đơn Nhập Hàng</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div style="margin-top: 5%;" class="container">
		<form:form action="admin-home/formNhapHang.htm" modelAttribute="nh"
			method="post">
			<div class="form-group">
				<label>ID</label>
				<form:input readonly="true" path="id" type="number" />
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Tên Nguyên Liệu</label>
					<form:input path="tenNL" type="text"
						placeholder="Bột cacao, Sữa đặc, Sữa chua,...." />
				</div>

			</div>
			<div class="form-group">
				<label>Số Lượng</label>
				<form:input path="soLuong" type="number" class="form-control"
					placeholder="1234" />
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Giá Mỗi Dịch Vụ</label>
					<form:input path="giaMoiDV" type="number" />
				</div>
				<div class="form-group col-md-4">

					<label>Loại Dịch Vụ</label>
					<form:input path="loai" type="text" />
				</div>
				<div class="form-group col-md-2">
					<div class="form-group col-md-2">
						<label>Dịch Vụ</label>
						<form:input path="dv" type="text" />
					</div>
				</div>

			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Nhà Cung Cấp</label>
					<form:input path="nhaCungCap" type="text" />
				</div>

				<div class="form-group col-md-6">
					<div class="form-group col-md-4">
						<label>Ghi Chú</label>
						<form:input path="ghiChu" type="text" />
					</div>
				</div>

				<div class="form-group col-md-6">
					<div class="form-group col-md-4">
						<label>Ngày Nhập</label> <input name="ngaynhaphang"
							type="datetime-local" id="set-date" value="${ngaynhaphang}" />
					</div>
				</div>


				<%--  <div class="form-group col-md-6">
					<label>Nhân Viên Tạo</label>
					<form:input path="cpnv" readonly="true" type="text"
						placeholder="Nhân Viên Tạo" value="${NHANVIEN.maNV}" />
				</div> --%>

			</div>


			<button class="btn btn-primary" type="submit"
				name="${btnupdate ? 'btnupdate' : 'Insert'}">${btnupdate ? 'Update' : 'Insert'}</button>
			<a style="font-size: 16px; padding: 10px;" class="btn btn-secondary"
				href="admin-home/admin-nhaphang.htm"> QUAY LẠI </a>
		</form:form>
	</div>

</body>
</html>