<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>IManagement</title>
<%@include file="html/cssDefinitions.html"%>
<%@include file="html/jsDefinitions.html"%>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body ng-app="imAngular">

	<%@include file="html/header.html"%>
	<%@include file="html/banner.html"%>

	<section class="section">
		<%@include file="html/floatingButtons.html"%>
		<div class="container">
			<div class="row tab">
				<div class="col s12">
					<ul class="tabs">
						<li class="tab col s3"><a href="#test1"><i
								class="material-icons right"
								style="padding-top: 15px; margin-right: 15px">supervisor_account</i>Users</a></li>
						<li class="tab col s3"><a class="active" href="#test2"><i
								class="material-icons right"
								style="padding-top: 15px; margin-right: 15px">assessment</i>Inventory</a></li>
						<li class="tab col s3"><a href="#test3"><i
								class="material-icons right"
								style="padding-top: 15px; margin-right: 15px">visibility</i>Details</a></li>
					</ul>
				</div>

				<%@include file="html/imUserController.html"%>
				<%@include file="html/imInventoryController.html"%>
				<%@include file="html/imDetailController.html"%>
			</div>
			<%@include file="html/userInventoryAnimation.html"%>
			
			<div class="container">
				<div id="dispAlpha" class="row"></div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<div id="inventory_div"></div>
			</div>
		</div>	
	</section>
	
	<!-- modals -->
	<!-- Modal Structure -->
	<%@include file="html/userModal.html" %>
	<%@include file="html/inventoryModal.html" %>
	
	<%@include file="html/footer.html" %>
</body>
</html>