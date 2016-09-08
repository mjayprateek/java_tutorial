<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" ng-app="novo-app">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Novopay Room Booking</title>
  <meta name="description" content="Novopay room booking system">
  <meta name="author" content="Prateek Khatri">

  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS	
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="resources/css/normalize.css">
  <link rel="stylesheet" href="resources/css/skeleton.css">
  <link rel="stylesheet" href="resources/css/custom.css">

  <!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="icon" type="image/png" href="resources/images/favicon.png">
  
  <!-- Javascript
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <script src="resources/js/jquery-3.1.0.min.js" ></script>
  <script src="resources/js/angular.min.js" ></script>
  <script src="resources/js/novoapp.js" ></script>
  
  <script>
	  	function hide(field) {
			$(field).css('display', 'none');
		}
  		
	  	var validateUsername = function validateUsername() {
  			//has been copied from 
  			var email = new RegExp('^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$');
  			var username = $('#username').val();
  			if(username=='' || email.test(username)) {
  				var error = new Object();
  				error.msg = "You haven't typed a valid email address";
  				return error;
  			}
  			
  			return null;
  		}
  		
  		var validatePassword = function validatePassword() {
  			var password = $('#password').val()
  			if(password=='') {
  				var error = new Object();
  				error.msg = "Please type in the password";
  				return error;
  			}
  			
  			return null;
  		}
  		
  		var validateConfirmPassword = function validateConfirmPassword() {
  			var password = $('#password').val()
  			var confirmPassword = $('#confirmPassword').val()
  			if(password=='') {
  				var error = new Object();
  				error.msg = "Please type in the password";
  				return error;
  			} 
  			
  			if(confirmPassword!=password) {
  				var error = new Object();
  				error.msg = "Passwords do not match";
  				return error;
  			}
  			
  			return null;
  		}
  		
  		var validateMobile = function validateMobile() {
  			
  			var email = new RegExp('\d{10}');
  			var username = $('#mobile').val();
  			if(username=='' || email.test(username)) {
  				var error = new Object();
  				error.msg = "Mobile number is not correct";
  				return error;
  			}
  			
  			return null;
  		}
  		
  		function showErrors(field, msg) {
  			$(field).show();
  			$(field).text(msg);
  		}
  		
  		function handleErrors(errorHandlerMapping) {
  			var errorOccurred = false;
  			Object.keys(errorHandlerMapping).forEach(function(key,index) {
  			    // key: the name of the object key
  			    // index: the ordinal position of the key within the object
  			    
  			    var mapping = errorHandlerMapping[key];
  			  	var errorField = mapping[0];
  			    var validator = mapping[1];
  			    
  			    var errors = validator();
  			    
  			  	if(errors!=null) {
	  				showErrors(errorField, errors.msg);
	  				errorOccurred = true;
	  			}
  			    
  			    
  			});
  			
  			return errorOccurred;
  		}
  		
  		var errorFields = ['#usernameError', '#passwordError'];
		errorFields.forEach(hide);
		
		var signupFields = ['#confirmPassword', '#mobileDiv'];
		signupFields.forEach(hide);
		
		var loginFieldsErrorHandlerMapping = new Object();
		loginFieldsErrorHandlerMapping['#usernameLogin'] = ['#usernameLoginError', validateUsername];
		loginFieldsErrorHandlerMapping['#passwordLogin'] = ['#passwordLoginError', validatePassword];
		
		var signupFieldsErrorHandlerMapping = new Object();
		signupFieldsErrorHandlerMapping['#username'] = ['#usernameError', validateUsername];
		signupFieldsErrorHandlerMapping['#password'] = ['#passwordError', validatePassword];
		signupFieldsErrorHandlerMapping['#confirmPassword'] = ['#confirmPasswordError', validateConfirmPassword];
		signupFieldsErrorHandlerMapping['#mobile'] = ['#mobileError', validateMobile];
  		
  		$(document).ready(function() {
  			$('#loginButton').click(function(e) {
  	  			e.preventDefault();
  	  			
  	  			var errorOccurred = handleErrors(loginFieldsErrorHandlerMapping);
  	  			
  	  			if(!errorOccurred)
  	  				$('#loginForm').submit();
  	  		})
  	  		
  	  		$('#signupButton').click(function(e) {
  	  			e.preventDefault();
  	  			
  	  			var errorOccurred = handleErrors(signupFieldsErrorHandlerMapping);
  	  			
  	  			if(!errorOccurred)
  	  				$('#signupForm').submit();
  	  		})
  	  		
  	  		$('#separator').css('height', $('#signupDiv').css('height'));
  			
  			$('#signupDiv').change(function() {
  				$('#separator').css('height', $('#signupDiv').css('height'));
  			})
  	  		
  		});		

  </script>

