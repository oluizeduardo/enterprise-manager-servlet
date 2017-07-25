<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Registered Companies</title>
</head>
<body>
    <h1 align = "center">Registered Companies</h1>
    <ul>
        <c: forEach var="company" items="${companies}">
           <li>ID: ${company.id} NAME: ${company.name} EMAIL: ${company.email} </li> 
        </c: forEach>
    </ul>
    <a href="/EnterpriseManager/registration.html">Add New Company</a>
</body>
</html>