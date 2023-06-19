<%@ page language="java" contentType="text/html; charset=utf-8"
   %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>UMI-INSCRIPTION EN LIGNE</title>
    <%@include file="/includes/navbar1.jsp"%>
    <!-- Font Icon -->
    <link rel="stylesheet" href="InscriptionEnligne/fonts/material-icon/css/material-design-iconic-font.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">
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
     <sql:query var="list" dataSource="${myDS}">
       SELECT * FROM deliberationdb.enseignant;
    </sql:query>
<!-- /////////////////////////////////////////////////////////// -->    
    <style type="text/css">
  <%@include file="InscriptionEnligne/css/style.css" %>
</style>
</head>
    <div class="main">

        <div class="container1">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="" alt="">
                    <img src="https://colorlib.com/etc/regform/colorlib-regform-15/images/signup-img.jpg" />
                </div>
                <div class="signup-form">
                    <form method="POST" action="" class="register-form" id="register-form" enctype="multipart/form-data">
                                        
   
                       <!--  <img src="https://www.umi.ac.ma/wp-content/themes/umi/images/logo.png" alt="Girl in a jacket" width="120" height="150"> -->
                        <div><img src="https://img.icons8.com/ios-filled/50/000000/student-registration.png"/><h1> INSCRIPTION EN LIGNE</h1></div>
                        <br>
                        <br>
                         <div class="form-row">
                          <p style="color:green;"> ${param.message}</p>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="name"> Nom </label>
                                <input type="text" name="NomFr" id="name" required />
                            </div>
                            <div class="form-group">
                                <label for="father_name">    الاسم الشخصي       </label>
                                <input type="text" name="NomAr" id="father_name" required/>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="form-group">
                                <label for="name"> Prenom </label>
                                <input type="text" name="PrenomFr" id="name" required/>
                            </div>
                            <div class="form-group">
                                <label for="father_name">     الاسم العائلي          </label>
                                <input type="text" name="PrenomAr" id="father_name" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address">Code Massar :</label>
                            <input type="text" name="MassarEtdudiant" id="massar" required/>
                        </div>
                        <div class="form-radio">
                            <label for="gender" class="radio-label">Sexe :</label>
                            <div class="form-radio-item">
                                <input type="radio" name="Sexe" id="male" value="m" checked>
                                <label for="male">Male</label>
                                <span class="check"></span>
                            </div>
                            <div class="form-radio-item">
                                <input type="radio" name="Sexe" id="female" value="f" required>
                                <label for="female">Female</label>
                                <span class="check"></span>
                            </div>

                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="state">Nationalite:</label>
                                <div class="form-select">
                                    <select id="country" name="Nationalite">
   <option value="Afganistan">Afghanistan</option>
   <option value="Albania">Albania</option>
   <option value="Algeria">Algeria</option>
   <option value="American Samoa">American Samoa</option>
   <option value="Andorra">Andorra</option>
   <option value="Angola">Angola</option>
   <option value="Anguilla">Anguilla</option>
   <option value="Antigua & Barbuda">Antigua & Barbuda</option>
   <option value="Argentina">Argentina</option>
   <option value="Armenia">Armenia</option>
   <option value="Aruba">Aruba</option>
   <option value="Australia">Australia</option>
   <option value="Austria">Austria</option>
   <option value="Azerbaijan">Azerbaijan</option>
   <option value="Bahamas">Bahamas</option>
   <option value="Bahrain">Bahrain</option>
   <option value="Bangladesh">Bangladesh</option>
   <option value="Barbados">Barbados</option>
   <option value="Belarus">Belarus</option>
   <option value="Belgium">Belgium</option>
   <option value="Belize">Belize</option>
   <option value="Benin">Benin</option>
   <option value="Bermuda">Bermuda</option>
   <option value="Bhutan">Bhutan</option>
   <option value="Bolivia">Bolivia</option>
   <option value="Bonaire">Bonaire</option>
   <option value="Bosnia & Herzegovina">Bosnia & Herzegovina</option>
   <option value="Botswana">Botswana</option>
   <option value="Brazil">Brazil</option>
   <option value="British Indian Ocean Ter">British Indian Ocean Ter</option>
   <option value="Brunei">Brunei</option>
   <option value="Bulgaria">Bulgaria</option>
   <option value="Burkina Faso">Burkina Faso</option>
   <option value="Burundi">Burundi</option>
   <option value="Cambodia">Cambodia</option>
   <option value="Cameroon">Cameroon</option>
   <option value="Canada">Canada</option>
   <option value="Canary Islands">Canary Islands</option>
   <option value="Cape Verde">Cape Verde</option>
   <option value="Cayman Islands">Cayman Islands</option>
   <option value="Central African Republic">Central African Republic</option>
   <option value="Chad">Chad</option>
   <option value="Channel Islands">Channel Islands</option>
   <option value="Chile">Chile</option>
   <option value="China">China</option>
   <option value="Christmas Island">Christmas Island</option>
   <option value="Cocos Island">Cocos Island</option>
   <option value="Colombia">Colombia</option>
   <option value="Comoros">Comoros</option>
   <option value="Congo">Congo</option>
   <option value="Cook Islands">Cook Islands</option>
   <option value="Costa Rica">Costa Rica</option>
   <option value="Cote DIvoire">Cote DIvoire</option>
   <option value="Croatia">Croatia</option>
   <option value="Cuba">Cuba</option>
   <option value="Curaco">Curacao</option>
   <option value="Cyprus">Cyprus</option>
   <option value="Czech Republic">Czech Republic</option>
   <option value="Denmark">Denmark</option>
   <option value="Djibouti">Djibouti</option>
   <option value="Dominica">Dominica</option>
   <option value="Dominican Republic">Dominican Republic</option>
   <option value="East Timor">East Timor</option>
   <option value="Ecuador">Ecuador</option>
   <option value="Egypt">Egypt</option>
   <option value="El Salvador">El Salvador</option>
   <option value="Equatorial Guinea">Equatorial Guinea</option>
   <option value="Eritrea">Eritrea</option>
   <option value="Estonia">Estonia</option>
   <option value="Ethiopia">Ethiopia</option>
   <option value="Falkland Islands">Falkland Islands</option>
   <option value="Faroe Islands">Faroe Islands</option>
   <option value="Fiji">Fiji</option>
   <option value="Finland">Finland</option>
   <option value="France">France</option>
   <option value="French Guiana">French Guiana</option>
   <option value="French Polynesia">French Polynesia</option>
   <option value="French Southern Ter">French Southern Ter</option>
   <option value="Gabon">Gabon</option>
   <option value="Gambia">Gambia</option>
   <option value="Georgia">Georgia</option>
   <option value="Germany">Germany</option>
   <option value="Ghana">Ghana</option>
   <option value="Gibraltar">Gibraltar</option>
   <option value="Great Britain">Great Britain</option>
   <option value="Greece">Greece</option>
   <option value="Greenland">Greenland</option>
   <option value="Grenada">Grenada</option>
   <option value="Guadeloupe">Guadeloupe</option>
   <option value="Guam">Guam</option>
   <option value="Guatemala">Guatemala</option>
   <option value="Guinea">Guinea</option>
   <option value="Guyana">Guyana</option>
   <option value="Haiti">Haiti</option>
   <option value="Hawaii">Hawaii</option>
   <option value="Honduras">Honduras</option>
   <option value="Hong Kong">Hong Kong</option>
   <option value="Hungary">Hungary</option>
   <option value="Iceland">Iceland</option>
   <option value="Indonesia">Indonesia</option>
   <option value="India">India</option>
   <option value="Iran">Iran</option>
   <option value="Iraq">Iraq</option>
   <option value="Ireland">Ireland</option>
   <option value="Isle of Man">Isle of Man</option>
   <option value="Israel">Israel</option>
   <option value="Italy">Italy</option>
   <option value="Jamaica">Jamaica</option>
   <option value="Japan">Japan</option>
   <option value="Jordan">Jordan</option>
   <option value="Kazakhstan">Kazakhstan</option>
   <option value="Kenya">Kenya</option>
   <option value="Kiribati">Kiribati</option>
   <option value="Korea North">Korea North</option>
   <option value="Korea Sout">Korea South</option>
   <option value="Kuwait">Kuwait</option>
   <option value="Kyrgyzstan">Kyrgyzstan</option>
   <option value="Laos">Laos</option>
   <option value="Latvia">Latvia</option>
   <option value="Lebanon">Lebanon</option>
   <option value="Lesotho">Lesotho</option>
   <option value="Liberia">Liberia</option>
   <option value="Libya">Libya</option>
   <option value="Liechtenstein">Liechtenstein</option>
   <option value="Lithuania">Lithuania</option>
   <option value="Luxembourg">Luxembourg</option>
   <option value="Macau">Macau</option>
   <option value="Macedonia">Macedonia</option>
   <option value="Madagascar">Madagascar</option>
   <option value="Malaysia">Malaysia</option>
   <option value="Malawi">Malawi</option>
   <option value="Maldives">Maldives</option>
   <option value="Mali">Mali</option>
   <option value="Malta">Malta</option>
   <option value="Marshall Islands">Marshall Islands</option>
   <option value="Martinique">Martinique</option>
   <option value="Mauritania">Mauritania</option>
   <option value="Mauritius">Mauritius</option>
   <option value="Mayotte">Mayotte</option>
   <option value="Mexico">Mexico</option>
   <option value="Midway Islands">Midway Islands</option>
   <option value="Moldova">Moldova</option>
   <option value="Monaco">Monaco</option>
   <option value="Mongolia">Mongolia</option>
   <option value="Montserrat">Montserrat</option>
   <option value="Morocco">Morocco</option>
   <option value="Mozambique">Mozambique</option>
   <option value="Myanmar">Myanmar</option>
   <option value="Nambia">Nambia</option>
   <option value="Nauru">Nauru</option>
   <option value="Nepal">Nepal</option>
   <option value="Netherland Antilles">Netherland Antilles</option>
   <option value="Netherlands">Netherlands (Holland, Europe)</option>
   <option value="Nevis">Nevis</option>
   <option value="New Caledonia">New Caledonia</option>
   <option value="New Zealand">New Zealand</option>
   <option value="Nicaragua">Nicaragua</option>
   <option value="Niger">Niger</option>
   <option value="Nigeria">Nigeria</option>
   <option value="Niue">Niue</option>
   <option value="Norfolk Island">Norfolk Island</option>
   <option value="Norway">Norway</option>
   <option value="Oman">Oman</option>
   <option value="Pakistan">Pakistan</option>
   <option value="Palau Island">Palau Island</option>
   <option value="Palestine">Palestine</option>
   <option value="Panama">Panama</option>
   <option value="Papua New Guinea">Papua New Guinea</option>
   <option value="Paraguay">Paraguay</option>
   <option value="Peru">Peru</option>
   <option value="Phillipines">Philippines</option>
   <option value="Pitcairn Island">Pitcairn Island</option>
   <option value="Poland">Poland</option>
   <option value="Portugal">Portugal</option>
   <option value="Puerto Rico">Puerto Rico</option>
   <option value="Qatar">Qatar</option>
   <option value="Republic of Montenegro">Republic of Montenegro</option>
   <option value="Republic of Serbia">Republic of Serbia</option>
   <option value="Reunion">Reunion</option>
   <option value="Romania">Romania</option>
   <option value="Russia">Russia</option>
   <option value="Rwanda">Rwanda</option>
   <option value="St Barthelemy">St Barthelemy</option>
   <option value="St Eustatius">St Eustatius</option>
   <option value="St Helena">St Helena</option>
   <option value="St Kitts-Nevis">St Kitts-Nevis</option>
   <option value="St Lucia">St Lucia</option>
   <option value="St Maarten">St Maarten</option>
   <option value="St Pierre & Miquelon">St Pierre & Miquelon</option>
   <option value="St Vincent & Grenadines">St Vincent & Grenadines</option>
   <option value="Saipan">Saipan</option>
   <option value="Samoa">Samoa</option>
   <option value="Samoa American">Samoa American</option>
   <option value="San Marino">San Marino</option>
   <option value="Sao Tome & Principe">Sao Tome & Principe</option>
   <option value="Saudi Arabia">Saudi Arabia</option>
   <option value="Senegal">Senegal</option>
   <option value="Seychelles">Seychelles</option>
   <option value="Sierra Leone">Sierra Leone</option>
   <option value="Singapore">Singapore</option>
   <option value="Slovakia">Slovakia</option>
   <option value="Slovenia">Slovenia</option>
   <option value="Solomon Islands">Solomon Islands</option>
   <option value="Somalia">Somalia</option>
   <option value="South Africa">South Africa</option>
   <option value="Spain">Spain</option>
   <option value="Sri Lanka">Sri Lanka</option>
   <option value="Sudan">Sudan</option>
   <option value="Suriname">Suriname</option>
   <option value="Swaziland">Swaziland</option>
   <option value="Sweden">Sweden</option>
   <option value="Switzerland">Switzerland</option>
   <option value="Syria">Syria</option>
   <option value="Tahiti">Tahiti</option>
   <option value="Taiwan">Taiwan</option>
   <option value="Tajikistan">Tajikistan</option>
   <option value="Tanzania">Tanzania</option>
   <option value="Thailand">Thailand</option>
   <option value="Togo">Togo</option>
   <option value="Tokelau">Tokelau</option>
   <option value="Tonga">Tonga</option>
   <option value="Trinidad & Tobago">Trinidad & Tobago</option>
   <option value="Tunisia">Tunisia</option>
   <option value="Turkey">Turkey</option>
   <option value="Turkmenistan">Turkmenistan</option>
   <option value="Turks & Caicos Is">Turks & Caicos Is</option>
   <option value="Tuvalu">Tuvalu</option>
   <option value="Uganda">Uganda</option>
   <option value="United Kingdom">United Kingdom</option>
   <option value="Ukraine">Ukraine</option>
   <option value="United Arab Erimates">United Arab Emirates</option>
   <option value="United States of America">United States of America</option>
   <option value="Uraguay">Uruguay</option>
   <option value="Uzbekistan">Uzbekistan</option>
   <option value="Vanuatu">Vanuatu</option>
   <option value="Vatican City State">Vatican City State</option>
   <option value="Venezuela">Venezuela</option>
   <option value="Vietnam">Vietnam</option>
   <option value="Virgin Islands (Brit)">Virgin Islands (Brit)</option>
   <option value="Virgin Islands (USA)">Virgin Islands (USA)</option>
   <option value="Wake Island">Wake Island</option>
   <option value="Wallis & Futana Is">Wallis & Futana Is</option>
   <option value="Yemen">Yemen</option>
   <option value="Zaire">Zaire</option>
   <option value="Zambia">Zambia</option>
   <option value="Zimbabwe">Zimbabwe</option>
