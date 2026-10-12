// -------------------res/layout/grid_item.xml-------------------

```xml
<?xml version="1.0" encoding="utf-8"?>
<ImageView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/imageView"
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:layout_gravity="center"
    android:scaleType="centerCrop"
    android:padding="5dp" />
```
// -------------------res/layout/activity_main.xml-------------------

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp">

    <GridView
        android:id="@+id/gridView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:numColumns="3"
        android:verticalSpacing="10dp"
        android:horizontalSpacing="10dp"
        android:stretchMode="columnWidth"
        android:gravity="center" />

</LinearLayout>
```
// -------------------MainActivity.java-------------------

```java
package com.example.gridalert;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = {
        R.drawable.apple,
        R.drawable.pineapple,
        R.drawable.banana,
        R.drawable.strawberry,
        R.drawable.grapes,
        R.drawable.pear
    };

    String[] names = {
        "Apple",
        "pineapple",
        "banana",
        "strawberry",
        "Grapes",
        "pear"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);

        ImageAdapter adapter = new ImageAdapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(MainActivity.this)
                .setTitle("Selected Image")
                .setMessage("You selected: " + names[position])
                .setPositiveButton("OK", null)
                .show();
        });
    }

    class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(
                int position,
                View convertView,
                ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater()
                    .inflate(R.layout.grid_item, parent, false);
            }

            ImageView imageView =
                convertView.findViewById(R.id.imageView);

            imageView.setImageResource(images[position]);

            return convertView;
        }
    }
}
```
