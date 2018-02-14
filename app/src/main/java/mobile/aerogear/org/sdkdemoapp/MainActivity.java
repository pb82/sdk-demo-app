package mobile.aerogear.org.sdkdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.aerogear.mobile.auth.AuthService;
import org.aerogear.mobile.core.MobileCore;
import org.aerogear.mobile.metrics.MetricsService;


public class MainActivity extends AppCompatActivity {
    private MobileCore core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.core = MobileCore.init(getApplicationContext());
        MetricsService metrics = this.core.getInstance(MetricsService.class);
        AuthService auth = this.core.getInstance(AuthService.class);

        auth.init(getApplicationContext(), null);

        // It's important that the metrics init is the last
        metrics.init(getApplicationContext());
    }
}
