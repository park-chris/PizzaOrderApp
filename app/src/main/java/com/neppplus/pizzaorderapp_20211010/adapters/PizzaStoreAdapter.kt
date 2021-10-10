package com.neppplus.pizzaorderapp_20211010.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.neppplus.pizzaorderapp_20211010.datas.StoreData

class PizzaStoreAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mContext, resId, mList) {
}