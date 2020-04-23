package vn.edu.ntu.nguyendinhhoanglan.nguyendinhhoanglan_59131178_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtDOB;
    EditText edtOHobby;
    RadioGroup rbgSex;
    ArrayList<Integer> hobbies;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews(){
        edtName = findViewById(R.id.edtName);
        edtDOB = findViewById(R.id.edtDateOfBirth);
        edtOHobby = findViewById(R.id.edtOtherHobby);
        rbgSex = findViewById(R.id.rbgSex);

        btnConfirm = findViewById(R.id.btnConfirm);

        hobbies = new ArrayList<>();
        hobbies.add(R.id.cbFilm);
        hobbies.add(R.id.cbMusic);
        hobbies.add(R.id.cbCafe);
        hobbies.add(R.id.cbHome);
        hobbies.add(R.id.cbCook);
    }

    private void addEvents(){
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });
    }

    private void alert(){
        String alertMessage;
        alertMessage =  edtName.getText().toString() + "\n" +
                        "Ngày sinh: " + edtDOB.getText().toString() + "\n" +
                        "Giới tính: ";
        switch (rbgSex.getCheckedRadioButtonId()){
            case R.id.rdbMale:
                alertMessage += "Nam\n";
                break;
            case R.id.rdbFemale:
                alertMessage += "Nữ\n";
                break;
        }

        String hobbiesStr = "";
        ArrayList<CheckBox> temp = new ArrayList<>();
        int j = 0;
        for (Integer i : hobbies) {
            temp.add((CheckBox)findViewById(i));
            if(temp.get(j).isChecked()){
                hobbiesStr += temp.get(j).getText().toString() + ", ";
            }
            j+=1;
        }
        hobbiesStr += edtOHobby.getText().toString();
        alertMessage += "Sở thích: ";
        if(hobbiesStr.isEmpty())
            alertMessage += "Không có";
        else
            alertMessage += hobbiesStr;

        Toast.makeText(getApplicationContext(), alertMessage.toString(), Toast.LENGTH_SHORT).show();
    }
}
