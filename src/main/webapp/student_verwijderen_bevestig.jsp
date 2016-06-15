<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

      <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Weet u dit zeker?</h3>
											<div class="row">
												<div class="col-md-10">
														<p>U kunt de autorisatie van een student, die aan uw account is gekoppeld, opheffen door hem of haar te "Verwijderen".
															Hierdoor zorgt u dat de betreffende student geen toegang meer heeft tot uw Rooster (Weekoverzicht) en dus ook geen afspraken meer bij u kan inplannen.</p>
												</div>
											</div>
											<form class="form-horizontal" method="post"
											action="${pageContext.request.contextPath}/slb/StudentVerwijderenServlet.do">

												<div class="row">
													<div class="col-md-10">
															<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
													</div>
												</div>

												<div class="row">
														<div class="col-md-10">
															<dl class="dl-horizontal" style="margin-bottom: 13px !important;">
																<dt>Naam:</dt>
																<dd>${fn:escapeXml(requestScope.studentNaam)}</dd>
																<dt>E-mail:</dt>
																<dd>${fn:escapeXml(requestScope.studentEmail)}</dd>
															</dl>
														</div>
														<input type="hidden" name="type" value="bevestig">
														<input type="hidden" name="studentEmail" value="${fn:escapeXml(requestScope.studentEmail)}">
												</div>

												<div class="row">
													<div class="col-md-10">
															<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
													</div>
												</div>

											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="${pageContext.request.contextPath}/slb/student_verwijderen/" class="btn btn-default" role="button">Annuleren</a>
														<button class="btn btn-bg-danger" type="submit">Ja, verwijderen!</button>
													</div>
												</div>
											</div>

											</form>


                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

<%@ include file="footer.jsp" %>  