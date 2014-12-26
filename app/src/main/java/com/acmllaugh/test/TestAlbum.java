package com.acmllaugh.test;

import java.util.Random;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class TestAlbum extends ActivityInstrumentationTestCase2{
	private static final String TARGET_PACKAGE_ID = "com.fineos.gallery3d";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = 
			"com.fineos.gallery3d.app.AlbumSetActivity";
	private static Class<?>	launcherActivityClass;

	static{
		try{
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	public TestAlbum() throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}
	
	private Solo solo;
	
	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testCanPress(){
		solo.clickOnScreen(390, 525);
		solo.sleep(2000);
		solo.clickOnScreen(142, 290);
		solo.sleep(2000);
		Random random = new Random(System.currentTimeMillis());
		for(int i = 0; i < 5000; ++i){
			int num = random.nextInt();
			int nextDirection = num % 2;
			if(nextDirection == 0){
				solo.drag(548, 212, 793, 784, 1);
//				solo.scrollToSide(Solo.RIGHT, 0.3f);
			}else{
				solo.drag(212, 548, 793, 784, 1);
			}
			solo.sleep(100);
		}

	}
	
	@Override
	protected void tearDown() throws Exception {
		try{
			solo.finalize();
		}catch(Throwable e){
			e.printStackTrace();
		}
		//getActivity().finish();
		super.tearDown();
	}
}
