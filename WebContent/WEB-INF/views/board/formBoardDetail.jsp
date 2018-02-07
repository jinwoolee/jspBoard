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
	
	//게시물 댓글 입력버튼 클릭 이벤트 핸들러
	$("#boardRepReg").on("click", function(){
		//validate 추가 
		
		$("#boardRepFrm").attr("method", "post");
		$("#boardRepFrm").attr("action", "/formBoardRep");
		$("#boardRepFrm").submit();
	});
	
	//게시물 댓글 수정버튼 클릭 이벤트 핸들러
	$(".boardRepMod").on("click", function(){
		var boardNo = $(this).data("boardno");
		var repNo = $(this).data("repno");
		var content = $(this).parent().find("textarea").val();
		
		$("#boardRepModify input[name=boardNo]").val(boardNo);
		$("#boardRepModify input[name=repNo]").val(repNo);
		$("#boardRepModify input[name=content]").val(content);
		
		$("#boardRepModify").attr("action", "/formBoardRepModify");
		$("#boardRepModify").submit();
	});
	
	//게시물 댓글 삭제버튼 클릭 이벤트 핸들러
	$(".boardRepDel").on("click", function(){
		var boardNo = $(this).data("boardno");
		var repNo = $(this).data("repno");
		
		$("#boardRepModify input[name=boardNo]").val(boardNo);
		$("#boardRepModify input[name=repNo]").val(repNo);
		
		$("#boardRepModify").attr("action", "/formBoardRepDelete");
		$("#boardRepModify").submit();
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

<form id="boardRepModify" method="post" action="/formBoardModify">
<input type="hidden" name="boardNo">
<input type="hidden" name="repNo">
<input type="hidden" name="conetnt">
</form>

<ul id="boardRepList">
    <c:forEach var="boardRep" items="${boardVo.boardRepList }">
        <li><c:choose>
        			<c:when test="${boardRep.regId == userId}">
        				${boardRep.regId} : <textarea name="content">${boardRep.content}</textarea>
        				<button type="button" class="boardRepMod" data-boardno="${board.boardNo}" data-repno="${boardRep.repNo}">수정</button>
        				<button type="button" class="boardRepDel" data-boardno="${board.boardNo}" data-repno="${boardRep.repNo}">삭제</button>
        			</c:when>
        			<c:otherwise>
        				${boardRep.regId} : ${boardRep.content}
        			</c:otherwise>
        		</c:choose>
        	</li>
    </c:forEach>
    <form id="boardRepFrm" method="post" action="/formBoardRep">
    		<input type="hidden" name="boardNo" value="${boardVo.boardNo }">
	    	<textarea name="content"></textarea>
	    	<button id="boardRepReg" type="button">댓글입력</button>
    	</form>
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