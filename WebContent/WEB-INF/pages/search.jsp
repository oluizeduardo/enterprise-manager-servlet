<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html lang="pt">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registered Companies</title>
</head>
<body>
    <h1 align = "center">Registered Companies</h1>
       
    <ul>
        <c:forEach items="companies" var="company">
		    <li>${company.getName()}</li>
        </c:forEach>
    </ul>
    <a href="/EnterpriseManager/registration.html">Add New Company</a>
</body>
</html>