var app=angular.module('app', [
    'ngRoute'/*,
    'ngResource',
    'ngMessages',
    'ngAria'*/
]);

app.config(function($routeProvider){
    $routeProvider
        .when('/register', {
            templateUrl : "resources/views/auth/register.html"
        })
        .otherwise(
            { templateUrl : "resources/views/home.html" }
        );
});