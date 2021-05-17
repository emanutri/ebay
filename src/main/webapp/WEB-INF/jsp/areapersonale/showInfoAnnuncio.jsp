<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Visualizza elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Id:</dt>
				  <dd class="col-sm-9">${show_annuncio_attr.id}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Testo Annuncio:</dt>
				  <dd class="col-sm-9">${show_annuncio_attr.testoAnnuncio}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9">${show_annuncio_attr.prezzo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data Pubblicazione:</dt>
				  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_annuncio_attr.dataPubblicazione}" /></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Aperto:</dt>
				  <dd class="col-sm-9">${show_annuncio_attr.aperto}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Categorie:</dt>
				  <dd class="col-sm-9">${show_annuncio_attr.categorie}</dd>
		    	</dl>
		    	
		    	<p>
				  <a class="btn btn-primary btn-sm" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
				    Info Utente
				  </a>
				</p>
				<div class="collapse" id="collapseExample">
				  <div class="card card-body">
				  	<dl class="row">
					  <dt class="col-sm-3 text-right">Nome:</dt>
					  <dd class="col-sm-9">${show_annuncio_attr.utente.nome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Cognome:</dt>
					  <dd class="col-sm-9">${show_annuncio_attr.utente.cognome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Username:</dt>
					  <dd class="col-sm-9">${show_annuncio_attr.utente.username}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Attivo dal:</dt>
					  <dd class="col-sm-9">${show_annuncio_attr.utente.dataCreazione}</dd>
				   	</dl>
				  </div>
				</div>
				<!-- end info Utente -->
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <a href="${pageContext.request.contextPath }/areapersonale" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
<%-- 				<a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath }/annuncio/list/">Back</a> --%>

		    </div>
		</div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>