<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/viewSchedule-style.css">
<link rel="stylesheet" href="style/returnSchedule.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>View Schedule</title>
</head>
<body >
	 <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" width="30" height="30" class="d-inline-block align-top" alt="">
          Star Pharmacy</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
	<br>
	<!--Return Schedule Here-->
	<div class="container" style="text-align:center;">
		<table class="table " style="color:black;">
			<thead>
				<tr>
					<th>Rep Name</th>
					<th>Doctor's Name</th>
					<th>Treating Ailment</th>
					<th>Medicine</th>
					<th>Slot</th>
					<th>Date</th>
					<th>Doctor Contact#</th>
				</tr>
			</thead>
			<tbody >
				<c:forEach items="${details}" var="detail">
					<tr>
						<td>${detail.name}</td>
						<td>${detail.doc}</td>
						<td>${detail.ailment}</td>
						<td>${detail.meds}</td>
						<td>${detail.slot}</td>
						<td>${detail.date}</td>
						<td>${detail.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/viewDemand"><button type="button" class="btn btn-outline-success">Place Demand</button></a>
	</div>
</body>
</html>
