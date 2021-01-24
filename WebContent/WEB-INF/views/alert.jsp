<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

		<title>경고</title>
		
		<c:if test="${requestScope.alert == 'wrong'}">
			<script>
				alert('아이디 혹은 비밀번호가 잘못 되었습니다.');
				location.href = './addList'; //다시 addList로
			</script>
		</c:if>
	</head>

</html>