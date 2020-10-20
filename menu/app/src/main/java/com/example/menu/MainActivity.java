package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThem;
    Button btnSua;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;

        int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.bt_them);
        btnSua = (Button) findViewById(R.id.bt_sua);
        edtMonHoc = (EditText) findViewById(R.id.editText);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Lập trình di động");
        arrayCourse.add("Cơ sở dữ liệu");
        arrayCourse.add("IOS");
        arrayCourse.add("Tin văn phòng");
        arrayCourse.add("Mạng máy tính");


        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayCourse);

        lvMonHoc.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}