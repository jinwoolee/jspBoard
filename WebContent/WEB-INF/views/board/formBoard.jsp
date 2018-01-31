<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/customCss.jsp"%>
<%@ include file="/WEB-INF/views/common/jquery.jsp"%>
<script>
$(function(){
	initEvent();
});

function initEvent(){
	//저장버튼 핸들러
	$("#save").on("click", function(){
		$("#frm").attr("method", "post");
		$("#frm").attr("action", "/formBoard");
		$("#frm").submit();
	});
	
	//취소버튼 핸들러
	$("#cancel").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "/formBoardList");
		$("#frm").submit();
	});
}
</script>
</head>
<body>
<form id="frm" method="post" action="/formBoard">
제목 : <input type="text" name="title"/> <br/>
내용 : <textarea name="content"></textarea> <br/>

	<input type="hidden" name="pBoardno" value="${pBoardno}">
	<input type="hidden" name="categoryNo" value="${categoryNo}">
	<input type="hidden" name="ord" value="0">
	<button id="save">저장</button>
	<button id="cancel">취소</button>
</form>
</body>
</html>