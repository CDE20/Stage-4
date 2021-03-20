<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html> 
<html lang="en"> 
  
<head> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/home-style.css">
    <title>Home</title>
</head>
<body>
     <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
          Star Pharmacy</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
    <br>
    <div class="container">
      <!--  <div class="row">  -->
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://blog-assets.freshworks.com/freshdesk/wp-content/uploads/2020/03/05162316/Shift-schedules.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">View Schedule</h4>
                        <p class="card-text">Click to view the  Schedule</p>
                        <form action="/viewSchedule" method="GET"><button type="submit" name="submit" class="btn btn-outline-primary">View Schedule</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
          <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://www.pngkey.com/png/full/125-1253173_register-register-png.png" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Place Demand</h4>
                        <p class="card-text">Place the medicine demand from stock</p>
                        <form action="/viewDemand" method="GET"><button type="submit" name="submit" class="btn btn-outline-success">Place Demand</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            
           
   <!--   </div>-->
  </div>
</div>  
             
        </div>
    </div>

</body> 
</html> 

