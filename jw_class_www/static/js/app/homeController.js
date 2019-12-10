var homeApp = angular.module('homeApp', []);
homeApp.controller('homeController', function($scope,$http) {
	$http({
	method:'GET',
	url:$tools.ctx+'/role/getRoles'				
	}).success(function(data){
		console.log(data);
		$scope.roles=data;
		$scope.selectedRole = $scope.roles[0];
	});
	
	
	$http({
		method:'GET',
		url:$tools.ctx+'/grade/getGradeList'				
		}).success(function(data){
			console.log(data);
			$scope.grades=data;
			$scope.selectedGrade = $scope.grades[0];
		});
	
	$scope.classes=[];
	$scope.selectedClass={};
	$scope.getClassList=function (x){
		console.log(x);
		$http({
			method:'POST',
			url:$tools.ctx+'/class/getUserClass?gradeId='+x
		}).success(function(data){
			console.log(data);
			$scope.classes=data;
			$scope.selectedClass=$scope.classes[0];
			console.log($scope.selectedClass);
		});
	}
});
