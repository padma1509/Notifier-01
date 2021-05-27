<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NOTIFIER - Keep tracks of your tasks in a smart way.</title>
    <meta name="description" content="SIGNUP NOTIFIER application">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
    
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css">
    
    <!-- Custom Font Icons CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/font.css">
    
    <!-- Google fonts - Muli-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
    
    <!-- theme stylesheet-->"
    <link rel="stylesheet" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/style.blue.css" id="theme-stylesheet">
    
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/custom.css">
    
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">


</head>
<body>

	<div class="login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>NOTIFIER</h1>
                  </div>
                  
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form id="loginform" name="loginform" action="${pageContext.request.contextPath}/login" method="POST" class="mb-4">
                  <span><label id="login-error" class="error" for="loginform">
                  <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
                  </label></span>
                    <div class="form-group">
                      <input id="email" type="email" name="email" class="input-material">
                      <label for="email" class="label-material">EMail</label>
                      <span><label id="email-error" class="error" for="email"></label></span>
                    </div>
                    <div class="form-group">
                      <input id="password" type="password" name="password" class="input-material">
                      <label for="password" class="label-material">Password</label>
                      <span><label id="password-error" class="error" for="password"></label></span>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                  </form><small>Do not have an account? </small><a href="${pageContext.request.contextPath}/signup" class="signup">Signup</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
	
	   <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/front.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
    
      <script>
      $(function() {
    	  
    	  
        $("form[name='loginform']").validate({
          
          rules: {
            email: {required:true,
            email:true
          },
           password:{
        required:true,minlength:8,maxlength:15,
        pswcheck:true}
          
          
          },
          messages: {
            email: {required:"Please enter your email",email:"Please enter vaild email"},
             password: {required:"please enter your password",minlength:"minimum password lenght must be 8",maxlenght:"maximum password length must be 15",pswcheck:"minmum 1 lowercase,1 uppercase,1 special character,1 digit"}
          
          }   
        });
      });
</script>
</body>
</html>