<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

      <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Uren openstellen</h3>

							<form class="form-horizontal" method="post"
									action="${pageContext.request.contextPath}/slb/UrenOpenstellen.do">
											<c:if test="${not empty requestScope.errorDatum}">
												<div class="has-error">
											</c:if>
											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Datum:</label></div>
												<div class="col-md-8">

													<div id="datum">
														<div class="input-group date">
															<input type="text" class="form-control" name="datum" placeholder="dd/mm/yyyy" value="${fn:escapeXml(requestScope.datum)}"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
														</div>
													</div>
													<c:if test="${not empty requestScope.errorDatum}">
														<span class="help-block">${requestScope.errorDatum}</span>
													</c:if>
												</div>
											</div>
											<c:if test="${not empty requestScope.errorDatum}">
												</div>
											</c:if>

											<c:if test="${not empty requestScope.errorBegintijd}">
												<div class="has-error">
											</c:if>
											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Begintijd:</label></div>
												<div class="col-md-8">

													<div class="input-group clockpicker">
														<input type="text" name="begintijd" id="begintijd" class="form-control" placeholder="hh:mm" value="${fn:escapeXml(requestScope.begintijd)}">
														<span class="input-group-addon">
															<span class="glyphicon glyphicon-time"></span>
														</span>
													</div>
													<c:if test="${not empty requestScope.errorBegintijd}">
														<span class="help-block">${requestScope.errorBegintijd}</span>
													</c:if>
												</div>
											</div>
											<c:if test="${not empty requestScope.errorBegintijd}">
												</div>
											</c:if>

											<c:if test="${not empty requestScope.errorEindtijd}">
												<div class="has-error">
											</c:if>
											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Eindtijd:</label></div>
												<div class="col-md-8">

													<div class="input-group clockpicker">
														<input type="text" name="eindtijd" id="eindtijd" class="form-control" placeholder="hh:mm" value="${fn:escapeXml(requestScope.eindtijd)}">
														<span class="input-group-addon">
															<span class="glyphicon glyphicon-time"></span>
														</span>
													</div>
													<c:if test="${not empty requestScope.errorEindtijd}">
														<span class="help-block">${requestScope.errorEindtijd}</span>
													</c:if>
												</div>
											</div>
											<c:if test="${not empty requestScope.errorEindtijd}">
												</div>
											</c:if>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 5px;">
												</div>
											</div>

											<div class="checkbox informatieblok-checkbox checkbox-primary">
												<input name="checkbox_split" type="checkbox" id="checkbox_split" ${fn:escapeXml(requestScope.checkbox_split)}>
												<label for="checkbox_split">
													Split functie
												</label>
											</div>

											<c:if test="${not empty requestScope.errorSplit}">
												<div class="has-error">
											</c:if>
											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Split:</label></div>
												<div class="col-md-8">
													<div class="input-group">
														<input type="text" name="split" class="form-control" placeholder="60" value="${fn:escapeXml(requestScope.split)}"><span class="input-group-addon">Min</span>
													</div>
													<c:if test="${not empty requestScope.errorSplit}">
														<span class="help-block">${requestScope.errorSplit}</span>
													</c:if>
												</div>
											</div>
											<c:if test="${not empty requestScope.errorSplit}">
												</div>
											</c:if>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
												</div>
											</div>
											
											<c:if test="${not empty requestScope.errorLocatie}">
												<div class="has-error">
											</c:if>
											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Locatie:</label></div>
												<div class="col-md-8">


														<input name="locatie" type="text" class="form-control" placeholder="NN1-" value="${fn:escapeXml(requestScope.locatie)}">
														<c:if test="${not empty requestScope.errorLocatie}">
															<span class="help-block">${requestScope.errorLocatie}</span>
														</c:if>
												</div>
											</div>
											<c:if test="${not empty requestScope.errorLocatie}">
												</div>
											</c:if>
											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="${pageContext.request.contextPath}/slb/" class="btn btn-default" role="button">Annuleren</a>
														<button href="#" class="btn btn-main" type="submit">Openstellen</button>
													</div>
												</div>
											</div>

									</form>

                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

    </div><!-- /#wrapper -->
    
<%@ include file="footer.jsp" %>    
    