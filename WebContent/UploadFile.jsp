<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <!-- <form method="post" action="UploadFileServlet" enctype="multipart/form-data"> -->
    <form id="sendform" method="post" action="" enctype="multipart/form-data">
     <fieldset>
        <legend>Upload File</legend>
        
        <div class="form-group">
                                <label for="name"> Prenom </label>
                                <input type="text" name="PrenomFr" id="name" />
                            </div>
                            
        <label for="filename_1">File: </label>
        <input id="filename_1" type="file" name="filename_1" size="50"/><br/>
        <label for="filename_2">File: </label>
        <input id="filename_2" type="file" name="filename_2" size="50"/><br/>
        
        <label for="filename_3">File: </label>
        <input id="filename_3" type="file" name="filename_3" size="50"/><br/>
        <br/>
        <input id="save" type="submit" value="Upload File"/>
    </fieldset>
    
    
    
  </form>
</body>
<script type="text/javascript">

$('#save').click(function(){
	
	 $("#sendform").attr("action", "UploadFileServlet?id=6");
	  $('#sendform').submit();
	
	});
	
	
	
	</script>
</html>