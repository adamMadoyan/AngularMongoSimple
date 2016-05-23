'use strict';

Mongo.app = angular.module('Mongo', [
    'ui.router',
    //'ui.bootstrap',
    'Mongo.app.controllers',
    'Mongo.app.services',
    'Mongo.app.directives',
    'Mongo.app.filters'
]);