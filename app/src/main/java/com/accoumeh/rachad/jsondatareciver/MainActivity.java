package com.accoumeh.rachad.jsondatareciver;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textviewresult);
        button = findViewById(R.id.button);
        mQueue = Volley.newRequestQueue(this);
        button.setOnClickListener(v -> {
            jsonParse();
        });
    }

    private void jsonParse() {
        String url = "https://usdtolb.xyz/api/dollar";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                       // int i = 0;
                        //int j = jsonArray.length();
                       // while (i < j) {
                            JSONObject employee = jsonArray.getJSONObject(i);
                            String string1 = employee.getString("id");
                            String string2 = employee.getString("buy");
                            String string3 = employee.getString("sell");
                            String string4 = employee.getString("name");
                            String string5 = employee.getString("country");
                            String string6 = employee.getString("updated_at");
                            String string7 = employee.getString("created_at");
                            String string8 = employee.getString("type");
                            String string9 = employee.getString("state");
                            textView.append(string1 + "\n" + string2 + "\n" + string3 + "\n" + string4 + "\n" + string5 + "\n" + string6 + "\n" + string7 + "\n" + string8 + "\n" + string9);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, Throwable::printStackTrace);
        mQueue.add(request);
    }
}