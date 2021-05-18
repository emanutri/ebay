<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Visualizza Utente</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		<div class='card'>
		    <div class='card-header'>
		        Visualizza Utente
		    </div>
			<form:form modelAttribute="show_utente_attr" method="post" action="show" novalidate="novalidate" >	
		
		    <div class='card-body'>
		    	<dl class="row">
					<dt class="col-sm-3 text-right">Id:</dt>
				 	<dd class="col-sm-9">${show_utente_attr.id}</dd>
		    	</dl>
		    	
		    	<dl class="row">
					<dt class="col-sm-3 text-right">Nome:</dt>
					<dd class="col-sm-9">${show_utente_attr.nome}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Cognome:</dt>
					<dd class="col-sm-9">${show_utente_attr.cognome}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  	<dt class="col-sm-3 text-right">Codice Fiscale:</dt>
				  	<dd class="col-sm-9">${show_utente_attr.codiceFiscale}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Data di Nascita:</dt>
				 	<dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_utente_attr.dataNascita}" /></dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Credito:</dt>
				 	<dd class="col-sm-9">${show_utente_attr.credito}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Data di Creazione:</dt>
				 	<dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_utente_attr.dataCreazione}" /></dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Stato:</dt>
				 	<dd class="col-sm-9">${show_utente_attr.stato}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				 	<dt class="col-sm-3 text-right">Ruoli:</dt>
				 	<c:forEach items = "${show_utente_attr.ruoliDTO }" var = "ruoloItem" >
				 	<dd class="col-sm-9">${ruoloItem.descrizione }</dd>
		    		</c:forEach>
		    	</dl>
		    	
		    	<p>
                <a class="btn btn-primary btn-sm" data-toggle="collapse" href="#collapseAnnunci" role="button" aria-expanded="false" aria-controls="collapseAnnunci">
                    Info Annunci
                </a>
	            </p>
   				<c:forEach var = "annuncioItem" items = "${show_utente_attr.annunci }">
	            <div class="collapse" id="collapseAnnunci">
	                <div class="card card-body">
	
	                    <dl class="row">
	                        <dt class="col-sm-3 text-right">Id: </dt>
	                        <dd class="col-sm-9">${annuncioItem.id}</dd>
	                    </dl>
	
	                    <dl class="row">
	                        <dt class="col-sm-3 text-right">Testo Annuncio: </dt>
	                        <dd class="col-sm-9">${annuncioItem.testoAnnuncio}</dd>
	                    </dl>
	
                        <dl class="row">
                            <dt class="col-sm-3 text-right">Stato Annuncio: </dt>
                            <dd class="col-sm-9" style="color:${annuncioItem.aperto?'green':'red' };">${annuncioItem.aperto?'Aperto':'Chiuso'}</dd>
                        </dl>
                        
                        <dl class="row">
						 	<dt class="col-sm-3 text-right">Data di Pubblicazione: </dt>
						 	<dd class="col-sm-9"><fmt:formatDate type = "date" value = "${annuncioItem.dataPubblicazione}" /></dd>
				    	</dl>
				    	
				    	<dl class="row">
						 	<dt class="col-sm-3 text-right">Categorie: </dt>
						 	<c:forEach items = "${annuncioItem.categorie }" var = "categoriaItem" >
						 	<dd class="col-sm-9">categoriaItem</dd>
				    		</c:forEach>
				    	</dl>
				    	
	                </div>
                </div>
                </c:forEach>
	        
	            <br>
		    	
		    	<p>
				  <a class="btn btn-primary btn-sm" data-toggle="collapse" href="#collapseAcquisti" role="button" aria-expanded="false" aria-controls="collapseAcquisti">
				    Elenco Acquisti
				  </a>
				</p>
				<c:forEach var = "acquistoItem" items = "${show_utente_attr.acquisti }">
					<div class="collapse" id="collapseAcquisti">
					  <div class="card card-body">
					  
					  	<dl class="row">
						  <dt class="col-sm-3 text-right">Id: </dt>
						  <dd class="col-sm-9">${acquistoItem.id}</dd>
					   	</dl>
					   	
					   	<dl class="row">
						  <dt class="col-sm-3 text-right">Descrizione: </dt>
						  <dd class="col-sm-9">${acquistoItem.descrizione}</dd>
					   	</dl>
					   	
					   	<dl class="row">
						  <dt class="col-sm-3 text-right">Prezzo:</dt>
						  <dd class="col-sm-9">${acquistoItem.prezzo}</dd>
					   	</dl>
					   	
					    <dl class="row">
						 	<dt class="col-sm-3 text-right">Data di Acquisto: </dt>
						 	<dd class="col-sm-9"><fmt:formatDate type = "date" value = "${acquistoItem.anno}" /></dd>
				    	</dl>
					   	
					  </div>
					</div>
				</c:forEach>
				<!-- end info Regista -->
			</div>
			
			<div class='card-footer'>
		        <a href="${pageContext.request.contextPath }/utente/show" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
			</div>
			</form:form>
		</div>
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>