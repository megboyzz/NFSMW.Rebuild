package com.ea.ironmonkey;

import android.opengl.GLSurfaceView;

public class RunLoop {
    public static final int STATE_RUNNING = 1;
    public static final int STATE_STOPPED = 0;
    private GLSurfaceView glSurfaceView;
    private int state;

    public RunLoop(GLSurfaceView gLSurfaceView) {
        this.glSurfaceView = gLSurfaceView;
        updateRenderMode();
    }

    private native void nativeOnRunLoopTick();

    private void setState(int i) {
        this.state = i;
        updateRenderMode();
    }

    private void updateRenderMode() {
        Log.v("RunLoop", "RunLoop.state = " + this.state);
        switch (this.state) {
            case 0:
                this.glSurfaceView.setRenderMode(0);
                return;
            case 1:
                this.glSurfaceView.setRenderMode(1);
                return;
            default:
                return;
        }
    }

    public int getState() {
        return this.state;
    }

    public void join() {
        setState(0);
    }

    public void onRunLoopTick() {
        if (this.state == 1) {
            nativeOnRunLoopTick();
        }
    }

    public void start() {
        setState(1);
    }

    public void stop() {
        setState(0);
    }
}
