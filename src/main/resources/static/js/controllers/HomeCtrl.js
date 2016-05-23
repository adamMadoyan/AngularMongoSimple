'use strict';

/**
 * Home controller
 */

Mongo.app.controllers.controller('home',
    ['$rootScope', '$scope', 'MainService',
        function ($rootScope, $scope, MainService) {
            console.info('home controller started');

            $scope.users = [];

            ($scope.getAll = function () {
                console.info("getAll");
                MainService.getAll(function (response) {
                    console.info(response);
                    $scope.users = response.data;
                });
            })();


        }
    ]
);