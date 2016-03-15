var app = angular.module('myApp', ['ngRoute']);
  app.config(function($routeProvider){
    $routeProvider
    .when('/', {
      templateUrl: 'login.html',
      controller: 'loginCtrl'
    })
    .when('/dashboard/:username', {
      templateUrl: 'dashboard.html',
      controller: 'dashboardCtrl'
    })    
    .when('/viewtickets/:username', {
      templateUrl: 'viewtickets.html',
      controller: 'viewTicketCtrl'
    })
    .when('/addticket/:username', {
      templateUrl: 'addticket.html',
      controller: 'addTicketCtrl'
    })    
  });

app.controller('loginCtrl', function($scope, $http, $location) {
$scope.userName = "testuser";
$scope.password = "testpass";
    $scope.submit = function(){
      /*localStorage.clear();
      return false;*/
  var username = $scope.userName;
    var password = $scope.password; 
    $http.get("http://MSPL-08-09-D158:8080/issue-tracker-pro/rest/auth/"+username+"/"+password)
  .success(function (data) {
    if(data.authenticated == true)
    {
      $location.path('/dashboard/'+ data.userName);
      localStorage.setItem('userToken',data.userToken)
    }
    else
    {
      alert('Wrong credential');
    }

  })
  .error(function (data){
    alert('error data : ' + data)
  });
    
    }
    
  });

app.controller('dashboardCtrl', function($scope, $http, $location, $routeParams) {
  /*alert('dashboardCtrl');
  alert($routeParams.username);*/

  $scope.username = $routeParams.username;
    // $scope.username = $routeParams.username;
  });

app.controller('viewTicketCtrl', function($scope, $http, $location, $routeParams) {
  var username = $routeParams.username;
  var inputParam = "userToken="+localStorage.getItem('userToken');
  var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
  $http.post('http://MSPL-08-09-D158:8080/issue-tracker-pro/rest/getTicketDetails/',inputParam,config)
  .success(function (data) {
    /*alert(JSON.stringify(data))*/
    $scope.listOfTicket = data;
    
  })
  .error(function (data){
    alert('in error')
  });
  });
  


app.controller('addTicketCtrl', function($scope, $http, $location, $routeParams) {
if(localStorage.getItem('defectid') == null || localStorage.getItem('defectid') == '') {
  $scope.defectid = 104;
}
else {
  $scope.defectid = localStorage.getItem('defectid');
}
var id = $scope.defectid;
    $scope.addDiffect = function() {
    var username = $routeParams.username;
    
    var summ =  $scope.summ;
    var desc = $scope.desc;
    var assign = $scope.select;

    

  var inputParam = "userToken="+localStorage.getItem('userToken') + "&id="+id + "&summ=" + summ + "&desc=" + desc +"&assign=" + assign;
  /*alert('inputParam : ' + inputParam)*/
  console.log(inputParam)
  var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
  $http.post('http://MSPL-08-09-D158:8080/issue-tracker-pro/rest/newTicketDetail/',inputParam,config)
  .success(function (data) {
    /*alert(JSON.stringify(data))*/
    $scope.defectid = parseInt($scope.defectid) + 1;
    localStorage.setItem('defectid', $scope.defectid);
    alert('Defect Added')
    

    /*if(data.GetUserDetailsResult[0].USER_ID != 0)
    {
  var username = data.GetUserDetailsResult[0].USER_NAME;
      alert('Valid user')
      $location.path('/dashboard/' + username);
    }
    else
    {
      alert('Wrong credential');
    }
*/
  })
  .error(function (data){
    alert('in error')
  });
}
  });
