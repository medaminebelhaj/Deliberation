<%if(session.getAttribute("role")==null){
	response.sendRedirect("http://localhost:8080/Delib2/Home");
}
%>
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

    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">

    <title>UMI-Espace Etudiant</title>

</head>

<body class="page-sub-page page-microsite">
<!-- Wrapper -->
<div class="wrapper">
<!-- Header -->
<div class="navigation-wrapper">
    

    <div class="branding">
        <div class="container">
               <div class="navbar-brand nav" id="brand">
                        <a href="index.html"><img src="https://www.umi.ac.ma/wp-content/themes/umi/images/logo.png" height="65px" alt="brand"></a>
                    </div>
            <div class="search pull-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button type="submit" class="btn"><i class="fa fa-search"></i></button>
                    </span>
                </div><!-- /input-group -->
            </div><!-- /.pull-right -->
        </div>
    </div>

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
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse navbar-left" role="navigation">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Home</a>
                        </li>
                        <li>
                            <a href="#">Academics</a>
                        </li>
                        <li>
                            <a href="#">Athletics</a>
                        </li>
                        <li>
                            <a href="#">About us</a>
                        </li>
                        <li>
                            <a href="#">Research</a>
                        </li>
                        <li>
                            <a href="#">Health & Medicine</a>
                        </li>
                        <li>
                            <a href="#">Initiatives</a>
                        </li>
                         <li>
                            <a href="#"></a>
                        </li>
                          <li>
                            <a href="#"></a>
                        </li>
                          <li>
                            <a href="#"></a>
                        </li>
                          <li>
                            <a href="#"></a>
                        </li>
                         <li>
                            <a href="#"></a>
                        </li>
                        <li class="active">
                            <a href="#" class="has-child no-link"><img src="https://img.icons8.com/ios-glyphs/30/C7AD05/guest-male.png"height="20PX"/>&nbsp;&nbsp;${sessionScope.nom} ${sessionScope.prenom}</a>
                            <ul class="list-unstyled child-navigation">
                                <li><a href="MyAccountEns?username=${sessionScope.username}">Espace Enseignant&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/ios-glyphs/30/FFFFFF/guest-male.png"height="20PX"/></a></li>
                                <li><a href="homepage-courses.html">LOGOUT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://img.icons8.com/ios/50/FFFFFF/exit.png" height="20PX"/></a></li>
                              
                            </ul>
                        </li>
                    </ul>
                </nav><!-- /.navbar collapse-->
                <div class="social">
                    <div class="icons">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-pinterest"></i></a>
                        <a href=""><i class="fa fa-youtube-play"></i></a>
                    </div><!-- /.icons -->
                </div>
            </div><!-- /.container -->
        </header><!-- /.navbar -->
    </div><!-- /.primary-navigation -->
</div>
<!-- end Header -->

<div id="page-content">
<!-- Slider -->
<div id="slider">
    <div class="container">
        <div class="slider-wrapper">
            <div class="row">
                <div class="col-md-9 col-sm-12">
                    <div class="row">
                        <div class="image-carousel">
                            <div class="slide">
                                <div class="col-md-4 col-sm-4">
                                    <h1>Bienvenue Monsieur ${sessionScope.nom}</h1>
                                     
                                    <p>
                                        Depuis plus de 30 ans, WEP contribue à vos côtés à l'éducation des jeunes. Nous avons, comme vous, le souci constant de les ouvrir au monde et de les aider à construire l'avenir qu'ils désirent. 

Nombreux sont les établissements et professeurs qui soutiennent notre mission depuis longtemps. Nous souhaitons, à notre tour, vous soutenir par le biais d'un espace et de différentes actions qui vous sont entièrement dédiés.
                                    </p>
                                    <a href="#" class="btn btn-framed btn-small btn-color-white">View Details</a>
                                </div><!-- /.col-md-4 -->
                                <div class="col-md-8 col-sm-8">
                                    <div class="image-carousel-slide"><img src="assets/img/slide-2.jpg" alt=""></div>
                                </div><!-- /.col-md-8 -->
                            </div><!-- /.slide -->
                            <div class="slide">
                                <div class="col-md-4 col-sm-4">
                                    <h1>Welcome Mr ${sessionScope.nom}</h1>
                                    <p>
                                        For more than 30 years, WEP has been contributing alongside you to the education of young people. We have, like you, the constant concern to open them up to the world and to help them build the future they desire.

