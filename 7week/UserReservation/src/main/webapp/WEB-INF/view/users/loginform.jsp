<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<div>
    <div>
        <form method="post" action="/authenticate">
            <div>
                <label>ID</label>
                <input type="text" name="userId">
            </div>
            <div>
                <label>PW</label>
                <input type="password" name="password">
            </div>
            <div>
                <label></label>
                <input type="submit" value="로그인">
            </div>
        </form>
    </div>
</div>
</body>
</html>