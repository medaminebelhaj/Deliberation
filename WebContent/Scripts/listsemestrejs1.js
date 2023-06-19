
	
	$(document).ready(function(){
		
		var btnadd=document.getElementById("addbtn");
		btnadd.hidden = true;
		 $(document).on('click','#addbtn',function(){
			   var idfiliere = document.getElementById("idfiliere");
				 var idetape = document.getElementById("idetape");
				
				   
				 
				
				 
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
					     
				
				 
				 var etapemodal = document.getElementById("idEtapemodal");
		
				 
				 
				 
			
			   $('#addEmployeeModal').modal('show');
			   
			   
	   	});
		 
	
		 
/* ------------------------------------------------------------------------------------------------ */
		idfiliere.onchange = function(){
			var form = $("#SelectFiliere");
			//var actionUrl = form.attr('action');
			//document.getElementById("SelectFiliere").submit();
			form.submit();
		//	alert("je suis ");
			
		};
/* ------------------------------------------------------------------------------------------------ */
		idetape.onchange = function(){
			var form = $("#SelectEtape");
			
			//var actionUrl = form.attr('action');
			//document.getElementById("SelectFiliere").submit();
			form.submit();
		//	alert("je suis ");
			
		};
/* ------------------------------------------------------------------------------------------------ */	
	
		$("#SelectEtape").submit(function(e) {
		
        
             var x = document.getElementById("idetape");
             
		    e.preventDefault(); // avoid to execute the actual submit of the form.
		    var table = document.getElementById('sembody');
		    var form = $(this);
		  //  var actionUrl = form.attr('action');
		    
		    
		    $.ajax({
		        type: "POST",
		        url: "listSemestre",
		        data: form.serialize(), // serializes the form's elements.
		        dataType : 'json',
		        success: function(data)
		        {
		        	var btnadd=document.getElementById("addbtn");
		    		btnadd.hidden = false;
		        
		        var string1 = JSON.stringify(data);
		    
		        var parsed = JSON.parse(string1);  
		       
		        for (var i = 0; i < parsed.length; i++) 
		        {
		        var newStr = parsed[i].replace('[', '');
		        newStr=newStr.replace(']','');
		       
		     
		        var obj = newStr.split(",");
		
		      //   $("#tablesemestre").find('tbody').append('<tr><th><span class="custom-checkbox"><input type="checkbox" id="selectAll"><label for="selectAll"></label></span></th><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td><a href="#editEmployeeModal" id="buttonedit" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a><a href="listSemestre?action=delete&id='+obj[1]+'"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td></tr>');
		         
		        

				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
             //  alert(obj)
			
				var cell1 = row.insertCell(0);
				cell1.innerHTML = '<span class="custom-checkbox"><input type="checkbox" id="selectAll"><label for="selectAll"></label></span>'
				
				var cell1 = row.insertCell(1);
				cell1.innerHTML = obj[1];
				
				var cell2 = row.insertCell(2);
				cell2.innerHTML =obj[0];
				
				var cell3 = row.insertCell(3);
				cell3.innerHTML = obj[3];
				
				var cell4 = row.insertCell(4);
				cell4.innerHTML = '<a href="#editEmployeeModal" id="buttonedit" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a><a href="listSemestre?action=delete&id='+obj[1]+'"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>';

				
				    
		   
		       
		        }
		        
		        // show response from the php script. */
		        },
		        fail:function(data) {
		           alert("Failed");
		        }
		    });
		    
		});


/* ------------------------------------------------------------------------------------------------ */	


		
		$("#SelectFiliere").submit(function(e) {
			
			 $('#idetape')
		        .empty()
		        
		    ;
		       
            
             var x = document.getElementById("idetape");
             
		    e.preventDefault(); // avoid to execute the actual submit of the form.

		    var form = $(this);
		  //  var actionUrl = form.attr('action');
		    
		    
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

    $(document).ready(function(){
        
        

    	$("body").on("click", "#sembody tr", function(){
    		
    		
            var id=($('td', this).eq(1).text());
    			var Nom=($('td', this).eq(2).text());
    			var NoteValid=($('td', this).eq(3).text());
    			
    			
    			 $("#idsemestre").val(id);
    			 $("#NmSemestre1").val(Nom);
    			 $("#NoteValidation").val(NoteValid);
    		 
    	});
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
	});
	/* ------------------------------------------------------------------------------------------------ */
	