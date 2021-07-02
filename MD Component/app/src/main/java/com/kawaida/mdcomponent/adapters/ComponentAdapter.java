package com.kawaida.mdcomponent.adapters;

import android.content.pm.ShortcutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kawaida.mdcomponent.R;
import com.kawaida.mdcomponent.utils.Component;
import com.kawaida.mdcomponent.utils.OnClickListener;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder>{

    private List<Component> mComponents;
    private OnClickListener mListener;

    public ComponentAdapter(List<Component> mComponents, OnClickListener mListener) {
        this.mComponents = mComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentAdapter.ViewHolder holder, int position) {
        Component component = mComponents.get(position);

        holder.setClickListener(mListener, component);
        holder.tvName.setText(component.getName());
        holder.imgPhoto.setImageResource(component.getPhotoRes());
    }

    public void add(Component component){
        if(!mComponents.contains(component)){
            mComponents.add(component);
            notifyItemInserted(mComponents.size() - 1);
        }
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        AppCompatImageView imgPhoto;
        TextView tvName;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgPhoto = itemView.findViewById(R.id.imgPhoto);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.view = itemView;
        }

        void setClickListener(OnClickListener listener, Component component){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(component);
                }
            });
        }
    }

}
