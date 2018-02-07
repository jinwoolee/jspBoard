<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formBoardList</title>
<%@ include file="/WEB-INF/views/common/customCss.jsp"%>
<%@ include file="/WEB-INF/views/common/jquery.jsp"%>
<%@ include file="/WEB-INF/views/common/bootstrap.jsp"%>
<script>
$(function() {
	initEvent();
});

function initEvent() {
	//게시글 tr 클릭
	$(".boardTr").on("click", function() {
		$("input[name=boardNo]").val($(this).data("boardno"));
		$("#frm").submit();
	});
	
	//등록 버튼
	$("#regist").on("click", function(){
		document.location="/formBoard"
	});
}
</script>
</head>
<body>

<div class="container"> 
    <h2 class="sub-header">게시판</h2>
    <div class="table-responsive">
        <form id="frm" method="get" action="/formBoardDetail">
            <input type="hidden" name="boardNo" value="0">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>글쓴이</th>
						<th>등록일시</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${boardList}" var="board">
						<c:choose>
							<c:when test="${board.delYn == 'Y' }">
								<tr>
									<td>${board.boardNo}</td>
									<td>삭제된 글 입니다.</td>
									<td>${board.regId}</td>
									<td><fmt:formatDate value="${board.regDt}"
											pattern="(yyyy) MM-dd" /></td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="boardTr pointer" data-boardNo="${board.boardNo}">
									<td>${board.boardNo}</td>
									<td>${board.title}</td>
									<td>${board.regId}</td>
									<td><fmt:formatDate value="${board.regDt}" pattern="(yyyy) MM-dd" /></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</form>
	   <button id="regist">등록</button>
	   </div>
    </div>
</body>
</html>