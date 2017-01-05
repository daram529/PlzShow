package com.example.q.plzshow.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.q.plzshow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by q on 2017-01-05.
 */

public class restaurantAdapter extends RecyclerView.Adapter<restaurantAdapter.ViewHolder> {

    private final Activity activity;
    private JSONArray resArray;

    public restaurantAdapter(Activity activity, JSONArray resArray) {
        assert activity != null;

        this.activity = activity;
        this.resArray = resArray;
    }


    @Override
    public int getItemCount() {
        return resArray.length();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_preview, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.position = position;
        final JSONObject resobj = resArray.optJSONObject(position);
        try {
            String url = resobj.getString("url");
            //Bitmap img = new loadPhoto().execute(url).get();
            Bitmap img =
            holder.imageView.setImageBitmap(img);
            holder.res_name.setText(resobj.getString("name"));
            holder.res_loc.setText(resobj.getString("location"));
            holder.res_des.setText(resobj.getString("description"));
            holder.res_phone.setText(resobj.getString("phone"));
//            holder.cardView.setOnClickListener(new View.OnClickListener() {
//            });
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private int position;
        private CardView cardView;
        private ImageView imageView;
        private TextView res_name;
        private TextView res_loc;
        private TextView res_des;
        private TextView res_phone;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.restaurant_cardView);
            imageView = (ImageView) view.findViewById(R.id.res_img);
            res_name = (TextView) view.findViewById(R.id.res_name);
            res_loc = (TextView) view.findViewById(R.id.res_loc);
            res_des = (TextView) view.findViewById(R.id.res_descrip);
            res_phone = (TextView) view.findViewById(R.id.res_phone);
        }
    }
}

//private class loadPhoto extends AsyncTask<String, Void, Bitmap> {
//    ImageView bmImage;
//
//    public loadPhoto () { }
//
//    protected Bitmap doInBackground(String... urls) {
//        String urldisplay = urls[0];
//        Bitmap mIcon11 = null;
//        try {
//            InputStream in = new URL(urldisplay).openStream();
//            mIcon11 = BitmapFactory.decodeStream(in);
//        } catch (Exception e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//        return mIcon11;
//    }
//
//}
