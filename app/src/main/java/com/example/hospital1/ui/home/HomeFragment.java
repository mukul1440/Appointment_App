package com.example.hospital1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hospital1.R;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    String[] Names = {"Doctor1", "Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"};
    int[] images = {R.drawable.drawer_logo, R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo,R.drawable.drawer_logo};
    ArrayAdapter<String> adapter;
    ListView listView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listView = v.findViewById(R.id.home_list);


        CustomAdaptor customAdaptor = new CustomAdaptor();
        listView.setAdapter(customAdaptor);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }


    class CustomAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.listview, null);
            ImageView i1 = (ImageView) view1.findViewById(R.id.imageView2);
            TextView t1 = (TextView) view1.findViewById(R.id.list);
            i1.setImageResource(images[position]);
            t1.setText(Names[position]);
            return view1;
        }

    }
    }

