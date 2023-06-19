
	

$(document).ready(function() {
	var btnadd=document.getElementById("addbtn");
	btnadd.hidden = true;
	
	
	 var idfiliere = document.getElementById("idfiliere");
	 var idetape = document.getElementById("idetape");
	 var idsemestre= document.getElementById("idsemestre");
	 var idanneUniv=document.getElementById("idanne");
	
	
/* ------------------------------------------------------------------------------------------------ */
	
/* ------------------------------------------------------------------------------------------------ */
		    idfiliere.onchange = function(){
			var form = $("#SelectFiliere");
			form.submit();
			
		};
//----------------------------------------------------------------------------------------------------------------
  $("#SelectFiliere").submit(function(e) {
			
			 $('#idetape').empty();
			
            
             var x = document.getElementById("idetape");
             
		    e.preventDefault(); // avoid to execute the actual submit of the form.

		    var form = $(this);
		  
		    $.ajax({
		        type: "POST",
		        url: "listSemestre",
		        data: form.serialize(), // serializes the form's elements.
		        dataType : 'json',
		        success: function(data)
		        {
		        
		        var string1 = JSON.stringify(data);
		        var parsed = JSON.parse(string1);  
		       
		        for (var i = 0; i < parsed.length; i++) {
		        var newStr = parsed[i].replace('[', '');
		        newStr=newStr.replace(']','');
		       
		     
		        var myArray = newStr.split(",");
		        
		        var option = document.createElement("option");
		       
		        option.text = myArray[1];
		        option.value=myArray[0];
		        x.add(option);
		        
		       
		        }
		        
		        // show response from the php script. */
		        },
		        fail:function(data) {
		           alert("Failed");
		        }
		    });
		    
		});
/* ------------------------------------------------------------------------------------------------ */
		idetape.onchange = function(){
			var form = $("#SelectEtape");
			form.submit();
			
		};
/* ------------------------------------------------------------------------------------------------ */	
 	$("#SelectEtape").submit(function(e) {
		
 		
        
             var x = document.getElementById("idsemestre");
             $("#idsemestre").empty();
             
		    e.preventDefault(); // avoid to execute the actual submit of the form.

		    var form = $(this);
		  
		    
		    $.ajax({
		        type: "POST",
		        url: "listModule",
		        data: form.serialize(), // serializes the form's elements.
		        dataType : 'json',
		        success: function(data)
		        {
		        
		        var string1 = JSON.stringify(data);
		    
		        var parsed = JSON.parse(string1);  
		       
		        for (var i = 0; i < parsed.length; i++) 
		        {
		        var newStr = parsed[i].replace('[', '');
		        newStr=newStr.replace(']','');
		       
		     
		       
		        var myArray = newStr.split(",");
		        
		        var option = document.createElement("option");
		       
		        option.text = myArray[0];
		        option.value=myArray[1];
		        x.add(option);
		   
		        }
		        
		     
		        },
		        fail:function(data) {
		           alert("Failed");
		        }
		    });
		    
		});


 
//-----------------------------------------------------------------------------------------
 
 idsemestre.onchange = function(){
	
	
	  var form = $("#SelectSemestre");

	     form.submit();
	
		
	};
//---------------------------------------------------------------------------------------------------------------
	$("#SelectSemestre").submit(function(e) {
		
		e.preventDefault();
		 $.ajax({
	            url:"GestionPvServlet?idanne="+idanneUniv.value+"&idfiliere="+idfiliere.value+"&idetape="+idetape.value+"&idsemestre="+idsemestre.value,
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
		
		    
		});
/* ------------------------------------------------------------------------------------------------ */	

/* ------------------------------------------------------------------------------------------------ */	
	
          

 /*  -------------------------------------------------------------------------------------------------*/
          
});
          
       