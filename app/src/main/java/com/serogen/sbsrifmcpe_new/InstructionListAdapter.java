package com.serogen.sbsrifmcpe_new;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InstructionListAdapter extends ArrayAdapter<InstructionItemFromInstructionsList> implements Filterable {

    private Activity context;
    private ArrayList<InstructionItemFromInstructionsList> list;
    private ArrayList<InstructionItemFromInstructionsList> filteredList;
    private int layoutResourceId;

    private ModelFilter filter;

    static class ViewHolder {
        public TextView text;
        public TextView text2;
        public ImageView image;
        public Button btn;
    }



    public InstructionListAdapter(Activity context, int layoutResourceId,ArrayList<InstructionItemFromInstructionsList> list) {
        super(context, layoutResourceId,list);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.list = new ArrayList<>();
        this.list.addAll(list);
        this.filteredList = new ArrayList<>();
        this.filteredList.addAll(list);
        getFilter();
    }
    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new ModelFilter();
        }
        return filter;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(layoutResourceId,null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = rowView.findViewById(R.id.instruction_item_name);
            viewHolder.text2 = rowView.findViewById(R.id.instruction_item_mcpe_only);
            viewHolder.image = rowView.findViewById(R.id.instruction_item_image);
            viewHolder.btn = rowView.findViewById(R.id.instruction_item_open_btn);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.text.setText(filteredList.get(position).getInstructionName());
        holder.text2.setVisibility(filteredList.get(position).isMcpeOnly()?View.VISIBLE:View.GONE);
        Picasso
                .with(context)
                .load(filteredList.get(position).getImageResourceId())
                .fit()
                .centerCrop()
                .into(holder.image);
        holder.btn.setTag(position);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer)v.getTag();
                ((MainActivity)context).onInstructionItemClicked(filteredList.get(position).getId());
            }
        });


        return rowView;
    }
    private class ModelFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint.toString().length() > 0)
            {
                ArrayList<InstructionItemFromInstructionsList> filteredItems = new ArrayList<InstructionItemFromInstructionsList>();

                for(int i = 0, l = list.size(); i < l; i++)
                {
                    InstructionItemFromInstructionsList m = list.get(i);
                    if(m.getInstructionName().toLowerCase().contains(constraint) || (((String) constraint).toLowerCase().equals("говно") && m.getId()==9))
                        filteredItems.add(m);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = list;
                    result.count = list.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            filteredList = (ArrayList<InstructionItemFromInstructionsList>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = filteredList.size(); i < l; i++)
                add(filteredList.get(i));
            notifyDataSetInvalidated();
        }
    }
}
