<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/common/customCss.jsp" %>	<%--css --%>
<%@ include file="/WEB-INF/views/common/jquery.jsp" %>	<%--jquery --%>
<script>
$(function(){
	initEvent();	
});

function initEvent(){
	$("#formBoard").on("click", function(){
		$("#frm").attr("action", "/formBoardList");
		$("#frm").submit();
	});
}
</script>

</head>
<body>

<form id="frm" method="get" action=""/>
	<span id="formBoard" class="pointer" >게시판 리스트 (form)</span> <br>  
	<span id="ajaxBoard" class="pointer" >게시판 리스트 (ajax)</span> <br>
</form>
</body>
</html>