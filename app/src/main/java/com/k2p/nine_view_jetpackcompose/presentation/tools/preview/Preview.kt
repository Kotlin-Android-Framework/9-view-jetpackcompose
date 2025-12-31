package com.k2p.nine_view_jetpackcompose.presentation.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.k2p.nine_view_jetpackcompose.presentation.screens.PersonCrudScreen

@Preview(showBackground = true)
@Composable
fun PersonCrudScreenPreview() {
    MaterialTheme {
        PersonCrudScreen()
    }
}