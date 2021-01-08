package com.example.pristine_e_comerce.ui.shopbycategory.shopbycategoryfragment.productpagedetails.productpagedetailsAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.pristine_e_comerce.R;
import com.example.pristine_e_comerce.ui.shopbycategory.shopbycategoryModel.GetAddressModel;


import java.util.List;

public class BuyNowProductAddressAdapter extends BaseAdapter {
    public List<GetAddressModel> listDataGetAddress;
    public Activity activity;
    GetAddressModel userSelectAddress;
   public BuyNowProductAddressAdapter(Activity activity,List<GetAddressModel> listDataGetAddress,GetAddressModel userSelectAddress) {
       this.activity = activity;
       this.listDataGetAddress = listDataGetAddress;
       this.userSelectAddress = userSelectAddress;
   }
    @Override
    public int getCount() {
        return listDataGetAddress.size();
    }

    @Override
    public Object getItem(int position) {
        return listDataGetAddress.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.buy_now_slect_address_list_layout, null);
        TextView tv_Name = convertView.findViewById(R.id.tv_Name);
        TextView tv_address = convertView.findViewById(R.id.tv_address);
        TextView tv_nearby_landmark = convertView.findViewById(R.id.tv_nearby_landmark);
        TextView tv_pincode_state=convertView.findViewById(R.id.tv_pincode_state);
        RadioButton select_address=(RadioButton) convertView.findViewById(R.id.select_address);
        select_address.setChecked(listDataGetAddress.get(position).selected_address);
        TableLayout tableyout = convertView.findViewById(R.id.tableyout);

        if(position==0){
            tableyout.setVisibility(View.VISIBLE);
        }else {
            tableyout.setVisibility(View.GONE);
        }
        select_address.setOnClickListener(v -> {
            for(int i=0;i<this.listDataGetAddress.size();i++){
                listDataGetAddress.get(i).selected_address=false;
            }
            listDataGetAddress.get(position).selected_address=true;
            userSelectAddress=  listDataGetAddress.get(position);
            notifyDataSetChanged();
        });
        tv_Name.setText(listDataGetAddress.get(position).full_name);
        tv_address.setText(listDataGetAddress.get(position).address);
        tv_nearby_landmark.setText(listDataGetAddress.get(position).nearby_landmark);
        tv_pincode_state.setText(listDataGetAddress.get(position).pincode+" ("+listDataGetAddress.get(position).state+")");

        return convertView;


    }
}
