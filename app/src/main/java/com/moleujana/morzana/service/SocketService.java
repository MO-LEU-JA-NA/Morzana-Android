package com.moleujana.morzana.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.moleujana.morzana.Constants;

import org.json.JSONObject;

import java.net.URISyntaxException;

import androidx.annotation.Nullable;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

//TODO Socket On Emit
public class SocketService extends Service {

    private Socket socket;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            socket = IO.socket(Constants.SERVER_URL);
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void on(String eventName, Emitter.Listener listener) {
        socket.on(eventName, listener);
    }

    public void emit(String eventName, JSONObject jsonObject) {
        socket.emit(eventName, jsonObject);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
