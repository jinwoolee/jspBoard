<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세조회</title>

<%@ include file="/WEB-INF/views/common/customCss.jsp" %>
<%@ include file="/WEB-INF/views/common/jquery.jsp" %>
<%@ include file="/WEB-INF/views/common/bootstrap.jsp" %>
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
		var content = $("#repNo_" + repNo + "_content").val();
		 
		$("#boardRepModifyFrm input[name=boardNo]").val(boardNo);
		$("#boardRepModifyFrm input[name=repNo]").val(repNo);
		$("#boardRepModifyFrm input[name=content]").val(content);
		
		$("#boardRepModifyFrm").attr("action", "/formBoardRepModify");
		$("#boardRepModifyFrm").submit();
	});
	
	//게시물 댓글 삭제버튼 클릭 이벤트 핸들러
	$(".boardRepDel").on("click", function(){
		var boardNo = $(this).data("boardno");
		var repNo = $(this).data("repno");
		
		$("#boardRepModifyFrm input[name=boardNo]").val(boardNo);
		$("#boardRepModifyFrm input[name=repNo]").val(repNo);
		
		$("#boardRepModifyFrm").attr("action", "/formBoardRepDelete");
		$("#boardRepModifyFrm").submit();
	});
}
</script>
</head>
<body>

<div class="container">
    <div class="form-horizontal">
	    <div class="form-group">
	        <label class="col-sm-2 control-label" >제목</label>
	        <div class="col-sm-10">
                <label class="control-label">${boardVo.title }</label>
            </div>
	    </div>
	    <div class="form-group">
	        <label class="col-sm-2 control-label">내용</label>
            <div class="col-sm-10">
                <label class="control-label">${boardVo.content }</label>
            </div>
	    </div>
    </div>
    
    <div class="form-horizontal">
		<div class="form-group">
            <label class="col-sm-2 control-label">첨부파일</label>
			<div class="col-sm-10">
                <ul id="boardFileList">
                    <c:forEach var="boardFile" items="${boardVo.boardFileList }">
                        <li>
	                       <label class="control-label">
	                           <a href="/fileDownload?fileNo=${boardFile.fileNo}" target="_blank"> ${boardFile.fileOrgNm }</a>
	                       </label>
	                    </li>
			        </c:forEach>
			    </ul>
            </div>
        </div>
    </div>

    <div class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">댓글</label>
            <div id="boardRepList" class="col-sm-10">
                <c:forEach var="boardRep" items="${boardVo.boardRepList }">
		          <c:choose>
		              <c:when test="${boardRep.delYn == 'Y'}">
                          <div class="form-group">
                              <div class="col-sm-1">****</div>
                              <div class="col-sm-11">삭제된 댓글입니다.</div>
                          </div>
		              </c:when>
		              <c:when test="${boardRep.regId == userId}">
		                  <div class="form-group">
			                  <div class="col-sm-1">
			                      ${boardRep.regId}
			                  </div>
			                  <div class="col-sm-6">
			                      <textarea id="repNo_${boardRep.repNo}_content" name="content" rows="1" class="form-control">${boardRep.content}</textarea>
			                  </div>
			                  <div class="col-sm-5">
	                            <button type="button" class="boardRepMod" data-boardno="${boardVo.boardNo}" data-repno="${boardRep.repNo}">수정</button>
	                            <button type="button" class="boardRepDel" data-boardno="${boardVo.boardNo}" data-repno="${boardRep.repNo}">삭제</button>
	                          </div>
	                       </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-sm-1">${boardRep.regId}</div>
                                <div class="col-sm-11">${boardRep.content}</div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <div class="form-horizontal">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-6">
		                <form id="boardRepFrm" method="post" action="/formBoardRep">
				            <input type="hidden" name="boardNo" value="${boardVo.boardNo }">
				            <textarea name="content" rows="1" class="form-control"></textarea>
				        </form>
			        </div>
			        <div class="col-sm-5">
			             <button id="boardRepReg" type="button">댓글입력</button>
			        </div>
		        </div>
            </div>
            
            <br/>
            
            
            <div class="form-horizontal">
                <div class="col-sm-2"></div>
                <div class="col-sm-10">
                    <button id="regist">답글</button>
	                <button id="list">목록</button>
	                <button id="modify">수정</button>
	                <button id="delete">삭제</button>
                </div>
            </div>
        </div>
    </div>
</div>

<form id="boardRepModifyFrm" method="post" action="/formBoardRepModify">
	<input type="hidden" name="boardNo">
	<input type="hidden" name="repNo">
	<input type="hidden" name="content">
</form>


<form id="frm">
	<input type="hidden" name="boardNo" value="${boardVo.boardNo }">
	<input type="hidden" name="pboardNo" value="${boardVo.boardNo }">
	<%--<input type="hidden" name="page" value=${page }>
	<input type="hidden" name="pageSize" value=${pageSize }> --%>
</form>
</body>
</html>