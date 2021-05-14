<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
  
    <jsp:include page="../header.jsp" />
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Registrazione</title>
    

    <!-- Favicons -->
    <meta name="theme-color" content="#563d7c">


    <style>
        
    body {
    	background-color: #ffffff !important; 
    	}
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
    </style>
    <link href="${pageContext.request.contextPath}/assets/css/registration.css" rel="stylesheet" type="text/css">

  </head>
  <body>
  	<jsp:include page="../navbar.jsp" />
	<div role = "main" class="container">
	  <div class="py-5 text-center">
	    <h2>Registrazione</h2>
	    <p class="lead">Benvenuto/a nel form di registrazione. Compilare tutti i campi per ottenere un account. Questo verra' in seguito validato da un amministratorie di sistema.</p>
	  </div>
	  
	  	<div class="alert alert-danger ${registration_utente_attr.hasErrors()?'':'d-none'}" role="alert">
			<c:forEach var ="errorItem" items="${registration_utente_attr.errors }">
	        	<ul>
					<li> ${errorItem }</li>	
				</ul>
	      	</c:forEach>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  
	  <div class="row">
	    <div class="col-md-12 order-md-1">
	      <h4 class="mb-3">Registrazione utente</h4>
	      <form novalidate action="ExecuteRegistrationUtenteServlet" method="post">
	        <div class="row">
	          <div class="col-md-6 mb-3">
	            <label for="nome">Nome</label>
	            <input type="text" class="form-control" name = "nome" id="nome" placeholder="Nome" value="${registration_utente_attr.nome }" required>
	          </div>
	          <div class="col-md-6 mb-3">
	            <label for="cognome">Cognome</label>
	            <input type="text" class="form-control" name = "cognome" id="cognome" placeholder="Cognome" value="${registration_utente_attr.cognome }" required>
	          </div>
	        </div>
	
	        <div class="mb-3">
	          <label for="username">Username</label>
	          <div class="input-group">
	            <input type="text" class="form-control" name = "username" id="username" placeholder="Username" value = "${registration_utente_attr.username }" autocomplete = "nope" required>
	          </div>
	        </div>
	
	        <div class="mb-3">
	          <label for="password">Password</label>
	          <input type="password" class="form-control" name = "password" id="password" placeholder="Password" value = "${registration_utente_attr.password }" autocomplete = "new-password" required>
	        </div>
	
	        <div class="mb-3">
	          <label for="confermaPassword">Conferma Password</label>
	          <input type="password" class="form-control" name = "confermaPassword" id="confermaPassword" placeholder="Conferma Password" value = "${registration_utente_attr.confermaPassword }" autocomplete = "new-password" required>
	        </div>
	
<!-- 	        <div class="mb-3"> -->
<!-- 	          <label for="address2">Address 2 <span class="text-muted">(Optional)</span></label> -->
<!-- 	          <input type="text" class="form-control" id="address2" placeholder="Apartment or suite"> -->
<!-- 	        </div> -->
	
<!-- 	        <div class="row"> -->
<!-- 	          <div class="col-md-5 mb-3"> -->
<!-- 	            <label for="country">Country</label> -->
<!-- 	            <select class="custom-select d-block w-100" id="country" required> -->
<!-- 	              <option value="">Choose...</option> -->
<!-- 	              <option>United States</option> -->
<!-- 	            </select> -->
<!-- 	            <div class="invalid-feedback"> -->
<!-- 	              Please select a valid country. -->
<!-- 	            </div> -->
<!-- 	          </div> -->
<!-- 	          <div class="col-md-4 mb-3"> -->
<!-- 	            <label for="state">State</label> -->
<!-- 	            <select class="custom-select d-block w-100" id="state" required> -->
<!-- 	              <option value="">Choose...</option> -->
<!-- 	              <option>California</option> -->
<!-- 	            </select> -->
<!-- 	            <div class="invalid-feedback"> -->
<!-- 	              Please provide a valid state. -->
<!-- 	            </div> -->
<!-- 	          </div> -->
<!-- 	          <div class="col-md-3 mb-3"> -->
<!-- 	            <label for="zip">Zip</label> -->
<!-- 	            <input type="text" class="form-control" id="zip" placeholder="" required> -->
<!-- 	            <div class="invalid-feedback"> -->
<!-- 	              Zip code required. -->
<!-- 	            </div> -->
<!-- 	          </div> -->
<!-- 	        </div> -->
	        
	        <button class="btn btn-primary btn-lg btn-block" type="submit">Registrati</button>
        	<a href="${pageContext.request.contextPath}/HomeServlet" class='btn btn-outline-secondary btn-lg btn-block' >
	            <i class='fa fa-chevron-left'></i> Back
	        </a>
	      </form>
	    </div>
	  </div>
	
	</div>
		<jsp:include page="../footer.jsp" />
  </body>
</html>
