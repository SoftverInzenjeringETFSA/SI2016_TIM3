/**
 * Created by Lejla on 08.05.2017..
 */
app.controller('AppController', function($scope) {
    $scope.headingTitle = "Dogovor za izlazak";

    /*User.get(1).then(function(response){

    });*/
});


/*app.factory('User', function($http) {
    return {
        fetch: function() {
            return $http.get("/api/v2/users")
        },
        get: function(id) {
            return $http.get("api/v2/users/" + id)
        },
        update: function(data) {
            return $http.put("api/v2/users/" + data.id, data)
        }
    }
})*/