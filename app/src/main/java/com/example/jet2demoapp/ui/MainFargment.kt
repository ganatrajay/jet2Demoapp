package com.example.jet2demoapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jet2demoapp.R
import com.example.jet2demoapp.adapter.DataModelAdapter
import com.example.jet2demoapp.model.DataModel
import com.example.jet2demoapp.viewmodel.DataViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainFargment:Fragment() {

    private val dataModel: DataViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.data_list_view, container, false)
    }

    override fun onStart() {
        super.onStart()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(view!!.context, LinearLayoutManager.VERTICAL, false)

        recyclerView.addItemDecoration(DividerItemDecoration(view!!.context, LinearLayoutManager.VERTICAL))


        dataModel.getData()

        dataModel.listData.observe(this, Observer(function = fun(dataModelList:List<DataModel>?){
            dataModelList?.let {

                var dataModelAdapter : DataModelAdapter = DataModelAdapter(dataModelList)
                recyclerView.adapter = dataModelAdapter

    }
}))
}
}