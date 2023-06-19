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

<link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
  
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
  <sql:query var="list" dataSource="${myDS}">
       SELECT * FROM deliberationdb.enseignant;
    </sql:query>
     <sql:query var="listFiliere" dataSource="${myDS}">
       SELECT * FROM deliberationdb.filiere ;
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
						<h2>Gestion des<b>      Elements</b></h2>
					</div>
					
                </div>
            </div>
                  <p style="color:red;"><c:out value="${msg2}"/></p>
                  
                  
                  
      <form  id="SelectFiliere">      
            
            <div class="form-group">
                
							
							<input type="hidden"  name="action" value="GetIdFiliere" class="form-control">
						</div>
            
							<label><h2>Choisir Filiere :</h2></label>
							<select class="select2_multiple form-control" id="idfiliere" name="idfiliere">
                              <c:forEach var="user" items="${listFiliere.rows}">
                              
                                    <option value=<c:out value="${user.idFiliere}"/>><c:out value="${user.NomFiliere}"/></option>
                              </c:forEach>
                            </select>
            </form>
           		
	
			
        <form method="post" action="" id="SelectEtape">         
            <div class="radio">
            <input type="hidden"  name="action" value="GetIdEtape" class="form-control">
							<label><h2>Choisir Etape :</h2></label>
							<select class="select2_multiple form-control" name="idetape" id="idetape">
                           
                            </select>
						 <br>
						</div>
       </form>	   
       		
        <form method="post" action="" id="SelectSemestre">         
            <div class="radio">
            <input type="hidden"  name="action" value="GetAllModulebyIdSeme" class="form-control">
							<label><h2>Choisir Semestre :</h2></label>
							<select class="select2_multiple form-control" name="idsemestre" id="idsemestre">
                           
                            </select>
						 <br>
						</div>
       </form>	
       
        <form method="post" action="" id="SelectModule">         
            <div class="radio">
            <input type="hidden"  name="action" value="GetAllElementbyIdmodule" class="form-control">
							<label><h2>Choisir Module :</h2></label>
							<select class="select2_multiple form-control" name="idModule" id="idModule1">
                           
                            </select>
						 <br>
						</div>
       </form>	           
						 <br>
						</div>
	
	
       
       
       
						
			</div>
            <table class="table table-striped table-hover"  id="tablesemestre">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>IdElement</th>
                        <th>Nom du Element</th>
                        <th>Note du Validation</th>
                        <th>Note Eliminatoire</th>
                       
                        
                        <th> Action</th>
                     
                    </tr>
                </thead>
                <tbody id="sembody">
                
                </tbody>
                   </table>
					
               
        
                       
                   
            </div>
            <div class="col-sm-6">
						
						<button id="addbtn" type="button" class="btn btn-success">Ajouter Module</button>
					</div>
        </div>
    </div>
    
    
    
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="modal-body">	
				<form method="post" action="listElement1">
					<div class="modal-header">						
						<h4 class="modal-title">Edit Element</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					
							<div class="form-group">
							
							<select hidden="hidden" class="select2_multiple form-control" id="idfilieremodal" name="idfiliere">
                            
                            </select>
						</div>
						<div class="form-group">
							
							<select hidden="hidden" class="select2_multiple form-control" id="idEtapemodal" name="idEtape">
                            
                            </select>
						</div>
						<div class="form-group">
							
							<select hidden="hidden" class="select2_multiple form-control" id="idSemestre_FK" name="idSemestre_FK">
                            
                            </select>
						</div>
						<div class="form-group">
							
							<select hidden="hidden" class="select2_multiple form-control" id="idModuleModal" name="idmoduleFK">
                            
                            </select>
						</div>
						
						<div class="form-group">
							<label>Nom d'Element</label>
							<input type="text" id="NomModule1" name="NomElement" class="form-control" required>
						
						</div>
						<div class="form-group">
							<label>La Note de Validation</label>
					<input type="text" id="NoteValidationModule1" name="NoteValidationElement" class="form-control" required>
						</div>
						<div class="form-group">
							<label>La Note Eliminatoire</label>
					<input type="text" id="NoteEliminatoireModule1" name="NoteEliminatioreElement" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Coefficiant</label>
					<input type="text" id="CoifficientModule" name="CorficientElement" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Choisir l'Enseignant :</label>
							<input list="weekday" class="form-control" name="idenseignant" id="mySelect2" style="width: 330px;">
                        <datalist id="weekday">
<!-- 							<select class="form-control" name="idEnseignant" id="mySelect2" style="width: 330px;"			>
 -->                              <c:forEach var="user1" items="${list.rows}">
                              
                                    <option value=<c:out value="${user1.idenseignant}"/>><c:out value="${user1.PrenomEnseignant}"/>       <c:out value="${user1.NomEnseignant}"/></option>
                              </c:forEach>
                           </datalist> 
						 <br>
						</div>
						<!-- <input list="weekday" class="form-control" name="idEnseignant" id="mySelect2" style="width: 330px;">
                      -->
					`
						<div class="form-group">
							<label></label>
							<input type="hidden" value="add" name="action" class="form-control" required>
						</div>
						 
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</form>
				
				</div>
				</div>
				</div>
		
	</div>
						
				
	
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="modal-body">	
				<form method="post" action="listModule">
					<div class="modal-header">						
						<h4 class="modal-title">Edit Module</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					
								
						<div class="form-group">
							<label></label>
								<input type="hidden" id="idModule" name="idelement" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Nom de module</label>
							<input type="text" id="NomModule" name="NomElement" class="form-control" required>
						
						</div>
						<div class="form-group">
							<label>La Note de Validation</label>
					<input type="text" id="NoteValidationModule" name="NoteValidationElement" class="form-control" required>
						</div>
						<div class="form-group">
							<label>La Note Eliminatoire</label>
					<input type="text" id="NoteEliminatoireModule" name="NoteEliminatioreElement" class="form-control" required>
						</div>
						
						<div class="form-group">
							<label></label>
							<input type="hidden" value="update" name="action" class="form-control" required>
						</div>
						 
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</form>
			</div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.js"></script>
    
    <!-- Javascript functions	-->

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
     <script src="Scripts/listeElementjs.js"></script>