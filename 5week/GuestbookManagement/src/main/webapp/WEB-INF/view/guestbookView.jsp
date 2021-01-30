<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guestbook</title>
</head>
<body>

<h1>방명록 관리 페이지</h1>
<hr/>

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
        <div>
            <input type="button" value="삭제" onclick="location.href='delete?no=${item.getId()}'"/>
        </div>
        <hr/>
    </div>
</c:forEach>

<form action="register" method="post">
    <div>
        <label>이름: </label>
        <input name="personName" type="text"/><br/>
    </div>
    <div>
        <label>내용: </label>
        <textarea name="content"></textarea><br/>
    </div>
    <div>
        <input type="submit" value="작성"/>
    </div>
</form>
<hr/>
</body>
</html>
