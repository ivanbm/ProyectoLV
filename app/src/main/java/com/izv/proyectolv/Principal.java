package com.izv.proyectolv;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        /*int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }*/
        switch (item.getItemId()){
            case R.id.editar:
                return true;
            case R.id.elimiar:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                //datos.remove(info.position);
                tostada(getString(R.string.msgeliminar));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual, menu);
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

    private void tostada(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
