package pl.kimorsolutions.smarthome.homemanagement.ui.home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.kimorsolutions.smarthome.homemanagement.R;
import pl.kimorsolutions.smarthome.homemanagement.ui.home.components.ChartCard;
import pl.kimorsolutions.smarthome.homemanagement.ui.home.components.DashboardTopText;
import pl.kimorsolutions.smarthome.homemanagement.ui.home.components.RoomConditionsCard;

public class HomeFragment extends Fragment {

    private ChartCard temperatureChartCard;
    private ChartCard humidityChartCard;
    private ChartCard pressureChartCard;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        LinearLayout layout = view.findViewById(R.id.homeContainer);
//        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setPadding(25,0,25,0);
        initCharts();
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(new DashboardTopText(requireContext()));
        layout.addView(new RoomConditionsCard(requireContext()));
        layout.addView(createHorizontalGap());
        layout.addView(temperatureChartCard);
        layout.addView(createHorizontalGap());
        layout.addView(humidityChartCard);
        layout.addView(createHorizontalGap());
        layout.addView(pressureChartCard);
        return view;
    }

    protected Space createHorizontalGap(){
        Space space = new Space(requireContext());
        space.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,15));
        return space;
    }

    protected void initCharts(){
        temperatureChartCard= new ChartCard(requireContext(), R.drawable.thermostat,"Temperatura z ostatnich 12 godzin (°C)", Color.rgb(252, 148, 3));
        temperatureChartCard.updateChartData(randomData(20,25));

        humidityChartCard= new ChartCard(requireContext(), R.drawable.humidity,"Wilgotność z ostatnich 12 godzin (%)", Color.rgb(30,30,255));
        humidityChartCard.updateChartData(randomData(40,65));

        pressureChartCard= new ChartCard(requireContext(), R.drawable.pressure,"Ciśnienie z ostatnich 12 godzin (hPa)", Color.rgb(255, 48, 48));
        pressureChartCard.updateChartData(randomData(990,1015));
//        temperatureChartCard.setData(randomData());
        //poprawić
    }

    List<Entry> randomData(int min, int max){
        Random r= new Random();
        List<Entry> randomized = new ArrayList<>();
        for(int hour=-12; hour<0; hour++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                randomized.add(new Entry(hour,r.nextInt(min,max)));
            }
        }
        return randomized;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
