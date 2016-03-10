var app = angular.module('myApp', ['ngRoute']);
  app.config(function($routeProvider){
    $routeProvider
    .when('/checkUser', {
      templateUrl: 'dashboard.html',
      controller: 'authCtrl'
    })    
    .when('/userlogin', {
      templateUrl: 'user_login.html',
      controller: 'userCtrl'
    })
    .when('/forgotuserpass', {
      templateUrl: 'forgot_userpass.html',
      controller: 'forgotCtrl'
    })
    .when('/dashboard/:username', {
      templateUrl: 'dashboard.html',
      controller: 'dashboardCtrl'
    })    
  });

app.controller('authCtrl', function($scope, $http, $location) {
	
	$scope.submit = function(){
	var userName = $scope.userName;
    var password = $scope.password; 
    $http.get("http://localhost:8080/issue-tracker-pro/rest/auth/"+userName+"/"+password)
  .success(function (data) {
    if(data.authenticated.authenticated == 'true')
    {
      alert('Valid user')
      $location.path('/dashboard');
    }
    else
    {
      alert('Wrong credential');
    }

  })
  .error(function (data){
    alert('in error')
  });
    
    }
    
  });

app.controller('userCtrl', function($scope, $http, $location) {
	$scope.username = "test";
	$scope.password = "test";
	$scope.submit = function(){
	var username = $scope.username;
    var password = $scope.password; 
    $http.get("http://www.abhi.com/Tech/Rest.svc/GetUserDetails/"+username+"/"+password)
  .success(function (data) {
    if(data.GetUserDetailsResult[0].USER_ID != 0)
    {
	var username = data.GetUserDetailsResult[0].USER_NAME;
      alert('Valid user')
      $location.path('/dashboard/' + username);
    }
    else
    {
      alert('Wrong credential');
    }

  })
  .error(function (data){
    alert('in error')
  });
    
    }
  });
  
app.controller('dashboardCtrl', function($scope, $http, $location, $routeParams) {
	alert($routeParams.username)
		$scope.username = $routeParams.username;
  });

app.controller('forgotCtrl', function($scope, $location) {
    $scope.submit = function(){
    var username = $scope.username;
    var tid = $scope.tid;
    var mbnumber = $scope.mbnumber;
    if(username == null || username == "")
    {
      if(tid == 'test' && mbnumber == '123')
      {
        alert('Credential sent on your mobile')
        $location.path('/userlogin');
      }
      else
      {
        alert('Wrong credential');
      }
    }
    else if (username == 'test' && mbnumber == '123') {
      alert('Credential sent on your mobile')
        $location.path('/userlogin');
      }
    else
    {
      alert('Wrong credential');
    }
    }    
  });