<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Room Info</title>
		
		<style type="text/css">
			.container {
			  display: table;
			}
			
			.row {
				display: table-row;
			}
			
			.item {
				display: table-cell;
				padding: 5%;
			}
			
			.action {
			    margin: 0.5%;
			    padding: 0.5%;
			    border: #2F5BB7;
			    border-style: hidden;
			    height: 40px;
			    float: left;
			}
			
			.insideAction {
			    margin: 0.5%;
			    padding: 0.5%;
			    float: left;
			}
			
		</style>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
		
		<!-- Include Bootstrap Datepicker -->
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
		
	</head> 
	<body>
		<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
		<script  type="text/javascript">
		 $(document).ready(function () {
			$('.form-control').datepicker({
				format: "yyyy-mm-dd"
			});
		 })
		</script>
		
		<h2>Rooms at Novopay office</h2>
		
		<form action="/spring-mvc/booking/book" method="post">
			<div id="roomsDiv" class="container">	
				<c:forEach var="room" items="${rooms}">
					<div class="row">
						<div class="item">
							<c:if test="${room.booked==false}">
								<input name="roomSelect" type="radio" value="${room.id}" >
							</c:if>
						</div>
						<div class="item" style="margin:5px;">
							Name: ${room.name} <br>
							Capacity: ${room.capacity} <br>
							Location: ${room.location } <br>
							
							<c:if test="${room.booked==true}">Booked from <b>${room.startTime}</b> till <b>${room.endTime}</b> ${room.repeatDescription}</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div class="action">
				Booking Date:
				<input type="text" name="bookingDate" id="bookingDate" class="insideAction form-control" />
			</div>
			<div class="action">
				From:
				<select name="bookFromSlot" id="bookFromSlot" class="insideAction">
				<c:forEach var="slot" items="${timeslots}">
					<option value="${slot.id}">${slot.time}</option>
				</c:forEach>
				</select>
			</div>
			<div class="action">
				To:
				<select name="bookToSlot" id="bookToSlot" class="insideAction">
				<c:forEach var="slot" items="${timeslots}">
					<option value="${slot.id}">${slot.time}</option>
				</c:forEach>
				</select>
			</div>
			<div class="action">
				Repeat Every:
				<select id="repeatType" name="repeatType" class="insideAction">
				<c:forEach var="repeat" items="${repeats}">
					<option value="${repeat.id}">${repeat.description}</option>
				</c:forEach>
				</select>
			</div>
			<div class="action">
				Till this date:
				<input id="repeatTill" name="repeatTill" class="insideAction form-control">
			</div>
			<div class="action">
				Email: <input type="text" id="username" name="username" class="insideAction" />
			</div>
			<c:if test="${not empty errors}">
				<div class="error">
					<ul>
						<c:forEach var="error" items="${errors}">
							<li><span>${error}</span></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<div class="action" style="padding-top: 50px;">	
				<button type="submit" class="insideAction form-control"> Book </button>
			</div>
		</form>
		
	</body>
</html>


