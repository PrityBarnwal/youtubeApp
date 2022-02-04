package com.coolapps.youtubejetpack.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun YouTubeChip(
    selected : Boolean,
    text:String,
    modifier: Modifier =Modifier
){
    Surface(color = when{
        selected -> MaterialTheme.colors.onSurface.copy(
            alpha = if (MaterialTheme.colors.isLight) 0.7f else 1f
        )
        else-> MaterialTheme.colors.error.copy(
            alpha = 0.05f
        )
    },
    contentColor = when{
        selected-> MaterialTheme.colors.surface
        else -> MaterialTheme.colors.onSurface
    },
    shape = CircleShape,
    border = BorderStroke(
        width = 1.dp,
        color = when{
            selected-> MaterialTheme.colors.surface
            else-> Color.LightGray
        }
    ),
        modifier = modifier
    ){
        Text(text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(
            vertical = 8.dp,
            horizontal = 12.dp
        ))
    }
}