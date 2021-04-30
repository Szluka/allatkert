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
    <form action="adoptation" method="post">
        <div class="form-group">
            <label class="font-l" for="name">Name:</label>
            <input type="text" class="form-control" value="<c:out value="${animal2.name}" />" id="name" name="name"
                   disabled>
        </div>
        <div class="form-group">
            <label class="font-l" for="adoptiveId">Adoptive:</label>
            <select class="form-control" id="adoptiveId" name="adoptiveId">
                <c:forEach var="adoptive" items="${adoptiveList}">
                    <option value="<c:out value="${adoptive.id}" />"><c:out value="${adoptive.name}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label class="font-l" for="date">Date:</label>
            <input type="date" class="form-control" id="date" name="date"
                   value="2021-04-16"
                   min="2021-04-16" max="2022-01-01">
        </div>
        <div class="form-group">
            <label class="font-l" for="donationType">Donation type:</label>
            <select class="form-control" id="donationType" name="donationType">
                <option value="money">Money (HUF)</option>
                <option value="food">Food (gramms)</option>
            </select>
        </div>
        <div class="form-group">
            <label class="font-l" for="donationValue">Donation Value:</label>
            <input type="number" class="form-control" value="1000" min="1000" step="1000" max="50000" id="donationValue"
                   name="donationValue">
        </div>
        <div class="form-group">
            <label class="font-l" for="donationFreq">Donation Frequency:</label>
            <select class="form-control" id="donationFreq" name="donationFreq">
                <option value="once">Once</option>
                <option value="daily">Daily</option>
                <option value="weekly">Weekly</option>
                <option value="monthly">Monthly</option>
                <option value="yearly">Yearly</option>
            </select>
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