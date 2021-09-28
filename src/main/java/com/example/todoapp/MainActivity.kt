package com.example.todoapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var items : ArrayList<ToDoitems>
lateinit var floButtom : FloatingActionButton
lateinit var myRv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = arrayListOf()



        floButtom = findViewById(R.id.floatingActionButton)
        floButtom.setOnClickListener{
            customDialog()


        }

         myRv = findViewById(R.id.rvMain)
        myRv.adapter = RecyclerViewAdapter(items)
        myRv.layoutManager = LinearLayoutManager(this)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteItem->{
                RecyclerViewAdapter(items).deleteItems()

                return true
            }

        }
        return true
    }

    private fun customDialog(){
        val dialogBuilder = AlertDialog.Builder(this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val toDo = EditText(this)
        toDo.hint = "Enter to-do item"
        layout.addView(toDo)

        dialogBuilder.setPositiveButton("ADD", DialogInterface.OnClickListener {
                dialog, id -> items.add(ToDoitems(toDo.text.toString(),false))
        })
            .setNegativeButton("CANCEL", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("New Item")
        alert.setView(layout)
        alert.show()
    }


}

