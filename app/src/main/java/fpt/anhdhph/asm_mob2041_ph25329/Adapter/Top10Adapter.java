package fpt.anhdhph.asm_mob2041_ph25329.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import fpt.anhdhph.asm_mob2041_ph25329.Model.Top;
import fpt.anhdhph.asm_mob2041_ph25329.R;

public class Top10Adapter extends RecyclerView.Adapter<Top10Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Top> lstTop;

    public Top10Adapter(Context context, ArrayList<Top> lstTop) {
        this.context = context;
        this.lstTop = lstTop;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top10,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Top top = lstTop.get(position);

        holder.tv_stt.setText(String.valueOf(holder.getAdapterPosition() + 1));
        holder.tv_tensach.setText(top.getTenSach());
        holder.tv_soluong.setText(String.valueOf(top.getSoLuong()));
    }

    @Override
    public int getItemCount() {
        return lstTop != null ? lstTop.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_stt,tv_tensach,tv_soluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stt = itemView.findViewById(R.id.tv_stt);
            tv_tensach = itemView.findViewById(R.id.tv_tensach);
            tv_soluong = itemView.findViewById(R.id.tv_soluong);
        }
    }
}
