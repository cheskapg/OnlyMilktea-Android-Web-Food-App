package com.example.ipt102project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class ListOrdersAdapter extends RecyclerView.Adapter<ListOrdersAdapter.ViewHolder> {
    private final ListOrdersData[] listdata;

    public ListOrdersAdapter(ListOrdersData[] listdata) {

        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_list_orders_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListOrdersData myListData = listdata[position];
        holder.foodName.setText(listdata[position].getFoodMenu_foodname());
        holder.foodPrice.setText(String.valueOf(listdata[position].getFoodMenu_foodprice()));
//        holder.foodImage.setImageResource(listdata[position].getImgID());
        holder.itemQty.setText(String.valueOf(listdata[position].getQuantity()));
        holder.itemhasPearls.setChecked(listdata[position].isItemHasPearls());
        holder.SubtotalValue.setText(String.valueOf(listdata[position].getSubtotalValue()));
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView foodImage;

        public TextView foodName;
        public TextView foodPrice;
        public TextView itemQty;
        public TextView SubtotalValue;

        public CheckBox itemhasPearls;

        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            // SET IMAGES
            this.foodImage = (ImageView) itemView.findViewById(R.id.imageView_FoodMenu_foodimage);
            // SET FOOD NAMES
            this.foodName = (TextView) itemView.findViewById(R.id.textView_FoodName);
            // SET FOOD PRICE
            this.foodPrice = (TextView) itemView.findViewById(R.id.textView_FoodMenu_foodprice);
            // SET FOOD ITEM QTY
            this.itemQty = (TextView) itemView.findViewById(R.id.textView_itemQty);
            // SET SUBTOTAL
            this.SubtotalValue = (TextView) itemView.findViewById(R.id.textView_SubtotalValue);
            // set checkbox
            this.itemhasPearls = (CheckBox) itemView.findViewById(R.id.checkBox_itemhasPearls);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_FoodMenuRelativeLayout);
        }
    }


}
//TODO: REIMPLEMENT CODE
