package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cgit.dvmart.Model.Cart;
import com.cgit.dvmart.Model.CartPrefrences;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ItemCartBinding;
import com.cgit.dvmart.databinding.ShopItemBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemCartBinding binding=ItemCartBinding.inflate(inflater,parent,false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.mBind(cartList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ItemCartBinding binding;
        public CartViewHolder(@NonNull ItemCartBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }


        public void mBind(Cart cart, int position){
            binding.itemText.setText(cart.getItmeName());
            binding.itemImage.setImageResource(cart.getImage());
            binding.finalQunt.setText(String.valueOf(cart.getQuantitiy()));
            binding.price.setText(cart.getPrice());

            binding.delItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartPrefrences prefrences = new CartPrefrences();
                    prefrences.removeCartProduct(context, cart);
                    notifyItemRemoved(position);

                }
            });
        }
    }
}
