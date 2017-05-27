/* global $ */
app.controller('AuthController', function($rootScope, $scope, $http, $location, Auth) {
    $scope.headingTitle = "Autentikacija ";

    /******************* 
    	Registracija korisnika 
    *******************/

    // Podaci iz forme 
    $scope.formRegistrationData = {};

    // Poruka za registraciju
    $scope.status = {
    	uspjeh : false,
    	neuspjeh : false,
    	poruka : ""
    }

    // Procesiranje forme 
    $scope.processRegistrationForm = function() {
        Auth.register($scope.formRegistrationData).then(function(response) {

            if(response)
            {
                $scope.status.uspjeh    = true;
                $scope.status.neuspjeh  = false;
                $scope.status.poruka    = "Uspještno ste se registrovali!";   

                // Ako je uspješna registraicja, odradi login
                Auth.login($scope.formRegistrationData.email, $scope.formRegistrationData.password).then(function(data){
                    if(data != false)
                    {
                        // Root autentikacija i prebacivanje na početnu
                        Auth.rootAutentikacija().then(function(resAut){
                            if(resAut) $location.path("/");
                        });  
                    }
                    else
                    {
                        $scope.status.uspjeh    = false;
                        $scope.status.neuspjeh  = true;
                        $scope.status.poruka    = "Račun je kreiran, ali se nismo uspjeli prijaviti na sistem.";
                    }  
                });   
            }
            else
            {
                $scope.status.uspjeh    = false;
                $scope.status.neuspjeh  = true;
                $scope.status.poruka    = "Greška prilikom registracije.";
            }
        });    
    };

    /******************* 
    	Prijava korisnika 
    *******************/

    $scope.formLoginData = {};

    $scope.loginStatus = {
        logovan : false,
        poruka : ""
    }


    $scope.processLoginForm = function() {
     
        Auth.login($scope.formLoginData.email, $scope.formLoginData.password).then(function(response){


            if(response.data != 0)
            {
                Auth.rootAutentikacija().then(function(resAut){
                    console.log(resAut);    
                    if(resAut.data) $location.path("/");
                });
            }
            else
            {
                $scope.loginStatus.logovan = false;
                $scope.loginStatus.poruka = "Nažalost, pristupni podaci nisu ispravni.";
            }  


        });       
    }

});