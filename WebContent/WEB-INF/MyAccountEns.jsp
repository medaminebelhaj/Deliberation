<%if(session.getAttribute("role")==null){
	response.sendRedirect("http://localhost:8080/Delib2/Home");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>

<html lang="en-US" xmlns="http://www.w3.org/1999/html">
<head>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/deliberationdb"
        user="root" password="0000"
    />
     
      <sql:query var="listElement" dataSource="${myDS}">
       select *from
           deliberationdb.element
        inner join 
        deliberationdb.module
        on deliberationdb.element.idmoduleFK = deliberationdb.module.idmodule
        
        inner join
    deliberationdb.semestre
        on deliberationdb.module.idSemestre_FK = deliberationdb.semestre.idsemestre
        inner join 
    deliberationdb.etape
           on deliberationdb.semestre.idEtape_FK = deliberationdb.etape.idetape
         inner join 
    deliberationdb.filiere
            on deliberationdb.etape.idFiliere_FK= deliberationdb.filiere.idfiliere 
            WHERE  deliberationdb.element.idenseignant=?;
        <sql:param value ="${sessionScope.id}"/>
    </sql:query>
     <sql:query var="listFiliere" dataSource="${myDS}">
       select *from
    deliberationdb.module
        inner join
    deliberationdb.semestre
        on deliberationdb.module.idSemestre_FK = deliberationdb.semestre.idsemestre
        inner join 
    deliberationdb.etape
           on deliberationdb.semestre.idEtape_FK = deliberationdb.etape.idetape
         inner join 
    deliberationdb.filiere
            on deliberationdb.etape.idFiliere_FK= deliberationdb.filiere.idfiliere 
            WHERE  deliberationdb.module.idEnseignant =?;
        <sql:param value ="${sessionScope.id}"/>
    </sql:query>
    
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->    
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Theme Starz">

    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">

    <title>Espace Enseignant</title>

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
<div id="page-content">
    <div class="container">
        <header><h1>Espace Enseignant</h1></header>
        <div class="row">
            <div class="col-md-8">
                <section id="my-account">
                      <ul class="nav nav-tabs" id="tabs">
                        <li class="active"><a href="#tab-profile" data-toggle="tab">Profile</a></li>
                        <li><a href="#tab-my-courses" data-toggle="tab">Gestion des Notes</a></li>
                       
                    </ul><!-- /#my-profile-tabs -->
                    <div class="tab-content my-account-tab-content">
                        <div class="tab-pane active" id="tab-profile">
                            <section id="my-profile">
                                <header><h3>Mon Compte</h3></header>
                                <div class="my-profile">
                                    <figure class="profile-avatar">
                                        <div class="image-wrapper"><img src="Images\<c:out value="${sessionScope.username}"/>.png"></div>
                                     
                                    </figure>                     
                                    
                                    <article>
                                        <div class="table-responsive">
                                            <table class="my-profile-table">
                                                <tbody>
                                         <form  method="POST" action="listUser">
                                                <tr>
                                                    <td class="title">Nom</td>
                                                    <td>
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" name="nom" id="name" value="${sessionScope.nom}">
                                                        </div><!-- /input-group -->
                                                    </td>
                                                </tr>
                                                 <tr>
                                                    <td class="title">Prenom</td>
                                                    <td>
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" name="prenom" id="name" value="${sessionScope.prenom}">
                                                        </div><!-- /input-group -->
                                                    </td>
                                                </tr>
                                               
                                                  <tr>
                                                    <td class="title">E-mail</td>
                                                    <td>
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" id="location" name="email" value="${sessionScope.email}">
                                                        </div>
                                                    </td>
                                                </tr>
                                             
                                                <tr>
                                                    <td class="title"></td>
                                                    <td>
                                                        <div class="input-group">
                                                            <input type="hidden" class="form-control" id="website" name="op" value="update2">
                                                                <input type="hidden" class="form-control" id="location" name="password" value="${sessionScope.password}"> 
                                                              <input type="hidden" class="form-control" id="website" name="role" value="${sessionScope.role}">
                                                                 <input type="hidden" class="form-control" name="username" id="location" value="${sessionScope.username}">
                                                        </div><!-- /input-group -->
                                                    </td>
                                                </tr>
                                                 <tr>
                                                    <td class="title"></td>
                                                    <td>
                                                        <div class="input-group">
                                                           
                                                              
                                                               <input type="hidden" class="form-control" id="website" name="idUser" value="${sessionScope.id}">
                                                        </div><!-- /input-group -->
                                                    </td>
                                                </tr>
                                      
                                               <!--  <tr>
                                                    <td class="title">Change Photo</td>
                                                    <td>
                                                        <div class="input-group">
                                                            <input type="file" id="change-photo">
                                                        </div><!-- /input-group -->
                                                    </td>
                                                </tr> 
                                                </tbody>
                                            </table>
                                        </div>
                                        <button type="submit" class="btn pull-right">Save Changes</button>
                                  </form>
                                    </article>
                                </div><!-- /.my-profile -->
                            </section><!-- /#my-profile -->
                        </div><!-- /tab-pane -->
                        
                        
                        <div class="tab-pane" id="tab-my-courses">
                           <%--  <section id="course-list">
                                <header><h3>Modules & Elements</h3></header>
                                <table class="table table-hover table-responsive course-list-table tablesorter">
                                    <thead>
                                    <tr>
                                        <th>Nom </th>
                                        <th>Semestre</th>
                                        <th class="starts">Filiere</th>
                                     
                                    </tr>
                                    </thead>
                                    <tbody>
                                  <c:forEach var="user" items="${listFiliere.rows}">
                                    <tr class="status-not-started">
                                        <th class="course-title"><a href="course-detail-v1.html"><c:out value="${user.NomModule}" /></a></th>
                                        <th class="course-category"><c:out value="${user.NmSemestre}" /></th>
                                         <th class="course-category"><c:out value="${user.NomFiliere}" /></th>
                                       <th class="course-category"><c:out value="${user.nbrElt}" /></th>
                                    </tr>
                                    </c:forEach>
                                  
                                    </tbody>
                                </table>
                                <div class="center">
                                    <ul class="pagination">
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                    </ul>
                                </div>
                            </section><!-- /#course-list --> --%>
                                                    <div class="tab-pane" id="tab-my-courses">
                            <section id="#tab-change-password">
                                <header><h3>Modules & Elements</h3></header>
                                <table class="table table-hover table-responsive course-list-table tablesorter">
                                    <thead>
                                    <tr>
                                        <th>Nom de </th>
                                        <th>Module</th>
                                        <th class="starts">Semestre</th>
                                        <th class="status">Filiere</th>
                                         <th class="status"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach var="user" items="${listElement.rows}">
                                    <tr class="status-not-started">
                                
                                  <th class="course-title"><a href="SaisirNoteSer?NomElement=<c:out value="${user.NomElement}"/>&idElement=<c:out value="${user.idelement}"/>&idModule=<c:out value="${user.idmodule}"/>"><c:out value="${user.NomElement}" /></a></th>
                                      
                                        <th class="course-category"><c:out value="${user.NomModule}" /></th>
                                       <th class="course-category"><c:out value="${user.NmSemestre}" /></th>
                                        <th class="course-category"><c:out value="${user.NomFiliere}" /></th>
                                        <th class="course-category" style="visibility:hidden;"><c:out value="${user.idelement}" /></th>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="center">
                                    <ul class="pagination">
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                    </ul>
                                </div>
                            </section><!-- /#course-list -->
                        </div><!-- /.tab-pane -->
                       
                </section>
            </div>

            <!--SIDEBAR Content-->
            <div class="col-md-4">
                <div id="page-sidebar" class="sidebar">
                    <aside class="news-small" id="news-small">
                        <header>
                            <h2>Related News</h2>
                        </header>
                        <div class="section-content">
                            <article>
                                <figure class="date"><i class="fa fa-file-o"></i>08-24-2014</figure>
                                <header><a href="#">U-M School of Public Health, Detroit partners aim to improve air quality in the city</a></header>
                            </article><!-- /article -->
                            <article>
                                <figure class="date"><i class="fa fa-file-o"></i>08-24-2014</figure>
                                <header><a href="#">At 50, Center for the Education of Women celebrates a wider mission</a></header>
                            </article><!-- /article -->
                            <article>
                                <figure class="date"><i class="fa fa-file-o"></i>08-24-2014</figure>
                                <header><a href="#">Three U-Michigan scientists receive Sloan fellowships</a></header>
                            </article><!-- /article -->
                        </div><!-- /.section-content -->
                        <a href="" class="read-more">All News</a>
                    </aside><!-- /.news-small -->
                </div><!-- /#sidebar -->
            </div><!-- /.col-md-4 -->
            <!-- end SIDEBAR Content-->




        </div><!-- /.row -->
    </div><!-- /.container -->
</div>
<!-- end Page Content -->

<!-- Footer -->
<footer id="page-footer">
    <section id="footer-top">
        <div class="container">
            <div class="footer-inner">
                <div class="footer-social">
                    <figure>Follow us:</figure>
                    <div class="icons">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-pinterest"></i></a>
                        <a href=""><i class="fa fa-youtube-play"></i></a>
                    </div><!-- /.icons -->
                </div><!-- /.social -->
                <div class="search pull-right">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button type="submit" class="btn"><i class="fa fa-search"></i></button>
                    </span>
                    </div><!-- /input-group -->
                </div><!-- /.pull-right -->
            </div><!-- /.footer-inner -->
        </div><!-- /.container -->
    </section><!-- /#footer-top -->

    <section id="footer-content">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-12">
                    <aside class="logo">
                        <img src="assets/img/logo-white.png" class="vertical-center">
                    </aside>
                </div><!-- /.col-md-3 -->
                <div class="col-md-3 col-sm-4">
                    <aside>
                        <header><h4>Contact Us</h4></header>
                        <address>
                            <strong>University of Universo</strong>
                            <br>
                            <span>4877 Spruce Drive</span>
                            <br><br>
                            <span>West Newton, PA 15089</span>
                            <br>
                            <abbr title="Telephone">Telephone:</abbr> +1 (734) 123-4567
                            <br>
                            <abbr title="Email">Email:</abbr> <a href="#">questions@youruniversity.com</a>
                        </address>
                    </aside>
                </div><!-- /.col-md-3 -->
                <div class="col-md-3 col-sm-4">
                    <aside>
                        <header><h4>Important Links</h4></header>
                        <ul class="list-links">
                            <li><a href="#">Future Students</a></li>
                            <li><a href="#">Alumni</a></li>
                            <li><a href="#">Give a Donation</a></li>
                            <li><a href="#">Professors</a></li>
                            <li><a href="#">Libary & Health</a></li>
                            <li><a href="#">Research</a></li>
                        </ul>
                    </aside>
                </div><!-- /.col-md-3 -->
                <div class="col-md-3 col-sm-4">
                    <aside>
                        <header><h4>About Universo</h4></header>
                        <p>Aliquam feugiat turpis quis felis adipiscing, non pulvinar odio lacinia.
                            Aliquam elementum pharetra fringilla. Duis blandit, sapien in semper vehicula,
                            tellus elit gravida odio, ac tincidunt nisl mi at ante. Vivamus tincidunt nunc nibh.
                        </p>
                        <div>
                            <a href="" class="read-more">All News</a>
                        </div>
                    </aside>
                </div><!-- /.col-md-3 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
        <div class="background"><img src="assets/img/background-city.png" class="" alt=""></div>
    </section><!-- /#footer-content -->

    <section id="footer-bottom">
        <div class="container">
            <div class="footer-inner">
                <div class="copyright">© Theme Starz, All rights reserved</div><!-- /.copyright -->
            </div><!-- /.footer-inner -->
        </div><!-- /.container -->
    </section><!-- /#footer-bottom -->

</footer>
<!-- end Footer -->
</div>
<!-- end Wrapper -->

<script type="text/javascript" src="assets/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/selectize.min.js"></script>
<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.placeholder.js"></script>
<script type="text/javascript" src="assets/js/jQuery.equalHeights.js"></script>
<script type="text/javascript" src="assets/js/icheck.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.vanillabox-0.1.5.min.js"></script>
<script type="text/javascript" src="assets/js/countdown.js"></script>
<script type="text/javascript" src="assets/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="assets/js/retina-1.1.0.min.js"></script>

<script type="text/javascript" src="assets/js/custom.js"></script>

</body>
</html>