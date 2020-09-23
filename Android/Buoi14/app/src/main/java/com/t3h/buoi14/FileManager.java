package com.t3h.buoi14;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileManager {

    public File[] getFiles(String path) {
        File f = new File(path);
        if (f.isDirectory()) {
            return f.listFiles();
        }
        return new File[0];
    }

    private String download(String link, String type) throws Exception {
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();

        String path = Environment.getExternalStorageDirectory().getPath()
                + "/k32/" + System.currentTimeMillis() + type;
        File f = new File(path);
        File parent = f.getParentFile();
        boolean created = parent.mkdirs();
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);

        byte[] b = new byte[1024];
        int count = in.read(b);
        while (count > 0) {
            out.write(b, 0, count);
            count = in.read(b);
        }
        in.close();
        out.close();
        return path;
    }

    public void download(final String link, final String type,
                         final FileDownloadCallback callback) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String path = download(link, type);
                    callback.onSuccess(path);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onFail(e);
                }
            }
        });
        t.start();
    }

    public interface FileDownloadCallback {
        void onSuccess(String path);
        void onFail(Exception ex);
    }
}
