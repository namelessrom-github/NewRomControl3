package com.nammeless.romcontrol;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wuby on 01/06/16.
 */
public class AboutFragment extends Fragment {

    ListView lv;
    String[] names;
    int [] icons={R.drawable.ic_aditya,
                  R.drawable.ic_florian,
                  R.drawable.ic_senthil,
                  R.drawable.ic_psyntific,
            R.drawable.ic_lex,
            R.drawable.ic_coolfire,
    R.drawable.ic_anna,
            R.drawable.ic_wuby986,
            R.drawable.ic_kmokhtar79,
            R.drawable.ic_tdunham,
            R.drawable.ic_remuntada78,
            R.drawable.ic_martillero};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootview = inflater.inflate(R.layout.about_layout, container , false);
        ImageView fb = (ImageView) rootview.findViewById(R.id.fb);
        fb.setOnClickListener(onClickListener);
        ImageView nf = (ImageView) rootview.findViewById(R.id.nf);
        nf.setOnClickListener(onClickListener);
        ImageView tel = (ImageView) rootview.findViewById(R.id.tel);
        tel.setOnClickListener(onClickListener);
        ImageView xda = (ImageView) rootview.findViewById(R.id.xda);
        xda.setOnClickListener(onClickListener);
        names = getResources().getStringArray(R.array.about_us);
        lv=(ListView) rootview.findViewById(R.id.list_view);

        lv.setAdapter(new CustomAdapter(icons));
        return rootview;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.fb:
                    Intent fb = new Intent(Intent.ACTION_VIEW);
                    fb.setData(Uri.parse("https://www.facebook.com/Nameless-Rom-503069359858482/"));
                    startActivity(fb);
                    break;
                case R.id.nf:
                    Intent nf = new Intent(Intent.ACTION_VIEW);
                    nf.setData(Uri.parse("http://www.forum.namelessrom.com/index.php"));
                    startActivity(nf);
                    break;
                case R.id.tel:
                    Intent tel = new Intent(Intent.ACTION_VIEW);
                    tel.setData(Uri.parse("https://telegram.me/joinchat/AGPCgz8rMCsejJVk2JoDtA"));
                    startActivity(tel);
                    break;
                case R.id.xda:
                    Intent xda = new Intent(Intent.ACTION_VIEW);
                    xda.setData(Uri.parse("http://forum.xda-developers.com/note-4/snapdragon-dev/rom-nameless-mm-lightfastdeodexed-t3363547"));
                    startActivity(xda);
                    break;
            }
        }
    };

    public class CustomAdapter extends BaseAdapter {
        Intent intent;
        String [] result;

        int [] imageId;
        LayoutInflater inflater;
        public CustomAdapter(int[] icons) {
            // TODO Auto-generated constructor stub

            result = getResources().getStringArray(R.array.about_us);
            imageId=icons;
            inflater = ( LayoutInflater ) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder
        {
            TextView tv;
            ImageView img;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder=new Holder();
            View rowView;
            rowView = inflater.inflate(R.layout.row_items_about_rom, null);
            holder.tv=(TextView) rowView.findViewById(R.id.item_about_title);
            holder.img=(ImageView) rowView.findViewById(R.id.item_about_icon);
            holder.tv.setText(result[position]);
            holder.img.setImageResource(imageId[position]);
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=5750672"));
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=2875091"));
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=6773050"));
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=4804849"));
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=227668"));
                            startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=4714483"));
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=5493353"));
                            startActivity(intent);
                            break;
                        case 7:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=4819130"));
                            startActivity(intent);
                            break;
                        case 8:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=1042140"));
                            startActivity(intent);
                            break;
                        case 9:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=5292754"));
                            startActivity(intent);
                            break;
                        case 10:
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("http://forum.xda-developers.com/member.php?u=4830018"));
                            startActivity(intent);
                            break;
                    }

                }});
            return rowView;
        }
    }
}