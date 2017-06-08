package contactdemo.userphoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.user_avatar)
    SimpleDraweeView userAvatar;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }



    @OnClick(R.id.user_avatar)
    public void onViewClicked() {
        Intent intent = new Intent(this,PhotoSettingActivity.class);
        startActivity(intent);
    }
}
