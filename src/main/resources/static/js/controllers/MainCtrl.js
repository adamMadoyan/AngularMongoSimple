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
            $scope.error = "";

            $scope.users = [];

            $scope.save = function () {
                console.info("save");
                $scope.resultNotFound = "";
                MainService.save($scope.user, function (response) {
                    console.info(response);
                    if (response.status == 200) {
                        $scope.result = response.data;
                        $scope.error = "";
                        $scope.success = "Your request completed successfully.";
                    } else if (response.status == 409) {
                        $scope.error = "User already exist.";
                        $scope.success = "";
                    }
                });
            };

            $scope.search = function () {
                $scope.error = "";
                $scope.success = "";
                console.info("search");
                MainService.getByEmail($scope.user.email, function (response) {
                    if (response.status == 200) {
                        $scope.result = response.data;
                        $scope.resultNotFound = "";
                    } else if (response.status == 404) {
                        $scope.result = null;
                        $scope.resultNotFound = "By this email there is no data!";
                    }
                });
            }

        }
    ]
);