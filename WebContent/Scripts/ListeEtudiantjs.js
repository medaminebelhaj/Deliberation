
	

$(document).ready(function() {
	var btnadd=document.getElementById("addbtn");
	btnadd.hidden = true;
	
	   $(document).on('click','#addbtn',function(){
		  /* var idfiliere = document.getElementById("idfiliere");
			 var idetape = document.getElementById("idetape");
			 var idsemestre= document.getElementById("idsemestre");
			   
			 
			 alert($("#idfiliere option:selected" ).val());*/
			 
			 var filiermodal = document.getElementById("idfilieremodal");
			  var option = document.createElement("option");
			    option.text = $( "#idfiliere option:selected" ).text();
			     option.value=$("#idfiliere option:selected" ).val();
			     filiermodal.add(option);
			     var etapemodal = document.getElementById("idEtapemodal"); 
			     var option = document.createElement("option");
				    option.text = $( "#idetape option:selected" ).text();
				     option.value=$("#idetape option:selected" ).val();
				     etapemodal.add(option);
				     var semestremodal = document.getElementById("idSemestre_FK");    
				     var option = document.createElement("option");
					    option.text = $( "#idsemestre option:selected" ).text();
					     option.value=$("#idsemestre option:selected" ).val();
					     semestremodal.add(option);
						
			     
			     
			     
			     
			 
			 var etapemodal = document.getElementById("idEtapemodal");
			 var semestremodal = document.getElementById("idSemestre_FK");
			 
			 
			 
			 alert(idfiliere);
		   $('#addEmployeeModal').modal('show');
		   
		   
   	});
	 
	 






/* ------------------------------------------------------------------------------------------------ */
	

		
		 var idfiliere = document.getElementById("idfiliere");
		 
		 var idetape = document.getElementById("idetape");
		 var idsemestre= document.getElementById("idsemestre");
		
		 
		 
		 
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
		
		
	       
	       var x = document.getElementById("idsemestre");
	       
		    e.preventDefault(); // avoid to execute the actual submit of the form.

		    var form = $(this);
		  //  var actionUrl = form.attr('action');
		     var table = document.getElementById('sembody');
		     $("#tablesemestre > tbody").html("");
		     var idannee=$("#idanne option:selected").text();;
		     
		     var idfiliere=document.getElementById('idfiliere');
		     var idetape=document.getElementById('idetape');
		     var idsemestre=document.getElementById('idsemestre');
		    
			    $.ajax({
			        type: "POST",
			        url: "listEtudiant?idanne="+idannee+"&idfiliere="+idfiliere.value+"&idetape="+idetape.value+"&idsemestre="+idsemestre.value,
			        data: form.serialize(), // serializes the form's elements.
			        dataType : 'json',
			        success: function(data)
			        {
			        	
			        	var btnadd=document.getElementById("addbtn");
			    		btnadd.hidden = false;
			
				           // $("#tablesemestre").find('tbody').empty();
			              
			        	 var string1 = JSON.stringify(data);
					        var parsed = JSON.parse(string1);  
					       
					        for (var i = 0; i < parsed.length; i++) {
					        var newStr = parsed[i].replace('[', '');
					        newStr=newStr.replace(']','');
					       
					     
					        var obj = newStr.split(",");
					     
					       
					      

					var rowCount = table.rows.length;
					var row = table.insertRow(rowCount);

				
					var cell1 = row.insertCell(0);
					cell1.innerHTML = '<span class="custom-checkbox"><input type="checkbox" id="selectAll"><label for="selectAll"></label></span>'
					
					var cell1 = row.insertCell(1);
					cell1.innerHTML = obj[1];
					
					var cell2 = row.insertCell(2);
					cell2.innerHTML =obj[0];
					
					var cell3 = row.insertCell(3);
					cell3.innerHTML = obj[4];
					
					var cell4 = row.insertCell(4);
					cell4.innerHTML =obj[3];
					
					var cell5 = row.insertCell(5);
					cell5.innerHTML = '<a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a><a href="listSemestre?action=delete&id='+obj[1]+'"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>';

					
					    
				       
					        
						
					        }
			        },
			        fail:function(data) {
			           alert("Failed");
			        }
			    });
		    
		});
/* ------------------------------------------------------------------------------------------------ */	

	$("body").on("click", "#sembody tr", function(){
		
		
        var idmodule=($('td', this).eq(1).text());
			var Nom=($('td', this).eq(2).text());
			var NoteValid=($('td', this).eq(3).text());
			var NoteElim=($('td', this).eq(4).text());
			
			 $("#idModule").val(idmodule);
			 $("#NomModule").val(Nom);
			 $("#NoteEliminatoireModule").val(NoteElim);
			// $("#idsemestre").val(idse);
			// $("#NmSemestre").val(Nms);
			 $("#NoteValidationModule").val(NoteValid); 
	});

/* ------------------------------------------------------------------------------------------------ */	
		$('[data-toggle="tooltip"]').tooltip();
		
		
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function(){
			if(this.checked){
				checkbox.each(function(){
					this.checked = true;                        
				});
			} else{
				checkbox.each(function(){
					this.checked = false;                        
				});
			} 
		});
		checkbox.click(function(){
			if(!this.checked){
				$("#selectAll").prop("checked", false);
			}
		});

	/* ------------------------------------------------------------------------------------------------ */



        	$('[data-toggle="tooltip"]').tooltip();
        	
        	// Select/Deselect checkboxes
        	var checkbox = $('table tbody input[type="checkbox"]');
        	$("#selectAll").click(function(){
        		if(this.checked){
        			checkbox.each(function(){
        				this.checked = true;                        
        			});
        		} else{
        			checkbox.each(function(){
        				this.checked = false;                        
        			});
        		} 
        	});
        	checkbox.click(function(){
        		if(!this.checked){
        			$("#selectAll").prop("checked", false);
        		}
        	});
    
      
          $("#checkbox1").is(':checked', function(){
              $("#checkbox1").attr('value', 'true');
          });
          
          

 /*  -------------------------------------------------------------------------------------------------*/
          
});
          
       