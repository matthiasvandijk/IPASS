<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

    <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Afspraak informatie</h3>

											<form class="form-horizontal">

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 10px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Datum:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.datum)}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Begintijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.begintijd)}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Eindtijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.eindtijd)}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Locatie:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.locatie)}</label>
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Student:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.studentnaam)}</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Onderwerp:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">${fn:escapeXml(requestScope.onderwerp)}</label>
												</div>
											</div>

											</form>

											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="${pageContext.request.contextPath}/slb/" class="btn btn-main" role="button">Terug</a>
													</div>
												</div>
											</div>



                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

<%@ include file="footer.jsp" %>  