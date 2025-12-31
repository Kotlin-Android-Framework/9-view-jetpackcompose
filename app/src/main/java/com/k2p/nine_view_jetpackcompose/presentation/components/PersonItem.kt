package com.k2p.nine_view_jetpackcompose.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.k2p.nine_view_jetpackcompose.domain.model.Person

@Composable
fun PersonItem(
    person: Person,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "${person.name} ${person.lastName}",
                style = MaterialTheme.typography.titleMedium
            )

            Text(text = "Edad: ${person.age}")
            Text(text = if (person.alive) "Estado: Vivo" else "Estado: Fallecido")

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onDelete,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Eliminar")
            }
        }
    }
}
