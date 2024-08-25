package com.example.burgersapp.presenter.details


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgersapp.databinding.IngredientItemBinding
import com.example.burgersapp.domain.model.Ingredient
import com.squareup.picasso.Picasso


class IngredientsAdapter(
    private val ingredient: List<Ingredient>
) : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            IngredientItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = ingredient.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ingredient = ingredient[position]

        holder.binding.ingredientTitle.text = ingredient.name

        Picasso
            .get()
            .load(ingredient.img)
            .into(holder.binding.ingredientImage)
    }


    inner class MyViewHolder(val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root)
}