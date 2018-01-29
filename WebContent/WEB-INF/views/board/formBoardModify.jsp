<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세조회</title>

<%@ include file="/WEB-INF/views/common/customCss.jsp" %>
<%@ include file="/WEB-INF/views/common/jquery.jsp" %>
<script>
$(function(){
	initEvent();
});

function initEvent(){
	//수정버튼 클릭 이벤트 핸들러
	$("#modify").on("click", function(){
		$("#frm").attr("action", "/formBoardModify");
		$("#frm").attr("method", "post");
		$("#frm").submit();
	});
	
	//취소버튼 클릭 이벤트 핸들러
	$("#cancel").on("click", function(){
		$("#frm").attr("action", "/formBoardDetail");
		$("#frm").attr("method", "get");
		$("#frm").submit();
	});
}
</script>
</head>
<body>

<form id="frm">
<input type="hidden" name="boardNo" value="${boardVo.boardNo }">
제목 : <input type="text" name="title" value="${boardVo.title }"> <br/>
내용 : <textarea name="content">${boardVo.content }</textarea> <br/>
</form>
<button id="modify">수정</button>
<button id="cancel">취소</button>
</body>
</html>