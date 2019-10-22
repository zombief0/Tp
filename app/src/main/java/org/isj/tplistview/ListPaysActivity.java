package org.isj.tplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.isj.tplistview.adapter.PaysListAdapter;
import org.isj.tplistview.entities.Pays;
import org.isj.tplistview.utils.Utility;

public class ListPaysActivity extends AppCompatActivity {

    private ListView maListePaysView;
    private PaysListAdapter paysListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pays);

        maListePaysView = findViewById(R.id.maListePaysView);

        paysListAdapter = new PaysListAdapter(this, Utility.rerourneLaListeDePays());

        maListePaysView.setAdapter(paysListAdapter);

        // quand l'utilisateur clique sur un élément de la liste
        maListePaysView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = maListePaysView.getItemAtPosition(position);
                Pays pays = (Pays) o; // casting en pays
                Toast.makeText(ListPaysActivity.this, "Vous avez selectionné : " + " " + pays, Toast.LENGTH_LONG).show();
            }
        });
    }
}
