<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Ricerca</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Ricerca elementi</h5> 
		    </div>
		    <div class='card-body'>

					<form:form method="post" action="list" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome</label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" >
							</div>
							<div class="form-group col-md-6">
								<label>Cognome</label>
								<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" >
							</div>
						</div>
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Username</label>
								<input type="text" class="form-control" name="username" id="username" placeholder="Inserire lo username" >
							</div>
							<div class="form-group col-md-6">
								<label>Codice Fiscale</label>
								<input type="text" class="form-control" name="codiceFiscale" id="codiceFiscale" placeholder="Inserire il codice fiscale" >
							</div>
						</div>
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Data di Nascita</label>
                        		<input class="form-control" id="dataNascita" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataNascita" >
							</div>
							
							<div class="form-group col-md-6">
								<label>Data di Creazione</label>
                        		<input class="form-control" id="dataCreazione" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataCreazione" >
							</div>
						<div class="form-group col-md-6">
							<label for="stato">Stato</label>
							    <select class="form-control" id="stato" name="stato">
							    	<option value=""> -- Selezionare una voce -- </option>
								      	<c:forEach items="${list_stati_attribute}" var="statoItem">
								      		<option value="${statoItem}">${statoItem}</option>
								      	</c:forEach>
							    </select>	
						</div>
						<div class="form-group col-md-6">	
							<label for="roles">Ruoli:</label>
								<div class="form-check">
								<c:forEach items="${list_ruoli_attr}" var="ruoloItem">
								  	<input name="roles" class="form-check-input" type="checkbox" value="${ruoloItem.id}" id="defaultCheck${ruoloItem.id}">
							  		<label class="form-check-label" for="defaultCheck${ruoloItem.id}">${ruoloItem.descrizione}</label>
								<br/>
								</c:forEach>
								</div>
							</div>
						</div>
											
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						<input class="btn btn-outline-warning" type="reset" value="Ripulisci">

						<a class="btn btn-outline-primary ml-2" href="insert">Add New</a>
						
					</form:form>
			<!-- end card-body -->			   
		    </div>
		</div>	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>