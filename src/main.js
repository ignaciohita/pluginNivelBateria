/*global module, require*/
var cordova = require("cordova");

module.exports = {
    obtenerNivelBateria: function (successCallback, errorCallback) {
        "use strict";

        cordova.exec(successCallback, errorCallback, "NivelBateria", "obtenerNivelBateria", []);
    }
};
