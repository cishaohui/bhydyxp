package cn.ui.learn.propertyanimationprogrem;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView iv;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        iv = findViewById(R.id.button1);
        initAnimation();
        initData();
    }

    private void initData() {
        Log.d("123456", "initData: ++++++++++++++++++++++");
    }

    private void initAnimation() {

    }

    public void startAnimation(View view){

        //----------------补间动画-----------------
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translation);
//        iv.startAnimation(animation);
        //----------------属性动画-----------------
//        position +=100;
//        iv.setTranslationX(position);
//        iv.setAlpha((float) Math.random());
       //-----------------属性动画第一种------------
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0f, 300f, 500f);
//        oa.setDuration(1000);
//        oa.start();
//        ObjectAnimator oaa = ObjectAnimator.ofFloat(iv, "translationY", 0f, 200f, 500f);
//        oaa.setDuration(1000);
//        oaa.start();
//        ObjectAnimator ooa = ObjectAnimator.ofFloat(iv, "rotationX", 0f, 300f,500f);
//        ooa.setDuration(1000);
//        ooa.start();
        //-----------------属性动画第二种多个动画同时执行------------
        //方法1：
//        @SuppressLint("ObjectAnimatorBinding")
//        final ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "cishaohui", 0f, 100f);
//        oa.setDuration(1000);
//        //设置动画监听
//        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                //动画在执行的过程中，不断地调用此方法
//                oa.getAnimatedFraction();//百分比
//                //得到duration时间内 values当中的某个中间值
//                float value = (float) oa.getAnimatedValue();
//                iv.setScaleX(0.5f+value/300);
//                iv.setScaleY(0.5f+value/300);
//            }
//        });
//        oa.start();
        //方法2：
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 100f,500f,50f);
//        valueAnimator.setDuration(200);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                valueAnimator.getAnimatedFraction();//百分比
//                float value = (float) valueAnimator.getAnimatedValue();
//                iv.setScaleX(0.5f + value / 200);
//                iv.setScaleY(0.5f + value / 200);
//
//            }
//        });
//        valueAnimator.start();
        //方法3：
//        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0.5f, 1f);
//        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.3f, 1f);
//        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("translationX",0f,300f);
//
//        ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(iv, holder1, holder2, holder3);
//        oa.setDuration(1000);
//        oa.start();
        //方法4：
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv,"alpha", 1f,0.7f,1f);
//		ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv,"scaleX", 1f,0.7f,1f);
//		ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv,"scaleY", 1f,0.7f,1f);
//
//		AnimatorSet animatorSet = new AnimatorSet();
//		animatorSet.setDuration(500);
////		animatorSet.play(anim);//执行当个动画
//		animatorSet.playTogether(animator1,animator2,animator3);//同时执行
////		animatorSet.playSequentially(animator1,animator2,animator3);//依次执行动画
//		animatorSet.start();

        		/**
		 * x:匀速
		 * y:加速度   y=1/2*g*t*t
		 * 使用估值器最好实现。
		 */
//		ValueAnimator valueAnimator = new ValueAnimator();
//		valueAnimator.setDuration(4000);
//		valueAnimator.setObjectValues(new PointF(0, 0));
//		//估值器---定义计算规则
//		valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
//
//			@Override
//			public PointF evaluate(float fraction, PointF startValue,
//					PointF endValue) {
//				//拿到每一个时间点的坐标
//				//x=v*t (s秒)
//				PointF pointF = new PointF();
//				pointF.x = 100f*(fraction*4);//初始速度*(执行的百分比*4)
////				pointF.y = 0.5f*9.8f*(fraction*4)*(fraction*4);
//				pointF.y = 0.5f*150f*(fraction*4)*(fraction*4);
//				return pointF;
//			}
//		});
//
//		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//			public void onAnimationUpdate(ValueAnimator animation) {
//				//得到此时间点的坐标
//				PointF pointF = (PointF) animation.getAnimatedValue();
//
//				iv.setX(pointF.x);
//				iv.setY(pointF.y);
//			}
//		});
//		valueAnimator.start();

        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationY", 0f,1100f);
        oa.setDuration(500);
        //设置加速器---
//		oa.setInterpolator(new AccelerateInterpolator(5));
//		oa.setInterpolator(new AccelerateDecelerateInterpolator());
//		oa.setInterpolator(new AnticipateInterpolator(8));
//		oa.setInterpolator(new OvershootInterpolator());
//		oa.setInterpolator(new CycleInterpolator(4));
        oa.setInterpolator(new BounceInterpolator());
        oa.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
