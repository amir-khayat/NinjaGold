<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>
			Your Gold:
			<c:out value="${goldAmount}" />
		</h1>
		<div class="row mt-3">
			<div class="col-md-3">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/find" method="post">
					<input type="hidden" name="type" value="farm" /> <input
						class="btn btn-primary" type="submit" value="Find Gold!" />
				</form>
			</div>
			<div class="col-md-3">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<form action="/find" method="post">
					<input type="hidden" name="type" value="cave" /> <input
						class="btn btn-primary" type="submit" value="Find Gold!" />
				</form>
			</div>
			<div class="col-md-3">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<form action="/find" method="post">
					<input type="hidden" name="type" value="house" /> <input
						class="btn btn-primary" type="submit" value="Find Gold!" />
				</form>
			</div>
			<div class="col-md-3">
				<h2>Quest</h2>
				<p>(earns/ takes 0-50 gold)</p>
				<form action="/find" method="post">
					<input type="hidden" name="type" value="quest" /> <input
						class="btn btn-primary" type="submit" value="Find Gold!" />
				</form>
			</div>
		</div>
		<div class="mt-3">
			<label for="activities">Activities:</label>
			<div class="list-group"
				style="max-height: 200px; overflow-y: scroll;">
				<c:forEach var="message" items="${allMessages}">
					<div class="list-group-item ">
						<c:if test="${message.contains('earned')}">
							<p class="text-success">
								<c:out value="${message}" />
							</p>
						</c:if>
						<c:if test="${message.contains('lost')}">
							<p class="text-danger">
								<c:out value="${message}"/>
							</p>
						</c:if>

					</div>
				</c:forEach>
			</div>
		</div>

		<a href="/clear" class="btn btn-danger mt-3">Clear Messages</a>
	</div>
</body>
</html>
