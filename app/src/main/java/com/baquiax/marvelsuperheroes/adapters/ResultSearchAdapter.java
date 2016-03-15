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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by baquiax on 13/3/2016.
 */
public class ResultSearchAdapter extends RecyclerView.Adapter<ResultSearchAdapter.CharacterCell> {
    private Context context;
    private List<Character> resultOfSearch;
    private OnCharacterClickListener clickListener;

    public ResultSearchAdapter(Context context) {
        this.context = context;
        this.resultOfSearch = new ArrayList<Character>();
        Character c = new Character(1009157,"Spider-Girl (Anya Corazon)", "http://i.annihil.us/u/prod/marvel/i/mg/a/10/528d369de3e4f.jpg");
        this.resultOfSearch.add(c);
        this.resultOfSearch.add(c);
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
        Glide.with(context).load(c.getThumbnail()).into(holder.characterImage);
        if (this.clickListener != null) {
            holder.setOnItemClickListener(c, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
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
}
