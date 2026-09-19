package pl.kimorsolutions.smarthome.homemanagement.ui.devices;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import pl.kimorsolutions.smarthome.homemanagement.R;
import pl.kimorsolutions.smarthome.homemanagement.ui.home.HomeViewModel;
import pl.kimorsolutions.smarthome.homemanagement.ui.home.components.ComponentUtils;

public class DevicesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DevicesViewModel devicesViewModel =
                new ViewModelProvider(this).get(DevicesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_devices,container,false);
        LinearLayout layout = view.findViewById(R.id.devicesContainer);
        layout.setPadding(25,0,25,0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(ComponentUtils.createTabHeader(requireContext(),"Urządzenia"));
        layout.addView();
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

}