<!DOCTYPE html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="startdate.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>View Schedule</title>
</head>
<body  >
    <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
          Star Pharmacy</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
      <br>
      <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
                    <img class="card-img-top img-fluid" src="https://blog-assets.freshworks.com/freshdesk/wp-content/uploads/2020/03/05162316/Shift-schedules.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Enter Start Date</h4>
                        <p class="card-text">Schedule will be displayed for 5 days</p><br><br>
                        <form action="/RepSchedule" method="GET">
                        	<div class="controls">
                          <i style="font-size:24px" class="fa">&#xf073;</i>  <input type="date" class="date" id="startdate" name="startdate" required><br><br>
                            <button class="btn btn-outline-primary">View Schedule</button>
                       		</div>
						</form>
                        
                        <p></p>
                    </div>
                </div>
            </div>
   </div>
   </div>
</body>
</html>