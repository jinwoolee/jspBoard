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
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script>
var oEditors = [];

$(function(){
	initAttr();
	initEvent();
	seSetting();
});

function initAttr(){
	$("input[name=title]").focus();
}

function initEvent(){
	//수정버튼 클릭 이벤트 핸들러
	$("#modify").on("click", function(){
		$("#frm").attr("action", "/formBoardModify");
		$("#frm").attr("method", "post");
		$("#frm").submit();
	});
	
	//취소버튼 클릭 이벤트 핸들러
	$("#cancel").on("click", function(){
		document.location="/formBoardDetail?boardNo=" + $("#frm input[name=boardNo]").val();
	});
	
	//파일추가 버튼
	$("#addFileInput").on("click", function(){
		var fileInputCnt = $("#fileDiv input[type=file]").length + $("#boardFileList li").length;
		if(fileInputCnt >= 5){
			alert("최대 첨부 파일 갯수를 초과하였습니다.");
			return false;
		}else{
			var fileInput = "<input type=\"file\" name=\"uploadFile\"><br/>";
			$("#fileDiv").append(fileInput);
		}
	});
	
	//파일삭제 버튼
	$(".fileDelete").on("click", function(){
		var fileNo = $(this).data("fileno");
		var boardNo = $(this).data("boardno");
		$("#formBaordFileDelete input[name=fileNo]").val(fileNo);
		$("#formBaordFileDelete input[name=boardNo]").val(boardNo);
		$("#formBaordFileDelete").submit();
	});
}

//smart editor setting
function seSetting(){
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "content", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});
}
</script>
</head>
<body>

<div class="container">
    <div class="form-horizontal">
    
		<form id="frm" enctype="multipart/form-data">
			<input type="hidden" name="boardNo" value="${boardVo.boardNo }">
			<div class="form-group">
				<label class="col-sm-2 control-label" >제목</label>
		        <div class="col-sm-10">
	                <input type="text" name="title" value="${boardVo.title }">
	            </div>
		    </div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label" >내용</label>
		        <div class="col-sm-10">
	                <textarea id="content" name="content" rows="10" cols="100" style="width:766px; height:352px;">${boardVo.content }</textarea>
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
										<a href="/formBaordFileDelete?fileNo=${boardFile.fileNo}" target="_blank"> ${boardFile.fileOrgNm }</a>
		            						<button class="fileDelete" type="button" data-boardno="${boardVo.boardNo}" data-fileno="${boardFile.fileNo}">삭제</button>
			                       </label>
			                    </li>
					        </c:forEach>
					    </ul>
		            </div>
		        </div>
		    </div>
		    
			<div class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<button id="modify" type="button">수정</button>
						<button id="cancel" type="button">취소</button>
						<button id="addFileInput" type="button">파일추가(최대5개)</button>
						<div id="fileDiv">
							<input type="file" name="uploadFile"><br>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<form id="formBaordFileDelete" action="/formBaordFileDelete" method="post">
    <input type="hidden" name="boardNo" >
    <input type="hidden" name="fileNo" >
</form>
</body>
</html>