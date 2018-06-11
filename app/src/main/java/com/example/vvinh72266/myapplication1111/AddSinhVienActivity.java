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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AddSinhVienActivity extends AppCompatActivity {

    EditText edtHoTen, edtNamSinh, edtDiaChi;
    Button btnThem, btnHuy;

    String urlInsert ="http://10.45.6.140/androidwebservice/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        
        AnhXa();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hoten = edtHoTen.getText().toString().trim();
                String namsinh = edtNamSinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();

                if(hoten.isEmpty()||namsinh.isEmpty()||diachi.isEmpty()) {
                    Toast.makeText(AddSinhVienActivity.this, "vui long nhap lai", Toast.LENGTH_SHORT).show();
                }else{
                    ThemSinhVien(urlInsert);

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

    private  void ThemSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("ss")){
                            Toast.makeText(AddSinhVienActivity.this, "ss", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddSinhVienActivity.this, MainActivity.class));
                        }else {
                            Toast.makeText(AddSinhVienActivity.this, "fail", Toast.LENGTH_SHORT).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddSinhVienActivity.this, "xay ra loi", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","Loi"+error.toString());

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("hotenSV",edtHoTen.getText().toString().trim());
                params.put("namsinhSV",edtNamSinh.getText().toString().trim());
                params.put("diachiSV",edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        btnHuy = (Button) findViewById(R.id.buttonHuyThem);
        btnThem = (Button) findViewById(R.id.buttonThem);
        edtDiaChi = (EditText) findViewById(R.id.editTextDiaChi);
        edtHoTen = (EditText) findViewById(R.id.editTextHoTen);
        edtNamSinh = (EditText) findViewById(R.id.editTextNamSinh);
    }

}
