package com.iblancasa.arduband;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView tempoView;
    Button sum;
    Button res;
    Context contexto;

    int tempo = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contexto=this;

        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                tempoView = (TextView) stub.findViewById(R.id.tempo);
                sum = (Button) stub.findViewById(R.id.sumar);
                res = (Button) stub.findViewById(R.id.restar);

                sum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(tempo<128)
                            tempo++;
                        tempoView.setText(Integer.toString(tempo));
                    }
                });

                res.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(tempo>0)
                            tempo--;
                        tempoView.setText(Integer.toString(tempo));
                    }
                });

                tempoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(contexto, "Enviado", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



    }
}
