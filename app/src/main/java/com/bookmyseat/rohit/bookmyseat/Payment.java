package com.bookmyseat.rohit.bookmyseat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

import org.w3c.dom.Text;
/*Details
rohit
5529 4203 5061 5465
12/18
333
 */
public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        final CardForm cardform = (CardForm) findViewById(R.id.pay);
        TextView txt=(TextView)findViewById(R.id.payment_amount);
        Button btn=(Button)findViewById(R.id.btn_pay);

        txt.setText("ticket price");
        btn.setText("Pay");

        cardform.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(Payment.this,"Done",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Payment.this,Main2Activity.class));
                finish();
            }
        });


    }
}
