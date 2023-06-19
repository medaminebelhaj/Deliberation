<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>

<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Theme Starz">
  <link href="https://www.umi.ac.ma/wp-content/themes/umi/favicon.ico" rel="icon" >
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">

    <title>UMI Web-Site GLOBAL</title>

</head>



<!-- /////////////////////////////////////////////////////////// -->
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/deliberationdb"
        user="root" password="0000"
    />
    
     <sql:query var="listNews" dataSource="${myDS}">
       SELECT * FROM deliberationdb.news;
    </sql:query>
    
      <sql:query var="listEvents" dataSource="${myDS}">
       SELECT * FROM deliberationdb.events;
    </sql:query>
<!-- /////////////////////////////////////////////////////////// --> 
<body class="page-homepage-carousel">
<!-- Wrapper -->
<div class="wrapper">
<!-- Header -->
<div class="navigation-wrapper">
   
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
                        <li>
                            <a href="contact-us.html">Contact Us</a>
                        </li>
                        <li>
                            <a href="about-us.html" data-toggle="modal" data-target="#myModalProf">Login</a>
                          
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

<!-- Page Content -->
<div id="page-content">
<!-- Slider -->
<div id="homepage-carousel">
    <div class="container">
        <div class="homepage-carousel-wrapper">
            <div class="row">
                <div class="col-md-6 col-sm-7">
                    <div class="image-carousel">
                        <div class="image-carousel-slide"><img src="assets/img/slide-1.jpg" alt=""></div>
                        <div class="image-carousel-slide"><img src="assets/img/slide-2.jpg" alt=""></div>
                        <div class="image-carousel-slide"><img src="assets/img/slide-3.jpg" alt=""></div>
                    </div><!-- /.slider-image -->
                </div><!-- /.col-md-6 -->
                <div class="col-md-6 col-sm-5">
                    <div class="slider-content">
                        <div class="row">
                            <div class="col-md-12">
                                <h1>BIENVENUE</h1>

                                <h2>Vous êtes nouveau,  Voulez-vous vous inscrire maintenant ? </h2>
                              <p><a href="InscriptionServlet" class="btn btn-large pull-right">INSCRIPTION EN LIGNE</a></p>
                            
                            </div><!-- /.col-md-12 -->
                        </div><!-- /.row -->
                    </div><!-- /.slider-content -->
                </div><!-- /.col-md-6 -->
            </div><!-- /.row -->
            <div class="background"></div>
        </div><!-- /.slider-wrapper -->
        <div class="slider-inner"></div>
    </div><!-- /.container -->
</div>
<!-- end Slider -->

<!-- News, Events, About -->
<div class="block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <section class="news-small" id="news-small">
                    <header>
                        <h2>News</h2>
                    </header>
                    <div class="section-content">
                      <c:forEach var="user" items="${listNews.rows}">
                        <article>
                            <figure class="date"><i class="fa fa-file-o"></i><c:out value="${user.jourNews}" /><a>  </a>   <c:out value="${user.dateNews}" /><a>  </a><c:out value="${user.moisNews}" /></figure>
                            <header><a><c:out value="${user.textNews}" /></a></header>
                        </article><!-- /article -->
                       </c:forEach>
                       
                    </div><!-- /.section-content -->
                    <a href="" class="read-more stick-to-bottom">All News</a>
                </section><!-- /.news-small -->
            </div><!-- /.col-md-4 -->
            <div class="col-md-4 col-sm-6">
                <section class="events small" id="events-small">
                    <header>
                        <h2>Events</h2>
                       
                    </header>
                    <div class="section-content">
                    <c:forEach var="user" items="${listEvents.rows}">
                        <article class="event nearest">
                            <figure class="date">
                                <div class="month"><c:out value="${user.moisEvent}" /></div>
                                <div class="day"><c:out value="${user.jourEvent}" /></div>
                            </figure>
                            <aside>
                                <header>
                                    <a href="event-detail.html"><c:out value="${user.textEvent}" /></a>
                                </header>
                                <div class="additional-info"><img src="https://img.icons8.com/material-sharp/24/F1C40F/place-marker.png"/><a>  </a><c:out value="${user.lieuEvent}" /></div>
                            </aside>
                        </article>
                          </c:forEach>
                          <!-- /article -->
                       
                    </div><!-- /.section-content -->
                </section><!-- /.events-small -->
            </div><!-- /.col-md-4 -->
            <div class="col-md-4 col-sm-12">
                <section id="about">
                    <header>
                        <h2>A propos de l'UMI<h2>
                    </header>
                    <div class="section-content">
                        <img src="assets/img/students.jpg" alt="" class="add-margin">
                        <p><strong>Welcome to UMI</strong>La situation distinguée de l’université Moulay Ismail entre les régions Fès-Meknès et Drâa-Tafilalet, lui confère le devoir de contribuer efficacement au développement économique et social et à la diffusion du savoir.</p>
                        <a href="" class="read-more stick-to-bottom">Read More</a>
                    </div><!-- /.section-content -->
                </section><!-- /.about -->
            </div><!-- /.col-md-4 -->
        </div><!-- /.row -->
    </div><!-- /.container -->