Many institutions and teachers have supported our mission for a long time. We wish, in turn, to support you through a space and various actions that are entirely dedicated to you.
                                    </p>
                                    <a href="#" class="btn btn-framed btn-small btn-color-white">View Details</a>
                                </div><!-- /.col-md-4 -->
                                <div class="col-md-8 col-sm-8">
                                    <div class="image-carousel-slide"><img src="assets/img/slide-1.jpg" alt=""></div>
                                </div><!-- /.col-md-8 -->
                            </div><!-- /.slide -->
                        </div><!-- /.image-carousel -->
                    </div><!-- /.row -->
                </div><!-- /.col-md-9 -->

                <div class="col-md-3 col-sm-12">
                    <aside class="news-small" id="news-slider">
                        <header>
                            <h2>Related News</h2>
                        </header>
                        <div class="section-content">
                            <article>
                                <header><i class="fa fa-file-o"></i><a href="#">U-M School of Public Health, Detroit partners aim to improve air quality in the city</a></header>
                            </article><!-- /article -->
                            <article>
                                <header><i class="fa fa-file-o"></i><a href="#">At 50, Center for the Education of Women celebrates a wider mission</a></header>
                            </article><!-- /article -->
                            <article>
                                <header><i class="fa fa-file-o"></i><a href="#">Three U-Michigan scientists receive Sloan fellowships</a></header>
                            </article><!-- /article -->
                        </div><!-- /.section-content -->
                        <a href="" class="read-more">All News</a>
                    </aside><!-- /.news-small -->
                </div><!-- /.col-md-3 -->

            </div><!-- /.row -->
        </div><!-- /.slider-wrapper -->
    </div><!-- /.container -->
</div>
<!-- end Slider -->

