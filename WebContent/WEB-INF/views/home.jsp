<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX</title>




<style>
body {
	background-image: url("resources/imageind/sfondo2.jpg");
	background-attachment: fixed;
}
</style>


</head>


<body>

	<div style="width: 100%; text-align: center; padding-right: 15px;">



		<c:choose>
			<c:when test="${sessionScope.listaSerie != null}">
				<c:forEach var="serie" items="${sessionScope.listaSerie}">
					<a	href="${pageContext.servletContext.contextPath}/index/${serie.titolo}">
					
							<img src="resources/imageind/${serie.start}" alt="${serie.titolo}" 	width="750">
					</a>

					<br>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:redirect url="/serie2" />
			</c:otherwise>
		</c:choose>

		



	</div>
</body>
</html>