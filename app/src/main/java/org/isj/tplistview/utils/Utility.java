package org.isj.tplistview.utils;

import android.content.Context;
import android.util.Log;

import org.isj.tplistview.entities.Pays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel FOUOMENE  daniel.fouomene@objis-cameroun.com on 01/2019.
 */
public class Utility {


    // trouve ID  de l'image correspondant à partie du nom de l'image (dans le repertoire ressource drawable).
    public static  int getDrawableResIdByNom(Context context, String resNom)  {
        String pkgName = context.getPackageName();
        // Return 0 si non trouve.
        int resID = context.getResources().getIdentifier(resNom , "drawable", pkgName);
        Log.i("Utility", "Nom de la ressource : "+ resNom+"==> Ressource ID = "+ resID);
        return resID;
    }

    public static List<Pays> rerourneLaListeDePays() {
        List<Pays> list = new ArrayList<Pays>();
        Pays cameroun = new Pays("Cameroun", "cm", 28000000);
        Pays coteIvoire = new Pays("Côte d'Ivoire", "ci", 27000000);
        Pays france = new Pays("France", "fr", 142000000);

        list.add(cameroun);
        list.add(coteIvoire);
        list.add(france);


        return list;
    }
}