</div>
<!-- end News, Events, About -->

<!-- Testimonial -->
<section id="testimonials">
    <div class="block">
        <div class="container">
            <div class="author-carousel">
                <div class="author">
                    <blockquote>
                        <figure class="author-picture">  <img src="https://media-exp1.licdn.com/dms/image/C4E03AQFi34tEnedufw/profile-displayphoto-shrink_200_200/0/1517374689987?e=1652918400&v=beta&t=AMjm3exFMUZwui5Pj9usFjsO25ipPRqYaRuXlXCyLiE" height=100px alt=""></figure>
                        <article class="paragraph-wrapper">
                            <div class="inner">
                                <header>The present study delineates the exact controllability at time T of infinite dimensional hyperbolic system with bilinear distributed controls.</header>
                                <footer>El Hassan Zerrik(enseignant)</footer>
                            </div>
                        </article>
                    </blockquote>
                </div><!-- /.author -->
                <div class="author">
                    <blockquote>
                        <figure class="author-picture"> <img src="https://pbs.twimg.com/media/EaAKX6aXsAIS5To?format=jpg&name=900x900" height=100PX alt=""></figure>
                        <article class="paragraph-wrapper">
                            <div class="inner">
                                <header>  Le medicament devrait etre sur le marche marocain dans quelques mois. Lorsque les brevets ont été reconnus, j ai pu convaincre un laboratoire pharmaceutique marocain.</header>
                                <footer>Kawtar Hafidi</footer>
                            </div>
                        </article>
                    </blockquote>
                </div><!-- /.author -->
            </div><!-- /.author-carousel -->
        </div><!-- /.container -->
    </div><!-- /.block -->
</section>
<!-- end Testimonial -->



<!-- Our Professors, Gallery -->
<div class="block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-4">
                <section id="our-professors">
                    <header>
                        <h2>Our Professors</h2>
                    </header>
                    <div class="section-content">
                        <div class="professors">
                            <article class="professor-thumbnail">
                                <figure class="professor-image"><a href="member-detail.html"><img src="assets/img/professor.jpg" alt=""></a></figure>
                                <aside>
                                    <header>
                                        <a href="member-detail.html">Prof. Mathew Davis</a>
                                        <div class="divider"></div>
                                        <figure class="professor-description">Applied Science and Engineering</figure>
                                    </header>
                                    <a href="member-detail.html" class="show-profile">Show Profile</a>
                                </aside>
                            </article><!-- /.professor-thumbnail -->
                            <article class="professor-thumbnail">
                                <figure class="professor-image"><a href="member-detail.html"><img src="assets/img/professor-02.jpg" alt=""></a></figure>
                                <aside>
                                    <header>
                                        <a href="member-detail.html">Prof. Jane Stairway</a>
                                        <div class="divider"></div>
                                        <figure class="professor-description">Applied Science and Engineering</figure>
                                    </header>
                                    <a href="member-detail.html" class="show-profile">Show Profile</a>
                                </aside>
                            </article><!-- /.professor-thumbnail -->
                            <a href="" class="read-more stick-to-bottom">All Professors</a>
                        </div><!-- /.professors -->
                    </div><!-- /.section-content -->
                </section><!-- /.our-professors -->
            </div><!-- /.col-md-4 -->

            <div class="col-md-8 col-sm-8">
                <section id="gallery">
                    <header>
                        <h2>Gallery</h2>
                    </header>
                    <div class="section-content">
                        <ul class="gallery-list">
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-01.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-02.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-03.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-04.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-05.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-06.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-07.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-08.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-09.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-10.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-11.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-12.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-13.jpg" alt=""></a></li>
                            <li><a href="assets/img/gallery-big-image.jpg" class="image-popup"><img src="assets/img/image-14.jpg" alt=""></a></li>
                        </ul>
                        <a href="" class="read-more">Go to Gallery</a>
                    </div><!-- /.section-content -->
                </section><!-- /.gallery -->
            </div><!-- /.col-md-4 -->

        </div><!-- /.row -->
    </div><!-- /.container -->
