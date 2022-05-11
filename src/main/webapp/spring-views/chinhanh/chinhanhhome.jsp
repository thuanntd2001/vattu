<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>


<head>

 <meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>QLVT</title>

<!-- Favicons -->
<!-- <link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
 -->
<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<!-- Template Main CSS File -->
<link href="<c:url value='/common/chiNhanh/assets/css/style.css'/>" rel="stylesheet" type="text/css"> 
<link href="<c:url value='/common/chiNhanh/assets/css/css.css'/>" rel="stylesheet" type="text/css"> 

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>


</head>
<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
      
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->
        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <span class="d-none d-md-block dropdown-toggle ps-2">Phương Phạm</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li>
              <hr class="dropdown-divider">
            </li>
            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Thông tin cá nhân</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <i class="bi bi-box-arrow-right"></i>
                <span>Đăng xuất</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link collapsed" href="Nhanvien.html">
          <i class="bi bi-person-fill"></i>
          <span>Nhân viên</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="Vattu.html">
          <i class="bi bi-briefcase-fill"></i>
          <span>Vật tư</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="Kho.html">
          <i class="bi bi-house-fill"></i>
          <span>Kho</span>
        </a>
      </li>

    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Kho</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="Kho.html">Kho</a></li>
          <li class="breadcrumb-item active">Đơn đặt hàng</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              
              <!-- Bordered Table -->
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th scope="col">Mã số DDH</th>
                    <th scope="col">Ngày nhập</th>
                    <th scope="col">Nhà cung cấp</th>
                    <th scope="col">Mã NV</th>
                    <th scope="col">Mã Kho</th>
                    <th scope="col">Thao tác</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">001</th>
                    <td>10-10-2010</td>
                    <td>DH-Food</td>
                    <td>001</td>
                    <td>001</td>
                    <td>
                      <!-- Add icon library -->

                      <a href="CTDDH.html" class="fa fa-eye"></a>
                      <a href="Phieunhap.html" class="fa fa-indent"></a>
                      <a href="edit-Donhang.html" class="fa fa-pencil-square-o"></a>
                      
                      

                    </td>
                  </tr>
                  
                </tbody>
              </table>
              <a href="add-DDH.html" class="fa fa-plus"></a>
            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->


  <!-- Vendor JS Files -->
  <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/chart.js/chart.min.js"></script>
  <script src="assets/vendor/echarts/echarts.min.js"></script>
  <script src="assets/vendor/quill/quill.min.js"></script>
  <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>