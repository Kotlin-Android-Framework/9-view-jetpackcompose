package com.k2p.nine_view_jetpackcompose.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.k2p.nine_view_jetpackcompose.domain.model.Person
import com.k2p.nine_view_jetpackcompose.presentation.components.PersonItem
import java.time.LocalDate
import java.time.LocalDateTime

@Preview(
    name = "Phone",
    showBackground = true,
    device = "spec:width=411dp,height=891dp"
)
@Preview(
    name = "Tablet",
    showBackground = true,
    device = "spec:width=1280dp,height=800dp"
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun PersonCrudScreen() {

    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var alive by remember { mutableStateOf(true) }

    var personList by remember { mutableStateOf(listOf<Person>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Person CRUD",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = alive,
                onCheckedChange = { alive = it }
            )
            Text("Alive")
        }

        Button(
            onClick = {
                val newPerson = Person(
                    idUser = System.currentTimeMillis(),
                    name = name,
                    lastName = lastName,
                    dateOfBirth = LocalDate.now(),
                    age = age.toIntOrNull() ?: 0,
                    weight = weight.toFloatOrNull() ?: 0f,
                    alive = alive,
                    creationDate = LocalDateTime.now(),
                    modificationDate = LocalDateTime.now()
                )

                personList = personList + newPerson

                name = ""
                lastName = ""
                age = ""
                weight = ""
                alive = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Person")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider()

        LazyColumn {
            items(personList) { person ->
                PersonItem(
                    person = person,
                    onDelete = {
                        personList = personList.filter { it.idUser != person.idUser }
                    }
                )
            }
        }
    }
}


