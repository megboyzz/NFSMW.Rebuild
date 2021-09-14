package com.eamobile;

public interface IDownloadActivity {
    public static final int DOWNLOAD_CANCEL = 1;
    public static final int DOWNLOAD_START = 0;

    void onDownloadEvent(int i);

    void onResult(String str, int i);
}
