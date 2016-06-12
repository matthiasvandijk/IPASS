<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>
<!-- Page Content -->
      <div id="page-content-wrapper" style="min-height: 580px;">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-lg-12">
                      <h1>Content</h1>
                      <p>Bla bla bla <code>#page-content-wrapper</code>.</p>

											<div class="row">
													<div class="col-md-11 padding-right-null">
														<div class="week-title">
															Weekoverzicht
														</div>
													</div>
											</div>

											<div class="row">
													<div class="col-md-9 padding-right-null">
														<div class="week">
															<a href="#" class="btn week-nav-btn btn-main" role="button"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
															<div class="week-text"> Week <span id="weeknummer">5</span></div>
															<a href="#" class="btn week-nav-btn btn-main" role="button"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
														</div>
													<div class="row">
														<div class="col-md-2" id="MA">

															<div class="dag" id="MAdate"></div>
															<div id="MAcontent">
																<div class="informatieblok">
																	<div class="i-tijd"><span class="label background-blue-main">13:00 - 14:00</span></div>
																	<div class="i-locatie">NN1-D01.10</div>
																	<div class="i-student">Matthias van dijk</div>
																</div>

																<div class="informatieblok">
																	<div class="i-tijd">

																		<div class="checkbox informatieblok-checkbox checkbox-primary">
																			<input type="checkbox" id="checkbox1">
																			<label for="checkbox1">
																				13:00 - 14:00
																			</label>
																		</div>

																	</div>
																	<div class="i-locatie">OPEN</div>
																	<div class="i-student"></div>
																</div>
															</div>
														</div>




														<div class="col-md-2" id="DI">

															<div class="dag" id="DIdate"></div>
															<div id="DIcontent">

															</div>
														</div>

														<div class="col-md-2" id="WO">

															<div class="dag" id="WOdate"></div>
															<div id="WOcontent">

															</div>
														</div>

														<div class="col-md-2" id="DO">

															<div class="dag" id="DOdate"></div>
															<div id="DOcontent">

															</div>
														</div>

														<div class="col-md-2" id="VR">

															<div class="dag" id="VRdate"></div>
															<div id="VRcontent">

															</div>
														</div>

														<div class="col-md-2" id="ZA">

															<div class="dag" id="ZAdate">ZA 11-06-2016</div>
															<div id="ZAcontent">

															</div>
														</div>
													</div>
													</div>

													<div class="col-md-2 padding-left-right-null">
														<div class="week-container-right">
															<a href="uren_openstellen/" class="btn btn-main week-title-right-btn btn-default" style="margin-bottom: 8px;" role="button">Uren openstellen</a>
															<a href="#" class="btn btn-main week-title-right-btn btn-default" role="button">Uren sluiten</a>
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
    