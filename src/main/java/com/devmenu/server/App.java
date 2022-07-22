package com.devmenu.server;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import fi.iki.elonen.NanoHTTPD;

public class App extends NanoHTTPD {

    private Context context;
    public static final String LOG_TAG = "App";

    public App(int port, Context context) {
        super(port);
        this.context = context;
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FileInputStream createFileInputStream(String path){
        try{
            return context.openFileInput(path);
        }catch (FileNotFoundException e){
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    @Override
    public Response serve(IHTTPSession session) {

        String uri = session.getUri();

        if(uri.equals("/")) {
            FileInputStream stream = createFileInputStream("client/index.html");
            return newChunkedResponse(Response.Status.OK, "text/html", stream);
        }else {
            FileInputStream stream = createFileInputStream("client" + uri);
            String mime = "*/*";
            if(uri.endsWith(".js"))
                mime = "text/javascript";
            else if(uri.endsWith(".css"))
                mime = "text/css";
            else if(uri.endsWith(".ico"))
                mime = "image/ico";
            else if(uri.endsWith(".png"))
                mime = "image/png";
            return newChunkedResponse(Response.Status.OK, mime, stream);
        }
    }

}
