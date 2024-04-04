package com.example.androidtutoriallearning.jetpack_activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme
import androidx.compose.material3.TextButton as TextButton1

class LazyListJetPackActivity : AppCompatActivity() {

    private var dataList by mutableStateOf(emptyList<Peoples>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // use  mutableStateOf for  dataList  TODO

        setContent {
            AndroidTutorialLearningTheme {

                MyScreenContent(
                    dataList, ::addItem, ::updateItem, ::deleteItem, MyFloatingActionButton(

                    )
                )
            }
        }

        addItem(person = Peoples("vivviivv"))
    }


    private fun addItem(person: Peoples) {
        dataList = dataList + person
    }

    private fun updateItem(index: Int, updatedPerson: Peoples) {
        if (index in dataList.indices) {
            dataList = dataList.toMutableList().also { it[index] = updatedPerson }
        }
    }

    private fun deleteItem(index: Int) {
        if (index in dataList.indices) {
            dataList = dataList.toMutableList().also { it.removeAt(index) }
        }
    }
}


@Composable
fun MyScreenContent(
    dataList: List<Peoples>,
    addItem: (Peoples) -> Unit,
    updateItem: (Int, Peoples) -> Unit,
    deleteItem: (Int) -> Unit,
    myFloatingActionButton: Unit
) {


    Scaffold(
        modifier = Modifier.padding(top = 10.dp),
        floatingActionButton = {


        },
        content = { padding ->
            MyContent(
                dataList,
                padding,
                addItem,
                updateItem,
                deleteItem

            )
        }
    )
}


@Composable
fun OpenDialogue() {
    AddOrEditDialogue {
        println("hi")
    }
}

@Composable
fun MyFloatingActionButton(
) {
    FloatingActionButton(
        onClick = {


        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(Icons.Filled.Add, contentDescription = null)
    }
}

@Composable
fun AddOrEditDialogue(
    onadd: (Peoples) -> Unit, // Function to confirm action
) {
    var name by remember { mutableStateOf("") } // State for the entered name

    AlertDialog(
        title = {
            Text(text = "Add Item")
        },
        text = {
            Column {
                Text(text = "Enter the name of the item:")
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") }
                )
            }
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton1(
                onClick = {}
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton1(
                onClick = {
//                    onDismissRequest() // Dismiss the dialog
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}


@Composable
fun MyContent(
    dataList: List<Peoples>, padding: PaddingValues,
    addItem: (Peoples) -> Unit,
    updateItem: (Int, Peoples) -> Unit,
    deleteItem: (Int) -> Unit,
) {


    // use  mutableStateOf for  dataList  TODO

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Top
    ) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp)
        ) {
            items(dataList.size) { i ->
                MyListItem(
                    dataList[i],
                    i,
                    updateItem,
                    deleteItem
                )
            }
        }
    }
}


@Composable
fun MyListItem(
    person: Peoples,
    position: Int,
    updateItem: (Int, Peoples) -> Unit,
    deleteItem: (Int) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = person.name)
        MyDeleteButton { deleteItem(position) } // Pass a lambda function
    }
    Spacer(modifier = Modifier.height(10.dp))
    Divider()
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MyDeleteButton(deleteItem: () -> Unit) { // Change parameter type to () -> Unit
    IconButton(onClick = deleteItem) {
        Icon(
            painter = painterResource(id = R.drawable.delete),
            contentDescription = "Delete",
            modifier = Modifier.size(20.dp)
        )
    }
}


data class Peoples(val name: String)



