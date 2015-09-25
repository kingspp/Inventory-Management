<!DOCTYPE html>
<html>
<head>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link type="text/css" rel="stylesheet" href="css/style.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<nav class="grey darken-3" role="navigation">
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
		<div class="container">
			<div class="row center">
				<div class="col s12 m4 l8">
					<p>
						<a class="waves-effect waves-light btn main-menu user "><i
							class="material-icons right">supervisor_account</i>Users</a> <a
							class="waves-effect waves-light btn main-menu inventory"><i
							class="material-icons right">assessment</i>Inventory</a> <a
							class="waves-effect waves-light btn main-menu details"><i
							class="material-icons right">visibility</i>Details</a>
				</div>

				<div class="col s12 m4 l4">
					<form>
						<div class="input-field">
							<input type="search" id="search-field" class="field" required
								maxlength=""> <label for="search-field"><i
								class="mdi-action-search"></i></label> <i
								class="mdi-navigation-close close"></i>
						</div>
					</form>
				</div>


			</div>
			<div class="container">
				<div id="dispAlpha" class="row"></div>
			</div>
			<div class="container">
				<div class="row">
					<div id="inventory_div">
					</div>
				</div>
			</div>
		</div>
	</section>
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
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>