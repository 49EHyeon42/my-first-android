package com.cookandroid.trytosolve7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button btn1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사용자 정보 입력 (수정)");

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(
                        MainActivity.this, R.layout.dialog, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtEmail.setText(tvEmail.getText().toString());

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvName.setText(dlgEdtName.getText().toString());
                                tvEmail.setText(dlgEdtEmail.getText().toString());
                            }
                        });

                dlg.setNegativeButton("최소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = new Toast(MainActivity.this);

                                Display display =
                                        ((WindowManager) getSystemService(WINDOW_SERVICE))
                                                .getDefaultDisplay();

                                int xOffset = (int) (Math.random() * display.getWidth());
                                int yOffset = (int) (Math.random() * display.getHeight());

                                toast.setGravity(Gravity.TOP | Gravity.LEFT,
                                        xOffset, yOffset);

                                toastView = (View) View.inflate(
                                        MainActivity.this, R.layout.toast, null);
                                toastText = (TextView) toastView.findViewById(R.id.toastText);
                                toastText.setText("취소했습니다");
                                toast.setView(toastView);
                                toast.show();
                            }
                        });
                dlg.show();
            }
        });
    }
}