<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<!-- ���� ���ε� ��� ���� ������ ��
1. form �±� �ȿ� input type="file"�� ���� �����.
2. method=post �� �����ϴ�.
3. enctype="multipart/form-data"
4. poem.xml��  fileupload ������� �߰�
5. ���� ���ε��� ������ �����ϴ� vo�� ���� ����� ��û�� ó���Ѵ�. (RequestMapping)
6. !! -->
<body>
<h2 align="center">File Upload Form</h2>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
	����ڸ�<input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type ="submit" value="���Ͼ��ε�">
</form>
</body>
</html>