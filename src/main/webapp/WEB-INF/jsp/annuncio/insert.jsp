<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jqueryUI/jquery-ui.min.css" />
	<style>
		.ui-autocomplete-loading {
			background: white url("../assets/img/jqueryUI/anim_16x16.gif") right center no-repeat;
		}
		.error_field {
	        color: red; 
	    }
	</style>
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<%-- se l'attributo in request ha errori --%>
		<spring:hasBindErrors  name="insert_annuncio_attr">
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
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci nuovo annuncio</h5> 
		    </div>
		    <div class='card-body'>

					<form:form method="post" modelAttribute="insert_annuncio_attr" action="save" novalidate="novalidate" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="titolo">Testo Annuncio</label>
								<spring:bind path="testoAnnuncio">
									<input type="text" name="testoAnnuncio" id="testoAnnuncio" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il Testo Annuncio" value="${insert_annuncio_attr.testoAnnuncio }">
								</spring:bind>
								<form:errors  path="testoAnnuncio" cssClass="error_field" />
							</div>
							
							<div class="form-group col-md-6">
								<label for="genere">Prezzo</label>
								<spring:bind path="prezzo">
									<input type="number" name="prezzo" id="prezzo" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il prezzo" value="${insert_annuncio_attr.prezzo }">
								</spring:bind>
								<form:errors  path="prezzo" cssClass="error_field" />
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">	
									<label for="categorie">Categorie:</label>
										<div class="form-check">
										<c:forEach items="${list_categorie_attr}" var="categoriaItem">
										  	<input name="categoria" class="form-check-input" type="checkbox" value="${categoriaItem.id}" id="categoria${categoriaItem.id}">
									  		<label class="form-check-label" for="categoria${categoriaItem.id}">${categoriaItem.descrizione}</label>
										<br/>
										</c:forEach>
			                    </div>
		                    </div>
		                    <div class="form-check-inline">
							<label class ="form-check-inline" for="${insert_annuncio_attr.aperto}">Annuncio: </label>
						 		Aperto
	  							<input class="form-check-input" type="radio" name="aperto" id="aperto" value="${insert_annuncio_attr.aperto}true" >
	  							Chiuso
	  							<input class="form-check-input" type="radio" name="aperto" id="aperto" value="${insert_annuncio_attr.aperto}false" >
  							</div>
						</div>
						
						<div class="form-row">
						    <div class="form-group col-md-6">
									<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${insert_annuncio_attr.dataPubblicazione}' />
<!-- 									<label>Data di Pubblicazione <span class="text-danger">*</span></label> -->
			                    		<spring:bind path="dataPubblicazione">
			                     			<input type="hidden" class="form-control ${status.error ? 'is-invalid' : ''}" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"
			                         		title="formato : gg/mm/aaaa"  name="dataPubblicazione" required 
			                         		value="${parsedDate}" >
			                        	 </spring:bind>
			                       		<form:errors  path="dataPubblicazione" cssClass="error_field" />
							</div>
						</div>
<%-- 						<input type ="hidden" name="utente" value ="${insert_annuncio_attr.utente.id}"> --%>
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						
					</form:form>
				</div>	
		    
			<!-- end card-body -->			   
		    </div>
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>