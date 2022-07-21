package com.fox.mydialogfragmentexample

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import com.fox.mydialogfragmentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpleDialog.setOnClickListener {
            SimpleDialog.newInstance(getString(R.string.label_logout), getString(R.string.msg_logout)).show(supportFragmentManager, SimpleDialog.TAG)
        }

        binding.btnAlertDialog.setOnClickListener {
            onCreateDialog().show()
        }

        binding.btnExActivity.setOnClickListener {
            var myIntent = Intent(this, AlertDialogActivity::class.java )
            startActivity(myIntent)
        }
    }

     fun onCreateDialog(): Dialog {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog")
        builder.setMessage("Hello! I am Alert Dialog")
            builder.setIcon(R.drawable.ic_baseline_add_alert_24)

        builder.setPositiveButton("Ok", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                println("Positive button pressed")

            }
        })
        builder.setNegativeButton("Cancel", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                println("Negative button pressed")
                onDetachedFromWindow()
            }
        })
         builder.setNeutralButton("Netural", object: DialogInterface.OnClickListener {
             override fun onClick(dialog:DialogInterface, which:Int) {
                 println("Neutral button pressed")

             }
         })
        return builder.create()
    }

//    fun newOnCreateAlertDialog(view: View) {
//        val builder = AlertDialog.Builder(this)
//
//        with(builder){
//            setTitle("Alert Dialog")
//            setMessage("Hello! I am Alert Dialog")
//            setIcon(R.drawable.ic_baseline_add_alert_24)
//            setNegativeButton(android.R.string.cancel, null)
//            setNegativeButtonIcon(resources.getDrawable(R.drawable.ic_cancel))
//
//            }
//
//        }
//    }
}