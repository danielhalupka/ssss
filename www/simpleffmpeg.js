var ffmpegCordovaPlugin = {
    executeFFMpeg: function(ffmpegcommand, successCallback, errorCallback) {
    cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'SimpleFFMpeg', // mapped to our native Java class
            'callFFMpeg', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "ffmpegcommand": ffmpegcommand
            }]
        ); 
    }
}