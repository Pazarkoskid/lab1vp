<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Event Booking page - Welcome and choose an Event</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome to our Event Booking App</h1>
</header>
<main>
    <h2>Choose an event:</h2>
    <form action="/placeBooking" method="post">
        <c:forEach var="event" items="${events}">
            <label>
                <input type="radio" name="eventName" value="${event.name}" required>
                Name: ${event.name}, Description: ${event.description}, Rating: ${event.popularityScore}
            </label><br/>
        </c:forEach>

        <h2>Choose number of tickets:</h2>
        <input type="number" name="numTickets" min="1" max="10" required><br/>
        <br/>
        <input type="submit" value="Submit">
    </form>
</main>
</body>
</html>