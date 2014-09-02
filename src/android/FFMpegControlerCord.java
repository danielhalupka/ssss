package com.simpletask.ffmpegcordova;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import com.netcompss.ffmpeg4android_client.BaseWizard;
import com.netcompss.ffmpeg4android_client.FileUtils;
import com.netcompss.ffmpeg4android_client.Prefs;
import com.netcompss.ffmpeg4android_client.TranscodeBackground;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class FFMpegControlerCord extends BaseWizard {
	

	private String commandLine;
	
	public FFMpegControlerCord(String command){
		this.commandLine = command;
	}
	
	public void transcodeCommand(){
		String commandStr = this.commandLine;
		setCommand(commandStr);
		runTranscoing();
	}
	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    copyLicenseAndDemoFilesFromAssetsToSDIfNeeded();
	}

}