<!-- Content -->
<div class="block">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <section class="events small" id="events-small">
                    <header>
                        <h2>Events</h2>
                        <a href="" class="link-calendar">Calendar</a>
                    </header>
                    <div class="section-content">
                        <article class="event nearest">
                            <figure class="date">
                                <div class="month">jan</div>
                                <div class="day">18</div>
                            </figure>
                            <aside>
                                <header>
                                    <a href="#">Conservatory Exhibit: The garden of india a country and culture revealed</a>
                                </header>
                                <div class="additional-info">Matthaei Botanical Gardens</div>
                            </aside>
                        </article><!-- /article -->
                        <article class="event nearest-second">
                            <figure class="date">
                                <div class="month">feb</div>
                                <div class="day">01</div>
                            </figure>
                            <aside>
                                <header>
                                    <a href="#">February Half-Term Activities: Big Stars and Little Secrets </a>
                                </header>
                                <div class="additional-info clearfix" >Pitt Rivers and Natural History Museums</div>
                            </aside>
                        </article><!-- /article -->
                        <article class="event">
                            <figure class="date">
                                <div class="month">mar</div>
                                <div class="day">23</div>
                            </figure>
                            <aside>
                                <header>
                                    <a href="#">The Orchestra of the Age of Enlightenment perform with Music</a>
                                </header>
                                <div class="additional-info">Faculty of Music</div>
                            </aside>
                        </article><!-- /article -->
                    </div><!-- /.section-content -->
                </section><!-- /.events-small -->
            </div><!-- /.col-md-3 -->

            <div class="col-md-6">
                <section id="main-content">
                    <header>
                        <h2>Welcome to microsite</h2>
                    </header>
                    <div class="section-content">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam facilisis, purus eu ullamcorper ultrices,
                            lorem eros tincidunt mauris, quis adipiscing sapien ante quis sem. Pellentesque habitant morbi tristique
                            senectus et netus et malesuada fames ac turpis egestas. Curabitur a augue sit amet nibh cursus ultrices
                            vel vel elit. Sed ullamcorper sit amet lectus nec laoreet. Maecenas quam ligula, elementum vel eleifend
                            vel, dapibus scelerisque libero. </p>
                        <h3>Cras at fringilla ligula</h3>
                        <p>
                            Cras iaculis dapibus imperdiet. In sodales mauris nec turpis accumsan, at tincidunt nisi dapibus.
                            Integer sit amet mauris vehicula, porttitor turpis nec, ultrices enim. Curabitur ornare libero vitae
                            fringilla tincidunt. Nunc quis diam egestas, tempor nisl id, semper quam. Suspendisse dui dolor, tempus
                            non semper sed, cursus quis ligula. Curabitur vehicula ligula sed placerat malesuada. Vestibulum auctor
                            interdum nibh. Maecenas dignissim condimentum convallis.
                        </p>
                        <p>
                            Phasellus eget semper dolor. Etiam at laoreet augue. Donec posuere suscipit ipsum, a elementum neque
                            porttitor a. Mauris iaculis fringilla ante auctor ultricies. Proin eget luctus sem, eu ultricies erat.
                            Integer elementum justo eget nisi adipiscing, id luctus sem convallis. Fusce dui lacus, posuere et
                            aliquam sed, vestibulum at urna.
                        </p>
                        <h2>Divisions</h2>

                        <div class="row">
                            <div class="col-md-6">
                                <a href="" class="universal-button framed">
                                    <h3>Science</h3>
                                    <figure class="date"><i class="fa fa-arrow-right"></i></figure>
                                </a><!-- /.universal-button -->
                            </div><!-- /.col-md-6 -->
                            <div class="col-md-6">
                                <a href="" class="universal-button framed">
                                    <h3>Art & Design</h3>
                                    <figure class="date"><i class="fa fa-arrow-right"></i></figure>
                                </a><!-- /.universal-button -->
                            </div><!-- /.col-md-6 -->
                        </div><!-- /.row -->

                        <div class="row">
                            <div class="col-md-6">
                                <a href="" class="universal-button framed">
                                    <h3>Psychology</h3>
                                    <figure class="date"><i class="fa fa-arrow-right"></i></figure>
                                </a><!-- /.universal-button -->
                            </div><!-- /.col-md-6 -->
                            <div class="col-md-6">
                                <a href="" class="universal-button framed">
                                    <h3>Mathematics</h3>
                                    <figure class="date"><i class="fa fa-arrow-right"></i></figure>
                                </a><!-- /.universal-button -->
                            </div><!-- /.col-md-6 -->
                        </div><!-- /.row -->

                        <div class="author-carousel">
                            <div class="author">
                                <blockquote>
                                    <figure class="author-picture"><img src="assets/img/student-testimonial.jpg" alt=""></figure>
                                    <article class="paragraph-wrapper">
                                        <div class="inner">
                                            <header>Morbi nec nisi ante. Quisque lacus ligula, iaculis in elit et, interdum semper quam. Fusce in interdum tortor.
                                                Ut sollicitudin lectus dolor eget imperdiet libero pulvinar sit amet.</header>
                                            <footer>Claire Doe</footer>
                                        </div>
                                    </article>
                                </blockquote>
                            </div><!-- /.author -->
                            <div class="author">
                                <blockquote>
                                    <figure class="author-picture"><img src="assets/img/student-testimonial.jpg" alt=""></figure>
                                    <article class="paragraph-wrapper">
                                        <div class="inner">
                                            <header>Morbi nec nisi ante. Quisque lacus ligula, iaculis in elit et, interdum semper quam. Fusce in interdum tortor.
                                                Ut sollicitudin lectus dolor eget imperdiet libero pulvinar sit amet.</header>
                                            <footer>Claire Doe</footer>
                                        </div>
                                    </article>
                                </blockquote>
                            </div><!-- /.author -->
                        </div><!-- /.author-carousel -->

                        <hr>

                        <p>
                            Nunc quis diam egestas, tempor nisl id, semper quam. Suspendisse dui dolor, tempus non semper sed,
                            cursus quis ligula. Curabitur vehicula ligula sed placerat malesuada. Vestibulum auctor interdum nibh.
                            Maecenas dignissim condimentum convallis. Phasellus eget semper dolor. Etiam at laoreet augue.
                            Donec posuere suscipit ipsum, a elementum neque porttitor a. Mauris iaculis fringilla ante auctor
                            ultricies. Proin eget luctus sem, eu ultricies erat. Integer elementum justo eget nisi adipiscing.
                        </p>
                    </div><!-- /.section-content -->
                </section><!-- /.main-content -->
            </div><!-- /.col-md-6 -->

            <div class="col-md-3">
                <section class="news-small" id="news-small">
                    <header>
                        <h2>News</h2>
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
                </section><!-- /.news-small -->
            </div><!-- /.col-md-3 -->
        </div><!-- /.row -->
    </div><!-- /.container -->
</div>
<!-- end Content -->
</div>

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
<script type="text/javascript" src="assets/js/retina-1.1.0.min.js"></script>

<script type="text/javascript" src="assets/js/custom.js"></script>

</body>
</html>