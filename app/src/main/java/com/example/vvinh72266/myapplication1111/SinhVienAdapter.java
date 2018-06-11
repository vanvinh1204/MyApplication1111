package com.example.vvinh72266.myapplication1111;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by v.vinh72266 on 11-Jun-18.
 */

public class SinhVienAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }


    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtHoTen, txtNamSinh, txtDiaChi;
        ImageView imgDelete, imgEdit;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtHoTen     = (TextView) convertView.findViewById(R.id.textviewHoTenCustom);
            holder.txtDiaChi    = (TextView) convertView.findViewById(R.id.textviewDiaChiCustom);
            holder.txtNamSinh   = (TextView) convertView.findViewById(R.id.textviewNamSinhCustom);
            holder.imgDelete    = (ImageView) convertView.findViewById(R.id.imageviewDelete);
            holder.imgEdit      = (ImageView) convertView.findViewById(R.id.imageviewEdit);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final SinhVien sinhvien = sinhVienList.get(position);

        holder.txtHoTen.setText(sinhvien.getHoTen());
        holder.txtNamSinh.setText("Nam Sinh: "+ sinhvien.getNamSinh());
        holder.txtDiaChi.setText(sinhvien.getDiaChi());

        //bat su kien xoa va sua

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateSinhVienActivity.class);
                intent.putExtra("dataSinhVien", sinhvien);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
