<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guestbook</title>
</head>
<body>

<c:forEach var="item" items="${guestbookList}">
    <div>
        <div>No: ${item.getId()}
        </div>
        <div>성함: ${item.getPersonName()}
        </div>
        <div>내용: ${item.getContent()}
        </div>
        <div>등록일: ${item.getRegdate()}
        </div>
        <hr/>
    </div>
</c:forEach>

<form action="regist" method="post">
    <div>
        <label>이름: </label>
        <input name="personName" type="text"/><br/>
    </div>
    <div>
        <label>내용: </label>
        <textarea name="content"></textarea><br/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
