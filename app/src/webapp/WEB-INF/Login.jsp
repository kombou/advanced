<%--
  Created by IntelliJ IDEA.
  User: lesli
  Date: 18/11/2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<body>
<div class="col-lg-6 offset-3">
    <div class="card p-10">
        <h2 class="card-title">Login</h2>
        <hr>
        <div class="card-body">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="user">User name | E-mail</label>
                    <input class="form-control" name="user" id="user" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input class="form-control" name="password" id="password" type="password">
                </div>
                <button type="submit" class="btn btn-primary">Connexion</button>
            </form>
        </div>
    </div>
</div>
</body>
</body>
</html>