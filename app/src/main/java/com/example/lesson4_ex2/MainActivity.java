package com.example.lesson4_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<employeeList> extends AppCompatActivity {
    private ListView listView;
    private EditText maNV, tenNV;
    private RadioButton male, female;
    private Button btn;
    private int[] icon= {R.drawable.male, R.drawable.female};
    private Employee employee;
    private List<Employee> employeeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final EmployeeAdapter adapter = new EmployeeAdapter(this, icon, employeeList);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employee = new Employee();
                employee.setId(Integer.parseInt(maNV.getText().toString()));
                employee.setName(tenNV.getText().toString());
                if (male.isChecked())
                    employee.setSex(true);
                if (female.isChecked())
                    employee.setSex(false);
                employeeList.add(employee);

                listView.setAdapter(adapter);
            }
        });
    }

    private void init(){
        listView = findViewById(R.id.listView);
        maNV = findViewById(R.id.maNV);
        tenNV = findViewById(R.id.tenNV);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        btn = findViewById(R.id.btn);
        employeeList = new ArrayList<>();
    }
}