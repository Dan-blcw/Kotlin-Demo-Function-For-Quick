package com.Dan.demo

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.Dan.demo.databinding.ActivityMainBinding
import com.Dan.demo.databinding.CustomDialogBinding
import java.util.Calendar


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var diolog: AlertDialog
    lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Xy ly su kien
        /*
            btn.setOnClickListener{
                -Thuc hien-
                val a = edtNhapA.text.toString().toInt()
                val b = edtNhapB.text.toString().toInt()
                val k = A + B
                set lai doi tuong can set
                VD edtKq.setText(kq.toString())
                ....
            }
        */

        //AutoCompleteTextView
        setupAutoCTView()

        //#list view
        setupListView()

        //Spinner kotlin - Drop-Down Menu kotlin
        /*
            Giong list view, thong qua lop trung gian roi tao 1 con roi thay the
            va spChoose.adapter = con roi thay the
        */
        setupSpinnerCoBan()

        //DatePicker va TimePicker
        setupDatePicker()

        //Intent
        setupIntent()

        //Recycler
        setupRecycler()

        //contextMenu() -
        registerForContextMenu(binding.txtContextMenu)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //1.menu_demo_item - menu
//        menuInflater.inflate(R.menu.menu_demo_item,menu)

        //2. icon_in_menu - đặc tả icon trong menu
        menuInflater.inflate(R.menu.icon_in_menu,menu)

        /*
            //1 cách khác là tự add value vô(xem lại trong contextMenu)
            //add(int group id, int itemId, int order, CharSequence title)
            int order - thứ tự vị trí trong menu
            menu?.add(1,1,1,"item1")
            menu?.add(1,2,2,"item2")
            menu?.add(1,3,3,"item3")

            var submenu = menu?.addSubMenu("Title Menu")
            // tự động check tại male setChecked(true)
            submenu?.add(2,21,1,"Male").setChecked(true)
            submenu?.add(2,21,2,"Female")

            #setGroupCheckable(
                      int group,
                      boolean checkable
                      boolean exclusive)
                 group - id của Group muốn có nút check
                 checkable - true để cho phép dấu kiểm,
                           - false không cho phép, mặc định sẽ là false
                 exclusive - chọn true để chỉ được chọn 1 item trong group
                           - chọn false tích chọn được nhiều lựa chọn


            submenu?.setGroupCheckable(2,true,true)
            return super.onCreateOptionsMenu(menu)
        */
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuSearchItem -> Toast.makeText(this@MainActivity,"you click on Search Item",Toast.LENGTH_SHORT).show()
            R.id.mnuexit -> Toast.makeText(this@MainActivity,"you click on Exit",Toast.LENGTH_SHORT).show()
            R.id.mnuhome -> Toast.makeText(this@MainActivity,"you click on Home",Toast.LENGTH_SHORT).show()
            R.id.mnuIcon3 -> Toast.makeText(this@MainActivity,"you click on Search Item",Toast.LENGTH_SHORT).show()
            R.id.mnuIcon2 -> Toast.makeText(this@MainActivity,"you click on Home",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Green")
        menu?.add(3,32,2,"Black")
        menu?.add(3,33,3,"Blue")
        menu?.setHeaderTitle("Choose your color")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            31 -> {binding.txtContextMenu.setTextColor(Color.GREEN)}
            32 -> {binding.txtContextMenu.setTextColor(Color.BLACK)}
            33 -> {binding.txtContextMenu.setTextColor(Color.BLUE)}
        }
        return super.onContextItemSelected(item)
    }

    private fun setupIntent() {

        // intent tường minh
        binding.btnIntent.setOnClickListener {
            val it = Intent(this,MainActivity2::class.java)
            startActivity(it)
        }
        // intent không tường minh
        binding.btnIntent2.setOnClickListener {
            val it2 = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.pinterest.com/pin/403916660342909463/"))
            startActivity(it2)
        }
        binding.button.setOnClickListener{
            val intent3 = Intent(this,MainActivity3::class.java)
            startActivity(intent3)
        }
        binding.btnIntent4.setOnClickListener{
            val intent4 = Intent(this,MainActivity4::class.java)
            startActivity(intent4)
        }
        binding.btnExit.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                setTitle("Confirm Window")
                setMessage("Do you want to exit this app")
                setNegativeButton("Nahh Baby"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                setPositiveButton("Oke Baby"){ dialogInterface: DialogInterface, i: Int ->
                    finish()
                }
            }.show()
        }
        binding.button5.setOnClickListener {
            showDialogCustom()
        }
        binding.btnNavigation.setOnClickListener{
            val intent4 = Intent(this,MainActivity5::class.java)
            startActivity(intent4)
        }

        //1. Lấy dữ liệu từ Intent
        //  val i = intent
        //  val valuePF = i.getStringExtra("Your profile")
        //  val valueDB = i.getDoubleExtra("double",0.0)
        //    val valueBL = i.getBooleanExtra("isTrue",false)