</head>
<body>

  <!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <div class="container" ng-controller = "novo-ctl">
	    <div class="row">
	      <div class="eight columns" style="margin-top: 15%">
	        <h4>Novopay Room Booking</h4>
	        <p>This is the basic page of Novopay Room Booking System. This is intended to be a toy project to experiment and learn. This page is built using Skeleton CSS3 framework. Please find the documentation at <a href="http://www.getskeleton.com">Skeleton documentation</a>.</p>
	
	      </div>
	    </div>
    	
    	<div class="row">
    	<div class="five columns">
	    	<form action="/booking/login" method="post" id="loginForm">
			    
		    	<div class="row">
		    		<div class="u-full-width"><label for="usernameLogin">Username</label></div>
		    	</div>
		    	<div class="row">
		    		<div class="u-full-width  "><input class="u-full-width" type="text" id="username" /></div>
		    	</div>
		    	
		    	<div class="row "><span class="error" id="usernameLoginError" /></div>
		    	
		    	<div class="row">
		    		<div class="u-full-width"><label for="passwordLogin">Password</label></div>
		    	</div>
		    	<div class="row">
		    		<div class="u-full-width"><input class="u-full-width" type="text" id="password" /></div>
		    	</div>
		    	<div class="row" ><span class="error" id="passwordLoginError" /></div>
		    	
		    	<div class="row">
		    		<a class="u-full-width button button-primary" id="loginButton" href="#">Login</a>
		    	</div>
				
			</form>
			</div>
			
			<div class="one column"></div>
			<div class="one column vertical-line" id="separator"></div>
			
			<div id="signupDiv" class="five columns right-of-separator">
	    	<form action="/booking/signup" method="post" id="signupForm">
			    
		    	<div class="row">
		    		<div class="u-full-width"><label for="username">Username</label><span class="mandatory"> *<span></div>
		    	</div>
		    	<div class="row">
		    		<div class="u-full-width  "><input class="u-full-width" type="text" id="username" /></div>
		    	</div>
		    	<div class="row"><span class="error" id="usernameError" /></div>
		    	
		    	<div class="row">
		    		<div class="u-full-width"><label for="password">Password</label><span class="mandatory"> *<span></div>
		    	</div>
		    	<div class="row">
		    		<div class="u-full-width"><input class="u-full-width" type="text" id="password" /></div>
		    	</div>
		    	<div class="row" ><span class="error" id="passwordError" /></div>
		    	
		    	<div class="row">
		    		<div class="u-full-width"><label for="confirmPassword">Confirm password</label><span class="mandatory"> *<span></div>
		    	</div>
		    	<div class="row">
		    		<div class="u-full-width"><input class="u-full-width" type="text" id="confirmPassword" /></div>
		    	</div>
		    	<div class="row" ><span class="error" id="confirmPasswordError" /></div>
		    	
		    	<div class="row" id="mobileDiv">
			    	<div class="row">
			    		<div class="u-full-width"><label for="mobile">Mobile No.</label></div>
			    	</div>
			    	<div class="row">
			    		<div class="u-full-width"><input class="u-full-width" type="text" id="mobile" /></div>
			    	</div>
			    	<div class="row" ><span class="error" id="mobileError" /></div>
			    </div>
		    	
		    	<div class="row">
		    		<a class="u-full-width button button-primary" id="signupButton" href="/booking/signup" >Sign up</a>
		    	</div>
				
			</form>
			</div>
			
			
		</div>
    </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
