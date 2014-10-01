package com.izv.proyectolv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class Principal extends Activity {

    private ArrayList<Disco> datos;
    private Adaptador ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        initComponents();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initComponents(){
        datos = new ArrayList<Disco>();
        Disco dis1 = new Disco("Ghost Stories", "Coldplay", "Sony Music", "coldplay.gif");
        Disco dis2 = new Disco("Memories", "David Guetta", "Sony Music", "coldplay.gif");
        Disco dis3 = new Disco("Demons", "Imagine Dragons", "Sony Music", "imaginedragons.gif");
        datos.add(dis1);
        datos.add(dis2);
        datos.add(dis3);

        ad = new Adaptador(this, R.layout.lista_detalle, datos);
        final ListView ls = (ListView)findViewById(R.id.lvLista);
        ls.setAdapter(ad);

    }
}
