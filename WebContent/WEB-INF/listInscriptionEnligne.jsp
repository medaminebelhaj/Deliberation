<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscription En Ligne</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<!-- /////////////////////////////////////////////////////////// -->
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/deliberationdb"
        user="root" password="0000"
    />
 <sql:query var="listUser" dataSource="${myDS}">
     SELECT * FROM deliberationdb.etudiantinscriptionenligne order by DateInscription;
    </sql:query>    
  
<!-- /////////////////////////////////////////////////////////// -->    
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><img  src="https://cdn-icons.flaticon.com/png/512/3097/premium/3097115.png?token=exp=1650812092~hmac=95b484b16d3bd9fb9ea235e8dcdc9a9c" height =30px> <span>   UMI-Admin!</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <%@ include file="/includes/MenuProfileNav.jsp" %>
				<%@ include file="/includes/SideBarMenu.jsp" %>
            <!-- /sidebar menu -->
		</div>
	</div>

			<!-- top navigation -->
			<%@ include file="/includes/TopNavbar.jsp" %>
			<!-- /top navigation -->

            <!-- page content -->
    <div class="right_col" role="main">
       <div class="">     
             <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Inscription <b>En Ligne</b></h2>
					</div>
					<div class="col-sm-6">
						
											
					</div>
                </div>
            </div>
            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
            <table class="table table-striped table-hover " id="myTable">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>Code Massar</th>
                        <th>Nom</th>
						<th>Prenom</th>
                        <th>Mention de Bac</th>
                        <th>Option de BAC</th>
                         <th>Date</th>
                        
                    </tr>
                </thead>
                <tbody>
                
                
            
  <c:forEach var="user" items="${listUser.rows}">
                
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><c:out value="${user.massaretudiant}" /></td>
                        <td><c:out value="${user.nomfr}" /></td>
						 <td><c:out value="${user.prenomfr}" /></td>
                      <td> <c:out value="${user.mention}" /></td>
                        <td> <c:out value="${user.seriedebac}" /></td>
                         <td> <c:out value="${user.DateInscription}" /></td>
                        <td>
                            <!-- <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a> -->
                        <td><a href="GetInscription?action=valide&id=<c:out value="${user.massaretudiant}" />">Valide</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="GetInscription?action=delete&id=<c:out value="${user.massaretudiant}" />">Delete</a> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a></td>
                        
                      
                    </tr>
                    
         </c:forEach>
                    
                   
                </tbody>
            </table>
			
        </div>
    </div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="listUser" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Add Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">	
									
						<div class="form-group">
							<label>Name</label>
							<input type="text" name="nom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Prenom</label>
							<input type="text" name="prenom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<textarea type="email" name="email" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Password</label>
							
							  <input id="password-field" type="password" class="form-control form-control" name="password" value="">
                              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
						</div>	
						<div class="form-group">
							<label>Role</label>
							 <select  class="form-control" name="role">
                                    <option value="admin">Admin</option>
                                    <option value="enseignant">Enseignant</option>
                             </select>
						</div>	
						<div class="form-group">
							<label></label>
							<input type="hidden" name="op" value="add" class="form-control" required></input>
						</div>				
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form action="listUser" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Edit Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
						<div class="modal-body">	
						<div class="form-group">
							<label></label>
							<input type="hidden" id="iduser" name="idUser" class="form-control" required>
						</div>			
						<div class="form-group">
							<label>Name</label>
							<input type="text" id="nomuser" name="nom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Prenom</label>
							<input type="text" id="prenomuser" name="prenom" class="form-control" required>
						</div>
					
						<div class="form-group">
							<label>Email</label>
							<textarea type="email"  name="email" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Username</label>
							<input type="text" id="usernameuser" name="username" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="text" id="passworduser" name="password" class="form-control" required>
						</div>
						
						<div class="form-group">
							<label>Role</label>
							 <select  class="form-control" name="role">
                                    <option value="admin">Admin</option>
                                    <option value="enseignant">Enseignant</option>
                                       <option value="etudiant">Etudant</option>
                             </select>
						</div>	
						<div class="form-group">
							<label></label>
							<input type="hidden" name="op" value="update" class="form-control" required></input>
						</div>				
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
	 <!-- /page content -->
	 

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="/vendors/validator/multifield.js"></script>
    <script src="/vendors/validator/validator.js"></script>
    
    <!-- Javascript functions	-->
	<script>
	
	$(".toggle-password").click(function() {

		  $(this).toggleClass("fa-eye fa-eye-slash");
		  var input = $($(this).attr("toggle"));
		  if (input.attr("type") == "password") {
		    input.attr("type", "text");
		  } else {
		    input.attr("type", "password");
		  }
		});
	

		
		
		
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

	</script>
		<script>
	
	
	
	$(document).ready(function(){
		
		$('#myTable').find('tr').click( function(){
			
			
			
			//var td = this.cells[0];  // the first <td>
			var idUser=($('td', this).eq(0).text());
			var NomUser=($('td', this).eq(1).text());
			var PrenomUser=($('td', this).eq(2).text());
			var UsernameUser=($('td', this).eq(3).text());
			var PasswordUser=($('td', this).eq(4).text());
			 $("#iduser").val( idUser );
			 $("#nomuser").val(NomUser);
			 $("#prenomuser").val(PrenomUser);
			 $("#usernameuser").val(UsernameUser);
			 $("#passworduser").val(PasswordUser);
			});
		
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
	
	$(".toggle-password").click(function() {

		  $(this).toggleClass("fa-eye fa-eye-slash");
		  var input = $($(this).attr("toggle"));
		  if (input.attr("type") == "password") {
		    input.attr("type", "text");
		  } else {
		    input.attr("type", "password");
		  }
		});

	</script>
	<script>
		function hideshow(){
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");
			
			if(password.type === 'password'){
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			}
			else{
				password.type = "password";
				slash.style.display = "none";
				eye.style.display = "block";
			}

		}
	</script>

    <script>
        // initialize a validator instance from the "FormValidator" constructor.
        // A "<form>" element is optionally passed as an argument, but is not a must
        var validator = new FormValidator({
            "events": ['blur', 'input', 'change']
        }, document.forms[0]);
        // on form "submit" event
        document.forms[0].onsubmit = function(e) {
            var submit = true,
                validatorResult = validator.checkAll(this);
            console.log(validatorResult);
            return !!validatorResult.valid;
        };
        // on form "reset" event
        document.forms[0].onreset = function(e) {
            validator.reset();
        };
        // stuff related ONLY for this demo page:
        $('.toggleValidationTooltips').change(function() {
            validator.settings.alerts = !this.checked;
            if (this.checked)
                $('form .alert').remove();
        }).prop('checked', false);

        
        $(document).ready(function(){
        	// Activate tooltip
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
        });
    </script>
<style>
.hidetext { -webkit-text-security: disc; /* Default */ }
  body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {        
		padding-bottom: 15px;
		background: #435d7d;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn-group {
		float: right;
	}
	.table-title .btn {
		color: #fff;
		float: right;
		font-size: 13px;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
		outline: none !important;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
	/* Custom checkbox */
	.custom-checkbox {
		position: relative;
	}
	.field-icon {
  float: right;
  margin-left: -25px;
  margin-top: -25px;
  position: relative;
  z-index: 2;
}

.container{
  padding-top:50px;
  margin: auto;
}
	.custom-checkbox input[type="checkbox"] {    
		opacity: 0;
		position: absolute;
		margin: 5px 0 0 3px;
		z-index: 9;
	}
	.custom-checkbox label:before{
		width: 18px;
		height: 18px;
	}
	.custom-checkbox label:before {
		content: '';
		margin-right: 10px;
		display: inline-block;
		vertical-align: text-top;
		background: white;
		border: 1px solid #bbb;
		border-radius: 2px;
		box-sizing: border-box;
		z-index: 2;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		content: '';
		position: absolute;
		left: 6px;
		top: 3px;
		width: 6px;
		height: 11px;
		border: solid #000;
		border-width: 0 3px 3px 0;
		transform: inherit;
		z-index: 3;
		transform: rotateZ(45deg);
	}
	.custom-checkbox input[type="checkbox"]:checked + label:before {
		border-color: #03A9F4;
		background: #03A9F4;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		border-color: #fff;
	}
	.custom-checkbox input[type="checkbox"]:disabled + label:before {
		color: #b8b8b8;
		cursor: auto;
		box-shadow: none;
		background: #ddd;
	}
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 400px;
	}

	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}
	#myInput {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 100%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}</style>
    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/search.js"></script>
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
   
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>