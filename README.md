# Business Hours Picker
A business hours picker lib for android

[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19) [![](https://jitpack.io/v/bashizip/business-hours-picker.svg)](https://jitpack.io/#bashizip/business-hours-picker) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Business%20Hours%20Picker-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7540)

Want to add a business hours picker and viewer in your application? Try this library !

![gif](https://github.com/bashizip/business-hours-picker/blob/master/captures/ezgif.com-resize.gif?raw=true)


Support for Android 4.0.3 ( api 19 ) and up

Feel free to fork or issue pull requests on github. Issues can be reported on the github issue tracker.

## Installation

Step 1 : Add jitpack to your build.gradle file



	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



  Step 2 : Add the dependency



 	implementation 'com.github.bashizip:business-hours-picker:v1.0.0'

## Update

Simplified api : one picker, one viewer.

  ## How to use it


First  Add the picker and the viewer you want to use in your layout files. The library has 4 main components,
2 Pickers and 2 viewer respectively :

  **BusinessHoursWeekView**

  Use it to pick a full week of business days from monday to sunday
 ```xml
 <com.bashizip.bhlib.BusinessHoursWeekPicker
        android:id="@+id/bh_picker"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

   Use it to display a full week of business days

 ```xml
    <com.bashizip.bhlib.BusinessHoursWeekView
        android:layout_centerInParent="true"
        android:id="@+id/bh_view"
        android:gravity="center"
        bh:bhTextSize="14"
        bh:bhIcon="@drawable/ic_today_black_24dp"
        bh:bhTodayIcon="@drawable/ic_today_black_24dp"
        bh:bhTextColor="@color/text_default_color"
        bh:bhTodayColor="@color/colorAccent"
        bh:bhTodayTextSize="16"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
 ```

  Then in your java code :

  **The picker activity of fragment**

```java
	  BusinessHoursWeekPicker bh_picker = findViewById(R.id.bh_picker);
	  Button btn_apply = findViewById(R.id.btn_apply);
	     btn_apply.setOnClickListener(view -> {

		   List<BusinessHours> bhs = bh_picker.getBusinessHoursList();

		   // Here do your stuffs with the list

		});
 ```


   **The viewer activity or fragment**

  ```java
        List<BusinessHours> businessHoursList = getList();

       // Just call the setModel method and it's done !
       businessHoursWeekView.setModel(businessHoursList);
 ```


See the full sample app for more details.

  ##Styling
You can style the viewer  using theses attributes :

| Attribute  | Description  |
| ------------ | ------------ |
| bhIcon  | Left icon of the day  |
|bhTextColor   |  Text color |
| bhTextSize  | Test Size  |
| bhIconPadding  | Let icon padding  |
|  bhTextStyle | Defalut text style   |
|  bhTodayStyle | Today  text style ( highlighted)   |
|  bhTodayTextSize | Today  text size|
| bhTodayIcon | Today left icon|





  ## Licence

      MIT License

   	Copyright (c) [2019] [Patrick Bashizi]

  	 Permission is hereby granted, free of charge, to any person obtaining a copy
  	 of this software and associated documentation files (the "Software"), to deal
  	 in the Software without restriction, including without limitation the rights
  	 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  	 copies of the Software, and to permit persons to whom the Software is
   	furnished to do so, subject to the following conditions:

  	 The above copyright notice and this permission notice shall be included in all
   	copies or substantial portions of the Software.

  	 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 	  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  	 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  	 SOFTWARE.











