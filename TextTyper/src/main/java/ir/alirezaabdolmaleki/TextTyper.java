package ir.alirezaabdolmaleki;
import android.annotation.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import ir.alirezaabdolmaleki.textTyper.Typer.*;
import ir.alirezaabdolmaleki.textTyper.*;

public class TextTyper extends TextView
{
	Context contex;
	int CRText =0;
	boolean continue_or_stop = true;
	
	public static int SOUND_RES_ID;
	public static float SOUND_VOULUME;
	public static boolean ENABLE = false;
	public static Context context;
	
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextTyper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public TextTyper(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public TextTyper(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public TextTyper(Context context) {
        super(context);
        init(null);
    }

	

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            
            a.recycle();
        }
    }
	
	public void typeText(String text, final int durationMS)	
	{
		
		Texts tex = new Texts(text);
		final String[] tx = tex.getText();



		final Handler mHandler = new Handler();
		new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (continue_or_stop) {
						try {
							Thread.sleep(durationMS); // every 5 seconds
							mHandler.post(new Runnable() {

									@Override
									public void run() {


										if(tx.length == CRText){
											continue_or_stop = false;
										}else{
											append(tx[CRText++]);}
										
											if(Sound.ENABLE)
											{
											
												MediaPlayer player = MediaPlayer.create(getContext(),SOUND_RES_ID); 
												
												player.setVolume(SOUND_VOULUME, SOUND_VOULUME);
												player.start();
												
											}
									}
								});
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}).start();
		
	}
	public void setSound(int resSound, int volume){
		
		Sound.ENABLE = true;
		SOUND_RES_ID = resSound;
		SOUND_VOULUME = (float) volume/10;
		
	}
	public void setFont(String fontName)
	{
		Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
		setTypeface(myTypeface);	
	}

	
	}
