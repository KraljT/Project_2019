package com.example.stuff_14.Home;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApplicationMy extends Application {
    /*    private ApplicationMy app;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            app = (ApplicationMy) getApplication();
        }  */
    private static final String MY_FILE_NAME = "test.txt";
    public static final String TAG = ApplicationMy.class.getSimpleName();
    private Change_Username data;
    private Gson gson;
    private File file;
    private String idApp;

    @Override
    public void onCreate() {
        super.onCreate();
        //idApp = "NA"; Why not here?

    }

    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().setPrettyPrinting().create();
        }
        return gson;
    }

    public File getFile() {
        if (file == null) {
            File filesDir = getFilesDir();
            file = new File(filesDir, MY_FILE_NAME);
        }
        Log.i(TAG, file.getPath());
        return file;
    }

    private void saveToFile() {
        try {
            FileUtils.writeStringToFile(getFile(), getGson().toJson(data));
        } catch (IOException e) {
            Log.d(TAG, "Can't save " + file.getPath());
        }
    }

    private boolean readFromFile() {
        if (!getFile().exists()) return false;
        try {
            data = getGson().fromJson(FileUtils.readFileToString(getFile()), Change_Username.class);
            if (data == null) return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    public String getIdApp() {
        if (idApp == null) {
            //Try to read from s.p. or generate new id set idApp
            idApp = data.GetID();
        }
        return idApp;
    }

    public Change_Username getData() {
        if (data == null) {
            if (!readFromFile())
                data = new Change_Username();
        }
        return data;
    }

    public void save() {
        saveToFile();
    }
}
