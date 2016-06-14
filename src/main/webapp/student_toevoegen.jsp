<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

<!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Student toevoegen</h3>

							<form class="form-horizontal" method="post"
							action="${pageContext.request.contextPath}/slb/StudentToevoegenServlet.do">

								<div class="row">
									<div class="col-md-10">
											<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
									</div>
								</div>


								<c:if test="${not empty requestScope.studentToegevoegd}">
								<div class="has-success">
								</c:if>
								<c:if test="${not empty requestScope.errorStudentEmail}">
								<div class="has-error">
								</c:if>
									<div class="row u-margin">
										<div class="col-md-2"><label class="control-label u-label">HU e-mail:</label></div>
										<div class="col-md-8">


												<input type="text" class="form-control" name="studentEmail" placeholder="voorbeeld@student.hu.nl">
												<c:if test="${not empty requestScope.studentToegevoegd}">
													<span id="helpBlock" class="help-block">${requestScope.studentToegevoegd}</span>
												</c:if>
												<c:if test="${not empty requestScope.errorStudentEmail}">
													<span id="helpBlock" class="help-block">${requestScope.errorStudentEmail}</span>
												</c:if>


										</div>
									</div>
								<c:if test="${not empty requestScope.studentToegevoegd}">
									</div>
								</c:if>
								<c:if test="${not empty requestScope.errorStudentEmail}">
									</div>
								</c:if>

								<div class="row">
									<div class="col-md-10">
											<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
									</div>
								</div>

							<div class="row">
								<div class="col-md-10">
									<div class="pull-right">
										<a href="${pageContext.request.contextPath}/slb/" class="btn btn-default" role="button">Annuleren</a>
										<button class="btn btn-main" type="submit">Toevoegen</button>
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