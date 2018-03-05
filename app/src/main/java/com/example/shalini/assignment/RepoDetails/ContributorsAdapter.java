package com.example.shalini.assignment.RepoDetails;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shalini.assignment.contributorDetails.ContributorDetailsActivity;
import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.databinding.LayoutContributorsItemBinding;

import java.util.List;

import static com.example.shalini.assignment.AppConstants.EXTRA_CONTRIBUTOR;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.MyViewHolder> {
    List<Contributor> contributorsList;

    public ContributorsAdapter(List<Contributor> contributorsList) {
        this.contributorsList = contributorsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutContributorsItemBinding layoutContributorsItemBinding = LayoutContributorsItemBinding.inflate(layoutInflater);
        return new MyViewHolder(layoutContributorsItemBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contributor contributor =contributorsList.get(position);
        holder.bind(contributor);
    }

    @Override
    public int getItemCount() {
        return contributorsList != null ? contributorsList.size() : 0;
    }

    public void replaceData(List<Contributor> contributorList) {
        contributorsList = contributorList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        LayoutContributorsItemBinding layoutContributorsItemBinding;
        public MyViewHolder(LayoutContributorsItemBinding itemView) {
            super(itemView.getRoot());
            layoutContributorsItemBinding = itemView;
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contributor contributor = layoutContributorsItemBinding.getContributor();
                    Intent intent = new Intent(v.getContext(), ContributorDetailsActivity.class);
                    intent.putExtra(EXTRA_CONTRIBUTOR,contributor);
                    v.getContext().startActivity(intent);
                }
            });
        }
        public void bind(Contributor contributor){
            layoutContributorsItemBinding.setContributor(contributor);
            layoutContributorsItemBinding.executePendingBindings();
        }
    }
}
