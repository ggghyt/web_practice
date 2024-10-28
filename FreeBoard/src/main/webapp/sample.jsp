<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.7.1.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(e){
	// jQuery 객체 생성.
	$('<ul />') // document.createElement('ul')
		.append($('<li>사과</li>')) // <ul><li>사과</li></ul>
		.append($('<li />').html('바나나')) // <li>바나나</li>
		.append($('<li />').text('복숭아')) // <li>복숭아</li>
		.appendTo($('body'));
});
</script>
</head>
<body>
  <!-- webapp/sample.jsp -->
</body>
</html>