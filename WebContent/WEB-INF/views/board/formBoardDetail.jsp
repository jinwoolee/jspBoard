<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	//답글
	$("#regist").on("click", function(){
	    $("#frm").attr("action", "/formBoard");
	    $("#frm").attr("method", "get");
	    $("#frm").submit();
	});
	
	//목록버튼 클릭 이벤트 핸들러
	$("#list").on("click", function(){
	    $("#frm").attr("action", "/formBoardList");
	    $("#frm").attr("method", "get");
	    $("#frm").submit();
	});
	
	//수정버튼 클릭 이벤트 핸들러
	$("#modify").on("click", function(){
	    $("#frm").attr("action", "/formBoardModify");
	    $("#frm").attr("method", "get");
	    $("#frm").submit();
	});
	
	//삭제버튼 클릭 이벤트 핸들러
	$("#delete").on("click", function(){
	    $("#frm").attr("action", "/formBoardDelete");
	    $("#frm").attr("method", "post");
	    $("#frm").submit();
	});
}
</script>
</head>
<body>

제목 : ${boardVo.title } <br/>
내용 : ${boardVo.content } <br/>

첨부파일 : 
<ul id="boardFileList">
    <c:forEach var="boardFile" items="${boardVo.boardFileList }">
        <li><a href="/fileDownload?fileNo=${boardFile.fileNo}" target="_blank"> ${boardFile.fileOrgNm }</a></li>
    </c:forEach>
</ul>

<form id="frm">
	<input type="hidden" name="boardNo" value="${boardVo.boardNo }">
	<input type="hidden" name="pboardNo" value="${boardVo.boardNo }">
	<%--<input type="hidden" name="page" value=${page }>
	<input type="hidden" name="pageSize" value=${pageSize }> --%>
</form>
<button id="regist">답글</button>
<button id="list">목록</button>
<button id="modify">수정</button>
<button id="delete">삭제</button>
</body>
</html>