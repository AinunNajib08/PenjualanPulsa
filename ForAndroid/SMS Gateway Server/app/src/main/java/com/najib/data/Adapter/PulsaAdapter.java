package com.najib.data.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.najib.data.Model.Pulsa;
import com.najib.data.R;

import java.util.List;

public class PulsaAdapter extends RecyclerView.Adapter<PulsaAdapter.MyViewHolder> {
    List<Pulsa> mPulsaList;

    public PulsaAdapter(List<Pulsa> PulsaList) {
        mPulsaList = PulsaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewNama.setText("Nomor = " + mPulsaList.get(position).getNo_tujuan());
        holder.mTextViewNomor.setText("Status = " + mPulsaList.get(position).getStatus());
        holder.mTextJumlah.setText("Jumlah ="+mPulsaList.get(position).getNominal());

    }

    @Override
    public int getItemCount() {
        return mPulsaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor, mTextJumlah;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextJumlah = itemView.findViewById(R.id.tvJumlah);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}
