package com.akpinar.dictionary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val mContext:Context, private val  wordsList:List<Words>)
    : RecyclerView.Adapter<WordsAdapter.CardDesignHold>() {

    inner class CardDesignHold(design: View) : RecyclerView.ViewHolder(design){

        var word_card:CardView
        var textViewEnglish:TextView
        var textViewTurkish:TextView

        init {
            word_card = design.findViewById(R.id.word_card)
            textViewEnglish =design.findViewById(R.id.textViewEnglish)
            textViewTurkish =design.findViewById(R.id.textViewTurkish)
        }
    }

    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHold {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)
        return CardDesignHold(design)
    }

    override fun onBindViewHolder(holder: CardDesignHold, position: Int) {
        val word = wordsList.get(position)

        holder.textViewEnglish.text = word.English
        holder.textViewTurkish.text = word.Turkish

        holder.word_card.setOnClickListener{

            val intent = Intent(mContext,DetailActivity::class.java)
            intent.putExtra("object", word)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }
}