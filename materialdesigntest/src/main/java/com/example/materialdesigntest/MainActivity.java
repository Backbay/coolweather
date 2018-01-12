package com.example.materialdesigntest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private View headerview;
    private TextView mTv_name;
    private TextView mTv_mail;
    private ImageView mImg_header;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ImageView menu_img_setting;
    private TextView menu_tv_setting;
    private RelativeLayout menu_relative;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTableView();
        setListener();


    }

    private void initTableView() {
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.getTabAt(0).select();
        int tabCount = tabLayout.getTabCount();
        System.out.println(tabCount);
        //        tabLayout.setupWithViewPager(Viewpager);





    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //获取最顶层drawerlayout，用来点击菜单项后关闭滑动菜单
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ablum);
        }
        //获取NavigationView实例
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //设置item文本颜色
        //        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        //解决滑动menu(菜单)只显示灰色，设置为null，可以用安卓默认图标
        //        navigationView.setItemIconTintList(null);
        //获取Navigation的HeaderView的控件引用view对象
        //        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        //        drawerToggle.syncState();
        //        drawerLayout.setDrawerListener(drawerToggle);
        headerview = navigationView.getHeaderView(0);
        mImg_header = (ImageView) headerview.findViewById(R.id.img_header);
        mTv_name = (TextView) headerview.findViewById(R.id.nav_view_header_name);
        mTv_mail = (TextView) headerview.findViewById(R.id.nav_view_header_mail);

        menu_relative = (RelativeLayout) findViewById(R.id.menu_relative);

        //        menu_img_setting=(ImageView) navigationView.findViewById(R.id.menu_img_setting);
        //        menu_tv_setting=(TextView) navigationView.findViewById(R.id.nav_view_menu_setting);
        //        menu_img_setting.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast.makeText(MainActivity.this, "这是我的mail", Toast.LENGTH_SHORT).show();
        //                drawerLayout.closeDrawers();
        //            }
        //        });
        //        menu_tv_setting.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast.makeText(MainActivity.this, "这是我的mail2", Toast.LENGTH_SHORT).show();
        //                drawerLayout.closeDrawers();
        //            }
        //        });
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_add:
                Toast.makeText(this, "it is add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_search:
                Toast.makeText(this, "it is search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_at:
                Toast.makeText(this, "it is at", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_about:
                Toast.makeText(this, "it is about", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    private void setListener() {
        //调用滑动菜单header点击事件方法
        setNavigationViewHeaderViewListener();
        //调用滑动菜单menu点击事件方法
        setNavigationViewMenuItemListener();
        fab.setOnClickListener(this);
        menu_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是我的setting", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });
    }

    private void setNavigationViewHeaderViewListener() {
        mImg_header.setOnClickListener(this);
        mTv_name.setOnClickListener(this);
        mTv_mail.setOnClickListener(this);
    }

   /* //设置滑动菜单header点击事件的方法
    private void setNavigationViewHeaderViewListener() {
        mImg_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"这是我的图片", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });

        mTv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"这是我的名字", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });
        mTv_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"这是我的邮箱", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });
    }*/

    //设置滑动菜单menu点击事件的方法
    private void setNavigationViewMenuItemListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.option1:
                        Toast.makeText(MainActivity.this, "这是我的首页", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.option2:
                        Toast.makeText(MainActivity.this, "这是我的通知", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.option3:
                        Toast.makeText(MainActivity.this, "这是我的Blog", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.option4:
                        Toast.makeText(MainActivity.this, "这是我的作品", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.option5:
                        Toast.makeText(MainActivity.this, "这是关于我的", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }

        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_header:
                Toast.makeText(MainActivity.this, "这是我的image", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_view_header_name:
                Toast.makeText(MainActivity.this, "这是我的name", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_view_header_mail:
                Toast.makeText(MainActivity.this, "这是我的mail", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;
            case R.id.fab:
                Snackbar.make(v, "你是谁？", Snackbar.LENGTH_SHORT).setAction("我是yzg", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "回答正确加100分！", Toast.LENGTH_SHORT).show();

                    }
                }).show();
                break;

            default:
                break;
        }
    }
}
