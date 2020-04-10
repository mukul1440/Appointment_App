package com.example.hospital1;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class cancel extends Fragment {

    private CancelViewModel mViewModel;
    String[] Names = {"one", "two"};
    int[] images = {R.drawable.download, R.drawable.drawer_logo};
    ArrayAdapter<String> adapter;
    ListView listView;

    public static cancel newInstance() {
        return new cancel();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cancel_fragment, container, false);
        listView = v.findViewById(R.id.cancel_list);


        CustomAdaptor customAdaptor = new CustomAdaptor();
        listView.setAdapter(customAdaptor);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CancelViewModel.class);
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

