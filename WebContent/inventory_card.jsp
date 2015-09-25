<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="inventory_card">
		<div class="row">
			<div class="col s12 m7">
				<div class="card small">
					<div class="card-image">
						<img src="images/sample-1.jpg"> <span class="card-title">"+jsonObjectList.name+"</span>
					</div>
					<div class="card-content">
						<p>I am a very simple card. I am good at containing small bits
							of information. I am convenient because I require little markup
							to use effectively.</p>
					</div>
					<div class="card-action">
						<a href="#">\"+jsonObjectList.name+\"</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>