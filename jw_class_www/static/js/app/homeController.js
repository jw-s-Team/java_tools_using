var addUserApp = angular.module('addUserApp', []);
addUserApp.controller('addUserController', function($scope,$http) {
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
			$scope.classes=data;
			$scope.selectedClass=$scope.classes[0];
			console.log($scope.selectedClass);
		});
	}
	
	$scope.getClassList(1);

	
});

var editUserApp=angular.module('editUserApp',[]);
editUserApp.controller('editUserController',function($scope,$http){
	$scope.test="123";
	$scope.editRow="";
	$scope.editOne=function(row){
		$scope.editRow=row;
		console.log($scope.editRow);
		
	}
});
