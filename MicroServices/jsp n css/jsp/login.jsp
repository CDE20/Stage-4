<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<title>index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="style/index-
style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1"> 

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
      background-color: #add8e6
}

.flip-card {
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px;
  margin :5px;
   
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #bbb;
  color: black;
}

.flip-card-back {
  background-color: #2980b9;
  color: white;
  transform: rotateY(180deg);
}
</style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">STAR PHARMACY</a>
    </li>
   
  </ul>
</nav>

    <div class="container-fluid">
      
                    <!-- Demo content-->
                    <div class="container">
                        <div class="row">
                          
                            <div class="col-lg-10 col-xl-7 mx-auto">
                                <h3 align="center" class="display-4">Login</h3>
                                <p  align="center" class="text-muted mb-4">Employee Login</p>
                                <form action="/login" method="POST" model="userData" name="loginform">
                                    <div class="form-group mb-3">
                                        <input id="inputEmail" type="text" name="userid" placeholder="Username" required="" autofocus="" class="form-control rounded-pill border-0 shadow-sm px-4">
                                    </div>
                                    <div class="form-group mb-3">
                                        <input id="inputPassword" type="password" name="upassword" placeholder="Password" required="" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
                                    </div>
     
                                    <button  type="submit" name="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Login</button>
                                    <div class="text-center d-flex justify-content-between mt-4"><p>${errormsg}</u></p></div>
                                </form>
                            </div>
                        </div>
                    </div><!-- End -->
    
              
            </div><!-- End -->
    
  
     <div class="container">
      <div class="row">
     
    <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="https://epsilon.aeon.co/images/afef287f-dd6f-4a6a-b8a6-4f0a09330657/idea_sized-kendal-l4ikccachoc-unsplash.jpg" alt="Avatar" style="width:400px;height:400px;">
    </div>
    <div class="flip-card-back">
      <h1>mecidine</h1> 
    
    
    </div>
  </div>
</div>
   
   
    <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="https://pharmaceutical-journal.com/wp-content/uploads/2021/01/asian-pharmacist-ss-19-1456x967.jpg" alt="Avatar" style="width:400px;height:400px;">
    </div>
    <div class="flip-card-back">
       <h1>mecidine</h1> 
    
    </div>
  </div>
</div>
   
     
      <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="https://media.capc.org/images/AdobeStock_274131656.original.jpg" alt="Avatar" style="width:400px;height:400px;">
    </div>
    <div class="flip-card-back">
        <h1>mecidine</h1> 
    </div>
  </div>
</div>
   
      
   </div>
   </div> 
    
    

</body>
</html>