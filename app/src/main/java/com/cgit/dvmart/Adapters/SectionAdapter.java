package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.databinding.SectionLayoutBinding;

import java.util.List;


public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Section> sections;

    public SectionAdapter(Context context, List<Section> sections) {
        this.context = context;
        this.sections = sections;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SectionLayoutBinding binding = SectionLayoutBinding.inflate(layoutInflater,parent,false);
        return new SectionHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SectionHolder)holder).bindView(sections.get(position));
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    private class SectionHolder extends RecyclerView.ViewHolder{
        SectionLayoutBinding binding;
        public SectionHolder(@NonNull SectionLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Section section){
            binding.sectionName.setText(section.getSectionLabel());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            binding.sectionItemRv.setLayoutManager(gridLayoutManager);
            SectionItemAdapter sectionItemAdapter = new SectionItemAdapter(context,section.getItemArrayList());
            binding.sectionItemRv.setAdapter(sectionItemAdapter);
        }
    }
}
