package com.neppplus.pizzaorderapp_20211010

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.pizzaorderapp_20211010.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kotlinx.android.synthetic.main.pizza_store_list_item.*
import kotlinx.android.synthetic.main.pizza_store_list_item.logoImg
import kotlinx.android.synthetic.main.activity_view_store_detail.storeNameTxt as storeNameTxt1

class ViewStoreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)


//        시리얼라이저블 형태를 StoreData 형식으로 변환
        val storeData = intent.getSerializableExtra("store") as StoreData

        Glide.with(this).load(storeData.logoURL).into(logoImg)

        storeNameTxt.text = storeData.name
        phoneNumTxt.text = storeData.phoneNum


        callBtn.setOnClickListener {

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

                    val myUri = Uri.parse("tel:${storeData.phoneNum}")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri )
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    Toast.makeText(
                        this@ViewStoreDetailActivity,
                        "통화 권한이 거절되었습니다.",
                        Toast.LENGTH_SHORT
                    ).show()



                }


            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }


    }
}