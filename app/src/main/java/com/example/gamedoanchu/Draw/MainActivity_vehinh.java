    package com.example.gamedoanchu.Draw;

    import androidx.appcompat.app.AppCompatActivity;

    import android.graphics.Color;
    import android.graphics.Paint;
    import android.os.Bundle;
    import android.view.Display;
    import android.view.OrientationEventListener;
    import android.view.View;
    import android.view.animation.AnimationUtils;
    import android.graphics.Path;

    import static com.example.gamedoanchu.Draw.Display.colorlist;
    import static com.example.gamedoanchu.Draw.Display.current_brush;
    import static com.example.gamedoanchu.Draw.Display.pathArrayList;

    import com.example.gamedoanchu.R;

    public class MainActivity_vehinh extends AppCompatActivity {
        public static Path path= new Path();
        public static Paint paint_brush=new Paint();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_vehinh);

        }

        public void but(View view){
            view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
        }
        public void tay(View view){
            view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        pathArrayList.clear();
        colorlist.clear();
        path.reset();
        }
        public void xanh(View view){
    paint_brush.setColor(Color.GREEN);
    currentColor(paint_brush.getColor());
        }
        public void doo(View view){
            paint_brush.setColor(Color.RED);
            currentColor(paint_brush.getColor());
        }
        public void tim(View view){
            paint_brush.setColor(Color.MAGENTA);
            currentColor(paint_brush.getColor());
        }
        public void vang(View view){
            paint_brush.setColor(Color.YELLOW);
            currentColor(paint_brush.getColor());
        }
        public void xanhduong(View view){
            paint_brush.setColor(Color.BLUE);
            currentColor(paint_brush.getColor());
        }
        public void currentColor(int c){
        current_brush = c;
        path=new Path();
        }

    }