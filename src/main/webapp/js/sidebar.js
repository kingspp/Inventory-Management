/**
 * Created by Prathyush SP on 1/14/2016.
 */
$(function() {
    $('.button-collapse').sideNav({
            menuWidth: 300, // Default is 240
            edge: 'left', // Choose the horizontal origin
            closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
        }
    );

    $('.button-collapse').sideNav('show');
});