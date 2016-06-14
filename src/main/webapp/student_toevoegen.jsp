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
											action="${pageContext.request.contextPath}/slb/UrenOpenstellen.do">

												<div class="row">
													<div class="col-md-10">
															<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
													</div>
												</div>

												<div class="has-error">
													<div class="row u-margin">
														<div class="col-md-2"><label class="control-label u-label">HU e-mail:</label></div>
														<div class="col-md-8">


																<input type="text" class="form-control" name="student" placeholder="voorbeeld@student.hu.nl">
																<span id="helpBlock" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>


														</div>
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
														<a href="#" class="btn btn-default" role="button">Annuleren</a>
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