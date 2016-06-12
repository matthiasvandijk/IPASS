<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>

      <!-- Page Content -->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-sm-12 col-md-6">
                      <h3 class="u-title">Uren openstellen</h3>


											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Datum:</label></div>
												<div class="col-md-8">

													<div id="datum">
														<div class="input-group date">
															<input type="text" class="form-control" placeholder="dd/mm/yyyy"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
														</div>
													</div>
												</div>
											</div>



											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Begintijd:</label></div>
												<div class="col-md-8">

													<div class="input-group clockpicker">
														<input type="text" id="begintijd" class="form-control" placeholder="hh:mm">
														<span class="input-group-addon">
															<span class="glyphicon glyphicon-time"></span>
														</span>
													</div>
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Eindtijd:</label></div>
												<div class="col-md-8">

													<div class="input-group clockpicker">
														<input type="text" id="eindtijd" class="form-control" placeholder="hh:mm">
														<span class="input-group-addon">
															<span class="glyphicon glyphicon-time"></span>
														</span>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 10px;">
												</div>
											</div>

											<div class="checkbox informatieblok-checkbox checkbox-primary">
												<input type="checkbox" id="checkbox_split">
												<label for="checkbox_split">
													Split functie
												</label>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Split:</label></div>
												<div class="col-md-8">
													<div class="input-group">
														<input type="text" class="form-control" placeholder="60"><span class="input-group-addon">Min</span>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
														<hr class="divider" style="margin-top: 5px;margin-bottom: 15px;">
												</div>
											</div>

											<div class="row u-margin">
												<div class="col-md-2"><label class="control-label u-label">Locatie:</label></div>
												<div class="col-md-8">


														<input type="text" class="form-control" placeholder="NN1-">

												</div>
											</div>

											<div class="row">
												<div class="col-md-10">
													<div class="pull-right">
														<a href="${pageContext.request.contextPath}/slb/" class="btn btn-default" role="button">Annuleren</a>
														<a href="#" class="btn btn-main" role="button">Openstellen</a>
													</div>
												</div>
											</div>



                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

    </div><!-- /#wrapper -->
    
<%@ include file="footer.jsp" %>    
    