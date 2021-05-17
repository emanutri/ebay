<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Ricerca</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
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
		        <h5>Ricerca annunci</h5> 
		    </div>
		    <div class='card-body'>

					<form method="post" action="list" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Testo Annuncio</label>
								<input type="text" name="testoAnnuncio" id="testoAnnuncio" class="form-control" placeholder="Inserire il Testo dell'Annuncio" >
							</div>
							
							<div class="form-group col-md-6">
								<label>Prezzo</label>
								<input type="number" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" >
							</div>
						</div>
						<div class="form-group col-md-3">
							<label for="categorie">Categorie:</label>
								<div class="form-check">
								<c:forEach items="${list_categorie_attr}" var="categorieItem">
								  	<input name="categorie" class="form-check-input" type="checkbox" id = "defaultCheck${categorieItem.id}" value="${categorieItem.id}" >
							  		<label class="form-check-label" for="defaultCheck${categorieItem.id}">${categorieItem.descrizione}</label>
								<br/>
								</c:forEach>
								</div>
						</div>
						
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						<input class="btn btn-outline-warning" type="reset" value="Ripulisci">

						<a class="btn btn-outline-primary ml-2" href="${pageContext.request.contextPath }/annuncio/insert">Add New</a>
						
					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>