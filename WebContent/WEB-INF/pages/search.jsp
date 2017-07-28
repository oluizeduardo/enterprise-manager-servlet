<html lang="pt">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="styles/styleTableCompanies.css"> 
    <title>
    	<fmt:message key="mesage.titlepage"/>
    </title>
</head>
<body>
    <h1 align = "center">
    	<fmt:message key="mesage.welcome"/>
    </h1>
     
	<div align="center"> 
		<table>
			<thead>
				<tr>
					<th>
						<fmt:message key="mesage.id"/>
					</th>
					<th>
						<fmt:message key="mesage.name"/>
					</th>
					<th>EMAIL</th>
					<th>
						<fmt:message key="mesage.action"/>
					</th>
				</tr>
			</thead>	
			<c:forEach var="company" items="${companies}">
				<tr>
					<td id="table_id_column">${company.id}</td>
					<td id="table_name_column">${company.name}</td>
					<td id="table_email_column">${company.email}</td>
					<td id="table_action_column">						
						<a href="update?id=<c:out value="${company.id}"/>">
							<img src='img/edit.png' alt="<fmt:message key="mesage.update"/>">
						</a>
						&nbsp &nbsp
						<a href="delete?id=<c:out value="${company.id}"/>">
							<img src='img/delete.png' alt="<fmt:message key="mesage.delete"/>">
						</a>
					</td>
				</tr>
			</c:forEach>
		</table> 
	</div> 
    <p/>
    <a href="/EnterpriseManager/registration.html">
    	<fmt:message key="mesage.newcompany"/>
    </a>
    
    <c:import url="comon/footer.jsp"/>
</body>
</html>