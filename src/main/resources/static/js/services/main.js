'use strict';

Mongo.app.services.service('MainService',
    ['$http', 'Config',
        function ($http, Config) {

            this.save = function (user, callback) {
                $http({
                    method: 'POST',
                    url: '/users',
                    data: user,
                    headers: {'Content-Type': 'application/json'}
                }).then(function successCallback(response) {
                    callback(response);
                }, function errorCallback(response) {
                    callback(response);
                });
            };

            this.getByEmail = function (email, callback) {
                $http({
                    method: 'GET',
                    url: '/users',
                    params: {email: email}
                }).then(function successCallback(response) {
                    callback(response);
                }, function errorCallback(response) {
                    callback(response);
                });
            };

            this.getAll = function (callback) {
                $http({
                    method: 'GET',
                    url: '/users/'
                }).then(function successCallback(response) {
                    callback(response);
                }, function errorCallback(response) {
                    callback(response);
                });
            };
        }
    ]
);