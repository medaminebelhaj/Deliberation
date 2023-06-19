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

    <title>Gentelella Alela! | </title>

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
    
     <sql:query var="listFiliere" dataSource="${myDS}">
       SELECT * FROM deliberationdb.filiere;
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
 <sql:query var="listnews" dataSource="${myDS}">
       SELECT * FROM deliberationdb.news;
    </sql:query>
            <!-- page content -->
      <div class="right_col" role="main">
       <div class="">     
             <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>News</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover" id="tablefiliere">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>IdFiliere</th>
                         <th>JJ</th>
                        <th>le Jour</th>
						<th>Mois</th>
                        <th> Text </th>
                        <th>    </th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                          <c:forEach var="user" items="${listnews.rows}">
                <tr>
                
                <td>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</td>
                    <td><c:out value="${user.idnews}" /></td>
                    <td class="NomFiliere"><c:out value="${user.dateNews}" /></td>
                     <td class="NomFiliere"><c:out value="${user.jourNews}" /></td>
                     <td class="NomFiliere"><c:out value="${user.moisNews}" /></td>
                     <td class="NomFiliere"><c:out value="${user.textNews}" /></td>
                    <td><a href="#editEmployeeModal" id="buttonedit" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                           <td>  <a href="ManageNewsSer?action=delete&id=<c:out value="${user.idnews}" />"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
                    	
                   
                </tr>
            </c:forEach>
                       
                    </tr>
                    <tr>
						
            </div>
        </div>
    </div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="ManageNewsSer" method="POST">
					<div class="modal-header">						
						<h4 class="modal-title">Add News</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">	
					 	
						<div class="form-group">	
							<label>Le Jour</label>
							 <select  class="form-control" name="dateNews">
		  <option value="01">1</option>
          <option value="02">2</option>
          <option value="03">3</option>
          <option value="04">4</option>
          <option value="05">5</option>
          <option value="06">6</option>
          <option value="07">7</option>
          <option value="08">8</option>
          <option value="09">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
          <option value="13">13</option>
          <option value="14">14</option>
          <option value="15">15</option>
          <option value="16">16</option>
          <option value="17">17</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
          <option value="23">23</option>
          <option value="24">24</option>
          <option value="25">25</option>
          <option value="26">26</option>
          <option value="27">27</option>
          <option value="28">28</option>
          <option value="29">29</option>
          <option value="30">30</option>
          <option value="31">31</option>
                                      
                             </select>
						</div>
						
					<div class="form-group">	
							<label>Le Jour</label>
							 <select  class="form-control" name="jourNews">
							  <option value="Lundi">Lundi</option>
                              <option value="Mardi">Mardi</option>
                              <option value="Mercredi">Mercredi</option>
                              <option value="Jeudi">Jeudi</option>
                              <option value="Vendredi">Vendredi</option>
                              <option value="Samedi">Samedi</option>
                              <option value="Dimanche">Dimanche</option>
                              </select>
				</div>
				<div class="form-group">	
							<label>Le Mois</label>
							 <select  class="form-control" name="moisNews">
							     <option value="JAN">January</option>
                                 <option value="FEB">February</option>
                                 <option value="MAR">March</option>
                                 <option value="APR">April</option>
                                 <option value="MAY">May</option>
                                 <option value="JUN">June</option>
                                 <option value="JUL">July</option>
                                 <option value="AOUT">August</option>
                                 <option value="SEP">September</option>
                                 <option value="OCT">October</option>
                                 <option value="NOV">November</option>
                                 <option value="DEC">December</option>
                              </select>
				</div>
					<div class="form-group">
							<label>Text</label>
							<input type="text" name="textNews" class="form-control" required>
						</div>
						<div class="form-group">
							<label></label>
							<input type="hidden" value="add" name="op" class="form-control" required>
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
			
				<form action="ManageNewsSer" method="POST">
					<div class="modal-header">						
						<h4 class="modal-title">Add News</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">	
					 		<div class="form-group">
							<label>id</label>
							<input type="text" id="idnews" name="idnews" class="form-control" required>
						</div>
						<div class="form-group">	
							<label>Le Jour</label>
							 <select  class="form-control" name="dateNews" id="dateNews">
		  <option value="01">1</option>
          <option value="02">2</option>
          <option value="03">3</option>
          <option value="04">4</option>
          <option value="05">5</option>
          <option value="06">6</option>
          <option value="07">7</option>
          <option value="08">8</option>
          <option value="09">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
          <option value="13">13</option>
          <option value="14">14</option>
          <option value="15">15</option>
          <option value="16">16</option>
          <option value="17">17</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
          <option value="23">23</option>
          <option value="24">24</option>
          <option value="25">25</option>
          <option value="26">26</option>
          <option value="27">27</option>
          <option value="28">28</option>
          <option value="29">29</option>
          <option value="30">30</option>
          <option value="31">31</option>
                                      
                             </select>
						</div>
						
					<div class="form-group">	
							<label>Le Jour</label>
							 <select  class="form-control" name="jourNews" id="jourNews">
							  <option value="Lundi">Lundi</option>
                              <option value="Mardi">Mardi</option>
                              <option value="Mercredi">Mercredi</option>
                              <option value="Jeudi">Jeudi</option>
                              <option value="Vendredi">Vendredi</option>
                              <option value="Samedi">Samedi</option>
                              <option value="Dimanche">Dimanche</option>
                              </select>
				</div>
				<div class="form-group">	
							<label>Le Mois</label>
							 <select  class="form-control" name="moisNews" id="moisNews">
							     <option value="JAN">January</option>
                                 <option value="FEB">February</option>
                                 <option value="MAR">March</option>
                                 <option value="APR">April</option>
                                 <option value="MAY">May</option>
                                 <option value="JUN">June</option>
                                 <option value="JUL">July</option>
                                 <option value="AOUT">August</option>
                                 <option value="SEP">September</option>
                                 <option value="OCT">October</option>
                                 <option value="NOV">November</option>
                                 <option value="DEC">December</option>
                              </select>
				</div>
					<div class="form-group">
							<label>Text</label>
							<input type="text" name="textNews" id="textNews"  class="form-control" required>
						</div>
						<div class="form-group">
							<label></label>
							<input type="hidden" value="update" name="op" class="form-control" required>
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
	
	
	
	$(document).ready(function(){
		
		$('#tablefiliere').find('tr').click( function(){
			
			
			
			//var td = this.cells[0];  // the first <td>
			var idnews=($('td', this).eq(1).text());
			var dateNews=($('td', this).eq(2).text());
			var jourNews=($('td', this).eq(3).text());
			var moisNews=($('td', this).eq(4).text());
			var textNews=($('td', this).eq(5).text());
			 $("#idnews").val( idnews);
			 $("#dateNews").val(dateNews);
			 $("#jourNews").val(jourNews);
			 $("#moisNews").val(moisNews);
			 $("#textNews").val(textNews);
		
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
	}</style>
    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
   
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>