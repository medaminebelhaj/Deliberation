<%if(session.getAttribute("role")==null){
	response.sendRedirect("http://localhost:8080/Delib2/Home");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liste des Notes : ${sessionScope.AAAA} </title>
<!-- Bootstrap CSS -->
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap DataTable -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<!-- Bootstrap ExportDataTable -->
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.0/css/buttons.bootstrap.min.css">
<!-- Font icons -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<!--  ExportDataTable JS -->
<script src="https://cdn.datatables.net/buttons/1.5.0/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.0/js/buttons.bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.0/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.0/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.0/js/buttons.colVis.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <!-- /////////////////////////////////////////////////////////// -->
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/deliberationdb"
        user="root" password="0000"
    />
 
     <sql:query var="listFiliere" dataSource="${myDS}">
    select *
from
    deliberationdb.element
        inner join
    deliberationdb.inscriptionparelement
        on deliberationdb.element.idelement= deliberationdb.inscriptionparelement.idElement
          inner join
    deliberationdb.etudiantinscriptionpedago
        on deliberationdb.etudiantinscriptionpedago.MassarEtudiant= deliberationdb.inscriptionparelement.MassarEtudiant
               inner join
    deliberationdb.module
        on deliberationdb.module.idmodule= deliberationdb.inscriptionparelement.idModule
         where element.idElement=?;
           <sql:param value ="${ide}"/>
    </sql:query>
    
     <sql:query var="list" dataSource="${myDS}">
     SELECT * FROM deliberationdb.filiere;
    </sql:query>
    
<!-- /////////////////////////////////////////////////////////// -->
</head>

<body class="page-sub-page page-my-account">
<!-- Wrapper -->
<div class="wrapper">
<!-- Header -->
<div class="navigation-wrapper">
    <div class="secondary-navigation-wrapper">
        <div class="container">
            <div class="navigation-contact pull-left">Call Us:  <span class="opacity-70">000-123-456-789</span></div>
            <ul class="secondary-navigation list-unstyled pull-right">
                <li><a data-toggle="tab" href="#tab-profile"><i class="fa fa-user"></i>My Profile</a></li>
                <li><a data-toggle="tab" href="#tab-my-courses">My Courses</a></li>
                <li><a data-toggle="tab" href="#tab-change-password">Change Password</a></li>
                <li><a href="index.html">Log Out</a></li>
            </ul>
        </div>
    </div><!-- /.secondary-navigation -->
   <div class="primary-navigation-wrapper">
        <header class="navbar" id="top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="navbar-brand nav" id="brand">
                        <a href="index.html"><img src="https://www.umi.ac.ma/wp-content/themes/umi/images/logo.png" alt="brand"></a>
                    </div>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#" class="has-child no-link">Home</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="index.html">Homepage Education</a></li>
                                <li><a href="homepage-courses.html">Homepage Courses</a></li>
                                <li><a href="homepage-events.html">Homepage Events</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class=" has-child no-link">Courses</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="course-landing-page.html">Course Landing Page</a></li>
                                <li><a href="course-listing.html">Course Listing</a></li>
                                <li><a href="course-listing-images.html">Course Listing with Images</a></li>
                                <li><a href="course-detail-v1.html">Course Detail v1</a></li>
                                <li><a href="course-detail-v2.html">Course Detail v2</a></li>
                                <li><a href="course-detail-v3.html">Course Detail v3</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="has-child no-link">Events</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="event-listing-images.html">Events Listing with images</a></li>
                                <li><a href="event-listing.html">Events Listing</a></li>
                                <li><a href="event-grid.html">Events Grid</a></li>
                                <li><a href="event-detail.html">Event Detail</a></li>
                                <li><a href="event-calendar.html">Events Calendar</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="about-us.html">About Us</a>
                        </li>
                        <li>
                            <a href="#" class="has-child no-link">Blog</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="blog-listing.html">Blog listing</a></li>
                                <li><a href="blog-detail.html">Blog Detail</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="has-child no-link">Pages</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="full-width.html">Fullwidth</a></li>
                                <li><a href="left-sidebar.html">Left Sidebar</a></li>
                                <li><a href="right-sidebar.html">Right Sidebar</a></li>
                                <li><a href="microsite.html">Microsite</a></li>
                                <li><a href="my-account.html">My Account</a></li>
                                <li><a href="members.html">Members</a></li>
                                <li><a href="member-detail.html">Member Detail</a></li>
                                <li><a href="register-sign-in.html">Register & Sign In</a></li>
                                <li><a href="shortcodes.html">Shortcodes</a></li>
                            </ul>
                        </li>
                        <li class="active">
                            <a href="#" class="has-child no-link"><img src="https://img.icons8.com/ios-glyphs/30/C7AD05/guest-male.png"height="20PX"/>&nbsp;&nbsp;${sessionScope.nom} ${sessionScope.prenom}</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="index.html">Mon Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/ios-glyphs/30/FFFFFF/guest-male.png"height="20PX"/></a></li>
                                <li><a href="homepage-courses.html">LOGOUT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/ios/50/FFFFFF/exit.png" height="20PX"/></a></li>
                              
                            </ul>
                        </li>
                    </ul>
                </nav><!-- /.navbar collapse-->
            </div><!-- /.container -->
        </header><!-- /.navbar -->
    </div><!-- /.primary-navigation -->
    <div class="background">
        <img src="assets/img/background-city.png"  alt="background">
    </div>
</div>
<!-- end Header -->


<!-- Breadcrumb -->
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li class="active">Mon Compte</li>
    </ol>
</div>
<!-- end Breadcrumb -->

<!-- Page Content -->
<body>

<style type="text/css">
	
</style>

<div class="container" style="padding-top:20px;">

<table id="ExportDataTable" class="table table-striped table-hover table-bordered" cellspacing="0" width="100%">
<thead>
		<tr>
			<th>Massar</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Note de Tp</th>
			<th>Note de CC</th>
			<th>Note de Exam</th>
			<th>Note Total</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${listFiliere.rows}">
		<tr>
				<td><c:out value="${user.MassarEtudiant}" /><input type="hidden" name="MassarEtudiant" value="<c:out value="${user.MassarEtudiant}" />" ></td>
			<td><c:out value="${user.NomFr}" /></td>
				<td><c:out value="${user.PrenomFr}" /></td>
			 <td><c:out value="${user.NoteTp}"/> </td>
			<td><c:out value="${user.NoteCC}"/></td>
			<td><c:out value="${user.NoteExam}"/></td>
			<c:set var="val" value="${user.NoteValidationElement}"/>
			<c:set var="NoteTotal" value="${user.NoteTotal}"/>
<c:choose> 
  <c:when test="${val > NoteTotal}">
  <td style= background:red;><c:out value="${user.NoteTotal}"/></td>
  </c:when>
  <c:otherwise>
  <td style= background:green;><c:out value="${user.NoteTotal}"/></td>
  </c:otherwise>
</c:choose>
			<%-- <c:choose>
   <c:when test="${user.NoteTotal}>10"><td style= background:green;><c:out value="${user.NoteTotal}"/></td></c:when> <!-- if condition -->
   <c:when test="${user.NoteTotal}>10">	<td style= background:red;><c:out value="${user.NoteTotal}"/></td></c:when> <!-- else if condition -->

</c:choose> --%>
		<%-- 		<td style= background:red;><c:out value="${user.NoteTotal}"/></td> --%>
		</tr>
		 </c:forEach>
	</tbody>
	
</table>

</div>


<script type="text/javascript">
$(document).ready(function() {
    var table = $('#ExportDataTable').DataTable( {
        lengthChange: false,
        //buttons: [ 'copy', 'excel', 'pdf', 'print', 'colvis' ]
		buttons: [ 'copy', 'excel', 'pdf', 'print']
    } );
    table.buttons().container()
        .appendTo( '#ExportDataTable_wrapper .col-sm-6:eq(0)' );
} );
</script>

</body>
</html> 							