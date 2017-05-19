<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

il capitolo attuale è ${paginaAttuale}

<br>
<br>

  <select name="capitoli" id="capitoli" onchange="window.location=this.value;">
    <c:forEach items="${sessionScope.pagine }" var="val"> 
    il valore di val.numeroCapitolo è ${val.numeroCapitolo}
    
        <option value="${pageContext.servletContext.contextPath}/index/${val.serie.titolo}/${val.numeroCapitolo}" ${paginaAttuale == val.numeroCapitolo ? 'selected' : ' '}><c:out value="${val.titoloCapitolo}" ></c:out></option>   
    </c:forEach>                     
</select>



	<c:choose>
		<c:when test="${sessionScope.pagine != null}">
			<c:forEach var="paginaCorrente" items="${sessionScope.pagine}">
				${paginaCorrente.titoloCapitolo}

				<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:redirect url="/serie2" />
		</c:otherwise>
	</c:choose>












</body>
</html>