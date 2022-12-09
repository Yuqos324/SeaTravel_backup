package id.kotlin.seatravel.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.seatravel.R

class PesanAdapter (private val pesanan : ArrayList<Model>) : RecyclerView.Adapter<PesanAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_kapal,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = pesanan[position]
        holder.Img.setImageResource(currentItem.Image)
        holder.namaKapal.text = currentItem.namaKapal
        holder.desc.text = currentItem.Description
    }

    override fun getItemCount(): Int {
        return pesanan.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
       val Img : ImageView = itemView.findViewById(R.id.titleImage)
       val namaKapal : TextView = itemView.findViewById(R.id.heading)
       val desc : TextView = itemView.findViewById(R.id.desc)



    }


}