package pl.kimorsolutions.smarthome.homemanagement.ui.home.components;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.material.textview.MaterialTextView;

public class DashboardTopText extends MaterialTextView {
    public DashboardTopText(@NonNull Context context) {
        super(context);
        this.setText("Inteligentny Dom");
        this.setTextAppearance(context,(com.google.android.material.R.style.TextAppearance_Material3_TitleLarge));
        this.setPadding(0,15,0,15);
    }
}
