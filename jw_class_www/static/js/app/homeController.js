var homeApp = angular.module('homeApp', []);
homeApp.controller('homeController', function($scope,$http) {
	$http({
	method:'GET',
	url:$tools.ctx+'/role/getRoles'				
	}).success(function(data){
		$scope.roles=data;
		$scope.selectedRole = $scope.roles[0];
		console.log($scope.selectedRole);
	});
	
});
