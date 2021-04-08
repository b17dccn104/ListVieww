package com.example.lesson4_ex2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {
    private Activity context;
    private int[] icon;
    private Employee employee;
    private List<Employee> employeeList;

    public EmployeeAdapter(@NonNull Activity context, int[] icon, List<Employee> employeeList) {
        super(context, R.layout.list_employee, employeeList);
        this.context = context;
        this.icon = icon;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(R.layout.list_employee, null, true);

        ImageView iv = convertView.findViewById(R.id.icon);
        TextView tv = convertView.findViewById(R.id.employee);
        CheckBox cb = convertView.findViewById(R.id.sex);
        Button btnXoa = convertView.findViewById(R.id.btnXoa);
        employee = employeeList.get(position);

        tv.setText("ma" + employee.getId() + "-" + employee.getName());
        if (employee.isMale()) {
            iv.setImageResource(icon[0]);
            cb.setChecked(false);
        }
        else {
            iv.setImageResource(icon[1]);
            cb.setChecked(true);
        }
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeList.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
