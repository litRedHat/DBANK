<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>直销银行</title>
<link rel="shortcut icon" href="favicon.ico"/>
<script type="text/javascript" src="http://localhost:8080/DBANK/resource/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/DBANK/resource/js/jquery.json-2.4.js"></script>
<script type="text/javascript">
		var dat = {USER_ID: "6225882140083202"};
      function ajaxRequest() {
        $.ajax({
          url: "http://localhost:8080/DBANK/ajax.do",
          type: "POST",
          dataType: "json",
          contentType: "application/json; charset=utf-8",
          data: $.toJSON({USER_ID: "6225882140083202"}),
          //contentType: "application/x-www-form-urlencoded; charset=utf-8",
          //data: {USER_ID: "6225882140083202"},
          async: false,
          success: function(data) {
        	  alert(data.USER_NAME);
          },
          error: function() {
            alert("error");
          }
        });
      }
    </script>
</head>

<body>
	<input type="button" onclick="ajaxRequest()" value="发送ajax请求"></input>
	<form action="loadImg.html" method="post">
			<input type="hidden"  id="channelType" name="channelType" value="03"/>
			<input type="hidden"  id="sessionId" name="sessionId" value=""/>
			<input type="hidden"  id="picType" name="picType" value="01"/>
			<input type="submit" name="submit"/>
	</form>
</body>
</html>