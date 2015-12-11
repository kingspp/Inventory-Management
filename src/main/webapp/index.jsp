<!DOCTYPE html>
<html>
<head>
<title>IManagement</title>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link type="text/css" rel="stylesheet" href="css/style.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet"
	href="fontawesome/css/font-awesome.min.css" />



<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body ng-app="imAngular">
	<nav class=" red darken-4" role="navigation">
		<div class="nav-wrapper container">
			<a href="#" class="brand-logo">IMANAGEMENT</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="sass.html">Home</a></li>
				<li><a href="badges.html">About</a></li>
				<li><a href="collapsible.html">Contact Us</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<div id="index-banner" class="parallax-container">
			<div class="section no-pad-bot">
				<div class="container">
					<br> <br>
					<h1 class="header center text-lighten-2" style="color: #35404F">IManagement</h1>
					<div class="row center">
						<h5 class="header col s12 light">A modern responsive
							Inventory Management Platform</h5>
					</div>

					<br> <br>

				</div>
			</div>
			<div class="parallax" style="opacity: 0.4">
				<img src="img/Invent1.jpg" alt="Unsplashed background img 1"
					style="display: block; transform: translate3d(-50%, 281px, 0px);">
			</div>
		</div>
	</section>

	<section class="section">

		<div class="fixed-action-btn horizontal"
			style="bottom: 45px; right: 24px;">
			<a class="btn-floating btn-large red"> <i
				class="large material-icons">mode_edit</i>
			</a>
			<ul>
				<li><a class="btn-floating modal-trigger purple"
					href="#userModal"><i class="material-icons">supervisor_account</i></a></li>
				<li><a class="btn-floating modal-trigger green"
					href="#invModal"><i class="material-icons">assessment</i></a></li>
				<li><a class="btn-floating modal-trigger indigo"><i
						class="material-icons">visibility</i></a></li>
			</ul>
		</div>




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
				<div id="test1" class="col s12">
					<div class="container" ng-controller="imUserController">
						<div class="row">
							<div class="s12 col">
								<br>
								<form class="forms forms-inline input-field ">
									<div>
										<input type="text" class="input-big width-50" id="query"
											ng-model="query"> <label for="query">Search
											Users</label>
									</div>
								</form>
								<ul class="collection">
									<li class="collection-item avatar animated fadeInUp"
										style="-webkit-animation-duration: {{$index* 300"
										ng-repeat="u in users | filter:query | orderBy:'user.userName'">
										<a href="" ng-click="modalDetails(u.user)"
										class="modal-trigger title"><img
											ng-src="{{u.user.picture.thumbnail}}" alt="" class="circle">
											{{u.user.userName}}</a>
										<p>{{u.user.emailId}}, {{u.user.phoneNumber}}</p> <a href="#!"
										class="secondary-content" ng-click="removeUser(u)"><i
											class="small mdi-action-highlight-remove"></i></a>
									</li>
								</ul>
							</div>
						</div>
						<div id="modalDetailsUser" class="modal bottom-sheet">
							<div class="modal-content">
								<div class="row">
									<div class="l2 col">
										<img ng-src="{{user.picture.medium}}" alt=""
											class="align-right circle">
									</div>
									<div class="l10 col">
										<h2>{{user.userName}}</h2>
										<label>Email</label> {{user.emailId}} <br /> <label>Phone</label>
										{{user.phoneNumber}} <br /> <label>Project</label>
										{{user.project}} <br />
										<hr>
										<label>Blood Group</label> {{user.bloodGroup}} <br /> <label>Date
											of Joining</label> {{user.dob}} <br />
										<hr>
										<a class="waves-effect waves-light btn-small modal-trigger"
											href="#addInventoryModal"><i class="material-icons">add</i>Add
											Inventory</a>&nbsp&nbsp <a
											class="waves-effect waves-light btn-small modal-trigger"
											href="#returnInventoryModal"><i class="material-icons">add</i>Return
											Inventory</a>&nbsp&nbsp
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="test2" class="col s12">
					<div class="container" ng-controller="imInvController">
						<div class="row">
							<div class="s12 col">
								<br>
								<form class="forms forms-inline input-field ">
									<div>
										<input type="text" class="input-big width-50" id="query"
											ng-model="query"> <label for="query">Search
											Inventory</label>
									</div>
								</form>
								<ul class="collection">
									<li class="collection-item avatar animated fadeInUp"
										style="-webkit-animation-duration: {{$index* 300"
										ng-repeat="u in users | filter:query | orderBy:'user.username'">
										<a href="" ng-click="modalDetails(u.user)"
										class="modal-trigger title"><img
											ng-src="{{u.user.picture.thumbnail}}" alt="" class="circle">
											{{u.user.username}}</a>
										<p>{{u.user.location.city}}, {{u.user.location.state}}</p> <a
										href="#!" class="secondary-content" ng-click="removeUser(u)"><i
											class="small mdi-action-highlight-remove"></i></a>
									</li>
								</ul>
							</div>
						</div>
						<div id="modalDetailsInv" class="modal bottom-sheet">
							<div class="modal-content">
								<div class="row">
									<div class="l2 col">
										<img ng-src="{{user.picture.medium}}" alt=""
											class="align-right circle">
									</div>
									<div class="l10 col">
										<h2>{{user.username}}</h2>
										<label>Type</label> {{user.email}} <br /> <label>Price</label>
										{{user.phone}} <br />
										<hr>
										<label>Serial Number</label> <br /> <label>Date of
											Purchase</label> {{user.dob}} <br />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="test3" class="col s12">
					<div class="container" ng-controller="imDetailController">
						<div class="row">
							<div class="s12 col">
								<br>
								<form class="forms forms-inline input-field ">
									<div>
										<input type="text" class="input-big width-50" id="query"
											ng-model="query"> <label for="query">Search
											Details</label>
									</div>
								</form>
								<ul class="collection">
									<li class="collection-item avatar animated fadeInUp"
										style="-webkit-animation-duration: {{$index* 300"
										ng-repeat="u in users | filter:query | orderBy:'user.username'">
										<a href="" ng-click="modalDetails(u.user)"
										class="modal-trigger title"><img
											ng-src="{{u.user.picture.thumbnail}}" alt="" class="circle">
											{{u.user.username}}</a>
										<p>{{u.user.location.city}}, {{u.user.location.state}}</p> <a
										href="#!" class="secondary-content" ng-click="removeUser(u)"><i
											class="small mdi-action-highlight-remove"></i></a>
									</li>
								</ul>
							</div>
						</div>
						<div id="modalDetails" class="modal bottom-sheet">
							<div class="modal-content">
								<div class="row">
									<div class="l2 col">
										<img ng-src="{{user.picture.medium}}" alt=""
											class="align-right circle">
									</div>
									<div class="l10 col">
										<h2>{{user.username}}</h2>
										<label>Email</label> {{user.email}} <br /> <label>Password</label>
										{{user.password}}
										<hr>
										<label>Phone</label> {{user.phone}} <br /> <label>Location</label>
										{{user.location.city}}, {{user.location.state}} <br />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="container">
				<div class="row center">
					<!-- MILESTONE -->
					<div id="milestone" class="milestone">
						<div class="col s3 offset-s4">
							<div class="fact">
								<p class="timer center-align bold" data-to="114"
									data-speed="10000"></p>
								<i class="fa fa-4x fa-users center-align"></i>
								<p>Users</p>

							</div>
						</div>
						<div class="col s3 offset-s2 ">
							<div class="fact">
								<p class="timer center-align bold" data-to="252"
									data-speed="10000"></p>
								<i class="fa fa-4x fa-shopping-cart "></i>
								<p>Inventory</p>
							</div>

						</div>
						<!--	<div class="col s3" style="padding-top:50px">
							<a class="waves-effect waves-light btn  main-menu user" style="display:block"><i
							class="material-icons right">supervisor_account</i>Users</a> <a
							class="waves-effect waves-light btn  main-menu inventory" style="display:block"><i
							class="material-icons right">assessment</i>Inventory</a> <a
							class="waves-effect waves-light btn  main-menu details" style="display:block"><i
							class="material-icons right">visibility</i>Details</a>
							
						</div> 	-->

					</div>


				</div>
			</div>





			<!--<form>
				<div class="input-field">
				<input type="search" id="search-field" class="field" required
				maxlength=""> <label for="search-field"><i
				class="mdi-action-search"></i></label> <i
				class="mdi-navigation-close close"></i>
				</div>
			</form> -->







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
	<!-- User Modal>-->
	<div id="userModal" class="modal bottom-sheet">
		<div class="modal-content">
			<h4>
				<i class="fa fa-user-plus" style="font-size: 24px;"></i> User
			</h4>
			<div class="container">
				<div class="row">
					<form id="userForm" action="/user/insertUser" title=""
						method="post" enctype="multipart/form-data">
						<div class="col s2">
							<div class="row">
								<div class="file-field input-field col s1">
									<div class="image-upload form-field">
										<label for="file-input"> <img id="image"
											src="img/sample-user.png" />
										</label> <input id="file-input" type="file" />
									</div>
								</div>
							</div>
						</div>

						<div class="col s9">
							<div class="row">
								<div class="input-field col s5">
									<div class="form-field">
										<i class="material-icons prefix">account_circle</i> <label
											class="title">First Name</label> <input type="text"
											id="firstName" class="validate" required>
									</div>
								</div>

								<div class="input-field col s4">
									<div class="form-field">
										<input id="lastName" type="text" class="validate" required>
										<label for="lastName">Last Name</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s9">
									<i class="material-icons prefix">email</i> <input id="email"
										type="email" class="validate" required> <label
										for="email">Email</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s9">
									<i class="material-icons prefix">phone</i> <input id="ph"
										type="number" class="validate" required> <label
										for="ph">Ph Number</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s5">
									<i class="material-icons prefix">perm_contact_calendar</i> <input
										type="date" class="datepicker" required> <label
										for="birthdate" class="">Birthdate</label>
								</div>

								<div class="input-field col s4">
									<i class="material-icons prefix">invert_colors</i> <input
										id="bloodGroup" type="text" pattern="[a-zA-Z][+-]"
										class="validate" required> <label for="bloodGroup">Blood
										group</label>
								</div>

							</div>
							<div class="row">
								<div class="input-field col s9">
									<i class="material-icons prefix">code</i> <input id="project"
										type="text" class="validate" required> <label
										for="project">Project</label>
								</div>
							</div>
							<div class="row">
								<div class="col s1">
									<i class="material-icons prefix" style="padding-right: 20px;">person_pin</i>
								</div>
								<div class="col s3">
									<div class="input-field">

										<select class="icons">
											<option value="" disabled selected>Choose your
												option</option>
											<option value="male" data-icon="img/male.png"
												class="left circle">Male</option>
											<option value="female" data-icon="img/female.jpg"
												class="left">Female</option>
										</select><label>Gender</label>
									</div>
								</div>

							</div>
						</div>
						<div id="userSubmit" class="modal-footer">
							<button type="submit"
								class="modal-action  waves-effect waves-green btn-flat">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



	<!--Inventory Modal-->
	<div id="invModal" class="modal bottom-sheet">
		<div class="modal-content">
			<h4>
				<i class="material-icons">queue</i></i> Inventory
			</h4>
			<div class="container">
				<div class="row">
					<form class="col s12">
						<div class="col s2">
							<div class="row">
								<div class="file-field input-field col s1">
									<div class="image-upload">
										<label for="file-input"> <img id="image"
											src="img/sample-user.png" />
										</label> <input id="file-input" type="file" />
									</div>
								</div>
							</div>
						</div>

						<div class="col s9">
							<div class="row">
								<div class="input-field col s5">
									<i class="material-icons prefix">shopping_basket</i> <input
										id="inventory_name" type="text" class="validate"> <label
										for="inventory_name">First Name</label>
								</div>
								<div class="input-field col s4">
									<input id="type" type="text" class="validate"> <label
										for="type">Type</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s9">
									<i class="material-icons prefix">info_outline</i> <input
										id="snumber" type="text" class="validate"> <label
										for="snumber">Serial Number</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s9">
									<i class="material-icons prefix">perm_contact_calendar</i> <input
										type="date" class="datepicker"> <label for="DOP"
										class="">Date of Purchase</label>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Submit</a>
		</div>
	</div>


	<!--  Map user to inventory modal -->
	<div id="addInventoryModal" class="modal">
		<div class="modal-content">
			<h4>Add Inventory</h4>
			<p>A bunch of text</p>
		</div>
		<div id="test2" class="col s12">
			<div class="container" ng-controller="imInvController">
				<div class="row">
					<div class="s12 col">
						<br>
						<form class="forms forms-inline input-field ">
							<div>
								<input type="text" class="input-big width-50" id="query"
									ng-model="query"> <label for="query">Search
									Inventory</label>
							</div>
						</form>
						<ul class="collection">
							<li class="collection-item avatar animated fadeInUp"
								style="-webkit-animation-duration: {{$index* 300"
								ng-repeat="u in users | filter:query | orderBy:'user.username'">
								<a href="" ng-click="modalDetails(u.user)"
								class="modal-trigger title"><img
									ng-src="{{u.user.picture.thumbnail}}" alt="" class="circle">
									{{u.user.username}}</a>
								<p>{{u.user.location.city}}, {{u.user.location.state}}</p> <a
								href="#!" class="secondary-content" ng-click="removeUser(u)"><i
									class="small mdi-action-highlight-remove"></i></a>
							</li>
						</ul>
					</div>
				</div>
				<div id="modalDetailsInv" class="modal bottom-sheet">
					<div class="modal-content">
						<div class="row">
							<div class="l2 col">
								<img ng-src="{{user.picture.medium}}" alt=""
									class="align-right circle">
							</div>
							<div class="l10 col">
								<h2>{{user.username}}</h2>
								<label>Type</label> {{user.email}} <br /> <label>Price</label>
								{{user.phone}} <br />
								<hr>
								<label>Serial Number</label> <br /> <label>Date of
									Purchase</label> {{user.dob}} <br />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>


	<div id="returnInventoryModal" class="modal">
		<div class="modal-content">
			<h4>Return Inventory</h4>
			<p>A bunch of text</p>
		</div>
		<div id="test2" class="col s12">
			<div class="container" ng-controller="imInvController">
				<div class="row">
					<div class="s12 col">
						<br>
						<form class="forms forms-inline input-field ">
							<div>
								<input type="text" class="input-big width-50" id="query"
									ng-model="query"> <label for="query">Search
									Inventory</label>
							</div>
						</form>
						<ul class="collection">
							<li class="collection-item avatar animated fadeInUp"
								style="-webkit-animation-duration: {{$index* 300"
								ng-repeat="u in users | filter:query | orderBy:'user.username'">
								<a href="" ng-click="modalDetails(u.user)"
								class="modal-trigger title"><img
									ng-src="{{u.user.picture.thumbnail}}" alt="" class="circle">
									{{u.user.username}}</a>
								<p>{{u.user.location.city}}, {{u.user.location.state}}</p> <a
								href="#!" class="secondary-content" ng-click="removeUser(u)"><i
									class="small mdi-action-highlight-remove"></i></a>
							</li>
						</ul>
					</div>
				</div>
				<div id="modalDetailsInv" class="modal bottom-sheet">
					<div class="modal-content">
						<div class="row">
							<div class="l2 col">
								<img ng-src="{{user.picture.medium}}" alt=""
									class="align-right circle">
							</div>
							<div class="l10 col">
								<h2>{{user.username}}</h2>
								<label>Type</label> {{user.email}} <br /> <label>Price</label>
								{{user.phone}} <br />
								<hr>
								<label>Serial Number</label> <br /> <label>Date of
									Purchase</label> {{user.dob}} <br />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>






	<footer class="page-footer grey darken-3">
		<!-- <div class="container">
		<div class="row">
		<div class="col l6 s12">
		<h5 class="white-text">Footmagentaer Content</h5>
		<p class="grey-text text-lighten-4">You can use rows and
		columns here to organize your footer content.</p>
		</div>
		<div class="col l4 offset-l2 s12">
		<h5 class="white-text">Links</h5>
		<ul>
		<li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
		<li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
		<li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
		<li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
		</ul>
		</div>
		</div>
	</div>  -->


		<div class="footer-copyright">
			<div class="container center">
				© 2014 Copyright @Razorthink <a
					class="grey-text text-lighten-4 right version" href="#!"></a>
			</div>
		</div>
	</footer>
	<!--Import jQuery before materialize.js-->


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-countTo.js"></script>
	<script type="text/javascript" src="js/angular.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/controllers.js"></script>
	<script type="text/javascript" src="js/forms.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>


</body>
</html>