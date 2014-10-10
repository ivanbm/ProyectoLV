package com.izv.proyectolv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
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

        int id = item.getItemId();
        if (id == R.id.action_anadir) {
            anadir();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.editar:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                //1. obtenemos el indice
                int index = info.position;
                editar(index);
                ad.notifyDataSetChanged();

                return true;
            case R.id.elimiar:
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
        Disco dis1 = new Disco("Ghost Stories", "Coldplay", "Sony Music","coldplay.jpg");
        Disco dis2 = new Disco("Memories", "David Guetta", "Parlophone","davidguetta.jpg");
        Disco dis3 = new Disco("V", "Maroon 5", "Warner Music","maroon5.jpg");
        Disco dis4 = new Disco("Demons", "Imagine Dragons", "Virgin Music","imaginedragons.jpg");
        Disco dis5 = new Disco("Songs Of Innocence", "U2", "Warner Music","u2.jpg");
        datos.add(dis1);
        datos.add(dis2);
        datos.add(dis3);
        datos.add(dis4);
        datos.add(dis5);


        ad = new Adaptador(this, R.layout.lista_detalle, datos);
        final ListView ls = (ListView)findViewById(R.id.lvLista);
        ls.setAdapter(ad);
        registerForContextMenu(ls);

    }

    private void tostada(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public boolean anadir(){




        final AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setTitle(R.string.tituloAnadir);

        LayoutInflater inflater = LayoutInflater.from(this);
        final View vista = inflater.inflate(R.layout.anadir, null);
        alert.setView(vista);

        String[] spinnerArray = {"Parlophone", "Sony", "Warner Music"};
        Spinner selectDiscografica = (Spinner) findViewById(R.id.discografica);

        //setContentView(R.layout.anadir);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDiscografica.setAdapter(spinnerArrayAdapter);



        alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                EditText et1,et2;
                Spinner sp1;
                et1 = (EditText) vista.findViewById(R.id.etAlbum);
                et2 = (EditText) vista.findViewById(R.id.etAutor);
                sp1 = (Spinner) vista.findViewById(R.id.discografica);

                datos.add(new Disco(et1.getText().toString(),et2.getText().toString(), "Discografica del spinner","caratula"));
                ad.notifyDataSetChanged();
                tostada("Album añadido!");
            }
        });
        alert.setNegativeButton(android.R.string.no ,null);
        alert.show();

        return true;
    }


    /*-------------------------------------*/
    /*--      HAY QUE HACER EL EDITAR    --*/
    /*-------------------------------------*/


    public boolean editar(final int index){
        String aut = datos.get(index).getAutor();
        String alb = datos.get(index).getAlbum();
        String dis = datos.get(index).getDiscografica();

        final AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setTitle(R.string.tituloEditar);

        LayoutInflater inflater = LayoutInflater.from(this);
        final View vista = inflater.inflate(R.layout.anadir, null);
        alert.setView(vista);

        final EditText et1,et2, et3;
        et1 = (EditText) vista.findViewById(R.id.etAlbum);
        et2 = (EditText) vista.findViewById(R.id.etAutor);
        //et3 = (EditText) vista.findViewById(R.id.discografica);

        et1.setText(alb);
        et2.setText(aut);

        alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                datos.set(index, new Disco(et1.getText().toString(),et2.getText().toString(), "Discografica del spinner","caratula"));
                ad.notifyDataSetChanged();
                tostada("Album editado!");
            }
        });
        alert.setNegativeButton(android.R.string.no ,null);
        alert.show();

        return true;
    }


    /*----------------------------------------------------*/
    /*                  SELECCIONAR IMAGENES              */
    /*----------------------------------------------------*/
    final int REQ_CODE_PICK_IMAGE =1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case REQ_CODE_PICK_IMAGE:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(
                            selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                }
        }
    }
}
