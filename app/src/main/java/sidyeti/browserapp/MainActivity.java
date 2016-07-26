package sidyeti.browserapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    Button bt1, bt2, bt3, bt4, bt5;
    EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);
        wv = (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new WebCont());
        bt1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                String url = et.getText().toString();
                wv.loadUrl("http://" + url);
            }
        });

        bt5 = (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                wv.goBack();
            }
        });

        bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                wv.goForward();
            }
        });

        bt4 = (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                wv.reload();
            }
        });
    }
}


class WebCont extends WebViewClient
{
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        view.loadUrl(url);
        return true;
    }
}