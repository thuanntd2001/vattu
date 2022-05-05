<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Thực Đơn</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
	<div style="margin-top: 5%;" class="container">
		<form:form action="admin-home/formThucDon.htm" modelAttribute="td"
			method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>ID</label>
					<form:input path="id" type="text" placeholder="" />
				</div>

			</div>
			<label>Tên Loại Thức Uống</label>
			<div class="form-group">
				<div class="select-menu">

					<h5>
						<select name="loaithucuong">
							<c:forEach items="${loaithucuongs}" var="loai">

								<option value="${loai.id}"
									<c:if test="${loai.id == idloaiTU}" >selected</c:if>>
									${loai.tenLoai}</option>
							</c:forEach>
						</select>
					</h5>


				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Tên Thức Uống</label> <input value="${ten}" name="ten"
						type="text" />
				</div>
				<div class="form-group col-md-4">

					<label>Giá Thành</label> <input value="${gia}" name="gia"
						type="number" />
				</div>
			</div>


			<button class="btn btn-primary" type="submit"
				name="${btnupdate ? 'btnupdate' : 'Insert'}">${btnupdate ? 'Update' : 'Insert'}</button>
			<a style="font-size: 16px; padding: 10px;" class="btn btn-secondary"
				href="admin-home/admin-qlthucdon.htm"> QUAY LẠI </a>
		</form:form>
	</div>

</body>
</html>