<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="hu">
<head>
    <meta name="author" content="Szluka András">
    <meta name="description" content="Zooweb">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="zooStyle.css">
    <title>Zoo</title>
</head>

<body class="bg-dark text-light">
<nav class="navbar navbar-expand-lg bg_dark">
    <a class="navbar-brand text-light ml-1" href="#">🦁 Zoo 🐵</a>
    <div class="navbar-nav">
        <a class="nav-link text-light" href="index.jsp">Home 🐬</a>
        <a class="nav-link text-light" href="animal.jsp">Add Animal 🐢</a>
        <a class="nav-link text-light" href="adoptive.jsp">Adoptives 👤</a>
        <a class="nav-link text-light" href="animallist">List 🐰 of 🐴 animals 🐶</a>
    </div>
</nav>

<div class="container">
    <div class="container mt-3 mb-3"></div>

    <form action="animallist" method="post">
        <div class="row">
            <div class="col-2">
                <a href="animal.jsp" class="btn btn-light" role="button">New Animal</a>
            </div>
            <div class="col-6">
                <input type="text" class="form-control" name="kereses" id="kereses">
            </div>
            <div class="col-2">
                <select class="form-control custom-select" id="opciok" name="opciok">
                    <option>Name</option>
                    <option>Year</option>
                    <option>Specie</option>
                    <option>Intro</option>
                </select>
            </div>
            <div class="col-2">
                <button type="submit" class="btn btn-light">Search</button>
            </div>
        </div>
    </form>

    <table class="table text-light">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Year</th>
            <th scope="col">Specie</th>
            <th scope="col">Intro</th>
            <th scope="col">Picture</th>
            <th scope="col">Adopt</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="animal" items="${animalList}">
            <tr>
                <th scope="row"><c:out value="${animal.id}"/></th>
                <td><c:out value="${animal.name}"/></td>
                <td><c:out value="${animal.year}"/></td>
                <td><c:out value="${animal.specie}"/></td>
                <td><c:out value="${animal.intro}"/></td>
                <c:choose>
                    <c:when test="${animal.adopted=='0'}">
                        <td><img src="data:image/jpg;base64,${animal.picture}" class="kep"/></td>
                    </c:when>
                    <c:otherwise>
                        <td style="opacity: 0.7">No picture available</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${animal.adopted=='0'}">
                        <td><a style="text-decoration: none" class="text-light"
                               href="adoptation?id=<c:out value='${animal.id}' />">Adopt</a></td>
                    </c:when>
                    <c:otherwise>
                        <td style="opacity: 0.7">Already adopted</td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
        integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
        crossorigin="anonymous"></script>
</body>
</html>
