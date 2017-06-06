package org.wheatgenetics.androidlibraryuser;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.Menu
 * android.view.MenuInflater
 * android.view.MenuItem
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.androidlibraryuser.R
 * org.wheatgenetics.javalib.Utils
 * org.wheatgenetics.zxing.BarcodeScanner
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    private android.widget.TextView                          textView                   ;
    private org.wheatgenetics.zxing.BarcodeScanner           barcodeScanner       = null;

    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibraryuser.R.layout.activity_main);

        this.textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibraryuser.R.id.textView);
        assert null != this.textView;
        final int number = 2;
        this.textView.setText(java.lang.String.format("doubleOf(doubleOf(%d)) is %d", number,
            org.wheatgenetics.androidlibrary.Utils.doubleOf(
                org.wheatgenetics.javalib.Utils.doubleOf(number))));
    }

    @java.lang.Override
    public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.wheatgenetics.androidlibrary.R.menu.camera_options_menu, menu);
        assert null != menu;
        menu.findItem(org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem).setVisible(true);
        return true;
    }

    @java.lang.Override
    public boolean onOptionsItemSelected(final android.view.MenuItem item)
    {
        assert null != item;
        switch (item.getItemId())
        {
            case org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem:
                if (null == this.barcodeScanner)
                    this.barcodeScanner = new org.wheatgenetics.zxing.BarcodeScanner(this);
                this.barcodeScanner.scan();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @java.lang.Override
    protected void onActivityResult(final int requestCode,
        final int resultCode, final android.content.Intent data)
    {
        java.lang.String barcode = org.wheatgenetics.zxing.BarcodeScanner.parseActivityResult(
            requestCode, resultCode, data);
        if (null == barcode) barcode = "null";

        assert null != this.textView;
        this.textView.setText(barcode);
    }
}