//        binding.editTextTextPersonName.setText(valuePF +"\n"+valueDB+"\n"+valuePF)

        //2. Lấy dữ liệu từ túi bóng Bundle
        val i = intent
        val bundle = i.extras
        if(bundle != null){
            val valuePF = bundle.getString("Your profile")
            val valueDB = bundle.getDouble("double",0.0)
            val valueBL = bundle.getBoolean("isTrue",false)
            binding.editTextTextPersonName.setText(valuePF +"\n"+valueDB+"\n"+valueBL)
        }
    }

    private fun showDialogCustom() {
        //extension
//        val build = AlertDialog.Builder(this)
//        val view = layoutInflater.inflate(R.layout.custom_dialog,null)
//        build.setView(view)
//        diolog = build.create()
//        diolog.show()

        //ViewBinding
        val build = AlertDialog.Builder(this,R.style.ThemeCustom)
        // khác so với extension là binding tự động gọi nên inflate from this là được
        val diologBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
        build.setView(diologBinding.root)
        diologBinding.imageButton.setOnClickListener { diolog.dismiss() }
        diologBinding.button4.setOnClickListener{
            Toast.makeText(this@MainActivity,"You just click on It",Toast.LENGTH_SHORT).show()
        }
        diolog = build.create()
        diolog.show()
    }

    private fun setupDatePicker() {
        // khai báo biến cal get thời gian hiện tại
        val today = Calendar.getInstance()

        // set lai thời gian khi click vao button time
        val startHour = today.get(Calendar.HOUR_OF_DAY)
        val  startMinute = today.get(Calendar.MINUTE)

        // lắng nghe click lên button
        binding.btnimgTime.setOnClickListener {
            //Timepicker
            TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener {
                    //i : giờ , i2 : phút
                        timePicker, i, i2 ->  binding.txtDate.setText("$i : $i2")
                                                   },
                startHour,
                startMinute,
                true).show()
        }
        /*
            binding.btnimgDate.setOnClickListener {
            //Datepicker
            DatePickerDialog(
                this,
                DatePickerDialog.OnTimeSetListener {
                    //i : năm, i2: tháng, i3: ngày
                        datePicker, i, i2 ,3->  binding.txtDate.setText("$i3/${i2+1}/$i")
                                                   },
                2007,
                7,
                7,).show()
        }
        */
    }


    private fun setupAutoCTView() {
        val list = resources.getStringArray(R.array.AutoCTView)
        val adt = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        binding.autoCompleteTextView.setAdapter(adt)
        /*
            Gợi ý với 0 ký tụ nhập vào, chỉ cần click chuột là xuất hiện gợi ý
            View: Chế độ xem có trạng thái đã thay đổi ,
            b: Boolean true nếu đúng là nó có thay đổi
        */
        binding.autoCompleteTextView.setOnFocusChangeListener(
            View.OnFocusChangeListener { view, b
                -> binding.autoCompleteTextView.showDropDown()})

        binding.autoCompleteTextView.setOnItemClickListener(
            AdapterView.OnItemClickListener { adapterView, view, i, l
                ->  Toast.makeText(
                this,
                "Click Item "+ binding.autoCompleteTextView.text.toString(),
                Toast.LENGTH_SHORT).show()}
        )
    }

    private fun setupListView() {
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.img, "Do Nothing", "Dan"))
        list.add(OutData(R.drawable.img_1, "Your profile", "Dan"))

        customAdapter = CustomAdapter(this,list)
        binding.lvView.adapter = customAdapter
        binding.lvView.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity,"you choose "+list[p2].title,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSpinnerCoBan() {
        //co san
//        val list = resources.getStringArray(R.array.dio)
        // khong co san
//        val list = mutableListOf<String>()
//        list.add("English")
//        list.add("Vn")
//        list.add("Russia")
//        list.add("China")

        var list = mutableListOf<OutDataSpinner>()
        list.add(OutDataSpinner(R.drawable.img,"Dan"))
        list.add(OutDataSpinner(R.drawable.img_1, "Raki"))

//        val adt = ArrayAdapter(
//            this,
//            android.R.layout.simple_spinner_item,
//            list
//        )
//        val spDio = findViewById<Spinner>(R.id.spDio)
        val customAdapterSpinner = CustomAdapterSpinner(this,list)
        binding.spDio.adapter = customAdapterSpinner
        binding.spDio.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity,"you choose "+list[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
    private fun setupRecycler() {
        var list = mutableListOf<OutDataRecycler>()
        list.add(OutDataRecycler(R.drawable.img,"Dan","nothing"))
        list.add(OutDataRecycler(R.drawable.img_1, "Raki","forfunt"))

        val rvAdapter = RvAdapter(list,object: RvUtil{
            override fun OnClickTitle(pos: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Click ${list[pos].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
        // lấy ví dụ nên không cần demo về cơ bản nó tương tự như listView và GridView
        binding.rvDemo.adapter = rvAdapter

        // hiển thị giống listView
//        binding.rvDemo.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.VERTICAL,
//            false
//        )

        // hiển thị giống GridView
        // lưu ý 2 là cột
        binding.rvDemo.layoutManager = GridLayoutManager(
            this,
            2,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}