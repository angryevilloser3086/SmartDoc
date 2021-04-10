package com.example.smartdoc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class ProfileActivit : AppCompatActivity() {

    var button_date: ImageButton? = null
    var textview_date: TextView? = null
    var cal: Calendar = Calendar.getInstance()



    @SuppressLint("NewApi", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textview_date = this.text_view_date_1
        button_date = this.btn_picker_date





        imageButton.setOnClickListener {
            val imgbtnIntent = Intent(this,MainActivity::class.java)
            startActivity(imgbtnIntent)
        }
        Toastbutton.setOnClickListener {
           /* isAllFieldsChecked =CheckAllFields()
            if()*/
                Toast.makeText(applicationContext, "Details updated succesfully", Toast.LENGTH_LONG).show()
                val ToastbtnIntent = Intent(this,ChatActivity::class.java)
            startActivity(ToastbtnIntent)
            }


        //aa

        phnum.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            //s: Editable?

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                Toastbutton.isEnabled = mobileValidate(phnum.text.toString())


            }
        })

        Adhar.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            Toastbutton.isEnabled = aadharValidate()
            }

        })

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        btn_picker_date.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@ProfileActivit,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
    }

    @Suppress("NAME_SHADOWING")
    @SuppressLint("ResourceType")
    private fun aadharValidate(): Boolean {
        val p:Pattern = Pattern.compile("[1-9][0-9]{12}")
        val text = getString(R.id.Adhar)
        val m: Matcher = p.matcher(text)
        return m.matches()

    }


    private fun mobileValidate(text: String): Boolean {
        val p:Pattern = Pattern.compile("[6-9][0-9]{9}")
        val m: Matcher = p.matcher(text)
        return m.matches()
    }


    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.time)
    }

    /* btn_picker_date.setOnClickListener { View.OnClickListener {
         val getDate= getInstance()
         val datePicker = DatePickerDialog(this, android.R.Style.Hololight_Dialog_DatePickerDialog.OnDateSetListener { })
     }}*/

    }

