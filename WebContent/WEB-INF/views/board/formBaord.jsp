<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm" method="post" action="/formBoard">
제목 : <input type="text" name="title"/> <br/>
내용 : <textarea name="content"></textarea> <br/>

<input type="hidden" name="pBoardno" value="${pBoardno}">
<input type="hidden" name="categoryNo" value="${categoryNo}">
<input type="hidden" name="ord" value="0">
</form>
</body>
</html>