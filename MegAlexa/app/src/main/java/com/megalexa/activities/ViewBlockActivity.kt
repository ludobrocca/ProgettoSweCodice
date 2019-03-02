package com.megalexa.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.megalexa.R
import com.megalexa.adapters.view.BlockViewAdapter
import kotlinx.android.synthetic.main.activity_create_workflow.*
import kotlinx.android.synthetic.main.activity_view_block.*

class ViewBlockActivity:AppCompatActivity(), View.OnClickListener {

    private lateinit var block_names:ArrayList<String>
    private lateinit var rec_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_block)

        block_names=getDebugBlocks()

        rec_view=findViewById(R.id.recyclerView_addedBlocksView)
        rec_view.layoutManager= LinearLayoutManager(this)
        rec_view.adapter= BlockViewAdapter(block_names,this)

        var title: String?="PROVA"

        if(savedInstanceState == null){

            val extras :Bundle? = intent.extras
            if(extras==null){
                title="EXTRAS NULLI"
            } else {
                title= extras.getString("WORKFLOW_NAME")
            }

        }else{

            title= savedInstanceState.getSerializable("WORKFLOW_NAME") as String
        }
        workflow_title.text= title


        button_add_blockView.setOnClickListener(this)
        button_cancel_workflow_creationView.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v) {
            button_continue -> startActivity(Intent(this, CreateBlockActivity::class.java))
            button_cancel_workflow_creation -> startActivity(Intent(this, GeneralLoggedActivity::class.java))
        }
    }


    fun getDebugBlocks(): ArrayList<String>{
        return arrayListOf("Block1","Block2","Block3","Block4","Block5")

    }



}