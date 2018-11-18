<%--
  Created by IntelliJ IDEA.
  User: lesli
  Date: 16/11/2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
    <div class="col-lg-6 offset-3">
        <div class="card p-10">
            <h2 class="card-title">Inscription</h2>
            <hr>
            <div class="card-body">
                <form action="/registration" method="post">
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input class="form-control" name="nom" id="nom" type="text">
                        <span class="text-danger font-italic">${errors.nom}</span>
                    </div>
                    <div class="form-group">
                        <label for="prenom">Prenom</label>
                        <input class="form-control" name="prenom" id="prenom" type="text">
                        <span class="text-danger font-italic">${errors.prenom}</span>
                    </div>
                    <div class="form-group">
                        <label for="email">Adresse Electronique</label>
                        <input class="form-control" name="email" id="email" type="text">
                        <span class="text-danger font-italic">${errors.email}</span>
                    </div>
                    <div class="form-group">
                        <label for="password">Mot de passe</label>
                        <input class="form-control" name="password" id="password" type="password">
                        <span class="text-danger font-italic">${errors.password}</span>
                    </div>
                    <div class="form-group">
                        <label for="passwordMatcher">Mot de passe(Confirmation)</label>
                        <input class="form-control" name="passwordMatcher" id="passwordMatcher" type="password">
                        <span class="text-danger font-italic">${errors.passwordMatcher}</span>
                    </div>
                    <button type="submit" class="btn btn-primary">S'incrire</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>