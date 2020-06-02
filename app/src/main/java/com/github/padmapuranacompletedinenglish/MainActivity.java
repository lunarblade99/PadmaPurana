package com.github.padmapuranacompletedinenglish;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.padmapuranacompletedinenglish.menu.DrawerAdapter;
import com.github.padmapuranacompletedinenglish.menu.DrawerItem;
import com.github.padmapuranacompletedinenglish.menu.SimpleItem;
import com.github.padmapuranacompletedinenglish.menu.SpaceItem;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener,View.OnClickListener {

    private static final int POS_DASHBOARD = 0;
    private static final int POS_ACCOUNT = 1;
    private static final int POS_MESSAGES = 2;
    private static final int POS_CART = 3;
    private static final int POS_LOGOUT = 5;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_MESSAGES),
                createItemFor(POS_CART),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);

        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.ten).setOnClickListener(this);

    }

    @Override
    public void onItemSelected(int position) {
        if (position == POS_LOGOUT) {
            finish();
        }
        else if (position == POS_ACCOUNT) {
            Intent intent = new Intent(this, Indexing.class);
            startActivity(intent);
        }
        else if (position == POS_MESSAGES) {
            Intent intent = new Intent(this, Preface.class);
            startActivity(intent);
        }
        else if (position == POS_CART) {
            Intent intent = new Intent(this, Aboutme.class);
            startActivity(intent);
        }
        slidingRootNav.closeMenu();

    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.one)
        {
            Intent intent = new Intent(MainActivity.this, pdf1.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.two)
        {
            Intent intent = new Intent(MainActivity.this, pdf2.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.three)
        {
            Intent intent = new Intent(MainActivity.this, pdf3.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.four)
        {
            Intent intent = new Intent(MainActivity.this, pdf4.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.five)
        {
            Intent intent = new Intent(MainActivity.this, pdf5.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.six)
        {
            Intent intent = new Intent(MainActivity.this, pdf6.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.seven)
        {
            Intent intent = new Intent(MainActivity.this, pdf7.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.eight)
        {
            Intent intent = new Intent(MainActivity.this, pdf8.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.nine)
        {
            Intent intent = new Intent(MainActivity.this, pdf9.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.ten)
        {
            Intent intent = new Intent(MainActivity.this, pdf10.class);
            startActivity(intent);
        }
    }
}
