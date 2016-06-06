package com.nammeless.romcontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

@SuppressWarnings({"deprecation"})
public class AboutActivity extends AppCompatActivity {
    private Integer[] teamIds, creditsIds;
    private String[] mTeamLinks, mCreditsLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.aboutToolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        mTeamLinks = getResources().getStringArray(R.array.team_links);
        mCreditsLinks = getResources().getStringArray(R.array.credits_links);
        setUpViews();
    }

    private void setUpViews() {
        LinearLayout teamContainer = (LinearLayout) findViewById(R.id.teamContainerLayout);
        LinearLayout creditsContainer = (LinearLayout) findViewById(R.id.creditsContainerLayout);
        String[] teamArray = getResources().getStringArray(R.array.team_array);
        TypedArray teamIcons = getResources().obtainTypedArray(R.array.team_drawables);
        String[] creditsArray = getResources().getStringArray(R.array.credits_array);
        TypedArray creditsIcons = getResources().obtainTypedArray(R.array.credits_drawables);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        teamIds = new Integer[teamArray.length];
        creditsIds = new Integer[creditsArray.length];
        for (int i = 0; i < teamArray.length; i++) {
            @SuppressLint("InflateParams") View teamView = layoutInflater.inflate(R.layout.row_items_about_rom, null);
            teamIds[i] = View.generateViewId();
            teamView.setId(teamIds[i]);
            ((ImageView) teamView.findViewById(R.id.item_about_icon)).setImageDrawable(getResources().getDrawable(teamIcons.getResourceId(i, -1)));
            ((TextView) teamView.findViewById(R.id.item_about_title)).setText(teamArray[i]);
            assert teamContainer != null;
            teamContainer.addView(teamView);
        }

        for (int i = 0; i < creditsArray.length; i++) {
            @SuppressLint("InflateParams") View creditsView = layoutInflater.inflate(R.layout.row_items_about_rom, null);
            creditsIds[i] = View.generateViewId();
            creditsView.setId(creditsIds[i]);
            ((ImageView) creditsView.findViewById(R.id.item_about_icon)).setImageDrawable(getResources().getDrawable(creditsIcons.getResourceId(i, -1)));
            ((TextView) creditsView.findViewById(R.id.item_about_title)).setText(creditsArray[i]);
            assert creditsContainer != null;
            creditsContainer.addView(creditsView);
        }
        teamIcons.recycle();
        creditsIcons.recycle();
    }

    public void onItemClick(View view) {
        int id = view.getId();
        String link = null;
        if (Arrays.asList(teamIds).contains(id)) {
            link = mTeamLinks[Arrays.asList(teamIds).indexOf(id)];
        } else if (Arrays.asList(creditsIds).contains(id)) {
            link = mCreditsLinks[Arrays.asList(creditsIds).indexOf(id)];
        } else {
            switch (id) {
                case R.id.fb:
                    link = "https://www.facebook.com/Nameless-Rom-503069359858482/";
                    break;
                case R.id.nf:
                    link = "http://www.forum.namelessrom.com/index.php";
                    break;
                case R.id.tel:
                    link = "https://telegram.me/joinchat/AGPCgz8rMCsejJVk2JoDtA";
                    break;
                case R.id.xda:
                    link = "http://forum.xda-developers.com/note-4/snapdragon-dev/rom-nameless-mm-lightfastdeodexed-t3363547";
                    break;
            }
        }
        if (link != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));
            if (getPackageManager().resolveActivity(intent, 0) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(AboutActivity.this, "No application exists that can perform this action", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
