<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

      <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Afspraak inplannen</h3>

											<form class="form-horizontal" method="post"
											action="${pageContext.request.contextPath}/slb/UrenOpenstellen.do">

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 10px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Datum:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">(MA)30-05-2016</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Begintijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">13:00</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Eindtijd:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">14:00</label>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Locatie:</label></div>
												<div class="col-md-8">
															<label class="control-label u-label label-mod">NN1-D01.10</label>
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


														<input type="text" class="form-control" name="onderwerp" placeholder="Voorbeeld: Studievoortgang">

												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="#" class="btn btn-default" role="button">Annuleren</a>
														<button class="btn btn-main" type="submit">Afspraak inplannen</button>
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