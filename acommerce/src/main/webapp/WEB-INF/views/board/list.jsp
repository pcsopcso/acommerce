<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>로그인 페이지</title>
</head>

<body>
<h2>상품목록</h2>
<sec:authorize access="isAuthenticated()">
    <table border="1">
        <tr>
            <th>상품번호</th>
            <th>상품명</th>
            <th>가격</th>
            <th>상품설명</th>
        </tr>
        
        <c:forEach var="row" items="${list}">
        <tr>
            <td>
                ${row.id}
            </td>
            <td>
                ${row.productname}
            </td>
            <td>
                <fmt:formatNumber value="${row.price}" pattern="###,###,###"/>
            </td>
            <td>
                ${row.description}
            </td>
        </tr>
        </c:forEach>
         
    </table>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<p><a href="<c:url value="/login/loginForm.do" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="로그아웃" />
</form:form>
</sec:authorize>

<h3>
    [<a href="<c:url value="/intro/introduction.do" />">소개 페이지</a>]
    [<a href="<c:url value="/home.do" />">홈</a>]
    [<a href="<c:url value="/admin/adminHome.do" />">관리자 홈</a>]
</h3>
</body>
</html>
