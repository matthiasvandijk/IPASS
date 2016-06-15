<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

  <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Uren sluiten</h3>
											<div class="row">
												<div class="col-md-10">
														<p>U heeft de volgende uren geselecteerd en staat op het punt om deze definitief te sluiten.<br>
														Deze actie kan <b>NIET</b> ongedaan gemaakt worden.</p>
												</div>
											</div>
											<form class="form-horizontal" method="post"
											action="${pageContext.request.contextPath}/slb/SlbUrenSluitenServlet.do">

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 10px;">
												</div>
											</div>


											<div class="row">
												<div class="col-md-10">
													<c:forEach items="${afspraken}" var="item">
														<ul>
															<li><c:out value="${item}"/></li>
														</ul>
													</c:forEach>
													
													<input type="hidden" name="uren" value="${fn:escapeXml(requestScope.uren)}">
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="${pageContext.request.contextPath}/slb/" class="btn btn-default" role="button">Annuleren</a>
														<button class="btn btn-bg-danger" type="submit">Uren sluiten</button>
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