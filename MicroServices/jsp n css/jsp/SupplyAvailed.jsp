<!DOCTYPE html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/viewDemand-style.css">
      <link rel="stylesheet" href="style/supplyAvail.css">
    <title>Stock Available</title>
</head>

<body style="background-color:#90ee90; color:black">
      <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
          Star Pharmacy</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
      <br>
    
        <div class="row">
            <div class="col-lg-1"></div>
           
            
                            <table style="padding:50px;">
              	<thead>
				<tr>
					<th style="text-align:center">Pharmacy</th>
					<th style="text-align:center">Medicine</th>
					<th style="text-align:center">Stock Available</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pharmacyList}" var="ph"><br>
					<tr style="border:1px solid black">
						<td style="text-align:center">${ph.pharmacyName}</td>
						<td style="text-align:center">${ph.medicineName}</td>
						<td style="text-align:center">${ph.supplyCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
                            
                        
            </div>
       
    
 
</body>
</html>