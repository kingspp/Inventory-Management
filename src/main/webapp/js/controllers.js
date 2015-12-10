var imAngular = angular.module('imAngular', []);
imAngular.controller('imUserController', function ($scope, $http){

	$http.get('http://localhost:9876/user/getUsers').success(function(data) {
		$scope.users = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeUser = function(user){
		$scope.users.splice($scope.users.indexOf(user),1);
	};

	$scope.modalDetails = function(user){
		$scope.user = user;
		$('#modalDetailsUser').openModal();
	};

});

imAngular.controller('imInvController', function ($scope, $http){

	$http.get('http://localhost:9876/inventory/getInventory').success(function(data) {
		$scope.users = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeUser = function(user){
		$scope.users.splice($scope.users.indexOf(user),1);
	};

	$scope.modalDetails = function(user){
		$scope.user = user;
		$('#modalDetailsInv').openModal();
	};

});

imAngular.controller('imDetailController', function ($scope, $http){

	$http.get('http://api.randomuser.me/?results=1').success(function(data) {
		$scope.users = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeUser = function(user){
		$scope.users.splice($scope.users.indexOf(user),1);
	};

	$scope.modalDetails = function(user){
		$scope.user = user;
		$('#modalDetails').openModal();
	};

});

