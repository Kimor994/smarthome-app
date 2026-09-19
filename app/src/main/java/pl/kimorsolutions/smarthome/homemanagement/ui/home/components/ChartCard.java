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

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import pl.kimorsolutions.smarthome.homemanagement.R;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;
import java.util.List;

public class ChartCard extends LinearLayout {

    private int icon;
    private LineChart lineChart;
    public LineChart getLineChart(){
        return lineChart;
    }
    private String text;
    private int  color;
    private Context context;
    public ChartCard(@NonNull Context context, int icon, String text, int color) {
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

        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.OVAL);
        background.setColor(ContextCompat.getColor(context,R.color.blue_700));
        background.setSize(64,64);
        background.setPadding(25,25,25,25);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(icon);
        imageView.setColorFilter(Color.WHITE);
        imageView.setBackground(background);

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

        lineChart = new LineChart(context);
        lineChart.setBackgroundColor(Color.argb(0,0,0,0));
        lineChart.getDescription().setEnabled(false);
        lineChart.setPadding(15,0,15,5);
        lineChart.setMinimumHeight(375);
        lineChart.getAxisLeft().setTextColor(MaterialColors.getColor(this,android.R.attr.textColorPrimary));
        lineChart.getAxisRight().setEnabled(false);
        lineChart.setDrawMarkers(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getXAxis().setTextColor(MaterialColors.getColor(this,android.R.attr.textColorPrimary));
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        updateChartData(new ArrayList<>());
        content.addView(layoutHeader);
        content.addView(lineChart);

        infoLayout.addView(content);

        return infoLayout;
    }
    public void updateChartData(List<Entry> entries){
        LineDataSet dataSet = new LineDataSet(new ArrayList<>(entries),"");
        dataSet.setColor(color);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setLineWidth(3);
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
    }
}
