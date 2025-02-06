package fpt.anhdhph.asm_mob2041_ph25329.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import fpt.anhdhph.asm_mob2041_ph25329.IClickItemRCV;
import fpt.anhdhph.asm_mob2041_ph25329.Model.LoaiSach;
import fpt.anhdhph.asm_mob2041_ph25329.R;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiSach> lstLS;
    IClickItemRCV clickItemRCV;

    public LoaiSachAdapter(Context context, ArrayList<LoaiSach> lstLS,IClickItemRCV itemRCV) {
        this.context = context;
        this.lstLS = lstLS;
        this.clickItemRCV = itemRCV;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loaisach,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LoaiSach loaiSach = lstLS.get(position);
        holder.tv_maloai.setText("Mã Loại: " + loaiSach.getMaLoai());
        holder.tv_tenloai.setText("Tên Loại: " + loaiSach.getTenLoai());

        holder.btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItemRCV.iclickItem(holder,loaiSach.getMaLoai(),1);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItemRCV.iclickItem(holder,holder.getAdapterPosition(),0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstLS.size() != 0 ? lstLS.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_maloai,tv_tenloai;
        ImageButton btn_xoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maloai = itemView.findViewById(R.id.tv_maloai);
            tv_tenloai = itemView.findViewById(R.id.tv_tenloai);

            btn_xoa = itemView.findViewById(R.id.btn_delete);
        }
    }
}
