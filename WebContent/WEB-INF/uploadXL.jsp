<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html> 
<head> 
<title> Java File Upload Servlet Example </title> 
</head> 
<body>
  <input id="ajaxfile" type="file"/>
   <input id="" type="text"/>
   <br/>
  <button onclick="uploadFile()"> Upload </button>

  <!-- Ajax to Java File Upload Logic -->
  <script>
  async function uploadFile() {
    let formData = new FormData(); 
    formData.append("file", ajaxfile.files[0]);
    await fetch('UploadImageServlet', {
      method: "POST", 
      body: formData
    }); 
    alert('The file upload with Ajax and Java was a success!');
  }
  </script>
</body>
</html>