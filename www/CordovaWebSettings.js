var exec = require('cordova/exec');

exports.setAllowFileAccess = function (arg0, success, error) {
    exec(success, error, 'CordovaWebSettings', 'setAllowFileAccess', [arg0]);
};

exports.setAllowFileAccessFromFileURLs = function (arg0, success, error) {
    exec(success, error, 'CordovaWebSettings', 'setAllowFileAccessFromFileURLs', [arg0]);
};

exports.setAllowUniversalAccessFromFileURLs = function (arg0, success, error) {
    exec(success, error, 'CordovaWebSettings', 'setAllowUniversalAccessFromFileURLs', [arg0]);
};