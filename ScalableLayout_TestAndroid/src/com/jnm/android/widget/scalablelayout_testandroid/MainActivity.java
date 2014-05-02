package com.jnm.android.widget.scalablelayout_testandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jnm.android.widget.ScalableLayout;
import com.jnm.android.widget.ScalableLayout.TextViewWrapContentMode;

public class MainActivity extends Activity {
	private static void log(String pLog) {
		Log.e("ScalableLayout_TestAndroid", "MainActivity] "+pLog);
	}
	
			
	private TextView mTV_Text;
	private ScalableLayout mSL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// init base width and height of scalable layout.
		mSL = new ScalableLayout(this, 400, 400);
		mSL.setBackgroundColor(Color.LTGRAY);
		ScalableLayout.setLoggable();
		
//		RelativeLayout rl = (RelativeLayout)findViewById(R.id.main_relativelayout);
//		RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//		rllp.addRule(RelativeLayout.BELOW, R.id.main_textview);
//		rl.addView(mSL, rllp);
		
		setContentView(mSL);
		
		
		// insert TextView
		TextView tv = new TextView(this);
		tv.setText("test");
		tv.setBackgroundColor(Color.YELLOW);
		mSL.addView(tv, 20f, 40f, 100f, 30f);
		mSL.setScale_TextSize(tv, 20f);
		
		// insert ImageView
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.ic_launcher);
		mSL.addView(iv, 200f, 30f, 50f, 50f);
		
		
		mTV_Text = new EditText(this) {
//			@Override
//			protected void onTextChanged(CharSequence pText, int pStart, int pLengthBefore, int pLengthAfter) {
//			    super.onTextChanged(pText, pStart, pLengthBefore, pLengthAfter);
//				log("getHeight "+getHeight2(getContext(), (String)pText, (int)getTextSize(), getWidth()));
//				log("aa "+pText);
//			}
		};
		mTV_Text.setBackgroundColor(Color.RED);
		mTV_Text.setText("test");
//		mTV_Text.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//			 @SuppressLint("NewApi")
//			 @SuppressWarnings("deprecation")
//			 @Override
//			  public void onGlobalLayout() {
//				log("onGlobalLayout "+mTV_Text.getWidth());
//			   //now we can retrieve the width and height
////			   int width = view.getWidth();
////			   int height = view.getHeight();
//			   //...
//			   //do whatever you want with them
//			   //...
//			   //this is an important step not to keep receiving callbacks:
//			   //we should remove this listener
//			   //I use the function to remove it based on the api level!
//
////			if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
////			    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
////			   else
////			    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//			  }
//			 });
		mSL.addView(mTV_Text, 100, 100, 200, 50);
		mSL.setScale_TextSize(mTV_Text, 30);
//		mTV_Text.setSingleLine();
		
		mSL.setScale_TextViewWrapContentMode(mTV_Text, TextViewWrapContentMode.Vertical, true);
		
//		mTV_Text.addTextChangedListener(new TextWatcher() {
//			@Override
//			public void onTextChanged(CharSequence pS, int pStart, int pBefore, int pCount) { }
//			@Override
//			public void beforeTextChanged(CharSequence pS, int pStart, int pCount, int pAfter) { }
//			@Override
//			public void afterTextChanged(Editable pS) {
//				ScalableLayout.LayoutParams lTV_SLLP = (ScalableLayout.LayoutParams) mTV_Text.getLayoutParams();
//				
//				float lNewViewHeight = getHeight2(mTV_Text.getContext(), (String)pS.toString(), (int)mTV_Text.getTextSize(), mTV_Text.getWidth());
//				float lOldScaleHeight = lTV_SLLP.getScale_Height();
//				float lOldViewHeight = mTV_Text.getHeight();
//				float lNewScaleHeight = (lNewViewHeight * lOldScaleHeight / lOldViewHeight);
//				
//				log("getHeight1 "+lNewViewHeight);
////				log("getHeight2 "+mTV_Text.getHeight());
//				mSL.moveChildView(mTV_Text, lTV_SLLP.getScale_Left(), lTV_SLLP.getScale_Top(), lTV_SLLP.getScale_Width(), lNewScaleHeight);
//				
//				for(int i=0;i<mSL.getChildCount();i++) {
//					View v = mSL.getChildAt(i);
//					if(v == mTV_Text) {
//						continue;
//					}
//					ScalableLayout.LayoutParams lSLLP = (ScalableLayout.LayoutParams) v.getLayoutParams();
//					if(
//						lSLLP.getScale_Top() >= lTV_SLLP.getScale_Top()+lOldScaleHeight &&
//						(
//						( lTV_SLLP.getScale_Left() <= lSLLP.getScale_Left() && lSLLP.getScale_Left() <= lTV_SLLP.getScale_Left()+lTV_SLLP.getScale_Width() )
//						|| 
//						( lTV_SLLP.getScale_Left() <= lSLLP.getScale_Left()+lSLLP.getScale_Width() && lSLLP.getScale_Left()+lSLLP.getScale_Width() <= lTV_SLLP.getScale_Left()+lTV_SLLP.getScale_Width()) 
//						)) {
//						
//						mSL.moveChildView(v, lSLLP.getScale_Left(), lSLLP.getScale_Top()+lNewScaleHeight-lOldScaleHeight);
//					}
//				}
//				mSL.setScaleHeight(mSL.getScaleHeight()+lNewScaleHeight-lOldScaleHeight);
//
//				mSL.requestLayout();
//				mSL.forceLayout();
//			}
//		});

		ImageView iv2 = new ImageView(this);
		iv2.setImageResource(R.drawable.ic_launcher);
		mSL.addView(iv2, 220f, 160f, 50f, 50f);

		TextView tv2 = new TextView(this);
		tv2.setText("test");
		tv2.setBackgroundColor(Color.YELLOW);
		mSL.addView(tv2, 40f, 170f, 100f, 30f);
		mSL.setScale_TextSize(tv2, 20f);
		
		TextView tv3 = new TextView(this);
		tv3.setText("test");
		tv3.setBackgroundColor(Color.YELLOW);
		mSL.addView(tv3, 0f, 210f, 60f, 30f);
		mSL.setScale_TextSize(tv3, 20f);
		
		TextView tv4 = new TextView(this);
		tv4.setText("test");
		tv4.setBackgroundColor(Color.YELLOW);
		mSL.addView(tv4, 150f, 250f, 100f, 30f);
		mSL.setScale_TextSize(tv4, 20f);
		
		TextView tv5 = new TextView(this);
		tv5.setText("test");
		tv5.setBackgroundColor(Color.YELLOW);
		mSL.addView(tv5, 350f, 300f, 100f, 30f);
		mSL.setScale_TextSize(tv5, 20f);
		

		{
			Button btn = new Button(this);
			btn.setText("늘리기");
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View pV) {
					mTV_Text.setText(mTV_Text.getText()+"ㅁ디");
				}
			});
			mSL.addView(btn, 300, 100, 100, 60);
			mSL.setScale_TextSize(btn, 20);
		}
		{
			Button btn = new Button(this);
			btn.setText("줄이기");
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View pV) {
					mTV_Text.setText(mTV_Text.getText().subSequence(0, mTV_Text.getText().length()/2));
				}
			});
			mSL.addView(btn, 301, 170, 100, 60);
			mSL.setScale_TextSize(btn, 20);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}
	
}
