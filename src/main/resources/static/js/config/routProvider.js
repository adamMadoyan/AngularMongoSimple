'use strict';

Mongo.app.config(function ($stateProvider, $urlRouterProvider, Config) {

    // For any unmatched url, redirect to /
    $urlRouterProvider.otherwise(Config.routes.main.url);

    //Now set up the states
    for (var stateName in Config.routes) {
        var routParams = Config.routes[stateName];
        $stateProvider.state(stateName, routParams);
    }

});