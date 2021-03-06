<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet" type="text/css">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Gestione della Raccolta Film</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp" />
  
  
	<main role="main">

	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <h1 class="display-3">Benvenuto su ebay di emanuele e giacomo</h1>
	      <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	    </div>
	  </div>
	  
	  <div class="container">
	  
	  	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  
	    <!-- Example row of columns -->
	    <div class="row">
	      <div class="col-md-6">
	        <h2>Cerca Annunci</h2>
	        <p>Trova l'annuncio che fa per te! <br> Tra oltre 10'000 annunci sul nostro sito puoi trovare il prodotto a prezzo scontato che preferisci</p>
	        <p><a class="btn btn-primary" href="annuncio/search" role="button">Vai alla Funzionalit? &raquo;</a></p>
	      </div>
	      <div class="col-md-6">
	        <h2>Area Personale</h2>
	        <p>Questa funzionalit? ? realtiva alla Gestione del tuo fantastico profilo</p>
	        <p><a class="btn btn-primary" href="areapersonale/show" role="button">Vai alla Funzionalit? &raquo;</a></p>
	      </div>
	    </div>
	    
	    <hr>
	
	  </div> <!-- /container -->
	
	</main>
	
	<jsp:include page="./footer.jsp" />
  </body>
</html>