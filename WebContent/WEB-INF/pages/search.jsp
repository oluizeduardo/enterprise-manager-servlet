<html lang="pt">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="styles/styleTableCompanies.css"> 
    <title>Registered Companies</title>
</head>
<body>
    <h1 align = "center">Registered Companies</h1>
     
	<div align="center"> 
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
				</tr>
			</thead>	
			<c:forEach var="company" items="${companies}">
				<tr>
					<td id="width_id_column">${company.id}</td>
					<td id="width_name_column">${company.name}</td>
					<td id="width_email_column">${company.email}</td>
				</tr>
			</c:forEach>
		</table> 
	<div align="center"> 
    <p>
    <a href="/EnterpriseManager/registration.html">Add New Company</a>
</body>
</html>