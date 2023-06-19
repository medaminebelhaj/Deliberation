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

 <!-- JS -->
  
    <!-- Font Icon -->
    <link rel="stylesheet" href="InscriptionPeda/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="InscriptionPeda/vendor/nouislider/nouislider.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="InscriptionPeda/css/style.css">
    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
     </script>
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
</head>

<body class="nav-md">
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
<!-- /////////////////////////////////////////////////////////// -->
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/deliberationdb"
        user="root" password="0000"
    />
       <sql:query var="listEtape" dataSource="${myDS}">
       select *from
           deliberationdb.etape 
            WHERE  idFiliere_FK=?;
        <sql:param value ="${sessionScope.idFiliere}"/>
    </sql:query>
     
  
<!-- /////////////////////////////////////////////////////////// -->    
  
</head>

<body>

 <div class="right_col" role="main">
      
        <div class="container">
            <form method="POST" id="signup-form" class="signup-form" action="GetModuleByEtape">
                <div>
                    <h3>Affecter l'etape</h3>
                    <fieldset>
                        <h2>Affecter l'etape</h2>
                        <p class="desc">Choisir l annee selon le niveau acadimique</p>
                        <div class="fieldset-content">
                            <div class="form-row">
                                <label class="form-label">Image :</label>
                             
                                   <div class="form-row">
                                    <img src="Images/${sessionScope.massaeretudiant}${sessionScope.png}" id="imageBox" width="100" height="130">
                                    </div>
                                       <div class="form-flex">
                                    <div class="form-row">
                                       <span class="text-input">Nom</span>
                                     
                                        <h1 class="desc">${sessionScope.NomFr}</h1>
                                     
                                    </div>
                                    <div class="form-group">
                                        <span class="text-input">Prenom</span>
                                         <h1 class="desc">${sessionScope.PrenomFr}</h1>
                                       
                                    </div>
                                </div>
                            </div>
                        
                   <div class="form-row">
                             
                                <div class="form-flex">
                              
                                    <div class="form-group">
                                       <span class="text-input">Code Massar</span>
                                     
                                        <h1 class="desc">${sessionScope.massaeretudiant}</h1>
                                     
                                    </div>
                                    <div class="form-group">
                                        <span class="text-input">Mention</span>
                                         <h1 class="desc">${sessionScope.Mention}</h1>
                                    
                                    </div>
                                </div>
                            </div>
                             <div class="form-row">
                             
                                <div class="form-flex">
                                    <div class="form-group">
                                       <span class="text-input">Serie de Bac</span>
                                     
                                        <h1 class="desc">${sessionScope.SeriedeBac}</h1>
                                     
                                    </div>
                                    <div class="form-group">
                                        <span class="text-input">Date Inscription </span>
                                         <h1 class="desc">${sessionScope.DateInscription}</h1>
                                       
                                    </div>
                                </div>
                            </div>
                   <!--  <form id="GetModuleByEtape" method="Post">  -->
                       	<label>Choisir Etape</label>
                        <div class="select">
							<select  class="form-select form-select-lg mb-3" name="idFiliere">
                              <c:forEach var="user1" items="${listEtape.rows}">
                              
                                    <option value=<c:out value="${user1.idetape}"/>><c:out value="${user1.NmEtape}"/></option>
                              </c:forEach>
                            </select>
						 <br>
						</div>
                       
                    
                       
                           
                        </div>
                    </fieldset>
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////// -->
                    <h3>Affecter les modules</h3>
                    <fieldset>  
                    
                   
                     <div id="listmodulechekbox"></div>  
                    
                  <!--   </form> -->
                   
                    
                     </fieldset>
                   
                    <h3>Affecter Les Elements</h3>
                    <fieldset>
                        <h2>Liste Element des modules</h2>
                        <p class="desc">Set up your money limit to reach the future plan</p>
                        <div class="fieldset-content">
                            <div class="donate-us">
                               <div id="listelementchekbox"></div>  
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
        </div>

    </div>

   
     <script>
     $(document).ready(function(){
    	var a = document.getElementById('massar');
     document.getElementById('imageBox').src = "Images/" + a + ".png";
     }
     </script>
    
</body>



  <script src="InscriptionPeda/vendor/jquery/jquery.min.js"></script>
    <script src="InscriptionPeda/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="InscriptionPeda/vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="InscriptionPeda/vendor/jquery-steps/jquery.steps.min.js"></script>
    <script src="InscriptionPeda/vendor/minimalist-picker/dobpicker.js"></script>
    <script src="InscriptionPeda/vendor/nouislider/nouislider.min.js"></script>
    <script src="InscriptionPeda/vendor/wnumb/wNumb.js"></script>
     <script src="InscriptionPeda/js/main1.js"></script>
   

</html>