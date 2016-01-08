<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Room Information ${roomName} </title>
	</head> 
	<body>
		<form id="update_room" name="update_room" action="${updateRoomUrl}" >
			  Room Id: <input type="text" name="firstname"><br>
			  Room Name: <input type="text" name="lastname"><br>
			  Room Location: <input type="text" name="lastname"><br>
		</form> 
		<h2>${message}</h2>
	</body>
</html>
