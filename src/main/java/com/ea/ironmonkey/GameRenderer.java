package com.ea.ironmonkey;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

//TODO Это тоже рендеринг
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

    @Override
    public void onDrawFrame(GL10 gl10) {
        if (this.drawFrameListener != null) {
            this.drawFrameListener.onDrawFrame(gl10);
        } else {
            this.activity.getRunLoop().onRunLoopTick();
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        if (gl10 != _gl) {
            this.activity.nativeSurfaceChanged(gl10, width, height);
            _gl = gl10;
        }
        this._width = width;
        this._height = height;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.activity.nativeSurfaceCreated(gl10, eGLConfig);
    }

    public void setDrawFrameListener(DrawFrameListener drawFrameListener2) {
        this.drawFrameListener = drawFrameListener2;
    }

    public static void drawRectangle(GL10 gl, float x, float y, float width, float height, float r, float g,
                                     float b, float a) {
        float[] verticies = { -0.5f * width + x, -0.5f * height + y, 0.5f * width + x, -0.5f * height + y,
                -0.5f * width + x, 0.5f * height + y, 0.5f * width + x, 0.5f * height + y, };

        float[] colors = { r, g, b, a, r, g, b, a, r, g, b, a, r, g, b, a, };

        FloatBuffer polygonVerticies = makeFloatBuffer(verticies);
        FloatBuffer polygonColors = makeFloatBuffer(colors);

        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, polygonVerticies);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, polygonColors);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

    }

    public static final FloatBuffer makeFloatBuffer(float[] arr) {
        ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);
        return fb;
    }
}
