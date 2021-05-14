<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
    
    	.error_field {
	        color: red; 
	    }
        
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
	    <p class="lead">Benvenuto/a nel form di registrazione. Compilare tutti i campi per ottenere un account.</p>
	  </div>
	  
		<spring:hasBindErrors  name="registra_utente_attr">
			<%-- alert errori --%>
			<div class="alert alert-danger " role="alert">
				Attenzione!! Sono presenti errori di validazione
			</div>
		</spring:hasBindErrors>
		
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  
	  <h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
	  
	  <div class="row">
	    <div class="col-md-12 order-md-1">
	      <h4 class="mb-3">Registrazione utente</h4>
	      
	      <form:form action="save" method="post" modelAttribute="registra_utente_attr" novalidate="novalidate">
	      
	        <div class="row">
		        <div class="col-md-6 mb-3">
					<label>Nome <span class="text-danger">*</span></label>
					<spring:bind path="nome">
						<input type="text" name="nome" id="nome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il nome" value="${registra_utente_attr.nome }" required>
					</spring:bind>
					<form:errors  path="nome" cssClass="error_field" />
				</div>
				
				<div class="col-md-6 mb-3">
				<label>Cognome <span class="text-danger">*</span></label>
					<spring:bind path="cognome">
						<input type="text" name="cognome" id="cognome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il cognome" value="${registra_utente_attr.cognome }" required>
					</spring:bind>
					<form:errors  path="cognome" cssClass="error_field" />
				</div>
			</div>
		    <div class="row">
				<div class="form-group col-md-12">
					<label>Username <span class="text-danger">*</span></label>
					<spring:bind path="username">
						<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="nope" name="username" id="username" placeholder="Inserire username" value="${registra_utente_attr.username }" required>
					</spring:bind>
					<form:errors path="username" cssClass="error_field" /> 
				</div>
			</div>
	       <div class="row">
		        <div class="col-md-6 mb-3">
					<label>Password <span class="text-danger">*</span></label>
							<spring:bind path="password">
								<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="new-password" name="password" id="password" placeholder="Inserire password" value="${registra_utente_attr.password }" required>
							</spring:bind>
							<form:errors path="password" cssClass="error_field" />
				</div>
				        
		        <div class="col-md-6 mb-3">
					<label>Conferma Password <span class="text-danger">*</span></label>
							<spring:bind path="confermaPassword">
								<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="new-password" name="confermaPassword" id="confermaPassword" placeholder="Inserire conferma password" value="${registra_utente_attr.password }" required>
							</spring:bind>
							<form:errors path="confermaPassword" cssClass="error_field" />
				</div>
				
	        </div>
	       
	       <div class="row">
				
				<div class="form-group col-md-6">
					<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${registra_utente_attr.dataNascita}' />
					<label>Data di Nascita <span class="text-danger">*</span></label>
	                    		<spring:bind path="dataNascita">
	                     		<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataNascita" type="date" placeholder="dd/MM/yy"
	                         		title="formato : gg/mm/aaaa"  name="dataNascita" required 
	                         		value="${parsedDate}" >
	                         </spring:bind>
	                        	<form:errors  path="dataNascita" cssClass="error_field" />
				</div>
		
				<div class="form-group col-md-6">
					<label>Codice Fiscale <span class="text-danger">*</span></label>
					<spring:bind path="codiceFiscale">
						<input type="text" name="codiceFiscale" id="codiceFiscale" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il codice fiscale" value="${registra_utente_attr.codiceFiscale }" required>
					</spring:bind>
					<form:errors  path="codiceFiscale" cssClass="error_field" />
				</div>
		        
	        </div>
	        <br>
	        <br>
	              
	        <button class="btn btn-primary btn-lg btn-block" type="submit">Registrati</button>
        	<a href="${pageContext.request.contextPath}/home" class='btn btn-outline-secondary btn-lg btn-block' >
	            <i class='fa fa-chevron-left'></i> Back
	        </a>
	        
	      </form:form>
	    
	    </div>
	  </div>
	
	</div>
		<jsp:include page="../footer.jsp" />
  </body>
</html>
