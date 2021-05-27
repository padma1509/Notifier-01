<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.example.demo.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">

  <title>Note Details | NOTIFIER - Keep tracks of your tasks in a smart way</title>
  <link rel="shortcut icon" href="img/favicon.ico">



  <meta name="description" content="notifier app is used to add notes">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="robots" content="all,follow">
  <!-- Bootstrap CSS-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome CSS-->
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css">
  <!-- Custom Font Icons CSS-->
  <link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/font.css">
  <!-- Google fonts - Muli-->
  <link  rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
  <!-- theme stylesheet-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/style.default.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/custom.css">
  <!-- Favicon-->
  <link type="image/icon" rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
  
  <script  type="text/javascript" src="https://kit.fontawesome.com/03bde3c93b.js" crossorigin="anonymous"></script>

</head>

<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
User user=(User)session.getAttribute("userobj");
if(session.getAttribute("userobj")==null){
	response.sendRedirect("login.jsp");
}
%>

  <header class="header">
    <nav class="navbar navbar-expand-sm">

      <!--nav content-->
      <div class="container-fluid d-flex align-items-center justify-content-between">

        <!-- Navbar Header-->
        <div class="navbar-header">
          <a href="index.html" class="navbar-brand">
            <div class="brand-text brand-big visible text-uppercase"><strong
                class="text-primary">Notifier</strong><strong>App</strong></div>
            <div class="brand-text brand-sm"><strong class="text-primary">Noti</strong><strong>fier</strong></div>
          </a>

        </div>
        <!--End Navbar Header-->

        <!--Right menu list-->
        <div class="right-menu list-inline no-margin-bottom">

          <!-- Log out -->
          <div class="list-inline-item logout">
            <a id="logout" href="logout" class="nav-link"> <span class="d-none d-sm-inline">Logout </span>
            <i class="fas fa-power-off"></i></a>
          </div>
        </div>
      </div>
    </nav>
  </header>


  <div class="d-flex align-items-stretch">

    <div class="page-content" style="width:100%">

<center>

      <div class="col-lg-6 " style="margin-top:5%">
      
      
		     <table class="table table-striped">
                      
                      <tbody>
                        <tr>
                          <td ">NOTE NAME</td>
                          <td>${note.getNoteName()}</td>
                        </tr>
                        
                       <tr>
                          <td >START DATE</td>
                          <td>${note.getStartDate()}</td>
                        </tr>
                        
                       <tr>
                          <td>END DATE</td>
                          <td>${note.getEndDate()}</td>
                        </tr>
                        
                        <tr>
                          <td >REMAINDER DATE</td>
                          <td>${note.getRemainderDate()}</td>
                        </tr>
                        
                          <tr>
                          <td >Status</td>
                          <td>${note.getStatus().getStatusName()}</td>
                        </tr>
                        
                        <tr>
                          <td >Tag</td>
                          <td>${note.getTag().getTagName()}</td>
                        </tr>
                        
                              <tr>
                          <td>Description</td>
                          <td>
                         		 ${note.getNoteDescription()}
							</td>
                        </tr>
                        
                      </tbody>
                    </table>
                    <br/>
                    <br/>
                    <br/>
                    
                    <a href="note" class="btn btn-success">Back</a>

				
      </div>

</center>


    </div>
    <!--end main page content-->
  </div>
  <!-- JavaScript files-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/popper.js/umd/popper.min.js"> </script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery.cookie/jquery.cookie.js"> </script>

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery-validation/jquery.validate.min.js"></script>

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front.js"></script>
  
  
  
</body>

</html>