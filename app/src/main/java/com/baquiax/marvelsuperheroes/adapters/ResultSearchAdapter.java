package com.baquiax.marvelsuperheroes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baquiax.marvelsuperheroes.R;
import com.baquiax.marvelsuperheroes.models.Character;
import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baquiax on 13/3/2016.
 */
public class ResultSearchAdapter extends RecyclerView.Adapter<ResultSearchAdapter.CharacterCell> {
    public static final String BASE_URL = "http://gateway.marvel.com/";
    private static final String API_KEY = "1c81b0b4fb5e156d15bbe829e1a49279";
    private static final String PRIVATE_KEY = "e7b6bec556e4b3377d1d3ab0139df7598e4fe462";

    private Context context;
    private List<Character> resultOfSearch;
    private OnCharacterClickListener clickListener;
    private Retrofit retrofit;
    private MarvelClientInterface apiService;

    public ResultSearchAdapter(Context context) {
        this.context = context;
        this.resultOfSearch = new ArrayList<Character>();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.apiService = retrofit.create(MarvelClientInterface.class);
    }

    public void setOnItemClickListener(OnCharacterClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public CharacterCell onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_row, parent, false);
        CharacterCell vh = new CharacterCell(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CharacterCell holder, int position) {
        Character c = resultOfSearch.get(position);
        holder.characterId.setText(String.valueOf(c.getId()));
        holder.characterName.setText(c.getName());
        Glide.with(context).load(c.getImageUrl()).into(holder.characterImage);
        if (this.clickListener != null) {
            holder.setOnItemClickListener(c, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        if (resultOfSearch == null) return 0;
        return resultOfSearch.size();
    }

    public static class CharacterCell extends RecyclerView.ViewHolder {
        @Bind(R.id.characterId)
        TextView characterId;
        @Bind(R.id.characterImage)
        ImageView characterImage;
        @Bind(R.id.characterName)
        TextView characterName;

        private View view;
        public CharacterCell(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this,this.view);
        }

        public void setOnItemClickListener(final Character character, final OnCharacterClickListener listener){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(character);
                }
            });
        }
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public void  searchCharacters(String name) {
        int time = (int) (System.currentTimeMillis());
        Timestamp tsTemp = new Timestamp(time);
        String ts =  tsTemp.toString();
        String hash = ts + PRIVATE_KEY + API_KEY;
        hash = MD5(hash);
        Call<JsonObject> call = apiService.searchCharacters(API_KEY, name, ts, hash);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e(getClass().toString(), "Llamada hecha con éxito");
                resultOfSearch.clear();
                if (response.body() != null) {
                    JsonArray body = ((JsonObject) response.body().get("data")).get("results").getAsJsonArray();
                    for (JsonElement d : body) {
                        JsonObject data = (JsonObject) d;
                        int id = data.get("id").getAsInt();
                        String name = data.get("name").getAsString();
                        JsonObject thumb = data.get("thumbnail").getAsJsonObject();
                        String image = thumb.get("path").getAsString().replaceAll("\"","") + "." + thumb.get("extension").getAsString().replaceAll("\"","");
                        Character c = new Character(id, name, image);
                        resultOfSearch.add(c);
                    }
                }
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e(getClass().toString(), "Error en la llamada");
            }
        });

    }

    public class Container {
        Map<String, Object> content[];
    }
}