</select>

                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>
                            <div class="form-group">
                               <label for="pincode">Ville :</label>
                            <input type="text" name="Ville" id="pincode" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birth_date">CIN :</label>
                            <input type="text" name="CIN" id="birth_date" required>
                        </div>
                        <div class="form-group">
                            <label for="pincode"> Date de Naissance:</label>
                            <input type="date" value ="YYYY-MM-DD" name="DatedeNaissance" id="pincode" required>
                        </div>
                         <div class="form-row">
                            <div class="form-group">
                                <label for="name"> Lieu de naissance  </label>
                                <input type="text" name="LieudeNaissanceFr" id="name" required/>
                            </div>
                            <div class="form-group">
                                <label for="father_name">      مكان الازدياد   </label>
                                <input type="text" name="LieudeNaissanceAr" id="father_name" required/>
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="birth_date">Province :</label>
                            <input type="text" name="Province" id="birth_date" required>
                        </div>
                        
                         <div class="form-row">
                             <div class="form-group">
                            <label for="birth_date"> Annee de BAC</label>
                            <input type="text" value ="2021/2022" name="AnneedeBAC" id="birth_date" required>
                             </div>
                            <div class="form-group">
                                <label for="father_name">     Serie de BAC</label>
                                <input type="text" name="SeriedeBAC" id="father_name" required />
                            </div>
                            <div class="form-group">
                                <label for="father_name">    Mention</label>
                                <input type="text" name="Mention" id="father_name" required />
                            </div>
                            <div class="form-group">
                                <label for="father_name">   Lycée</label>
                                <input type="text" name="Lycee" id="father_name" required />
                            </div>
                        </div>
                         <div class="form-row">
                             <div class="form-group">
                            <label for="birth_date"> Lieu d’obtention de BAC</label>
                            <input type="text"  name="LieudeBAC" id="birth_date" required>
                             </div>
                            <div class="form-group">
                                <label for="father_name"> Academie</label>
                                <input type="text" name="Academie" id="father_name" required/>
                            </div>
                         </div> 
                        <div class="form-row">   
                            <div class="form-group">
                                <label for="father_name">  Date d’inscription</label>
                                <input type="date"  value="YYYY-MM-DD" name="DateInscription" id="father_name"  required/>
                            </div>
                            <div class="form-group">
                                <label for="father_name"> Etablissement.</label>
                                <input type="text" name="Etablissement" id="father_name" required/>
                            </div>
                        </div>
                       <div class="form-row"> 
                          <div class="form-group">
                           <label for="father_name"> Image </label> 
                         <input type="file" id="ajaxfile" name="file" accept=".png, .jpg, .jpeg" required>
               
                           </div>
                          
                          <div class="form-group">
                           <label for="father_name">Bac</label> 
                        
                          <input type="file" id="ajaxfile1" name="file1" accept=".pdf" required>
                           </div>
                          
                        </div>
                        <div class="form-group">
							<label>Choisir Filiere</label>
							<select name="Filiere">
                              <c:forEach var="user" items="${listFiliere.rows}">
                              
                                    <option value=<c:out value="${user.idFiliere}"/>><c:out value="${user.NomFiliere}"/></option>
                              </c:forEach>
                            </select>
                            <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
						 <br>
						</div>
                       
                        
                        <div class="form-submit">
                            <input type="submit" value="Reset All" class="submit" name="reset" id="reset" />
                            <!-- <input onclick="uploadFile()"  id="submit" /> -->
                          
                            <input id="save" class="submit" type="submit" value="Valide"/>
       
                        </div>
                    </form>
                    
                    
                    

                    
                </div>
            </div>
        </div>

    </div>

    <!-- JS -->
  
    <script src="InscriptionEnligne/vendor/jquery/jquery.min.js"></script>
    <script src="InscriptionEnligne/js/main.js"></script>
    
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">
    
    
       <script>
       
       $('#save').click(function(){
    	  // let form = document.getElementById('register-form');
    	   
    	   var elements = document.getElementById("register-form").elements;
    	   var chekfiled=0;

    	   for (var i = 0, element; element = elements[i++];) {
    	       if (element.type === "text" && element.value === "")
    	    	   chekfiled=1;
    	   }
    	   
   	   var e =document.getElementById("massar").value ;
    	   var result = e.localeCompare("");
    	   if(chekfiled==0){
    		   $("#register-form").attr("action", "UploadFileServlet?id="+e);
     		  $('#register-form').submit();
    	   } 
    	   else{
    		   alert("Veuillez remplir tous les champs");
    	   }
    		 
    		
    		});
    		
 /*  async function uploadFile() {
	
	  
	  
	  document.getElementById("register-form").submit();
	  alert("PHOTO");
    let formData = new FormData(); 
    formData.append("file", ajaxfile.files[0]);
   
    await fetch('UploadImageServlet?massar='+e, {
      method: "POST", 
      body: formData
    }); 
    alert('The file upload with Ajax and Java was a success!');
  } */
  </script>
  
   <script>
 /*  async function uploadFile1() {
	  var a =document.getElementById("massar").value ;
	  
	  
	  document.getElementById("register-form").submit();
	  alert("BAC");
    let formData = new FormData(); 
    formData.append("file1", ajaxfile.files[0]);
   
    await fetch('UploadBacServlet?massar='+a, {
      method: "POST", 
      body: formData
    }); 
    alert('The file upload with Ajax and Java was a success!');
  } */
  </script>
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>