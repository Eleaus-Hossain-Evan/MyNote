package com.example.mynote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerViewAdapter(private val context: Context, private val listener: INoteRVAdapter): RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteVewHolder>() {

    val allNotes = ArrayList<Note>()

    class NoteVewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val btnDlt = itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVewHolder {
        val viewHolder = NoteVewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
        viewHolder.btnDlt.setOnClickListener{
            listener.onItemClicked( allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteVewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        allNotes.size
    }
}
interface INoteRVAdapter{
    fun onItemClicked(note: Note)
}