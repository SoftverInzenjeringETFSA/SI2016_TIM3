var app = angular.module('app', [
  'ngRoute'
]).run(function($rootScope, $location, Auth){
    // Odradi provjeru autentikacije odmah
});

app.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
   $routeProvider
    .when('/register', {
        templateUrl : "/views/registration.html",
        controller: 'AuthController',
        resolve: {
            factory: userForbidden
        }
     })
    .when('/administration', {
        templateUrl : "/views/administration.html",
        controller: 'AdminController',
        resolve: {
            factory: adminOnly
        }
    })
    .when('/logout', {
        resolve: {
            factory: logout
        }
    })
    .when('/event/create', {
    	templateUrl : "/views/event/create.html",
    	resolve: {
            factory: userOnly
        }
    })
    .when('/event/list', {
    	templateUrl : "/views/event/list.html",
        resolve: {
            factory: userOnly
        }
    })
    .when('/event/show/:eventID', {
    	templateUrl : "/views/event/show.html",
        controller: 'EventController',
        resolve: {
            factory: userOnly
        }
    })
    .otherwise(
        { templateUrl : "/views/home.html" }
    );
}]);

/* Ove dijelove stranice mogu vidjeti samo korisnic */
var userOnly = function ($q, $rootScope, $location, Auth){
    // Provjeri autentikaciju
    Auth.rootAutentikacija().then(function(response){
        if(response.data != "")
            return true;
        else 
            $location.path("/register");
    });
}

/* Ove dijelove stranice ne mogu vidjeti logirani korisnici */
var userForbidden = function ($q, $rootScope, $location, Auth){
    Auth.rootAutentikacija().then(function(response){
        if(response.data != "")
            $location.path("/");
        else 
            return true;
    });
}

/* Admin only */
var adminOnly = function($q, $rootScope, $location, Auth) {
    Auth.rootAutentikacija().then(function(response){
        if($rootScope.user.role != "admin")
            //$location.path("/");
            console.log("admin nisi");
        else 
            return true;
    });
}

/* Logout sa sistem a */
var logout = function($q, $rootScope, $location, Auth){
    Auth.userLogout();
    $location.path("/");
    window.location.reload();
}