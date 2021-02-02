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
    <form action="delete" method="post">
        <div>
            No: ${item.id}
        </div>
        <div>
            이름: ${item.personName}
        </div>
        <div>
            내용: ${item.content}
        </div>
        <div>
            등록일: ${item.regdate}
        </div>
        <div>
            <input type="hidden" name="no" value="${item.id}"/>
            <input type="submit" value="삭제"/>
        </div>
        <hr/>
    </form>
</c:forEach>

<form action="register" method="post">
    <div>
        이름: <input name="personName" type="text"/><br/>
    </div>
    <div>
        내용: <textarea name="content"></textarea><br/>
    </div>
    <div>
        <input type="submit" value="작성"/>
    </div>
</form>
<hr/>
</body>
</html>
