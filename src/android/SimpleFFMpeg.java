/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpletask.ffmpegcordova;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Dax
 */
public class SimpleFFMpeg extends CordovaPlugin {

    public static final String ACTION_EXECUTE_FFMPEG = "callFFMpeg";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_EXECUTE_FFMPEG.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);
                String ffmpegCommand = arg_object.getString("ffmpegcommand");
				FFMpegControlerCord cont = new FFMpegControlerCord(ffmpegCommand);
				cont.transcodeCommand();
                callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch (JSONException e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
