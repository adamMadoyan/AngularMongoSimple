'use strict';

Mongo.app.constant('Config', {

    routes: {

        main: {
            name: 'main',
            title: 'Main page',
            url: '/',
            templateUrl: "/partials/pages/main.html",
            controller: 'main'
        },
        home: {
            name: 'home',
            title: 'Home page',
            url: '/home',
            templateUrl: "/partials/pages/home.html",
            controller: 'home'
        }
    }
});