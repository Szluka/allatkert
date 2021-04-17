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

<div class="container col-6 mt-5 mb-5">
    <h1 class="mx-auto">Animal registration</h1>
    <br>
    <form action="animal" method="post">
        <div class="form-group">
            <label class="font-l" for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label class="font-l" for="year">Year of birth:</label>
            <input type="text" class="form-control" id="year" name="year">
        </div>
        <div class="form-group">
            <label class="font-l" for="specie">Specie:</label>
            <select class="form-control custom-select" id="specie" name="specie">
                <option value="Dog">Dog</option>
                <option value="Cat">Cat</option>
                <option value="Horse">Horse</option>
                <option value="Hamster">Hamster</option>
            </select>
        </div>
        <div class="form-group">
            <label class="font-l" for="intro">Intro:</label>
            <input type="text" class="form-control" id="intro" name="intro">
        </div>
        <div class="form-group">
            <label class="font-l" for="picture">Picture:</label>
            <input type="file" class="form-control" id="picture" name="picture">
        </div>
        <br>
        <button type="submit" class="btn btn-light">Submit</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
        integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
        crossorigin="anonymous"></script>

</body>
</html>
