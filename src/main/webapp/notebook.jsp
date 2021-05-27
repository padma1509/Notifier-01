<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.example.demo.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">

  <title>NoteBook | NOTIFIER - Keep tracks of your tasks in a smart way</title>
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
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/style.blue.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/custom.css">
  <!-- Favicon-->
  <link type="image/icon" rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
  
  <script  type="text/javascript" src="https://kit.fontawesome.com/03bde3c93b.js" crossorigin="anonymous"></script>

</head>

<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("userobj")==null){
	response.sendRedirect("login.jsp");
}
%>

  <header class="header" >
    <nav class="navbar navbar-expand-sm" style="background-color: #ffffff">

      <!--nav content-->
      <div class="container-fluid d-flex align-items-center justify-content-between">

        <!-- Navbar Header-->
        <div class="navbar-header">
          <a href="index.html" class="navbar-brand">
            <div class="brand-text brand-big visible text-uppercase"><strong
                class="text-primary">Notifier</strong><strong>App</strong></div>
            <div class="brand-text brand-sm"><strong class="text-primary">Noti</strong><strong>fier</strong></div>
          </a>

          <!-- Sidebar Toggle Btn-->
          <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
        </div>
        <!--End Navbar Header-->

        <!--Right menu list-->
        <div class="right-menu list-inline no-margin-bottom">
          <div class="list-inline-item">
            <input id="myInput" type="text" onkeyup="searchNote()" placeholder="Search for notebooks.."
              class="input-material">
          </div>


          <!--Message-->
          <div class="list-inline-item dropdown">
            <a id="navbarDropdownMenuLink1" href="#" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false" class="nav-link messages-toggle">
              <i class="fas fa-bell"></i><span class="badge dashbg-1">25</span>
            </a>

            <div aria-labelledby="navbarDropdownMenuLink1" class="dropdown-menu messages">
              <a href="#" class="dropdown-item message d-flex align-items-center">

                <div class="content"> <strong class="d-block">Sara Wood</strong><span class="d-block">lorem ipsum dolor
                    sit amit</span><small class="date d-block">10:30pm</small></div>
              </a>

            </div>
          </div>
          <!--End Message-->

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
    <!-- Sidebar Navigation-->
    <nav id="sidebar" style="background-color: #ffffff">
      <!-- Sidebar Header-->
      <div class="sidebar-header d-flex align-items-center">

        <div class="title">
          <h1 class="h5"> ${user.userName}</h1>

        </div>
      </div>
      <!-- Sidebar Navidation Menus-->
      <ul class="list-unstyled">
        <li class="active"><a href="notebook"> <i class="fa fa-book"></i>NOTE BOOKS </a></li>
        <li ><a href="allnotes"> <i class="fa fa-sticky-note"></i>NOTES </a></li>
        <li><a href="edituser"> <i class="fas fa-user-edit"></i>EDIT USER </a></li>
      </ul>

    </nav>
    <!-- Sidebar Navigation end-->

    <!--main page content-->

    <div class="page-content" style="background-color: #ffffff">

      <!--page header-->
      <div class="page-header">
        <div class="container-fluid d-flex align-items-center justify-content-between">
          <div class="left-menu">
            <h2 class="h5 no-margin-bottom">NOTE BOOKS</h2>
          </div>
          <div class="right-menu list-inline no-margin-bottom">
            <div class="list-inline-item" style="background-color: #ffffff">
              <button type="button" data-toggle="modal" data-target="#addNotebook" class="btn button-add">
                <i class="fas fa-plus-square"></i> Add NoteBook</button>
            </div>
          </div>
        </div>
      </div>

      <!--add note book-->

      <!-- Modal Form-->
      <!-- Modal-->
      <div id="addNotebook" tabindex="-1" role="dialog" aria-labelledby="addNotebookLabel" aria-hidden="true"
        class="modal fade text-left">
        <div role="document" class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header"><strong id="addNotebookLabel" class="modal-title">ADD NOTEBOOK</strong>
              <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span
                  aria-hidden="true">x</span></button>
            </div>
            
            
            <form action="addnotebook" id="addNotebook" name="addNotebook" method="POST">
            <div class="modal-body">


                <div class="form-group">
                  <label for="notebookName" >NOTE BOOK NAME</label>                      
                  <input type="text" placeholder="Enter notebook name" id="notebookName" name="notebookName" class="form-control">
                   <span><label id="notebookName-error" class="error" for="notebookName"></label></span>
                   
                </div>
                <div class="form-group">
                  <label for="notebookDescription">Description</label>
                  <input type="text" placeholder="Enter description about notebook" id="notebookDescription" name="notebookDescription" class="form-control">
                <span><label id="notebookDescription-error" class="error" for="notebookDescription"></label></span>
                </div>

            </div>
            <div class="modal-footer">
              <button type="button" data-dismiss="modal" class="btn btn-secondary">Close</button>
              <button type="submit" class="btn btn-primary">Save</button>
            </div>
            </form>
            
            
            
            
          </div>
        </div>
      </div>

      <!--end add note book-->

      <!--Notebook-->


      <div class="col-lg-12 " id="notebook">
      
      
		     <c:forEach items="${NoteBookList}" var="item">
		     	  <div class="card notebookRow" id="${item.key.getId()}">
		          <div class="card-header" style="background-color:#676be6; ">
		            <div class="row">
		              <div class="col-10" id="cardname"><a href="note?notebookId=${item.key.getId()}">${item.key.getNoteBookName()}</a></div>
		              <div class="col-1"> <a href="deletenotebook?notebookId=${item.key.getId()}"><i class="fas fa-trash-alt"></i> </a> </div>
		              <div class="col-1"> <a href="#"  data-toggle="modal" data-target="#editNotebook${item.key.getId()}">
		              
		              <i class="fas fa-pencil-alt"></i> </a> </div>
		            </div>
		
		          </div>
		          <div class="card-body">
		            <h6 class="card-titlet">${item.key.getNoteBookDescription()}</h6>
		            <p class="card-text">no of notes => <c:out value="${item.value} Notes" /></p>
		
		          </div>
		        </div>
		     	
		     	
		<div id="editNotebook${item.key.getId()}" tabindex="-1" role="dialog" aria-labelledby="editNotebookLabel" aria-hidden="true"
        class="modal fade text-left">
        <div role="document" class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header"><strong id="editNotebook" class="modal-title">Edit NOTEBOOK</strong>
              <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span
                  aria-hidden="true">x</span></button>
            </div>
            
            
            <form action="editnotebook" id="editNotebook" name="editNotebook" method="POST">
            <div class="modal-body">
					
				 <div class="form-group">
                  <label for="notebookName" ></label>                      
                                     
                  <input type="hidden"  id="notebookId" name="notebookId" value="${item.key.getId()}" class="form-control">
                </div>
                
                
                

                <div class="form-group">
                  <label for="notebookName" >NOTE BOOK NAME</label>                      
                  <input type="text" placeholder="Enter notebook name" id="notebookName" name="notebookName" value="${item.key.getNoteBookName()}" class="form-control">
                   <span><label id="notebookName-error" class="error" for="notebookName"></label></span>
                   
                </div>
                <div class="form-group">
                  <label for="notebookDescription">Description</label>
                  <input type="text" placeholder="Enter description about notebook" id="notebookDescription" name="notebookDescription" value="${item.key.getNoteBookDescription()}" class="form-control">
                <span><label id="notebookDescription-error" class="error" for="notebookDescription"></label></span>
                </div>

            </div>
            <div class="modal-footer">
              <button type="button" data-dismiss="modal" class="btn btn-secondary">Close</button>
              <button type="submit" class="btn btn-primary">Save</button>
            </div>
            </form>
            
          </div>
        </div>
      </div>
      
      
		     </c:forEach>


      </div>

      <!-- end Notebook-->
      
      <!-- Modal for edit notebook -->
         


    </div>
    <!--end main page content-->
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
	  
	  
      $("form[name='editNotebook']").validate({
        
      	  rules: {
      		     
      		  notebookName:{required:true,minlength:2},
      		  notebookDescription:{required:true,minlength:2},        	       

              },
              messages: {
              	notebookName: {minlength:"Notebook name must be greater than two digit",required:"Please enter notebook name"},
              	notebookDescription: {minlength:"Notebook Description must be greater than two digit",required:"Please enter notebook name"},

              }   
      });
      
      
      $("form[name='addNotebook']").validate({
          
      	  rules: {
      		     
      		  notebookName:{required:true,minlength:2},
      		  notebookDescription:{required:true,minlength:2},        	       

              },
              messages: {
              	notebookName: {minlength:"Notebook name must be greater than two digit",required:"Please enter notebook name"},
              	notebookDescription: {minlength:"Notebook Description must be greater than two digit",required:"Please enter notebook name"},

              }   
      });
      
 
      
    });


    function searchNote() {
      var input, filter, table, tr, td, i, txtValue, temp;
      input = document.getElementById("myInput");
      filter = input.value.toUpperCase();
      table = document.getElementById("notebook");
      tr = table.getElementsByClassName("notebookRow");



      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("div").cardname;

        if (td) {
          txtValue = td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          }
          else {
            tr[i].style.display = "none";
          }
        }
      }
    }

  </script>
 
       
</body>

</html>