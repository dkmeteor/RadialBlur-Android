# Demo
![Examples list](https://raw.githubusercontent.com/dkmeteor/MotionBlur-Android/master/release/blur_center.png)

![Examples list](https://raw.githubusercontent.com/dkmeteor/MotionBlur-Android/master/release/blur_translate.png)

# How to use

add dependence

    compile 'com.dk.image.process.radialblur:library:0.1.0@aar'

Or just copy `com.dk.image.process.blur.RadialBlur` to your projct and call static functions:

	MotionBlur.doMotionBlur(Bitmap src, int dx, int dy)
	MotionBlur.doMotionBlur(Bitmap src, int centerX, int centerY, float factor) 

You can check codes in demo project.

	Bitmap mSrc = BitmapFactory.decodeResource(getResources(), R.drawable.charming);
	mImage.setImageBitmap(MotionBlur.doMotionBlur(mSrc, 400, 400, 0.02f));

# License
Copyright (c) 2015 [Dean Ding](http://dk-exp.com)

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)