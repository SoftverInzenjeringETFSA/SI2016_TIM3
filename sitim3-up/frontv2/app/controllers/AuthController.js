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
        if($scope.registrationValidation()) {
            $scope.regValErrors = "";
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
        }   
    };

    $scope.regValErrors = "";
    $scope.registrationValidation = function() {
        $scope.regValErrors = "";
        var valid = true;
        // Ime mora biti uneseno
        if($scope.formRegistrationData.name.length == 0) {
            $scope.regValErrors += "Ime mora biti uneseno. ";
            valid = false;
        }

        // Email mora imati mail format
        var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
        if(!pattern.test($scope.formRegistrationData.email)) {
            $scope.regValErrors += "E-mail mora imati ispravana format. ";
            valid = false;
        }

        // Password mora biti jednak jedan sa drugim
        if($scope.formRegistrationData.password != $scope.formRegistrationData.repPassword) {
            $scope.regValErrors += "Password i ponovljeni password se ne podudaraju ";
            valid = false;
        }

        // Password mora imati više od osam karaktera 
        if($scope.formRegistrationData.password.length < 8) {
            $scope.regValErrors += "Password mora imati minimalno 8 karaktera. ";
            valid = false;
        }

        return valid;
    }

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