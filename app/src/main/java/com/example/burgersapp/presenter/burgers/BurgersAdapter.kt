package com.example.burgersapp.presenter.burgers


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgersapp.databinding.BurgerItemBinding
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.util.formattedValue
import com.squareup.picasso.Picasso


class BurgersAdapter(
    private val burgers: List<Burger>,
    private val burgerClick : (Int) -> Unit
) : RecyclerView.Adapter<BurgersAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            BurgerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = burgers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val burger = burgers[position]

        holder.binding.textTitleHamburger.text = burger.name
        holder.binding.textDescriptionHamburger.text = burger.desc
        holder.binding.textPriceHamburger.text = burger.price?.formattedValue()

        Picasso
            .get()
            .load(burger.image?.get(1)?.lg)
            .into(holder.binding.imageBurger)

        holder.itemView.setOnClickListener { burgerClick(burger.id?:0) }
    }


    inner class MyViewHolder(val binding: BurgerItemBinding) : RecyclerView.ViewHolder(binding.root)
}