<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it">
	<head>
		<jsp:include page="../header.jsp" />
		<title>Inserisci nuovo</title>
		
		<!-- style per le pagine diverse dalla index -->
	    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
	 <style>
	    .error_field {
	        color: red; 
	    }
	</style>
	    
	</head>
	<body>
		<jsp:include page="../navbar.jsp" />
		
		<spring:hasBindErrors  name="edit_utente_attr">
			<%-- alert errori --%>
			<div class="alert alert-dismissible alert-danger " role="alert">
				Attenzione!! Sono presenti errori di validazione
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</spring:hasBindErrors>
		
		<main role="main" class="container">
		
			<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			<div class='card'>
			    <div class='card-header'>
			        <h5>Inserisci nuovo utente</h5> 
			    </div>
			    <div class='card-body'>
			    
			    		<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
	
						<form:form modelAttribute="edit_utente_attr" method="post" action="modify" novalidate="novalidate" >
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger">*</span></label>
								<spring:bind path="nome">
									<input type="text" name="nome" id="nome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il nome" value="${edit_utente_attr.nome }" required>
								</spring:bind>
								<form:errors  path="nome" cssClass="error_field" />
							</div>
							
							<div class="form-group col-md-6">
								<label>Cognome <span class="text-danger">*</span></label>
								<spring:bind path="cognome">
									<input type="text" name="cognome" id="cognome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il cognome" value="${edit_utente_attr.cognome }" required>
								</spring:bind>
								<form:errors  path="cognome" cssClass="error_field" />
							</div>
						</div>
							
							<div class="form-row">	
								<div class="form-group col-md-6">
									<label>Username <span class="text-danger">*</span></label>
									<spring:bind path="username">
										<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="nope" name="username" id="username" placeholder="Inserire username" value="${edit_utente_attr.username }" required>
									</spring:bind>
									<form:errors path="username" cssClass="error_field" /> 
								</div>

								<div class="form-group col-md-6">
									<label>Password <span class="text-danger">*</span></label>
									<spring:bind path="password">
										<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="new-password" name="password" id="password" placeholder="Inserire password" value="${edit_utente_attr.password }" required>
									</spring:bind>
									<form:errors path="password" cssClass="error_field" />
								</div>
							</div>
							
							<div class="form-row">
						        <div class="form-group col-md-6">
									<label>Conferma Password <span class="text-danger">*</span></label>
											<spring:bind path="confermaPassword">
												<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" autocomplete="new-password" name="confermaPassword" id="confermaPassword" placeholder="Inserire conferma password" value="${edit_utente_attr.password }" required>
											</spring:bind>
											<form:errors path="confermaPassword" cssClass="error_field" />
								</div>
					
								<div class="form-group col-md-6">
									<label>Codice Fiscale <span class="text-danger">*</span></label>
									<spring:bind path="codiceFiscale">
										<input type="text" name="codiceFiscale" id="codiceFiscale" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il codice fiscale" value="${edit_utente_attr.codiceFiscale }" required>
									</spring:bind>
									<form:errors  path="codiceFiscale" cssClass="error_field" />
								</div>
				        
			       			 </div>
			       		<div class="form-row">
			       			<div class="form-group col-md-6">
									<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${edit_utente_attr.dataNascita}' />
									<label>Data di Nascita <span class="text-danger">*</span></label>
			                    		<spring:bind path="dataNascita">
			                     			<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataNascita" type="date" placeholder="dd/MM/yy"
			                         		title="formato : gg/mm/aaaa"  name="dataNascita" required 
			                         		value="${parsedDate}" >
			                        	 </spring:bind>
			                       		<form:errors  path="dataNascita" cssClass="error_field" />
							</div>
						</div>
			       		<div class="form-row">
							<div class="form-group col-md-6">
								<label for="stato">Stato</label>
								    <select class="form-control" id="stato" name="stato">
								    	<option value=""> -- Selezionare una voce -- </option>
									      	<c:forEach items="${list_stati_attribute}" var="statoItem">
									      		<option value="${statoItem}" ${edit_utente_attr.stato.equals(statoItem)?'checked':'' }>${statoItem}</option>
									      	</c:forEach>
								    </select>	
							</div>
							<div class="form-group col-md-6">	
								<label for="roles">Ruoli:</label>
									<div class="form-check">
									<c:forEach items="${list_ruoli_attr}" var="ruoloItem">
									  	<input name="roles" class="form-check-input" type="checkbox" value="${ruoloItem.id}" id="defaultCheck${ruoloItem.id}"
									  	${edit_utente_attr.ruoli.contains(ruoloItem)?'checked':'' }>
								  		<label class="form-check-label" for="defaultCheck${ruoloItem.id}">${ruoloItem.descrizione}</label>
									<br/>
									</c:forEach>
									</div>
							</div>
						</div>
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					</form:form>
			    </div>
			</div>
		
		
		<!-- end container -->	
		</main>
		<jsp:include page="../footer.jsp" />
		
	</body>
</html>