<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Advertiser</title>
</head>
<body>
<div style="border:1px solid #ccc;text-align:right;padding:5px;">
   <a href="${pageContext.request.contextPath}/chinhanh/list">Publisher List</a>
   &nbsp;&nbsp;
   <a href="${pageContext.request.contextPath}/congty/list">Advertiser List</a>
</div>

<h1>Publisher Page</h1>

<c:forEach var="item" items="${publishers}" varStatus="status">

  ${item}  <br/>
 
</c:forEach>

</body>
</html>