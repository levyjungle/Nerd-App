<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminPage</title>
</head>
<body>
	<h2>PNG - JPG - MP4</h2>
	<form method="post" action="uploadfile" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="text" name="synopsis">
		<input type="file" name="fileUploadPhoto" accept="image/*">
		<input type="file" name="fileUploadVideo" accept="video/*">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>