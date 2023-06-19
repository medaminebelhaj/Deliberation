<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>

 <form  id="SelectSemestre">         
            <div class="radio">
            <input type="hidden"  name="action" value="GetIdEtape" class="form-control">
							<label><h2>Choisir Semestre :</h2></label>
							<select class="select2_multiple form-control" name="idsemestre" id="idsemestre">
                           
                            </select>
						 <br>
						</div>
						
						<input id="btn" type="button" class="btn btn-success" value="Add">
       </form>	   



<!-- 
<table border="1" cellpadding="0" cellspacing="0">
    <tr height="50">
     <td align="center" width="150" rowspan="2">CNE</td>
       
        <td align="center" width="300" colspan="3">S1</td>
        <td align="center" width="150" rowspan="2">NoteFinal</td>
        <td align="center" width="150" rowspan="2">Resultat</td>
      
      
-----------------  Pour les module ------------------    
   <tr height="50">
      
        <td align="center" width="150">M1</td>
         <td align="center" width="150">M2</td>
           <td align="center" width="150">M6</td>
    </tr>
-------------Pour les note de chaque modules------------      
    <tr height="50">
        <td align="center" width="150">CNE</td>
        
             <td align="center" width="150">NOTE1</td>
               <td align="center" width="150">NOTE2</td>
                 <td align="center" width="150">NOTE3</td>
                   <td align="center" width="150">NOTEfinal</td>
                     <td align="center" width="150">result</td>
    </tr>
    
      <tr height="50">
        <td align="center" width="150">CNE</td>
        
             <td align="center" width="150">NOTE1</td>
               <td align="center" width="150">NOTE2</td>
                 <td align="center" width="150">NOTE3</td>
                   <td align="center" width="150">NOTEfinal</td>
                     <td align="center" width="150">result</td>
    </tr> -->
<!------------------------------------------------------------->       
</table>


<div id="table1">

</div>
</body>

    <script>
        $(document).ready(function() {                       
            $('#somebutton').click(function() {               
                $.get('GetUserServlet', function(responseText) { 
                    $('#somediv').text(responseText);        
                });
            });
        });


        $("#btn").click(function(){
         $.ajax({
            url:'GestionPvServlet',
            data:{name:'abc'},
            type:'post',
            cache:false,
            success:function(data){
              alert(data);
               $('#table1').html(data);
             
            },
            error:function(){
              alert('error');
            }
         }
    );
}
);
    </script>
</html>