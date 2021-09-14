package com.ea.ironmonkey;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameRenderer implements GLSurfaceView.Renderer {
    static GL10 _gl = null;
    private int _height;
    private int _width;
    private GameActivity activity;
    private DrawFrameListener drawFrameListener;

    public GameRenderer(GameActivity gameActivity) {
        this.activity = gameActivity;
    }

    public int getHeight() {
        return this._height;
    }

    public int getWidth() {
        return this._width;
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.drawFrameListener != null) {
            this.drawFrameListener.onDrawFrame(gl10);
        } else {
            this.activity.getRunLoop().onRunLoopTick();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (gl10 != _gl) {
            this.activity.nativeSurfaceChanged(gl10, i, i2);
            _gl = gl10;
        }
        this._width = i;
        this._height = i2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.activity.nativeSurfaceCreated(gl10, eGLConfig);
    }

    public void setDrawFrameListener(DrawFrameListener drawFrameListener2) {
        this.drawFrameListener = drawFrameListener2;
    }
}
