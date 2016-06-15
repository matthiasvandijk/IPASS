<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="header.jsp" %>
<!-- Page Content -->
      <div id="page-content-wrapper" style="min-height: 580px;">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-lg-12">
                  
                  <c:if test="${not empty requestScope.errorUrenSluiten}">
                  	<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>Oops!</strong> ${requestScope.errorUrenSluiten}
					</div>
                  </c:if>
                  <c:if test="${not empty requestScope.success}">
                  	<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>Goed bezig!</strong> ${requestScope.success}
					</div>
                  </c:if>
                  
                      <h2 class="margin-title">Dashboard</h2>

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
															<button class="btn week-nav-btn btn-main" id="terug"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></button>
															<div class="week-text"> Week <span id="weeknummer">5</span></div>
															<button class="btn week-nav-btn btn-main" id="verder"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>
														</div>
													<div class="row">
														<div class="col-md-2" id="MA">

															<div class="dag" id="MAdate"></div>
															<div id="MAcontent">
					
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

															<div class="dag" id="ZAdate"></div>
															<div id="ZAcontent">

															</div>
														</div>
													</div>
													</div>

													<div class="col-md-2 padding-left-right-null">
														<div class="week-container-right">
															<a href="uren_openstellen/" class="btn btn-main week-title-right-btn btn-default" style="margin-bottom: 8px;" role="button">Uren openstellen</a>
															<a href="#" id="uren_sluiten_btn" class="btn btn-main week-title-right-btn btn-default" role="button">Uren sluiten</a>
														</div>
													</div>
											</div>
                  </div>
              </div>
          </div>
      </div>
      <!-- /#page-content-wrapper -->

    </div><!-- /#wrapper -->

<script src="${pageContext.request.contextPath}/js/slb.js"></script>
    
<%@ include file="footer.jsp" %>    
    