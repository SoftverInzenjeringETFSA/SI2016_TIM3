<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Dogovor za izlazak</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="../../resources/bower-material-master/angular-material.css">


</head>

<body >

<div ng-controller="AppController as ctrl" ng-view>
    <md-toolbar>
        <div class="md-toolbar-tools">
            <md-button aria-label="Go Back">
                Go Back
            </md-button>

            <md-truncate style="position: absolute; left: 90px; right: 170px; top: 13px; bottom: 13px;">Toolbar with Standard Buttons</md-truncate>

            <span flex></span>
            <md-button class="md-raised" aria-label="Learn More">
                Learn More
            </md-button>
            <md-button class="md-fab md-mini" aria-label="Favorite">
                <md-icon md-svg-icon="img/icons/favorite.svg"></md-icon>
            </md-button>
        </div>
    </md-toolbar>
</div>
<script src="./webjars/angularjs/1.4.8/angular.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-resource.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-route.js"></script>
<script src="../../resources/angular/app.js"></script>
<script src="../../resources/angular/AppController.js"></script>
<script src="../../resources/bower-material-master/angular-material.js"></script>

</body>
</html>