package com.example.vvinh72266.myapplication1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.example.vvinh72266.myapplication1111.R.id.editTextDiaChiEdit;

public class UpdateSinhVienActivity extends AppCompatActivity {

    EditText edtHoTen, edtDiaChi, edtNamSinh;
    Button btnCapNhat, btnHuy;

    int id =0;

    String urlUpdate="http://10.45.6.140/androidwebservice/update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);

        Intent intent =getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("dataSinhVien");
        Toast.makeText(this, sinhVien.getHoTen(), Toast.LENGTH_SHORT).show();

        AnhXa();

        id = sinhVien.getId();
        edtHoTen.setText(sinhVien.getHoTen());
        edtNamSinh.setText(sinhVien.getNamSinh() + "");
        edtDiaChi.setText(sinhVien.getDiaChi());

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hoten = edtHoTen.getText().toString().trim();
                String namsinh = edtNamSinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();

                if(hoten.isEmpty()||namsinh.isEmpty()||diachi.isEmpty()) {
                    Toast.makeText(UpdateSinhVienActivity.this, "vui long nhap lai", Toast.LENGTH_SHORT).show();
                }else{
                    CapNhatSinhVien(urlUpdate);

                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private  void CapNhatSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("ss")){
                            Toast.makeText(UpdateSinhVienActivity.this, "ss", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(UpdateSinhVienActivity.this, MainActivity.class));
                        }else {
                            Toast.makeText(UpdateSinhVienActivity.this, "fail", Toast.LENGTH_SHORT).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateSinhVienActivity.this, "xay ra loi", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","Loi"+error.toString());

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("idSV",String.valueOf(id));
                params.put("hotenSV",edtNamSinh.getText().toString().trim());
                params.put("namsinhSV",edtNamSinh.getText().toString().trim());
                params.put("diachiSV",edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void AnhXa() {
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        btnHuy = (Button) findViewById(R.id.buttonHuyEdit);
        edtDiaChi = (EditText) findViewById(R.id.editTextDiaChiEdit);
        edtHoTen = (EditText) findViewById(R.id.editTextHoTenEdit);
        edtNamSinh = (EditText) findViewById(R.id.editTextNamSinhEdit);

    }
}
