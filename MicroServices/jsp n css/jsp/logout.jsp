<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
<title>logout</title>
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


.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}


.button2 {background-color: #008CBA;} /* Blue */

.container {
  
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
</head>
<body>

 <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
          Star Pharmacy</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>                    <!-- Demo content-->
                    <div class="container">
                        
                          
                            <div class="col-lg-10 col-xl-7 mx-auto">
                                <h3  class="display-4">Logged Out</h3>
                                <p   class="text-muted mb-4">you have loggout successfully</p>
								  
                                 <p   class="text-muted mb-4">sign in again</p>		
                                 <a  href="/loginn"><button type="button" class="btn btn-outline-success">Sign in</button></a>								 
								                               
                            </div>
                      
                    </div><!-- End -->
                         
              
           
      
  
   

</body>
</html>