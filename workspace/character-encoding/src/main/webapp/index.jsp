<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String defaultEncoding = System.getProperty("default.client.encoding");
if (defaultEncoding == null) {
	defaultEncoding = "";
}
String encodingOverride = System.getProperty("client.encoding.override");
if (encodingOverride == null) {
	encodingOverride = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page to change system properties</title>
</head>
<body>
<form action="setproperty" method="get">
	<label for="default.client.encoding">default.client.encoding :</label>
	<input type="text" id="default.client.encoding" name="default_encoding" value="<%=defaultEncoding%>">
	<input type="submit" value="Set">
</form>
<hr />
<form action="setproperty" method="get">
	<label for="client.encoding.override">client.encoding.override :</label>
	<input type="text" id="client.encoding.override" name="encoding_override" value="<%=encodingOverride%>">
	<input type="submit" value="Set">
</form>
<hr >
<pre>
curl -v --data-binary "str=%81%5C" -H "Content-Type=application/x-www-form-urlencoded" localhost:9080/character-encoding/default
curl -v --data-binary "str=%81%5C" -H "Content-Type=application/x-www-form-urlencoded" localhost:9080/character-encoding/cp943
curl -v --data-binary "str=%81%5C" -H "Content-Type=application/x-www-form-urlencoded" localhost:9080/character-encoding/ms932
</pre>
</body>
</html>