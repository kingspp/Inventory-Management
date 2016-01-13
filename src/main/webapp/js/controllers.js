var imAngular = angular.module('imAngular', []);

imAngular.controller('imUserController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http ){

	$http.get('user/getUsers').success(function(data) {
		$scope.users = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeUser = function(user){
		$scope.users.splice($scope.users.indexOf(user),1);
	};

	$scope.modalDetails = function(user){
		$scope.user = user;
		console.log(user);
		$rootScope.$emit('userID', user.userId);
		$('#modalDetailsUser').openModal();
	};

}]);

imAngular.controller('imInvController', function ($scope, $http){

	$http.get('inventory/getInventory').success(function(data) {
		$scope.inventory = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeInventory = function(inventory){
		$scope.inventory.splice($scope.inventory.indexOf(inventory),1);
	};

	$scope.modalDetails = function(inventory){
		$scope.inventory = inventory;
		console.log($scope.inventory);
		$('#modalDetailsInv').openModal();
	};

});

//Get Free Inventory
imAngular.controller('imGetFreeInventory', function ($scope, $http){

	$http.get('/inventory/getFreeInventory').success(function(data) {
		$scope.inventory = data.results;
	}).error(function(data, status) {
		alert('get data error!');
	});

	$scope.removeInventory = function(inventory){
		$scope.inventory.splice($scope.inventory.indexOf(inventory),1);
	};

	$scope.modalDetails = function(inventory){
		$scope.inventory = inventory;
		console.log($scope.inventory);
		$('#modalDetailsInv').openModal();
	};

});


//Get UserInventory
imAngular.controller('imGetInventoryForUser', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http ){
	console.log($scope.userID);
	$http.get('inventory/getInventoryForuser/1').success(function (data) {
		$scope.inventory = data.results;
	}).error(function (data, status) {
		alert('get data error!');
	});

	$scope.removeInventory = function (inventory) {
		$scope.inventory.splice($scope.inventory.indexOf(inventory), 1);
	};

	$rootScope.$on('userID', function (event, data) {
		$http.get('/inventory/getInventoryForuser/'+data).success(function (data) {
			$scope.inventory = data.results;
		}).error(function (data, status) {
			alert('get data error!');
		});
	});

	$scope.modalDetails = function (inventory) {
		$scope.inventory = inventory;
		console.log($scope.inventory);
		$('#modalDetailsInv').openModal();
	};
}]);



imAngular.controller('imDetailController', function ($scope, $http){

	$http.get('/inventory/getTransactions').success(function(data) {
		console.log(data);
		$scope.detail = data;
	}).error(function(data, status) {
		//alert('get data error!');
	});

	$scope.removeDetail = function(detail){
		$scope.detail.splice($scope.detail.indexOf(detail),1);
	};

	$scope.modalDetails = function(detail){
		$scope.detail = detail;
		$('#modalDetails').openModal();
	};

});




