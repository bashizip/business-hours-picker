# Business Hours Picker
A business hours picker lib for android *

[![](https://jitpack.io/v/bashizip/business-hours-picker.svg)](https://jitpack.io/#bashizip/business-hours-picker)

Want to add a business hours picker and viewer in your application? Try this library ! 


![capture1](https://raw.githubusercontent.com/bashizip/business-hours-picker/master/captures/device-2019-02-27-224116.png)


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
  
    implementation 'com.github.bashizip:business-hours-picker:v1.0.0-beta.2'
   
  ## How to use it 
  
   
First  Add the picker and the viewer you want to use in your layout files. The library has 4 main components,
2 Pickers and 2 viewer respectively :

**BusinessHoursPicker**

 Use it to pick a single business day

    <com.bashizip.bhlib.BusinessHoursPicker
        app:dayOfWeek="Monday"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
  **BusinessHoursWeekView**
  
  Use it to pick a full week of business days from monday to sunday
  
   <com.bashizip.bhlib.BusinessHoursWeekView
        android:id="@+id/bh_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
   **BusinessHoursView**
    
    Use it to display a single business day
    
     <com.bashizip.bhlib.BusinessHourView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
   **BusinessHoursWeekView**
     
    Use it to display a full week of business days 
    
    <com.bashizip.bhlib.BusinessHoursWeekView
        android:id="@+id/bh_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
  Then in your java code :
  
  **The picker activity of fragment**
  
        BusinessHoursWeekPicker bh_picker = findViewById(R.id.bh_picker);
        Button btn_apply = findViewById(R.id.btn_apply);

        btn_apply.setOnClickListener(view -> {

            List<BusinessHours> bhs = bh_picker.getBusinessHoursList();
            
            // Here do your stuffs with the list
            
            //In this example we pass it to another activity for viewing
            Intent intent = new Intent(this, ViewerActivity.class);
            intent.putExtra(BH_LIST, (Serializable) bhs);
            startActivity(intent);

        });
        
   **The viewer activity or fragment**
   
        Intent intent = getIntent();
        List<BusinessHours> businessHoursList = (List<BusinessHours>) intent.getSerializableExtra(MainActivity.BH_LIST);
       
       // Just call the setModel method and it's done !
       businessHoursWeekView.setModel(businessHoursList);
       
    
    See the full sample app for more details
       

  

   
  
  
  
  
  