</div>
<!-- end Our Professors, Gallery -->

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
                       <img src="https://www.umi.ac.ma/wp-content/themes/umi/images/logo.png" alt="" class="vertical-center">
                    </aside>
                </div><!-- /.col-md-3 -->
                <div class="col-md-3 col-sm-4">
                    <aside>
                        <header><h4>Contact Us</h4></header>
                        <address>
                            <strong>UMI Univesie Moulay Ismail</strong>
                            <br>
                            <span> Presidence, Marjane 2, B.P.:298</span>
                            <br><br>
                            <span>Meknes</span>
                            <br> 
                            <h2>Telephone:</h2 ><p>05 35 46 73 06 <br>05 35 46 73 06</p>
                            <br>
                            <h2>E-mail:</h2 > <a> <p>presidence@umi.ac.ma<br>mediateur@umi.ac.ma</p>
</a>
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
                       
                        <div>
                     
                        </div>
                    </aside>
                </div><!-- /.col-md-3 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
        <div class="background"><img src="assets/img/background-city.png" class="" alt=""></div>
    </section><!-- /#footer-content -->

    <section id="footer-bottom">
        <div class="container">
           
        </div><!-- /.container -->
    </section><!-- /#footer-bottom -->

</footer>
<!-- end Footer -->

</div>
<!-- end Wrapper -->
 <!-- MODALS //////////////////////////// -->
  
<div id="myModalProf" class="modal fade">
  <div class="modal-dialog modal-login">
    <div class="modal-content">
      <div class="modal-header">
         <div >
       <h4>LOGIN</h4>
             

        </div>  
        <div class="avatar">
      <img src="https://img.icons8.com/ios-glyphs/60/000000/user-male--v1.png"/>
           

        </div>        
      
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
      </div>
      <div class="modal-body">
        <form  method="POST" action="loginSer" class="register-form" id="register-form">
          <div class="form-group">
          <label>Username</label>
            <input type="text" class="form-control" name="username" placeholder="Username" required="required">   
          </div>
        
          <div class="form-group">
          <label>Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password" required="required"> 
          </div>    
             <br>    
          <div class="form-group">
            <button type="submit" class="btn  btn-lg btn-block login-btn">Login</button>  
          </div>    
           </form>
              <p style="color:red;"> ${param.message}</p>
   
         <%--  <c:remove var="msg2" scope="session" />  --%>
        <br>
         <br>
          <br>
      </div>
      
    </div>
  </div>
</div>     
<script>




$(document).ready(function(){

	
	$("#register-form").submit(function(e) {
       alert("gjhjh")
     /* 
	    e.preventDefault(); // avoid to execute the actual submit of the form.

	    var form = $(this);
	    var actionUrl = form.attr('action'); */
	    
/* 	    
	    $.ajax({
	        type: "POST",Z
	        url: "loginSer",
	        data: form.serialize(), // serializes the form's elements.
	       
	        success: function(data)
	        {
	        alert(data);
	       
	    
	        
	        // show response from the php script. */
	       /*  },
	        fail:function(data) {
	           alert("Failed");
	        } */
	    }); 
	    
	});
	

  
  

</script>


<style type="text/css">

  .modal-login {    
    color: #636363;
    width: 350px;
    height: 17000px;
  }
  .modal-login .modal-content {
    padding: 20px;
    border-radius: 5px;
    border: none;
  }
  .modal-login .modal-header {
    border-bottom: none;   
        position: relative;
        justify-content: center;
  }
  .modal-login h4 {
    text-align: center;
    font-size: 26px;
    margin: 30px 0 -15px;
  }
  .modal-login .form-control:focus {
    border-color: #70c5c0;
  }
  .modal-login .form-control, .modal-login .btn {
    min-height: 40px;
    border-radius: 3px; 
  }
  .modal-login .close {
        position: absolute;
    top: -5px;
    right: -5px;
  } 
  .modal-login .modal-footer {
    background: #ecf0f1;
    border-color: #dee4e7;
    text-align: center;
        justify-content: center;
    margin: 0 -20px -20px;
    border-radius: 5px;
    font-size: 13px;
  }
  .modal-login .modal-footer a {
    color: #999;
  }   
  .modal-login .avatar {
    position: absolute;
    margin: 0 auto;
    left: 0;
    right: 0;
    top: -70px;
    width: 95px;
    height: 95px;
    border-radius: 50%;
    z-index: 9;
    background: #4f3eb0;
    padding: 15px;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
  }
  .modal-login .avatar img {
    width: 100%;
  }
  .modal-login.modal-dialog {
    margin-top: 80px;
  }
    .modal-login .btn {
        color: black;
        border-radius: 4px;
    background: #e6b505;
    text-decoration: none;
    transition: all 0.4s;
        line-height: normal;
        border: none;
    }
  .modal-login .btn:hover, .modal-login .btn:focus {
    background: #FE4321;
    outline: none;
  }
  .trigger-btn {
    display: inline-block;
    margin: 100px auto;
    color:#FE4321;
    font-size:30px;
  }
</style>

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
<script type="text/javascript" src="assets/js/retina-1.1.0.min.js"></script>

<script type="text/javascript" src="assets/js/custom.js"></script>

</body>
</html>