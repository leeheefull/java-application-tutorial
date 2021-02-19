<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Test</title>
</head>
<body>
<h1>Reservation Test</h1>
카테고리 목록 보기<br/>
<input type="button" value="api/categories"
       onclick="location.href='http://localhost:8080/api/categories'"/>
<br/><br/><br/>
프로모션 목록 보기<br/>
<input type="button" value="api/promotions"
       onclick="location.href='http://localhost:8080/api/promotions'"/>
<br/><br/><br/>
전시상품 전체 보기<br/>
<input type="button" value="api/displayinfos"
       onclick="location.href='http://localhost:8080/api/displayinfos'"/>
<br/><br/><br/>
카테고리별 전시상품 보기<br/>
<input type="button" value="api/displayinfos/category/3"
       onclick="location.href='http://localhost:8080/api/displayinfos/category/3'"/>
<br/><br/><br/>
카테고리별 전시상품 페이지로 보기<br/>
<input type="button" value="api/displayinfos/category/3?pagesize=4&pageno=1"
       onclick="location.href='http://localhost:8080/api/displayinfos/category/3?pagesize=4&pageno=1'"/>
<br/><br/><br/>
특정 전시상품 세부사항 보기<br/>
<input type="button" value="api/displayinfos/displayinfo/1"
       onclick="location.href='http://localhost:8080/api/displayinfos/displayinfo/1'"/>
<br/><br/><br/>
댓글 전체 보기<br/>
<input type="button" value="api/comments"
       onclick="location.href='http://localhost:8080/api/comments'"/>
<br/><br/><br/>
상품별 댓글 보기<br/>
<input type="button" value="api/comments/product/1"
       onclick="location.href='http://localhost:8080/api/comments/product/1'"/>
<br/><br/><br/>
상품별 댓글 페이지로 보기<br/>
<input type="button" value="api/comments/product/1?pagesize=5&pageno=1"
       onclick="location.href='http://localhost:8080/api/comments/product/1?pagesize=5&pageno=1'"/>
</body>
</html>