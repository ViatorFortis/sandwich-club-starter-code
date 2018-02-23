package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;

        try {
            sandwich = new Sandwich();

            JSONObject sandwichJSONObject = new JSONObject(json);
            JSONObject sandwichNameJSONObject = sandwichJSONObject.getJSONObject("name");

            sandwich.setMainName(sandwichNameJSONObject.getString("mainName") );

            JSONArray sandwichOtherNamesJSONArray = sandwichNameJSONObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < sandwichOtherNamesJSONArray.length(); i++) {
                alsoKnownAs.add(sandwichOtherNamesJSONArray.getString(i) );
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);

            sandwich.setPlaceOfOrigin(sandwichJSONObject.getString("placeOfOrigin") );
            sandwich.setDescription(sandwichJSONObject.getString("description") );
            sandwich.setImage(sandwichJSONObject.getString("image") );

            JSONArray sandwichIngredientsJSONArray = sandwichJSONObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for(int i = 0; i < sandwichIngredientsJSONArray.length(); i++) {
                ingredients.add(sandwichIngredientsJSONArray.getString(i) );
            }
            sandwich.setIngredients(ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
