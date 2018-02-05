<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 입력</title>

<%@ include file="/WEB-INF/views/common/customCss.jsp"%>
<%@ include file="/WEB-INF/views/common/jquery.jsp"%>
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
	
	//저장버튼 핸들러
	$("#save").on("click", function(){
		if(confirm("저장하시겠습니까?")) {
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "/formBoard");
			$("#frm").submit();
		}
	});
	
	//취소버튼 핸들러
	$("#cancel").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "/formBoardList");
		$("#frm").submit();
	});
	
	//파일추가 버튼
	$("#addFileInput").on("click", function(){
		var fileInputCnt = $("#fileDiv input[type=file]").length;
		if(fileInputCnt >= 5){
			alert("최대 첨부 파일 갯수를 초과하였습니다.");
			return false;
		}else{
			var fileInput = "<input type=\"file\" name=\"uploadFile\"><br/>";
			$("#fileDiv").append(fileInput);
		}
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
<form id="frm" method="post" action="/formBoard" enctype="multipart/form-data">
제목 : <input type="text" name="title" /> <br>
내용 : <textarea id="content" name="content" rows="10" cols="100" style="width:766px; height:352px;"></textarea> <br>
	<button id="save" type="button">저장</button>
	<button id="cancel">취소</button>
	<button id="addFileInput" type="button">파일추가(최대5개)</button>
	<div id="fileDiv">
		<input type="file" name="uploadFile"><br>
	</div>

	<input type="hidden" name="pboardNo" value="${param.pboardNo}">
	<input type="hidden" name="categoryNo" value="${param.categoryNo}">
	<input type="hidden" name="ord" value="0">
</form>
</body>
</html>