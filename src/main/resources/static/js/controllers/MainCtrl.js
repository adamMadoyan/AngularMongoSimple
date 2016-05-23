'use strict';

/**
 * Main controller
 */

Mongo.app.controllers.controller('main',
    ['$rootScope', '$scope', 'MainService', 'Config',
        function ($rootScope, $scope, MainService, Config) {
            console.info('main controller started');

            $scope.user = {
                email: "admin@mail.ru"
            };

            $scope.users = [];

            $scope.save = function () {
                console.info("save");
                MainService.save($scope.user, function (data) {
                    console.info(data);
                    if (response.status == 200) {
                        $scope.result = response.data;
                    } else if (response.status == 409) {
                        $scope.error = "User already exist";
                    }
                });
            };

            $scope.search = function () {
                console.info("search");
                MainService.getByEmail($scope.user.email, function (response) {
                    if (response.status == 200) {
                        $scope.result = response.data;
                    } else if (response.status == 404) {
                        $scope.result = null;
                    }
                });
            }

        }
    ]
);