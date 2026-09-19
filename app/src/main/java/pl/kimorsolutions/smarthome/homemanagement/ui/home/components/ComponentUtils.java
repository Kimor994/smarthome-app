package pl.kimorsolutions.smarthome.homemanagement.ui.home.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.textview.MaterialTextView;

import java.util.HashMap;
import java.util.List;

import pl.kimorsolutions.smarthome.homemanagement.R;

public class ComponentUtils {
    public static Space createHorizontalGap(Context context){
        Space horizontalSpace = new Space(context);
        horizontalSpace.setLayoutParams(new FrameLayout.LayoutParams(15,10));
        return horizontalSpace;
    }
    public static MaterialCardView createMaterialCard(int icon, String header, String lore, HashMap<Object,Object> additionalDetails){

    }
    public static LinearLayout createTabHeader(Context context, String text){
        LinearLayout layout = new LinearLayout(context);
        TextView textView =  new TextView(context);
        textView.setTextColor(MaterialColors.getColor(layout, android.R.attr.textColorPrimary));
        textView.setGravity(View.TEXT_ALIGNMENT_VIEW_START);
        textView.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleLarge);
        textView.setText(text);;
        layout.addView(textView);;
        return layout;

    }
    public static LinearLayout createHeader(Context context, int icon, String text){
        LinearLayout layout = new LinearLayout(context);
        layout.setGravity(Gravity.CENTER_VERTICAL);
        ImageView view = new ImageView(context);
        view.setColorFilter(Color.WHITE);
        view.setImageResource(icon);

        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.OVAL);
        background.setColor(ContextCompat.getColor(context, R.color.blue_300));
        background.setSize(96,96);
        background.setPadding(25,25,25,25);
        view.setBackground(background);

        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(25,0,0,0);
        textView.setText(text);
        textView.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleMedium);

        layout.addView(view);
        layout.addView(textView);

        return layout;
    }

}
