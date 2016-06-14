<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

      <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Afspraak inplannen</h3>
                      
								<c:if test="${empty requestScope.error}">
											<form class="form-horizontal" method="post"
											action="${pageContext.request.contextPath}/student/StudentAfspraakInplannenServlet.do">
								
											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 10px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Datum:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${requestScope.datum}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Begintijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${requestScope.begintijd}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Eindtijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${requestScope.eindtijd}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Locatie:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${requestScope.locatie}</label>
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Onderwerp:</label></div>
												<div class="col-md-8">

														<input type="hidden" name="afspraakId" value="${requestScope.afspraakId}">
														<input type="text" class="form-control" name="onderwerp" placeholder="Voorbeeld: Studievoortgang">
									</c:if>					
														<c:if test="${not empty requestScope.error}">
														<div class="u-margin">
																<div class="has-error">
																	<span class="help-block">${requestScope.error}</span>
																</div>
															
														</div>	
														</c:if>		
									<c:if test="${empty requestScope.error}">								
												</div>
											</div>
									</c:if>
											<div class="row">
												<div class="col-md-10">
												<c:if test="${empty requestScope.error}"><div class="pull-right"></c:if>
														<a href="${pageContext.request.contextPath}/student/" class="btn btn-default" role="button">Annuleren</a>
														<c:if test="${empty requestScope.error}"><button class="btn btn-main" type="submit">Afspraak inplannen</button></c:if>
												<c:if test="${empty requestScope.error}"></div></c:if>
												</div>
											</div>
									<c:if test="${empty requestScope.error}">
											</form>
									</c:if>		

                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

    </div><!-- /#wrapper -->


<%@ include file="footer.jsp" %>  