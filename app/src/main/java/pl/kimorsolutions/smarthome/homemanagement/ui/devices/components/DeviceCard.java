package pl.kimorsolutions.smarthome.homemanagement.ui.devices.components;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;

public class DeviceCard extends LinearLayout {

    private int icon;
    private String text;
    private int  color;
    private Context context;
    public DeviceCard(@NonNull Context context, int icon, String text, int color) {
        super(context);
        this.icon=icon;
        this.text=text;
        this.color=color;
        this.context=context;

        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        MaterialCardView card = createCard();
        card.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        addView(card);
    }

    protected MaterialCardView createCard(){
        MaterialCardView infoLayout = new MaterialCardView(context,null,com.google.android.material.R.attr.materialCardViewFilledStyle);
        infoLayout.setPadding(15,10,15,10);
//
//        GradientDrawable background = new GradientDrawable();
//        background.setShape(GradientDrawable.OVAL);
//        background.setColor(ContextCompat.getColor(context, R.color.blue_700));
//        background.setSize(64, 64);
//        background.setPadding(25, 25, 25, 25);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(icon);
        imageView.setColorFilter(Color.WHITE);
//        imageView.setBackground(background);

        TextView textCaption = new TextView(context);
        textCaption.setPadding(25,0,0,0);
        textCaption.setText(text);
        textCaption.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleMedium);

        LinearLayout layoutHeader = new LinearLayout(context);
        layoutHeader.setPadding(20,20,20,20);
        layoutHeader.setGravity(Gravity.CENTER_VERTICAL);
        layoutHeader.setOrientation(HORIZONTAL);
        layoutHeader.addView(imageView);
        layoutHeader.addView(textCaption);

        LinearLayout content = new LinearLayout(context);
        content.setOrientation(VERTICAL);

        content.addView(layoutHeader);


        infoLayout.addView(content);

        return infoLayout;
    }
}
