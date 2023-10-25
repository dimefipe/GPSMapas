package com.example.gpsmapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;  //declaran e inicializan las variables

    GoogleMap mMap; //Objeto googleMap que se utilizará para interactuar con el mapa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIDEO ====================================================
        VideoView MiVideito = findViewById(R.id.videoView);
        String videito = "android.resource://"+getPackageName()+"/"+R.raw.stomas;
        Uri uri = Uri.parse(videito);
        MiVideito.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        MiVideito.setMediaController(mediaController);
        mediaController.setAnchorView(MiVideito);

        //MAPA ======================================================
        txtLatitud=findViewById(R.id.txt_Latitud);
        txtLongitud=findViewById(R.id.txt_Longitud);
        //Se llama el fragmento mapa para asegurar que el mapa este listo para su uso
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override //se llama cuando el mapa está listo
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap=googleMap; //Se inicializa el objeto mMap con GoogleMap
        this.mMap.setOnMapClickListener(this); //Se configura el manejador del evento de clic
        this.mMap.setOnMapLongClickListener(this);

        //MARCADORES =================================================
        //Se colola un marcador en una ubicación especifica y se mueve la camara para centrarla en esa ubicación
        LatLng Arica = new LatLng(-18.483192249971417, -70.31038613217935);
        mMap.addMarker(new MarkerOptions().position(Arica).title("ST Arica"));

        LatLng Iquique = new LatLng(-20.239028932692012, -70.14495636972387);
        mMap.addMarker(new MarkerOptions().position(Iquique).title("ST Iquique"));

        LatLng Antofagasta = new LatLng(-23.63452507168484, -70.39407406087933);
        mMap.addMarker(new MarkerOptions().position(Antofagasta).title("ST Antofagasta"));

        LatLng LaSerena = new LatLng(-29.90845307512955, -71.25722620300718);
        mMap.addMarker(new MarkerOptions().position(LaSerena).title("ST La Serena"));

        LatLng Vinia = new LatLng(-33.037515318554405, -71.52212563299955);
        mMap.addMarker(new MarkerOptions().position(Vinia).title("ST Viña del Mar"));

        LatLng Santiago = new LatLng(-33.44879473531572, -70.66079123171421);
        mMap.addMarker(new MarkerOptions().position(Santiago).title("ST Santiago"));

        LatLng Talca = new LatLng(-35.427231937570646, -71.67295666200641);
        mMap.addMarker(new MarkerOptions().position(Talca).title("ST Talca"));

        LatLng Concepcion = new LatLng(-36.82613146091092, -73.0616253027451);
        mMap.addMarker(new MarkerOptions().position(Concepcion).title("ST Concepcion"));

        LatLng Angeles = new LatLng(-37.47194547772881, -72.35399490271848);
        mMap.addMarker(new MarkerOptions().position(Angeles).title("ST Los Angeles"));

        LatLng Temuco = new LatLng(-38.73302316004357, -72.60203015775674);
        mMap.addMarker(new MarkerOptions().position(Temuco).title("ST Temuco"));

        LatLng Valdivia = new LatLng(-39.81521380107432, -73.23315018345761);
        mMap.addMarker(new MarkerOptions().position(Valdivia).title("ST Valdivia"));

        LatLng Osorno = new LatLng(-40.57160333187076, -73.13772593142227);
        mMap.addMarker(new MarkerOptions().position(Osorno).title("ST Osorno"));

        LatLng PuertoMontt = new LatLng(-40.52538776922028, -73.13505956701204);
        mMap.addMarker(new MarkerOptions().position(PuertoMontt).title("ST Puerto Montt"));

        //CENTRARSE EN UN MARCADOR ===================================
        float zoomLevel = 4;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Santiago));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Santiago, zoomLevel));
    }

    @Override //Utilizan este metodo para manejar los eventos del clic largo en el mapa
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }

    //Se actualizan los campos de texto con las coordenadas de latitud y longitud
    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }
}