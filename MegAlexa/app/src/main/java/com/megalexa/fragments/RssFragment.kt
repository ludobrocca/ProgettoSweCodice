/*
* File: RssFragment.kt
* Version: 1.0.0
* Date: 2019-02-18
* Author: Ludovico Brocca
*
* License:
*
* History:
* Author                || Date         || Description
* Ludovico Brocca       || 2019-02-18   || Writing class RssFragment
*                       ||              ||
*/

package com.megalexa.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.megalexa.R
import com.megalexa.activities.CreateBlockActivity
import com.megalexa.adapters.connectors.ConnectorFeedRss

class RssFragment : Fragment(){
    private var url=""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.rss_fragment_layout,container,false)

        val button= view.findViewById<Button>(R.id.confirm_button)
        val editText= view.findViewById<EditText>(R.id.insert_URL)

        button.setOnClickListener {

            val connector = ConnectorFeedRss(editText.text.toString())
            val isValid=  connector.valid()

            if(editText.text.toString() == ""|| !isValid) {
                Toast.makeText(context, "url is invalid", Toast.LENGTH_SHORT).show()
            }
            else{
                url= editText.text.toString()
                val activity= activity as CreateBlockActivity
                activity.onFragmentClick(this)
            }

        }

    return view
    }


    fun getUrl(): String  {
        return url
    }

}

