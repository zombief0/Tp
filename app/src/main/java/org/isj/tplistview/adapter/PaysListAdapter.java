package org.isj.tplistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.isj.tplistview.R;
import org.isj.tplistview.entities.Pays;
import org.isj.tplistview.utils.Utility;

import java.util.List;

/**
 * Created by Daniel FOUOMENE  daniel.fouomene@objis-cameroun.com on 01/2019.
 */
public class PaysListAdapter  extends BaseAdapter {

    private List<Pays> listeDesPays;
    private LayoutInflater layoutInflater;
    private Context context;

    public PaysListAdapter(Context context,  List<Pays> listeDonnee) {
        this.context = context;
        this.listeDesPays = listeDonnee;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listeDesPays.size();
    }

    @Override
    public Object getItem(int position) {
        return listeDesPays.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //C'est ici que nous allons remplir notre element de la liste avec le texte/image de chaque objet Pays
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        //Android nous fournit un convertView null lorsqu'il nous demande de la créer
        //dans le cas contraire, cela veux dire qu'il nous fournit une vue recyclée
        //comme nos vues sont réutilisées, notre élément possède déjà un ViewHolder
        if (convertView == null) {
            //Nous récupérons notre item_liste_personnalise via un LayoutInflater,
            //qui va charger un layout xml dans un objet View
            convertView = layoutInflater.inflate(R.layout.item_liste_pays, null);

            //si elle n'avait pas encore de ViewHolder
            holder = new ViewHolder();

            //récupérer nos sous vues
            holder.drapeauView = (ImageView) convertView.findViewById(R.id.imageViewDrapeau);
            holder.nomPaysView = (TextView) convertView.findViewById(R.id.textViewNomPays);
            holder.populationView = (TextView) convertView.findViewById(R.id.textViewPopulation);

            //puis on sauvegarde le mini-controlleur dans la vue
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //récupérer l'item [position] de la List<Pays> listeDesPays
        Pays pays = this.listeDesPays.get(position);

        //il ne reste plus qu'à remplir notre vue
        holder.nomPaysView.setText(pays.getNomPays());
        holder.populationView.setText("Population: " + pays.getPopulation());
        int idDrapeau = Utility.getDrawableResIdByNom(context,pays.getNomFichierDrapeau());
        holder.drapeauView.setImageResource(idDrapeau);

        //nous renvoyons notre vue à l'adapter, afin qu'il l'affiche
        //et qu'il puisse la mettre à recycler lorsqu'elle sera sortie de l'écran
        return convertView;
    }

    /**
     * Afin d’éviter d’appeler les méthodes findViewById à chaque réutilisation des vues, Android a rajouteé un concept,
     * nommé ViewHolder (gardien/protecteur de vue), qui va avoir le rôle de mini controlleur, associé a chaque élément de la ListView,
     * et qui va stocker les références vers nos sous vues (dans notre cas : titre, texte et image).
     */
    static class ViewHolder {
        ImageView drapeauView;
        TextView nomPaysView;
        TextView populationView;
    }

}