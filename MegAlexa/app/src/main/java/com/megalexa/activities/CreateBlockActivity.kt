package com.megalexa.activities


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.megalexa.R
import com.megalexa.adapters.view.ListArrayAdapter
import com.megalexa.fragments.RssFragment
import kotlinx.android.synthetic.main.activity_create_block.*


class CreateBlockActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_block)

        listView = findViewById(R.id.view_blocks)
        val blockList = getBlockList()


        listView.adapter = ListArrayAdapter(this, blockList)


        button_cancel_block.setOnClickListener(this)

        var fragment: Fragment

        listView.setOnItemClickListener{
                _,_,position, _
            ->

            if(position==0) {
                Toast.makeText(this, "position $position", Toast.LENGTH_SHORT).show()
                fragment = RssFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment).addToBackStack("").commit()
            }

            if(position==1) {
                Toast.makeText(this, "position $position", Toast.LENGTH_SHORT).show()
            }

            if(position==2) {
                Toast.makeText(this, "position $position", Toast.LENGTH_SHORT).show()
            }

            if(position==3) {
                Toast.makeText(this, "position $position", Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onClick(view: View) {


    when(view.id){
        R.id.button_cancel_block -> {
            this.finish()
        }
    }


    }


    private fun getBlockList(): List<Pair<String, Int>> {

        val list = getTitlesList()
        //more pairs to be added
        return listOf(
            Pair(list[0], R.drawable.ic_mr_button_connecting_30_light),
            Pair(list[1], R.drawable.ic_mr_button_connecting_30_light),
            Pair(list[2], R.drawable.ic_mr_button_connecting_30_light),
            Pair(list[3], R.drawable.ic_mr_button_connecting_30_light)
        )

    }


    private fun getTitlesList(): List<String> {

        return listOf("Add FeedRSS", "Add Alarm Clock", "Add Text Block", "Add Filter")

    }



}
