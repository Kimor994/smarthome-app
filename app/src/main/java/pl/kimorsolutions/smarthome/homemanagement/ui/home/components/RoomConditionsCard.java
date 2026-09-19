package pl.kimorsolutions.smarthome.homemanagement.ui.home.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.color.MaterialColors;

import org.jetbrains.annotations.NotNull;

import pl.kimorsolutions.smarthome.homemanagement.R;

public class RoomConditionsCard extends LinearLayout {
    public RoomConditionsCard(@NonNull Context context) {
        super(context);

        addView(getInformationalComponent(context,R.drawable.thermometer,"20,00 °C"));
        addView(ComponentUtils.createHorizontalGap(context));
        addView(getInformationalComponent(context,R.drawable.humidity,"100%"));
        addView(ComponentUtils.createHorizontalGap(context));
        addView(getInformationalComponent(context,R.drawable.pressure,"1013 hPa"));

        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    protected MaterialCardView getInformationalComponent(@NotNull Context context, int drawable, String value){
        MaterialCardView infoLayout = new MaterialCardView(context,null,com.google.android.material.R.attr.materialCardViewFilledStyle);
        infoLayout.setPadding(15,10,15,10);
        infoLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        ImageView icon = new ImageView(context);
        icon.setImageResource(drawable);
        icon.setColorFilter(Color.WHITE);

        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.OVAL);
        background.setColor(ContextCompat.getColor(context,R.color.blue_700));
        background.setSize(64,64);
//        background.setPadding(10,10,10,10);

        background.setPadding(25,25,25,25);

//        LayoutParams iconSize = new LinearLayout.LayoutParams(80,80);
//        icon.setLayoutParams(iconSize);
        icon.setBackground(background);

        TextView text = new TextView(context);
        text.setPadding(25,0,0,0);
        text.setText(value);
        text.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleSmall);
        text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setGravity(Gravity.CENTER_HORIZONTAL);
//        text.setTextColor(MaterialColors.getColor(this,com.google.android.material.R.attr.colorOnPrimary));
        text.setSingleLine(true);
        text.setMaxLines(1);
        text.setEllipsize(null);
//        text.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        LinearLayout layout = new LinearLayout(context);
        layout.setPadding(20,20,20,20);
        layout.setGravity(Gravity.CENTER_VERTICAL);
        layout.setOrientation(HORIZONTAL);
        layout.addView(icon);
        layout.addView(text);

        infoLayout.addView(layout);

        return infoLayout;
    }

}

