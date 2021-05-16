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
							<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${insert_annuncio_attr.dataPubblicazione}' />
							<div class="form-group col-md-6">
								<label for="dataPubblicazione">Data di Pubblicazione</label>
                        		<spring:bind path="dataPubblicazione">
	                        		<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"
	                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" value="${parsedDate}" >
	                            </spring:bind>
                            	<form:errors  path="dataPubblicazione" cssClass="error_field" />
							</div>
							
							<div class="form-group col-md-6">
								<label for="categorie">Categorie</label>
							    <select class="form-control" id="categoria" name="categoria">
							    	<option value="" selected> -- Selezionare una voce -- </option>
							      	<c:forEach items="${insert_categoria_attr }" var="categoriaItem">
							      		<option value="${categoriaItem.id}" >${categoriaItem.descrizione }</option>
							      	</c:forEach>
							    </select>
							</div>
							
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-3" style = "padding-top: 3px;">
								<div class="form-check-inline">
								  <label class="form-check-label" for="annuncio.aperto">
								    <input type="radio" class="form-check-input" name="annuncio.aperto" value="${insert_annuncio_attr.aperto}" checked="checked">Attivo
								  </label>
								</div>
								<div class="form-check-inline">
								  <label class="form-check-label" for="annuncio.aperto">
								    <input type="radio" class="form-check-input" name="annuncio.aperto" value="${insert_annuncio_attr.aperto=='error'}">Disattivo
								  </label>
								</div>
							</div>	
							<div class="form-group col-md-6" >
								<label for="utente">Utente</label>
							    <select class="form-control" id="utente" name="utente">
							    	<option value="" selected> -- Selezionare una voce -- </option>
							      	<c:forEach items="${insert_utente_annuncio }" var="utenteItem">
							      		<option value="${utenteItem}" ${insert_annuncio_attr.utente.id == utenteItem.id?'selected':''} >${utenteItem.nome } ${utenteItem.cognome }</option>
							      	</c:forEach>
							    </select>
							</div>
 						</div> 
<%-- 						<input type ="hidden" name="utente" value ="${insert_annuncio_attr.utente.id}"> --%>
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						
					</form:form>
					
					<%-- FUNZIONE JQUERY UI PER AUTOCOMPLETE --%>
					<script>
						$("#registaSearchInput").autocomplete({
							 source: function(request, response) {
							        $.ajax({
							            url: "../regista/searchRegistiAjax",
							            datatype: "json",
							            data: {
							                term: request.term,   
							            },
							            success: function(data) {
							                response($.map(data, function(item) {
							                    return {
								                    label: item.label,
								                    value: item.value
							                    }
							                }))
							            }
							        })
							    },
							//quando seleziono la voce nel campo deve valorizzarsi la descrizione
						    focus: function(event, ui) {
						        $("#registaSearchInput").val(ui.item.label)
						        return false
						    },
						    minLength: 2,
						    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
						    select: function( event, ui ) {
						    	$('#registaId').val(ui.item.value);
						    	//console.log($('#registaId').val())
						        return false;
						    }
						});
					</script>
					<!-- end script autocomplete -->	
					
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>